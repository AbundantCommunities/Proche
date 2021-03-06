package abcd

import grails.transaction.Transactional
import java.net.URLEncoder
import groovy.sql.Sql

@Transactional
class AssetService {

    // Grails injects the default DataSource
    def dataSource

    def countActive( ) {
        Asset.countByActive( Boolean.TRUE )
    }

    def restfulSearch( ) {
        def query = Long.parseLong( params.q )
        log.info "Anon searching for ${query}"

        // Result is like [[241,Home Plumbing],[50,Joseph Vautour], ...]
        def assets = Asset.executeQuery(
                'select trim(lower(a.text)), count(a) as ca from Answer as a where a.question.id=:qId group by trim(lower(a.text)) order by ca desc',
                [q:q] )

        render JsonWriter.write( assets )
    }

    /**
     * We intend that, generally speaking, only application administrators will want
     * to see inactive assets.
     */
    def search( String q, Boolean showInactive, Long communityId, Integer walkingDistance ) {
        Community community = Community.get( communityId )
        
        if( showInactive ) {
            log.info "Search assets (active & inactive) for ${q}"
            return Asset.withCriteria {
                eq( "community", community )
                or {
                    ilike( "organization", "%${q}%" )
                    ilike( "name",         "%${q}%" )
                    ilike( "description",  "%${q}%" )
                    ilike( "location",     "%${q}%" )
                    ilike( "keywords",     "%${q}%" )
                }
                order( "name" )
            }
        } else {
            log.info "Search active assets for ${q}"
            return Asset.withCriteria {
                eq( "community", community )
                eq( "active", Boolean.TRUE )
                or {
                    ilike( "organization", "%${q}%" )
                    ilike( "name",         "%${q}%" )
                    ilike( "description",  "%${q}%" )
                    ilike( "location",     "%${q}%" )
                    ilike( "keywords",     "%${q}%" )
                }
                order( "name" )
            }
        }
    }

    def update( params ) {
        def id = params.long('id')
        def asset = Asset.get( id )
        log.info "Update asset ${asset}"

        if( asset.version != params.long('version') ) {
            throw new Exception('Stale asset')
        }

        // TODO Make DRY WRT AssetSuggestionService
        if( params['asset.community.id'] == "null" ) {
            asset.community = null
        } else {
            // TODO Prevent an asset from having NO COMMUNITY (??)
            Long communityId = Long.parseLong( params['asset.community.id'] )
            asset.community = Community.get( communityId )
        }

        asset.active = params.active.toBoolean( ) // true iff "true" (ignoring case)
        asset.name = params.name
        asset.description = params.description
        asset.organization = params.organization
        asset.location = params.location
        asset.zeroCost = params.zeroCost != null  // This field will be absent if checkbox is cleared
        asset.phoneNumber = params.phoneNumber
        asset.emailAddress = params.emailAddress
        asset.url = params.url
        asset.administratorComment = params.administratorComment

        if( params.keywords ) {
            log.info "Keywords not null; size is ${params.keywords.size()}"
            asset.keywords = params.keywords
        } else {
            log.info "keywords is null"
        }

        asset.save( flush:true, failOnError: true )
    }

    /**
     * If includeInactive is TRUE then we consider inactive assets when we determine
     * what communities have assets.
     */
    def getCommunitiesInUse( Boolean includeInactive ) {

        def clause = includeInactive ? '' : 'AND a.active'
        def select = 'SELECT DISTINCT c.id, c.name FROM asset AS a, community AS c WHERE a.community_id = c.id ' + clause + ' ORDER by c.name'

        final Sql sql = new Sql( dataSource )
        def communities = sql.rows( select )
        return communities
    }
}

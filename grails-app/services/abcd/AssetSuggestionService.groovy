package abcd

import grails.transaction.Transactional

@Transactional
class AssetSuggestionService {

    /**
     * How many suggestions are waiting to be resolved?
     */
    def countUnresolved( ) {
        AssetSuggestion.countByResolution( AssetSuggestion.UNRESOLVED )
    }

    /**
     * Anonymous user offers a suggested asset. We use Google's reCaptcha.
     */
    def saveOffer( params ) {
        def recaptcha = params['g-recaptcha-response']
        log.info "GOOGLE RECAPTCH RESPONSE = ${recaptcha}"

        def sug = new AssetSuggestion( )

        sug.name = params.name
        sug.description = params.description
        sug.organization = params.organization
        sug.location = params.location
        sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared
        sug.phoneNumber = params.phoneNumber
        sug.emailAddress = params.emailAddress
        sug.url = params.url
        sug.schedule = 'N/A'
        sug.suggesterComment = params.suggesterComment
        sug.suggesterContactInfo = params.suggesterContactInfo
        sug.suggesterName = params.suggesterName

        sug.resolution = AssetSuggestion.UNRESOLVED
        sug.administratorComment = 'admin comment'
        sug.keywords = 'keywords'

        sug.save( flush:true, failOnError: true )
    }

    /**
     * Administrator has modified a suggestion but is not ready to promote it.
     */
    def update( params ) {
        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        log.info "Update (neither Accept nor Reject) ${sug}"

        if( sug.version != params.long('version') ) {
            throw new Exception('Stale suggested asset')
        }

// sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared

        // Keep alphabetical order so that we can easily desk-check what parameters we ALLOW to be copied.
        sug.properties[ 'administratorComment', 'description', 'emailAddress', 'keywords', 'location',
                'name', 'organization', 'phoneNumber', 'schedule', 'suggesterComment', 'suggesterContactInfo',
                'suggesterName', 'url', 'zeroCost'] = params

        sug.save( flush:true, failOnError: true )
    }

    /**
     * Promote a suggested asset into a public facing asset.
     */
    def accept( params ) {
        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        log.info "Accept ${sug}"

        if( sug.version != params.long('version') ) {
            throw new Exception('Stale suggested asset')
        }

        if( !params.location ) {
            log.warn "Location not provided for ${sug}"
            return "You did not enter a Location"
        }

        // sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared

        // Keep alphabetical order so that we can easily desk-check what parameters we ALLOW to be copied.
        sug.properties[ 'administratorComment', 'description', 'emailAddress', 'keywords', 'location',
                'name', 'organization', 'phoneNumber', 'schedule', 'suggesterComment', 'suggesterContactInfo',
                'suggesterName', 'url', 'zeroCost'] = params

        // TODO Make DRY WRT AssetService
        if( params['sug.community.id'] == "null" ) {
            sug.community = null
        } else {
            // TODO Prevent an asset from having NO COMMUNITY (??)
            Long communityId = Long.parseLong( params['sug.community.id'] )
            sug.community = Community.get( communityId )
        }

        sug.resolution = AssetSuggestion.ACCEPTED
        sug.save( failOnError:true, flush:true )

        Asset asset = new Asset( )

        // sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared

        // Keep alphabetical order so that we can easily desk-check what parameters we ALLOW to be copied.
        asset.properties[ 'administratorComment', 'description', 'emailAddress', 'keywords', 'location',
                'name', 'organization', 'phoneNumber', 'schedule', 'url', 'zeroCost'] = params

        // This is kludgee
        asset.community = sug.community

        asset.formallyReviewed = new Date( )
        asset.active = Boolean.TRUE
        asset.save( failOnError:true, flush:true )
        return null
    }

    /**
     * Promote a suggested asset into a public facing asset.
     */
    def reject( params ) {
        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        log.info "Reject ${sug}"

        if( sug.version != params.long('version') ) {
            throw new Exception('Stale suggested asset')
        }

// sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared

        sug.properties[ 'administratorComment', 'description', 'emailAddress', 'keywords', 'location',
                'name', 'organization', 'phoneNumber', 'schedule', 'suggesterComment', 'suggesterContactInfo',
                'suggesterName', 'url', 'zeroCost'] = params

        sug.resolution = AssetSuggestion.REJECTED
        sug.save( failOnError:true, flush:true )
    }
}

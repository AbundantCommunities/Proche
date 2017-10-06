package abcd

import grails.transaction.Transactional
import java.net.URLEncoder

@Transactional
class AssetService {

    // TODO Consider removing firstLetters etc
    def firstLetters() {
        def assets = AssetSuggestion.list( [sort: 'name', order: 'asc'] )
        def result = [ ]
        Character previousLetter = null
        Integer count = 0
        assets.each{
            Character thisLetter = it.name.charAt(0)
            println "Read ${thisLetter}, previous was ${previousLetter}, count is ${count}"
            if( previousLetter ) {
                if( thisLetter == previousLetter ) {
                    println '    nothing new here'
                } else {
                    result << [ letter: previousLetter, count: count ]
                    count = 0
                }
            } else {
                println '    (nothing to compare to)'
            }
            previousLetter = thisLetter
            count++
        }
        if( previousLetter ) {
            result << [ letter: previousLetter, count: count ]
        }
        result
    }

    def search( String q, Integer offset ) {
        println "Asset Svc: search for ${q} offset ${offset}"
        def query = Asset.whereAny {
            name =~ "%${q}%"
            description =~ "%${q}%"
        }
        query.list( [sort: 'name', offset: offset, max: 10000] )
    }

    String locateOnMap( Asset asset ) {
        String loc = asset.location
        loc = URLEncoder.encode(loc, "UTF-8")
        "https://www.google.ca/maps/place/${loc},+Edmonton,+AB,+Canada"
    }

    def byFirstLetter( firstLetter ) {
        def nextLetter = 'C'
        def query = Asset.where {
            name >= firstLetter
            name < nextLetter
        }
        def result = query.findAll( )
        println "Found ${result.size()} assets starting with ${firstLetter}"
    }

    def update( params ) {
        def id = params.long('id')
        def asset = Asset.get( id )

        if( asset.version != params.long('version') ) {
            throw new Exception('Stale asset')
        }

        asset.name = params.name
        asset.description = params.description
        asset.organization = params.organization
        asset.location = params.location
        asset.zeroCost = params.zeroCost != null  // This field will be absent if checkbox is cleared
        asset.phoneNumber = params.phoneNumber
        asset.emailAddress = params.emailAddress
        asset.url = params.url
        asset.schedule = params.schedule
        if( params.keywords ) {
            println "keywords not null; size is ${params.keywords.size()}"
            asset.keywords = params.keywords
        } else {
            println "keywords is null"
        }

        asset.save( flush:true, failOnError: true )
    }
}

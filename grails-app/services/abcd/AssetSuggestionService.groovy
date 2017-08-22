package abcd

import grails.transaction.Transactional

@Transactional
class AssetSuggestionService {

    def update( params ) {
        def id = params.long('id')
        def sug = AssetSuggestion.get( id )

        if( sug.version != params.long('version') ) {
            throw new Exception('Stale suggested asset')
        }

        sug.name = params.name
        sug.description = params.description
        sug.organization = params.organization
        sug.location = params.location
        sug.zeroCost = params.zeroCost != null  // This field will be absent if checkbox is cleared
        sug.phoneNumber = params.phoneNumber
        sug.emailAddress = params.emailAddress
        sug.url = params.url
        sug.schedule = params.schedule
        sug.administratorComment = params.administratorComment 
        sug.keywords = params.keywords

        sug.save( flush:true, failOnError: true )
    }

    def accept( params ) {
        println "Accepting suggestion id ${params.id}"

        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        sug.resolution = 'A'
        sug.save()

        Asset asset = new Asset( )
        asset.properties[ 'name', 'zeroCost', 'description', 'organization', 'location',
                'phoneNumber', 'emailAddress', 'url', 'schedule', 'keywords'] = params

        asset.save(failOnError: true, flush: true)
    }
}

package abcd

import grails.transaction.Transactional

@Transactional
class AssetSuggestionService {

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

        sug.resolution = 'N'
        sug.administratorComment = 'admin comment'
        sug.keywords = 'keywords'

        sug.save( flush:true, failOnError: true )
    }

    /**
     * Administrator has modified a suggestion but is not ready to promote it.
     */
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
        sug.zeroCost = (params.zeroCost != null)  // This field will be absent if checkbox is cleared
        sug.phoneNumber = params.phoneNumber
        sug.emailAddress = params.emailAddress
        sug.url = params.url
        sug.schedule = params.schedule
        sug.administratorComment = params.administratorComment 
        sug.keywords = params.keywords

        sug.save( flush:true, failOnError: true )
    }

    /**
     * Administrator asks that we promote a suggested asset into a public facing asset.
     */
    def promote( params ) {
        log.info "Promoting suggestion id ${params.id}"

        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        sug.resolution = 'A'
        sug.save( failOnError:true, flush:true )

        Asset asset = new Asset( )
        asset.properties[ 'name', 'zeroCost', 'description', 'organization', 'location',
                'phoneNumber', 'emailAddress', 'url', 'schedule', 'keywords'] = params

        asset.save( failOnError:true, flush:true )
    }
}

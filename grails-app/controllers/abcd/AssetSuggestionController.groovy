package abcd

class AssetSuggestionController {

    //    static allowedMethods = [families:'GET', save:'POST']
    def assetSuggestionService

    /**
     * We summarize the suggestions we have on file and offer a link
     * to see the unresolved ones (so that we can make them publicly visible).
     */
    def index() {
        [
            all: AssetSuggestion.count( ),
            fresh: AssetSuggestion.countByResolution('N'),
            accepted: AssetSuggestion.countByResolution('A'),
            rejected: AssetSuggestion.countByResolution('R')
        ]
    }

    def list() {
        Long offset
        Integer max
        if( !params.max ) {
            offset = 0
            max = 5
        } else {
            offset = params.long('offset')
            max = params.int('max')
        }
        [
            sugs: AssetSuggestion.findAllByResolution( 'N',  [max:max, offset:offset, sort:'name'] ),
            sugCount: AssetSuggestion.count()
        ]
    }

    def emptyForm(){
        // nothing to do here; we'll just present an empty form to the user.
    }

    def saveOffer() {
        def recaptchaResponse = params.'g-recaptcha-response'
        println "GOOGLE RECAPTCH RESPONSE = ${recaptchaResponse}"

        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        assetSuggestionService.saveOffer( params )

        flash.message = "Thanks for your suggestion"
        flash.nature = 'SUCCESS'
        redirect controller:'uberTop'
    }

    def save() {
        def id = params.long('id')
        String button = params.button
        println "Button is ${button}"
        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        switch( button ) {
            case 'Update':
                assetSuggestionService.update( params )
                redirect action:'seeOne', id:id
                break

            case 'Accept':
                println "User wants to accept ${params}"
                assetSuggestionService.accept( params )
                redirect action:'list'
                break

            case 'Reject':
                assetSuggestionService.reject( params )
                redirect controller:'asset', action:'index'
                break

            default:
                throw new Exception("Invalid button ${button}")
        }
    }
}

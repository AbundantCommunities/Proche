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
        [
            sugs: AssetSuggestion.findAllByResolution( 'N',  [sort: 'name', order: 'asc'] )
        ]
    }

    def seeOne(){
        [
            sug: AssetSuggestion.get( Long.valueOf(params.id) )
        ]
    }
    
    def save() {
        def recaptchaResponse = params.'g-recaptcha-response'
        println "GOOGLE RECAPTCH RESPONSE = ${recaptchaResponse}"

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

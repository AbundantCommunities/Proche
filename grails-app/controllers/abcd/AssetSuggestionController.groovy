package abcd

class AssetSuggestionController {

    //    static allowedMethods = [families:'GET', save:'POST']
    def assetSuggestionService
    def mapService
    def authenticateService

    /**
     * We summarize the suggestions we have on file and offer a link
     * to see the unresolved ones (so that we can make them publicly visible).
     */
    def index() {
        authenticateService.ensurePrivileged( session )
        [
            all: AssetSuggestion.count( ),
            fresh: AssetSuggestion.countByResolution('N'),
            accepted: AssetSuggestion.countByResolution('A'),
            rejected: AssetSuggestion.countByResolution('R')
        ]
    }

    def list() {
        authenticateService.ensurePrivileged( session )
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
        log.info "Empty suggested asset form"
    }

    def view( ){
        authenticateService.ensurePrivileged( session )
        Long id = params.long('id')
        AssetSuggestion sug = AssetSuggestion.get( id )
        log.info "View ${sug}"
        if( sug ) {
            [
                sug: sug,
                mapLink: mapService.locateOnMap( sug.location )
            ]
        } else {
            throw new Exception( "Suggested Asset ${id} not found")
        }
    }

    def saveOffer() {
        def recaptchaResponse = params.'g-recaptcha-response'
        log.info "GOOGLE RECAPTCH RESPONSE = ${recaptchaResponse}"

        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        assetSuggestionService.saveOffer( params )

        flash.message = "Thanks for your suggestion"
        flash.nature = 'SUCCESS'
        redirect controller:'uberTop'
    }

    def save() {
        authenticateService.ensurePrivileged( session )
        def id = params.long('id')
        String button = params.button
        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        switch( button ) {
            case 'Update':
                assetSuggestionService.update( params )
                redirect action:'seeOne', id:id
                break

            case 'Accept':
                log.info "User wants to accept ${params}"
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

package abcd

class AssetSuggestionController {

    //    static allowedMethods = [families:'GET', save:'POST']
    def assetSuggestionService
    def mapService
    def authenticateService

    /**
     * List the UNRESOLVED suggested assets.
     */
    def index() {
        authenticateService.ensurePrivileged( session )

        // TODO this code is non-DRY WRT AssetController
        Long offset
        Integer max
        if( params.offset ) {
            offset = params.long('offset')
            max = params.int('max')
        } else {
            if( session.pagination ) {
                offset = session.pagination.offset
                max = session.pagination.max
            } else {
                offset = 0
                max = 5
            }
            params.offset = offset
            params.max = max
        }

        log.info "List suggested assets offset ${offset} max ${max}"
        session.pagination = [ offset:offset, max:max ]

        [
            sugs: AssetSuggestion.findAllByResolution( AssetSuggestion.UNRESOLVED,  [max:max, offset:offset, sort:'name'] ),
            sugCount: AssetSuggestion.countByResolution( AssetSuggestion.UNRESOLVED )
        ]
    }

    def emptyForm(){
        log.info "Empty suggested asset form"
    }

    def edit( ) {
        authenticateService.ensurePrivileged( session )
        AssetSuggestion sug = AssetSuggestion.get( params.long('id') )
        log.info "Edit ${sug}"
        [
            sug: sug,
            mapLink: mapService.locateOnMap( sug )
        ]
    }

    /**
     * Anonymous user submits a Suggested Public Asset
     */
    def saveOffer() {
        def recaptchaResponse = params.'g-recaptcha-response'
        log.info "GOOGLE RECAPTCH RESPONSE = ${recaptchaResponse}"

        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        normalizeUrl( params )
        assetSuggestionService.saveOffer( params )

        flash.message = "Thanks for your suggestion"
        flash.nature = 'SUCCESS'
        redirect controller:'uberTop'
    }

    /**
     * Authenticated user updates a suggestion (may be resolved)
     */
    def save() {
        authenticateService.ensurePrivileged( session )
        def id = params.long('id')
        String button = params.button
        if( !params.name ) {
            throw new RuntimeException( "assetSuggestion.name is empty" )
        }

        params.schedule = 'N/A'
        params.keywords = params.keywords? params.keywords : 'N/A'
        normalizeUrl( params )

        switch( button ) {
            case 'Update':
                log.info "Update ${params}"
                // FIXME We fail to save the Neighbourhood back to suggested assets table
                assetSuggestionService.update( params )
                redirect action:'index'
                break

            case 'Accept':
                log.info "Accept ${params}"
                def problem = assetSuggestionService.accept( params )
                if( problem ) {
                    flash.message = "We can't save your suggestion because ${problem}"
                    flash.nature = 'WARNING'
                    redirect action:'edit', id:id
                } else {
                    redirect action:'index'
                }
                break

            case 'Reject':
                log.info "Reject ${params}"
                assetSuggestionService.reject( params )
                redirect action:'index'
                break

            default:
                throw new Exception("Invalid button ${button}")
        }
    }

    // TODO The normalizeUrl function is also in AssetController
    def normalizeUrl( params ) {
        String url = params.url
        if( url ) {
            if( url.startsWith("http://") || url.startsWith("https://") ) {
                log.debug "We like ${url}"
            }
            else {
                log.debug "Prefixing ${url} with http://"
                params.url = "http://${url}"
            }
        } else {
            log.debug "Sadly there is no URL"
        }
    }
}

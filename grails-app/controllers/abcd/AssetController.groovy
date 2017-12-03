package abcd

class AssetController {

    //  static allowedMethods = [families:'GET', save:'POST']
    def assetService
    def mapService
    def authenticateService
    def assetSuggestionService

    def comment( ) {
        log.info "Enter comment for a public asset ${params}"
        def asset = Asset.get( params.long('id') )
        [
            asset: asset
        ]
    }

    def saveComment( ) {
        log.info "Save comment on public asset"
        Asset asset = Asset.get( params.long('id') )
        Comment comment = new Comment( )
        comment.asset = asset
        comment.submitterName = params.submitterName
        comment.submitterContactInfo = params.submitterContactInfo
        comment.says = params.says
        comment.save( flush:true, failOnError: true )
        flash.message = "Thanks for your comment"
        flash.nature = 'SUCCESS'
        redirect action:'view', id:asset.id
    }

    def initSearch( ) {
        // I wish I could remember how to specify a URI for our form so that
        // this closure is not required!
        log.info "Init a search of assets"
    }

    def search( ) {
        String q = params.q
        Integer offset
        
        if( params.offset ) {
            offset = params.integer( 'offset' )
        } else {
            offset = 0
        }

        log.info "Search for ${q} offset ${offset}"
        [
            q: q,
            offset: offset,
            assets: assetService.search( q, offset ),
            suggestionCount: assetSuggestionService.countUnresolved( )
        ]
    }

    def index() {
        log.info "Odd. Someone asked for assets counted by letter"
        [
            countsByLetter: assetService.firstLetters( )
        ]
    }

    def list() {
        // TODO this code is non-DRY WRT AssetSuggestionController
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
        log.info "List assets offset ${offset} max ${max}"
        session.pagination = [ offset:offset, max:max ]

        [
            assets: Asset.list( max:max, offset:offset, sort:'name' ),
            assetCount: Asset.count( ),
            suggestionCount: assetSuggestionService.countUnresolved( )
        ]
    }

    def view( ){
        Long id = params.long('id')
        log.info "View asset ${id}"
        Asset asset = Asset.get( id )
        if( asset ) {
            [
                asset: asset,
                mapLink: mapService.locateOnMap( asset.location )
            ]
        } else {
            throw new Exception( "Asset ${id} not found")
        }
    }

    def edit( ){
        authenticateService.ensurePrivileged( session )
        Long id = params.long('id')
        log.info "Edit asset ${id}"
        Asset asset = Asset.get( id )
        if( asset ) {
            [
                asset: asset,
                mapLink: mapService.locateOnMap( asset.location )
            ]
        } else {
            throw new Exception( "Asset ${id} not found")
        }
    }

    def save() {
        authenticateService.ensurePrivileged( session )
        def id = params.long('id')

        // TODO Check for valid params
        normalizeUrl( params )
        if( !params.name ) {
            throw new RuntimeException( "asset.name is empty" )
        }

        log.info "Save of asset ${id} requested"
        assetService.update( params )
        redirect action:'list'
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

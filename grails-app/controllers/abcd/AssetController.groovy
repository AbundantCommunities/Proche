package abcd

class AssetController {

    //  static allowedMethods = [families:'GET', save:'POST']
    def assetService
    def mapService
    def authenticateService

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
            suggestionCount: AssetSuggestion.count()
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
            assetCount: Asset.count(),
            suggestionCount: AssetSuggestion.count()
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
        log.info "Edit of ${asset} requested"
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
        if( !params.name ) {
            throw new RuntimeException( "asset.name is empty" )
        }

        log.info "Save of asset ${id} requested"
        assetService.update( params )
        redirect action:'list'
    }
}

package abcd

class AssetController {

    //    static allowedMethods = [families:'GET', save:'POST']
    def assetService

    def initSearch( ) {
        // I wish I could remember how to specify a URI for our form so that
        // this closure is not required!
    }

    def search( ) {
        String q = params.q
        Integer offset
        
        if( params.offset ) {
            offset = params.integer( 'offset' )
        } else {
            offset = 0
        }

        [
            q: q,
            offset: offset,
            assets: assetService.search( q, offset )
        ]
    }

    def index() {
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
        session.pagination = [ offset:offset, max:max ]
        [
            assets: Asset.list( max:max, offset:offset, sort:'name' ),
            assetCount: Asset.count()
        ]
    }
    
    def view( ){
        Long id = params.long('id')
        // We track offset & max for returning to paginated list view
        Long offset = params.long('offset')
        Integer max = params.int('max')

        Asset asset = Asset.get( id )
        if( asset ) {
            [
                asset: asset,
                mapLink: assetService.locateOnMap( asset )
            ]
        } else {
            throw new Exception( "Asset ${id} not found")
        }
    }
    
    def edit( ){
        Long id = params.long('id')
        Asset asset = Asset.get( id )
        if( asset ) {
            [
                asset: asset,
                mapLink: assetService.locateOnMap( asset )
            ]
        } else {
            throw new Exception( "Asset ${id} not found")
        }
    }
    
    def save() {
        def id = params.long('id')
        if( !params.name ) {
            throw new RuntimeException( "asset.name is empty" )
        }

        assetService.update( params )
        redirect controller:'asset', action:'edit', id:id
    }
}

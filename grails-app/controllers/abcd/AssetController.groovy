package abcd

class AssetController {

    //    static allowedMethods = [families:'GET', save:'POST']
    def assetService

    def initSearch( ) {
        // maybe do something
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
    
    def listForLetter() {
        [
            assets: assetService.byFirstLetter( params.firstLetter )
        ]
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

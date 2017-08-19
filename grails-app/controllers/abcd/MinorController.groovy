package abcd

class MinorController {

    def assetClassService

    def index( ) {
        Integer id = Integer.valueOf( params.id )
        def minor = MinorAssetClass.get( id )
        def privates = assetClassService.privateSearch( id )
        def groups = assetClassService.groupSearch( id )
        [ 'minorClass':minor, 'privateAssets':privates, 'groupAssets':groups ]
    }
}

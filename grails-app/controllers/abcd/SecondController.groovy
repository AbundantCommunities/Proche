package abcd

class SecondController {

    def assetClassService

    def index( ) {
        Integer id = Integer.valueOf( params.id )
        def major = MajorAssetClass.get( id )
        def result = assetClassService.getMinorClasses( id )
        [ 'majorClass': major, 'minorClasses': result ]
    }
}

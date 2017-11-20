package abcd

class GroupAssetController {

    def honeycombService

    def majorClass( ) {
        Integer id = Integer.valueOf( params.id )
        def major = MajorAssetClass.get( id )
        [ majorClass: major ]
    }

    def minorClass( ) {
        Integer id = Integer.valueOf( params.id )
        def minor = MinorAssetClass.get( id )
        [ minorClass: minor ]
    }
}
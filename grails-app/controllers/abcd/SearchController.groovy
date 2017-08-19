package abcd

class SearchController {

    def assetClassService

    def index() { }

    def search( ) {
        String q = params.q
        def term = "%${q.toLowerCase()}%"
        def minors = MinorAssetClass.findAll("from MinorAssetClass as m where LOWER(m.name) like ?", [term])
        println "FOUND ${minors} minor classes"

        def privates
        def groups
        if( minors.size() > 0 ) {
            def id = minors[0].id
            privates = assetClassService.privateSearch( id )
            groups = assetClassService.groupSearch( id )
        } else {
            privates = [ ]
            groups = [ ]
        }
        [ 'q':q, 'privateAssets':privates, 'groupAssets':groups ]
    }
}

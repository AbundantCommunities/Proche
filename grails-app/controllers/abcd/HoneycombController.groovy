package abcd

class HoneycombController {

    def honeycombService

    def hierarchy( ) {
        def hierarchy = honeycombService.getHierarchy( )
        log.info "HoneycombService's getHierarchy returned ${hierarchy}"
        return [hierarchy: hierarchy]
    }

    def major( ) {
        log.info "Get list of majors"
        [
            majors: honeycombService.getMajors( )
        ]
    }

    def minorsForMajor( ) {
        Long majorId = params.long('id')
        log.info "Get minors for major id ${majorId}"
        def ( MajorAssetClass major, AssetClassHierarchy[] nodes ) = honeycombService.getMinors( majorId )
        [
            major: major,
            nodes: nodes
        ]
    }
}

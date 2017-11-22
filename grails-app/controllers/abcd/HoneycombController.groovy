package abcd

class HoneycombController {

    def honeycombService
    def authenticateService

    def index( ) {
        log.info "Show the Honeycomb"
        [
            hierarchy: honeycombService.getHierarchy( )
        ]
    }

    def major( ) {
        Long majorId = params.long( 'id' )
        log.info "Edit MajorAssetClass ${majorId}"
        [
            major: honeycombService.getMajor( majorId )
        ]
    }

    def minor( ) {
        Long minorId = params.long( 'id' )
        log.info "Edit MinorAssetClass ${minorId}"
        [
            minor: honeycombService.getMinor( minorId )
        ]
    }

    def saveMajor( ) {
        authenticateService.ensurePrivileged( session )
        def id = params.long('id')
        if( !params.name ) {
            throw new RuntimeException( "MajorAssetClass name is empty" )
        }

        log.info "Save MajorAssetClass ${id}"
        honeycombService.saveMajor( params )
        redirect action:"index"
    }

    def saveMinor( ) {
        authenticateService.ensurePrivileged( session )
        def id = params.long('id')
        if( !params.name ) {
            throw new RuntimeException( "MinorAssetClass name is empty" )
        }

        log.info "Save MinorAssetClass ${id}"
        honeycombService.saveMinor( params )
        redirect action:"index"
    }
}

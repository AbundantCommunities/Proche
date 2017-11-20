package abcd

class MajorAssetClassController {
    def honeycombService

    def view( ) {
        Long majorId = params.long( 'id' )
        log.info "View MajorAssetClass is ${majorId}"
        [
            major: honeycombService.getMajor( majorId )
        ]
    }
}

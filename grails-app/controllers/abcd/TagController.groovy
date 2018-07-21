package abcd

class TagController {

    def TagService tagService

    def index( ) {
        String tagText = params.q
        log.info "Tag is ${tagText}"

        // Other sites that call this service can use our data as they see fit
        header( 'Access-Control-Allow-Origin', '*' )

        def result = tagService.getAssets( tagText )
        render groovy.json.JsonOutput.toJson( result )
    }
}

package abcd

class TagController {

    def TagService tagService

    /**
     * Example: http://localhost:8080/Proche/tag?q=food might return this
     * JSON text containging two assets: [{"id":87,"name":"Community Kitchen"},
     * {"id":89,"name":"How to grow vegetables"}]
     * 
     * Note the above is JUST an example. Our TagService controls what properties
     * are returned for each asset.
     */
    def index( ) {
        String tagText = params.q
        log.info "Tag is ${tagText}"

        // Other sites that call this service can use our data as they see fit
        header( 'Access-Control-Allow-Origin', '*' )

        def result = tagService.getAssets( tagText )
        render groovy.json.JsonOutput.toJson( result )
    }
}

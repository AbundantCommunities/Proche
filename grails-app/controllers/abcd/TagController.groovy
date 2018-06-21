package abcd

class TagController {

    def TagService tagService

    def index( ) {
        String tagText = params.q
        log.info "Tag is ${tagText}"
        def result = tagService.getAssets( tagText )
        render groovy.json.JsonOutput.toJson( result )
    }
}

package abcd

class TagController {

    def TagService tagService

    def index() {
        String tagText = params.tag
        log.info "Tag is ${tagText}"
        [
            tagText: tagText,
            assets: tagService.getAssets( tagText )
        ]
    }
}

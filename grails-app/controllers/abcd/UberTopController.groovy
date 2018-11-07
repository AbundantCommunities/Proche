package abcd

class UberTopController {

    def assetSuggestionService
    def assetService

    def index() {
        response.setHeader("Strict-Transport-Security", "max-age=86400")
        log.info "Topmost menu for user ${session.user}"
        [
            assetCount: assetService.countActive( ),
            suggestionCount: assetSuggestionService.countUnresolved( ),
            commentCount: Comment.count( )
        ]
    }
}

package abcd

class UberTopController {

    def assetSuggestionService

    def index() {
        log.info "Topmost menu for user ${session.user}"
        [
            assetCount: Asset.count(),
            suggestionCount: assetSuggestionService.countUnresolved( ),
            commentCount: Comment.count( )
        ]
    }
}

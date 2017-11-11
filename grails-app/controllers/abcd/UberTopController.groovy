package abcd

class UberTopController {

    def index() {
        log.info "Topmost menu for user ${session.user}"
        [
            assetCount: Asset.count(),
            suggestionCount: AssetSuggestion.count()
        ]
    }
}

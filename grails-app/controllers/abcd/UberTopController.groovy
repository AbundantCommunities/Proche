package abcd

class UberTopController {

    def index() {
        [
            assetCount: Asset.count(),
            suggestionCount: AssetSuggestion.count()
        ]
    }
}

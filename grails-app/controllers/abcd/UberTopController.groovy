package abcd

class UberTopController {

    def index() {
        [
            assetCount: Asset.count()
        ]
    }
}

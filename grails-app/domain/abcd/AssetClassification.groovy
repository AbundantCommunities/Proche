package abcd
/**
 * An Asset can be related to more than one MinorAssetClass.
 */
class AssetClassification {
    Asset asset
    MinorAssetClass minorAssetClass

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}

package abcd
/**
 * An instance of an Asset within a MinorAsset.
 */
class MinorAssetPair {
    MinorAssetClass minorAssetClass
    Asset asset
    Integer sortOrder // The order of Assets with a MinorAssetClass

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // An Asset can exist at most once for a given MinorAssetClass
        asset unique: ['minorAssetClass']
    }
    
    String toString( ) {
        "MinorAsset[${minorAssetClass}:${asset}]"
    }
}

package abcd
/**
 * A MinorAssetClass can belong to zero or more MajorAssetClass(es).
 * A MajorAssetClass can own zero or one of each MinorAssetClass.
 */
class AssetClassHierarchy {
    MajorAssetClass majorAssetClass
    Integer sortOrder // The order of MinorAssetClass(es) with a MajorAssetClass
    MinorAssetClass minorAssetClass

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // A MinorAssetClass can exist at most once for a given MajorAssetClass
        minorAssetClass unique: ['majorAssetClass']
    }
    
    String toString( ) {
        "Hierarchy[${majorAssetClass}:${minorAssetClass}]"
    }
}

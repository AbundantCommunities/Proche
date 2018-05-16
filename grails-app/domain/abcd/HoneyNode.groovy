package abcd
/**
 * A MinorAssetClass can belong to zero or more MajorAssetClass(es).
 * A MajorAssetClass can own zero or one of EACH MinorAssetClass.
 * 
 * 2018.4.24: I searched all Groovy files. Only HoneycombService references
 * HoneyNode.
 * 
 * From InsertBones.sql I can see that HoneyNode is what pairs a minor
 * and a major class.
 */
class HoneyNode {
    MajorAssetClass majorAssetClass
    MinorAssetClass minorAssetClass
    Integer sortOrder // The order of MinorAssetClass(es) with a MajorAssetClass

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // A MinorAssetClass can exist at most once for a given MajorAssetClass
        minorAssetClass unique: ['majorAssetClass']
    }
    
    String toString( ) {
        "HoneyNode[${majorAssetClass}:${minorAssetClass}]"
    }
}

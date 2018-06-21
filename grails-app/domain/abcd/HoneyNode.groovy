package abcd
/**
 * 2018.6.19: I searched all Groovy files. Only HoneycombService does anything
 * with HoneyNode.
 * 
 * A MinorAssetClass can belong to zero or more MajorAssetClass(es).
 * A MajorAssetClass can own zero or one of a given MinorAssetClass.
 * 
 * From InsertBones.sql I can see that HoneyNode is what pairs a minor
 * and a major class.
 */
class HoneyNode {
    MajorAssetClass majorAssetClass
    MinorAssetClass minorAssetClass
    Integer sortOrder // The order of MinorAssetClasses within a MajorAssetClass

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

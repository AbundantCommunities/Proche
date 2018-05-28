package abcd
/**
 * In our 2-level hierarchy of asset classes, a MinorAssetClass is at the
 * second level. See HoneyNode.
 */
class MinorAssetClass {
    String name
    String description
    String keywords

    Date dateCreated
    Date lastUpdated

    static hasMany = [ categories : Category ]

    static constraints = {
        keywords nullable: true
    }

    String toString( ) {
        "[Minor:${id},${name}]"
    }
}

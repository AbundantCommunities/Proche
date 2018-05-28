package abcd
/**
 * In our 2-level hierarchy of asset classes, a MajorAssetClass is at the
 * top level. See HoneyNode.
 */
class MajorAssetClass {
    String name
    String description
    Integer sortOrder
    String keywords

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name( )
        description( )
        sortOrder( )
        keywords nullable: true
    }

    String toString( ) {
        "[Major:${id},${name}]"
    }
}

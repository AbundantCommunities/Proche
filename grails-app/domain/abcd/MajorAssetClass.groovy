package abcd

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

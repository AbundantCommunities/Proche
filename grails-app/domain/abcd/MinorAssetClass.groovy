package abcd

class MinorAssetClass {
    String name
    String description
    String keywords

    Date dateCreated
    Date lastUpdated

    static constraints = {
        keywords nullable: true
    }

    String toString( ) {
        "[Minor:${id},${name}]"
    }
}

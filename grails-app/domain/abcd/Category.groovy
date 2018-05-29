package abcd
/**
 * An asset can be assigned to one or more categories. Here is an example of
 * why we need categories: We had an asset whose program name was "Our Lady of
 * Grace Program". That is the way it was promoted. Displaying that name to
 * someone told them nothing about the program's goals. Putting that asset
 * into categories "Teen Pregnancies" and "Parenting for teens" helps.
 */
class Category {
    String name
    String description

    Date dateCreated
    Date lastUpdated

    static hasMany = [ assets : Asset ]

    /* This means: one adds a Category to an Asset or to a MinorAssetClass.
     * One does adds neither Assets nor MinorAssetClasses to a Category. */
    static belongsTo = [ Asset, MinorAssetClass ]

    static constraints = {
    }
    
    String toString( ) {
        "Category ${id}:${name}"
    }
}

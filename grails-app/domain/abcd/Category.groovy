package abcd
/**
 * An asset can be assigned to one or more categories. Here is an example of
 * why we need categories: We have an asset whose program name is "Our Lady of
 * Grace Program". That name was chosen by the organization that runs the
 * program. Displaying that name to someone tells them nothing about the
 * program's goals & services. Assigning the asset to categories "Teen
 * Pregnancies" and "Parenting for teens" helps.
 */
class Category {
    String name
    String description

    Date dateCreated
    Date lastUpdated

    static hasMany = [ assets : Asset ]

    /* This means: one adds a Category to an Asset or to a MinorAssetClass.
     * One adds neither Assets nor MinorAssetClasses to a Category. */
    static belongsTo = [ Asset, MinorAssetClass ]

    static constraints = {
    }
    
    String toString( ) {
        "Category ${id}:${name}"
    }
}

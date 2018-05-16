package abcd

/**
 * An asset can be assigned to one or more categories. The motivation for Category
 * came when we started. We had an asset whose program name was "Our Lady of Grace
 * Program". Displaying that name to someone told them nothing. So, we now display
 * the Category and the asset name.
 */
class Category {
    String name
    String description

    static constraints = {
    }
}

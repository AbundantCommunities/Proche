package abcd

/**
 * An organization that administers data for one or more Community.
 */
class Administration {

    String name

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    String toString( ) {
        "Administration ${id}:${name}"
    }
}

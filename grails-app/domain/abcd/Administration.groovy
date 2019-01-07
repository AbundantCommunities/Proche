package abcd

/**
 * An organization that administers data for one or more Community.
 */
class Administration {

    String name

    static hasMany = [ communities: Community, tags: Tag ]

    Date dateCreated
    Date lastUpdated

    String toString( ) {
        "Administration ${id}:${name}"
    }
}

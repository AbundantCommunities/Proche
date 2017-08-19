package abcd

/**
 * An Organization is the entity that controls and/or pays for an asset.
 */
class Organization {
    String name

    Date dateCreated
    Date lastUpdated

    static hasMany = [ assets:Asset ]

    static constraints = {
    }
}

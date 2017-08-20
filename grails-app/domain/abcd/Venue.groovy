package abcd

/**
 * A Venue is generally a building. We like buildings because they have a name
 * and an address. Knowing a venue's name helps a person find the building. Of
 * course, knowing the address helps, too!
 * 
 * A Venue can also be virtual (a webpage, a phone number).
 */
class Venue {
    Boolean virtual  // if true then address is a URL or phone number
    String name  // of building, park, etc.
    String address  // Enough to translate to a lat & long.

    // If virtual then lat & long will be null

    // Lat & long have implied scale of 5 decimal places.
    // Ex: 12345678 would 123.45678 degrees. 123 would be 0.00123 degrees.

    // OR... Should I simply store floats??
    // Depends on how Grails maps to Postgres columns.

    Long latitude  // A value of 1 is approx 1.11 metres
    Long longitude // Distance changes with latitude.

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // null if Venue is virtual
        latitude nullable: true
        longitude nullable: true
    }
}

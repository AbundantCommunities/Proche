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

    // If Venue's location is virtual then lat & long will be null

    // Lat & long have implied Scale Factor of 5 decimal places.
    // Ex: 12345678 would 123.45678 degrees. 123 would be 0.00123 degrees.
    // A value of 1 corresponds to 1.11 metres.

    // OR... Should I simply store floats??
    // Depends on how Grails maps to Postgres columns.

    Long latitude
    Long longitude

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // null if Venue is virtual
        latitude nullable: true
        longitude nullable: true
    }
}

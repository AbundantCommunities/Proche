package abcd

/**
 * A Venue is generally a building. We like buildings because they have a name
 * and an address. Knowing a venue's name helps a person find the building. Of
 * course, knowing the address helps, too!
 */
class Venue {
    String name  // of building, park, etc.
    String address  // Enough to translate to a lat & long.

    Date dateCreated
    Date lastUpdated

    // In degrees, with 0.00001 the smallest absolute value
    // (gives me precision of 1.11 metres)
    BigDecimal latitude
    BigDecimal longitude

    static constraints = {
        // Normally, min and max do not affect the database schema but I need
        // min, max and scale to get numeric(7,5) and numeric(8,5).
        latitude  min: new BigDecimal('-90'),  max: new BigDecimal('90'),  scale: 5
        longitude min: new BigDecimal('-180'), max: new BigDecimal('180'), scale: 5
    }
}

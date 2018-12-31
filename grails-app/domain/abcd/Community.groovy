package abcd
/**
 * This is very similar to CommonGood's Neighbourhood domain class. But
 * CommonGood works at the level of the Community League, Homeowners Association,
 * etc. This is a matter of administration. Sometimes this differs from what
 * Proche needs.
 * 
 * Update: As of December 2018 we have a domain called Administration which looks
 * after the data of one or more Community objects.
 * 
 * Proche needs to work with geographical areas whose size is small enough
 * that residents therein feel some level of affinity for each other. There is
 * also a practical consideration. If an area is so large that a resident may
 * take say, an hour, to walk to the home of someone else in the area, that
 * works against engagement.
 * 
 * This class, Community, is about engagement, not administration.
 * 
 * There is no significance in the fact that CommonGood uses "neighbourhood"
 * and Proche uses "community". We simply needed two different terms, to
 * reduce confusion when reading code.
 */
class Community {

    String name
    static belongsTo = [administration:Administration]

    // The centre of this community
    BigDecimal centreLatitude  // in degrees; negative is south of equator
    BigDecimal centreLongitude  // in degrees; negative is east of Greenwich

    Date dateCreated
    Date lastUpdated

    static constraints = {
        // Scale is 5 because 0.00001 degrees latitude is around 1 metre.
        // One metre is close enough for our purposes.
        centreLatitude  nullable: true, scale: 5
        centreLongitude nullable: true, scale: 5
    }

    static mapping = {
        centreLatitude  defaultValue: 0.0
        centreLongitude defaultValue: 0.0
    }

    String toString( ) {
        "Community ${id}:${name}"
    }
}

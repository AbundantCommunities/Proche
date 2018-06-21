package abcd
/**
 * This is very similar to CommonGood's Neighbourhood domain class. But
 * CommonGood works at the level of the Community League, Homeowners Association,
 * etc. This is a matter of administration. Sometimes this differs from what
 * Proche needs.
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

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}

package abcd

/**
 * This is very similar to CommonGood's Neighbourhood domain class. However,
 * a Community is a municipal designation and names an area of land. For example,
 * in Edmonton, AB, Canada, Highlands community is organized by the neighbourhood
 * called Highlands Community League. The three communities of Sifton Park,
 * Belmont and Kernohan are all organized by the neighbourhood called South
 * Clareview Community League. [Blame it on history!]
 */
class Community {

    String name

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}

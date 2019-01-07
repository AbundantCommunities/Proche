package abcd
/**
 * Like a hashtag. Suppose we create a hashtag called "summerForKids" and
 * associate it with half a dozen assets that are particularly relevant to
 * summertime activities for kids. And suppose we implement a RESTful API that
 * anyone can call, asking "give me the assets tagged with summerForKids"
 * and our app returns the six assets.
 */
class Tag {

    Administration administration
    String text

    static hasMany = [ taggedAssets: TaggedAsset ]

    Date dateCreated
    Date lastUpdated
}

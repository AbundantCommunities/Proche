package abcd
/**
 * The public can post a comment on any of our assets.
 */
class Comment {
    Asset asset
    String submitterName
    String submitterContactInfo
    String says

    Date dateCreated
    Date lastUpdated

    static constraints = {
        submitterName maxSize: 50
        submitterContactInfo maxSize: 70
        says maxSize: 2000
    }

    String toString( ) {
        "Comment ${id} name ${submitterName} ${says}"
    }
}

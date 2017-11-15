package abcd

class Comment {

    Asset asset
    String name
    String contactInfo
    String says

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name maxSize: 40
        contactInfo maxSize: 60
        says maxSize: 2000
    }

    String toString( ) {
        "Comment ${id} name ${name} ${says}"
    }
}

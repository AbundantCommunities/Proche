package abcd

class Asset {
    String name
    String description
    String organization
    String location
//    Venue venue
//    String locationInVenue  // ex: "Rm 253", "north end of Allan St"
    Boolean zeroCost  // We don't use "free" because that term has tech meanings.

    String phoneNumber
    String emailAddress
    String url
    String schedule
    String keywords

// Anonymous search will find this asset only between these two dates
//    Date becomeVisible
//    Date becomeInvisible

    Date dateCreated
    Date lastUpdated

    String shortDescription
    static transients = [ 'shortDescription' ]

    static constraints = {
        name blank: false
        description maxSize: 1000, blank: false
        organization blank: false
        location blank: false
        phoneNumber blank: true
        emailAddress blank: true
        url maxSize: 2000, blank: true
        schedule blank: true
        keywords maxSize: 1000, blank: true
    }

    def getShortDescription( ) {
        if( description.size() < 100 ) {
            description
        } else {
            description.substring( 100 )
        }
    }
}

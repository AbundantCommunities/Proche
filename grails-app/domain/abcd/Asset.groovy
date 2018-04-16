package abcd

class Asset {
//    static java.sql.Timestamp LONG_AGO
//    static {
//        def longAgo = new Date( )
//        longAgo.clearTime()
//        longAgo.set year: 1950, month: java.util.Calendar.JUNE, date: 21
//        LONG_AGO = longAgo.toTimestamp( )
//    }

    String name
    String knownAs
    String description
    String organization
    String location
    Community community
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

    Date formallyReviewed
    Date dateCreated
    Date lastUpdated

    String shortDescription
    static transients = [ 'shortDescription' ]

    static mapping = {
        formallyReviewed defaultValue: 'CURRENT_DATE'
        knownAs defaultValue: "'KNOWN AS'"
    }

    static constraints = {
        name blank: false
        description maxSize: 1000, blank: false
        organization blank: false
        location blank: false
        community nullable: true
        phoneNumber blank: true
        emailAddress blank: true
        url maxSize: 2000, blank: true
        schedule blank: true
        keywords maxSize: 1000, blank: true
    }

    def getShortDescription( ) {
        if( description.size() <= 160 ) {
            description
        } else {
            // At least 161 characters. We will return a substring, but
            // preferably we will try not to break in the middle of a word.
            Integer idx = 161
            while( idx ) {
                Character iChar = description[idx]
                if( ! Character.isLetterOrDigit(description[idx] as Character) ) {
                    return description.substring( 0, idx ) + "..."
                }
                idx--
            }
            return description.substring( 0, 160 ) + "..."
        }
    }
}

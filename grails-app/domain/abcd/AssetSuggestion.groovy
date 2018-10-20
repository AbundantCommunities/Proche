package abcd
/**
 * The public can suggest assets for us to include in our database.
 */
class AssetSuggestion {
    static final String UNRESOLVED = "Unresolved"
    static final String ACCEPTED = "Accepted"
    static final String REJECTED = "Rejected"
    String resolution  // Unresolved, Accepted, Rejected

    String suggesterName
    String suggesterContactInfo
    String suggesterComment

    Community community
    String name
    String description
    String organization
    String location
    Boolean zeroCost  // We don't use "free" because that term has tech meanings.
    String phoneNumber
    String emailAddress
    String url
    String schedule

    String keywords
    String administratorComment

    Date dateCreated
    Date lastUpdated

    String shortDescription
    static transients = [ 'shortDescription' ]

    static constraints = {
        community nullable: true
        // FIXME suggestion descr max GT asset desc max
        description maxSize: 1000
        url maxSize: 2000
        // FIXME suggesterComment max way too long
        suggesterComment maxSize: 2000
        administratorComment maxSize: 500
        keywords maxSize: 1000
    }

    Boolean isQueued( ) {
        resolution.equals( UNRESOLVED )
    }

    String toString( ) {
        "SuggestedAsset ${id} ${resolution} name ${name} loc ${location}"
    }

    // FIXME same method is in Asset domain class
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

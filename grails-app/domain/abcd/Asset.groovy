package abcd
/**
 * The Asset class is the heart & soul of this application. All assets are
 * considered PUBLIC. They are in no way confidential.
 */
class Asset {
    String name
    String description
    String organization
    String location
    Community community
    Boolean zeroCost  // We say zeroCost because free has technical meaning.

    String phoneNumber
    String emailAddress
    String url
    String keywords

// Anonymous search will find this asset only between these two dates
//    Date becomeVisible
//    Date becomeInvisible

    Date reviewed
    Date dateCreated
    Date lastUpdated

    String shortDescription
    static transients = [ 'shortDescription' ]

    static hasMany = [ categories : Category ]

    static mapping = {
        reviewed defaultValue: 'CURRENT_DATE'
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

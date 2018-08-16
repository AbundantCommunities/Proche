package abcd
/**
 * The Asset class is the heart & soul of this application. All assets are
 * considered PUBLIC (although some Asset fields are used only internally).
 */
class Asset {
    Boolean active  // else not visible to the public at this time
    String name  // what the operating organization calls the asset
    String description
    String organization // who owns or operates this asset
    String location  // like "123 Happy Lane NW"
    Community community  // AKA neighbourhood
    Boolean zeroCost  // We say zeroCost because free has technical meaning.

    String url  // Ideally, this tells the user phone #, email address, etc
    String phoneNumber  // Who to contact for more info
    String emailAddress  // Who to contact for more info

    String keywords

// Anonymous search will find this asset only between these two dates
//    Date becomeVisible
//    Date becomeInvisible

    Date formallyReviewed
    Date dateCreated
    Date lastUpdated

    String shortDescription
    static transients = [ 'shortDescription' ]

    static hasMany = [ categories : Category ]

    static mapping = {
        active   defaultValue: "'TRUE'"
        formallyReviewed defaultValue: 'CURRENT_DATE'
    }

    static constraints = {
        name blank: false
        description maxSize: 1000, blank: false
        organization blank: false
        location blank: true
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
    
    String toString( ) {
        "Asset ${id}:${name}"
    }
}

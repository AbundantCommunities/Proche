package abcd

class AssetSuggestion {
    String resolution  // 1st letter in New, Accepted, Rejected
    String suggesterName
    String suggesterContactInfo
    String suggesterComment

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

    static constraints = {
        description maxSize: 1000
        url maxSize: 2000
        suggesterComment maxSize: 2000
        keywords maxSize: 1000
    }
}

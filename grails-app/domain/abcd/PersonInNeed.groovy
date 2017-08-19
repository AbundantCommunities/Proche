package abcd

class PersonInNeed {
    String name
    String emailAddress
    String phoneNumber
    String homeAddress

    // See note re lat & long in Venue class
    Long homeLatitude
    Long homeLongitude

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name( )
        emailAddress nullable: true
        phoneNumber nullable: true
        homeAddress nullable: true
    }
}

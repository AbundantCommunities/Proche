package abcd

class RequestForAid {
    PersonInNeed person

    // Exactly one of these two fields will be non-null:
    Asset organizationAsset
    String individualAsset

    // If the PersonInNeed navigated via the taxonomy these will be non-null:
    MajorAssetClass majorAssetClass
    MinorAssetClass minorAssetClass

    String note // Comment entered by PersonInNeed

    // Coordinates used for asset search.
    // See note re lat & long in Venue class.
    Long latitude
    Long longitude
    String ipAddress

    Boolean dispatched
    String dispatchNote
    Boolean closed
    String closeNote

    Date dateCreated
    Date lastUpdated

    static constraints = {
        organizationAsset nullable: true
        individualAsset nullable: true
        majorAssetClass nullable: true
        minorAssetClass nullable: true
        note( )
        latitude nullable: true
        longitude nullable: true
        dispatched defaultValue: "FALSE"
        dispatchNote nullable: true
        closed defaultValue: "FALSE"
        closeNote nullable: true
    }
}

package abcd

import grails.transaction.Transactional

@Transactional
class AssetClassService {

    def getMajorClasses( ) {
        MajorAssetClass.listOrderBySortOrder( )
    }

    def getMinorClasses( majorId ) {
        def query = AssetClassHierarchy.where {
                majorAssetClass.id == majorId
        }
        query.list(sort:'sortOrder')
    }

    def privateSearch( minorId ) {
        def result = [new PrivateAsset( name:'gardening', walkingDistance:7 ),
                        new PrivateAsset( name:'food prep', walkingDistance:59 )]
        switch ( minorId ) {
        case 14:
            // Child & elder care
            result = [new PrivateAsset( name:'Experience caring for aging parents', walkingDistance:20 )]
            break;
        case 56:
            // Money mgmt
            result = [new PrivateAsset( name:'Retired bank teller', walkingDistance:19 )]
        }
        return result
    }

    def groupSearch( minorId ) {
        def result
        def ven = Venue.get(1)
        def org = Organization.get(1)

        switch ( minorId ) {
        case 14:
            // Child & elder care
            result = [new Asset( name:'Pre-school program', description:'We look after kids while you work.',
                        organization:org, venue:ven, areaInVenue:'Common Room', cost:'Free', phoneNumber:'n/a',
                        website:'cbc.ca', schedule:'Mon-Fri', keywords:'children childcare' ),
                        new Asset( name:'Your Aging Parent', description:'Three one-hour classes with tips to help you help your elderly parents.',
                        organization:org, venue:ven, areaInVenue:'Room B3', cost:'Free', phoneNumber:'n/a',
                        website:'cbc.ca', schedule:'Mon-Fri', keywords:'work job' )]
            break;
        default:
            result = [new Asset( name:'Self-help Inc', address:'123 Lane', walkingDistance:7 ),
                new GroupAsset( name:'Street Aid', address:'55 Street', walkingDistance:59 )]

        }
        return result
    }

    def getHierarchy( )
    {
        def hierarchy = AssetClassHierarchy.findAll(
                'from AssetClassHierarchy ach order by ach.majorAssetClass.sortOrder, ach.sortOrder'
        )

        println "Found ${hierarchy.size()} AssetClassHierarchy rows"
        MajorAssetClass lastMajor = null
        def majors = [ ]
        def minors
        hierarchy.each{
            if( lastMajor ) {
                if( lastMajor != it.majorAssetClass ) {
                    // We have encountered a change in major class
                    // push out the previous major class
                    println "Begin ${it.majorAssetClass}"
                    minors = [ ]
                    majors << ['major':it.majorAssetClass,'minors':minors]
                    lastMajor = it.majorAssetClass
                } else {
                    // Current row has same major as lastMajor
                    println "    ${it.minorAssetClass}"
                }
            } else {
                println "Begin ${it.majorAssetClass}"
                minors = [ ]
                majors << ['major':it.majorAssetClass,'minors':minors]
                lastMajor = it.majorAssetClass
            }
            minors << it.minorAssetClass
        }
        println "No more data"
        return majors
    }
}
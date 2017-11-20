package abcd

import grails.transaction.Transactional

@Transactional
class HoneycombService {

    def getHierarchy( )
    {
        def hierarchy = AssetClassHierarchy.findAll(
                'from AssetClassHierarchy ach order by ach.majorAssetClass.sortOrder, ach.sortOrder'
        )
        log.info "Found ${hierarchy.size()} AssetClassHierarchy rows"
        MajorAssetClass lastMajor = null
        def majors = [ ]
        def minors
        hierarchy.each{
            if( lastMajor ) {
                if( lastMajor != it.majorAssetClass ) {
                    // We have encountered a change in major class
                    // push out the previous major class
                    log.debug "Begin ${it.majorAssetClass}"
                    minors = [ ]
                    majors << [ major: it.majorAssetClass, minors: minors ]
                    lastMajor = it.majorAssetClass
                } else {
                    // Current row has same major as lastMajor
                    log.debug "    ${it.minorAssetClass}"
                }
            } else {
                log.debug "Begin ${it.majorAssetClass}"
                minors = [ ]
                majors << [ major: it.majorAssetClass, minors: minors ]
                lastMajor = it.majorAssetClass
            }
            minors << it.minorAssetClass
        }
        return majors
    }

    def getMajor( Long majorId ) {
        log.info "Get a MajorAssetClass"
        MajorAssetClass.get( majorId )
    }

    def getMajors( ) {
        log.info "WTF?"
        MajorAssetClass.findAll("from MajorAssetClass as major order by major.sortOrder")
    }

    def getMinors( Long majorId  ) {
        MajorAssetClass major = MajorAssetClass.get( majorId )
        log.info "Get minors for ${major}"
        def nodes = AssetClassHierarchy.findAll("from AssetClassHierarchy as harchy where harchy.majorAssetClass = :major order by harchy.sortOrder",
            [ major: major] )
        return new Tuple2( major, nodes )
    }
}

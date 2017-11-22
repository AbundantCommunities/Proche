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

    def getMinor( Long minorId ) {
        log.info "Get MinorAssetClass id ${minorId}"
        MinorAssetClass.get( minorId )
    }

    def saveMajor( params ) {
        def id = params.long('id')
        MajorAssetClass major = MajorAssetClass.get( id )
        log.info "Update ${major}"

        if( major.version != params.long('version') ) {
            throw new Exception('Stale major')
        }

        major.name = params.name
        major.description = params.description
        if( params.keywords ) {
            log.info "Keywords not null"
            major.keywords = params.keywords
        } else {
            log.info "keywords is null"
            major.keywords = 'N/A'
        }

        major.save( flush:true, failOnError: true )
    }

    def saveMinor( params ) {
        def id = params.long('id')
        MinorAssetClass minor = MinorAssetClass.get( id )
        log.info "Update ${minor}"

        if( minor.version != params.long('version') ) {
            throw new Exception('Stale minor')
        }

        minor.name = params.name
        minor.description = params.description
        if( params.keywords ) {
            log.info "Keywords not null"
            minor.keywords = params.keywords
        } else {
            log.info "keywords is null"
            minor.keywords = 'N/A'
        }

        minor.save( flush:true, failOnError: true )
    }

    def getMajorsOLD( ) {
        log.info "WTF?"
        MajorAssetClass.findAll("from MajorAssetClass as major order by major.sortOrder")
    }

    def getMinorsOLD( Long majorId  ) {
        MajorAssetClass major = MajorAssetClass.get( majorId )
        log.info "Get minors for ${major}"
        def nodes = AssetClassHierarchy.findAll("from AssetClassHierarchy as harchy where harchy.majorAssetClass = :major order by harchy.sortOrder",
            [ major: major] )
        return new Tuple2( major, nodes )
    }
}

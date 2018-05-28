package abcd

import grails.transaction.Transactional

@Transactional
class HoneycombService {

    /**
     * Returns a list of dictionaries. Each entry represents a MajorAssetClass and
     * is a dictionary with two entries:
     *    'major' is the MajorAssetClass
     *    'minors' is a list of MinorAssetClass
     */
    def getHierarchy( )
    {
        def hierarchy = HoneyNode.findAll(
                'from HoneyNode hn order by hn.majorAssetClass.sortOrder, hn.sortOrder'
        )
        log.info "Found ${hierarchy.size()} HoneyNode rows"
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
        log.info "Get MajorAssetClass ${majorId}"
        MajorAssetClass.get( majorId )
    }

    def getMinor( Long minorId ) {
        log.info "Get MinorAssetClass id ${minorId}"
        MinorAssetClass.get( minorId )
    }

    def getAssetsOfMinorClass( Long minorId ) {
        log.info "Get Assets of Minor Class id ${minorId}"
        MinorAssetClass minor = MinorAssetClass.get( minorId )
        MinorAssetPair[] pairs = MinorAssetPair.findAllByMinorAssetClass( minor,  [sort: 'sortOrder'] )
        return new Tuple2( minor, pairs )
    }

    def getMinorClassesOfAsset( Long assetId ) {
        log.info "Get Minor Classes of Asset id ${assetId}"
        Asset asset = Asset.get( assetId )
        MinorAssetPair[] pairs = MinorAssetPair.findAllByAsset( asset )

        def honeycomb =  getHierarchy( )
        honeycomb.each {
            // each entry is a dictionary with two entries:
            // 1. 'major' is a MajorAssetClass
            // 2. 'minors' is a list of MinorAssetClass
            MajorAssetClass major = it.major
            MinorAssetClass[] minors = it.minors
            def augments = [ ]
            minors.each {
                MinorAssetClass minor = it
                // is minor in pairs? (i.e, is asset in pairs?)
                Boolean assigned = Boolean.FALSE
                pairs.each {
                    if( it.minorAssetClass.equals(minor) ) {
                        assigned = Boolean.TRUE
                    }
                }
                augments << [ minor:minor, assetIsAssigned:assigned ]
            }
            it.augmentedMinors = augments
        }
        return new Tuple2( asset, honeycomb )
    }

    def addToMinorClass( Long assetId, Long minorId ) {
        Asset asset = Asset.get( assetId )
        MinorAssetClass minor = MinorAssetClass.get( minorId )

        MinorAssetPair pair = MinorAssetPair.find {
            minorAssetClass == minor
            asset == asset
        }

        if( pair ) {
            log.warn "${asset} is already paired with ${minor}"
            throw new RuntimeException("Duplicate asset classification prevented")
        } else {
            log.info "Pair ${asset} with ${minor}"
            pair = new MinorAssetPair( )
            pair.minorAssetClass = minor
            pair.asset = asset
            pair.sortOrder = 123
            pair.save( flush: true, failOnError: true )
        }
    }
/*
    def removeFromMinorClass( Long assetId, Long minorId ) {
        Asset asset = Asset.get( assetId )
        MinorAssetClass minor = MinorAssetClass.get( minorId )
        //MinorAssetPair pair = MinorAssetPair.findAll("from MinorAssetPair where minorAssetClass=? and asset=?",[minor,asset])

        def pair = MinorAssetPair.find {
            minorAssetClass == minor
            asset == asset
        }

        log.info "Delete ${pair}"
        pair.delete( flush:true )
    }
*/
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
}

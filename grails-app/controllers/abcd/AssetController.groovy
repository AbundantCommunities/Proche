package abcd

class AssetController {

    //  static allowedMethods = [families:'GET', save:'POST']
    def assetService
    def mapService
    def authenticateService
    def assetSuggestionService
    def honeycombService

    def comment( ) {
        log.info "Enter comment for a public asset ${params}"
        def asset = Asset.get( params.long('id') )
        [
            asset: asset
        ]
    }

    def saveComment( ) {
        log.info "Save comment on public asset"
        Asset asset = Asset.get( params.long('id') )
        Comment comment = new Comment( )
        comment.asset = asset
        comment.submitterName = params.submitterName
        comment.submitterContactInfo = params.submitterContactInfo
        comment.says = params.says
        comment.save( flush:true, failOnError: true )
        flash.message = "Thanks for your comment"
        flash.nature = 'SUCCESS'
        redirect action:'view', id:asset.id
    }

    def initSearch( ) {
        Boolean includeInactive = authenticateService.isPrivileged( session )
        def communitiesInUse = assetService.getCommunitiesInUse( includeInactive )
        log.info "User will search assets from ${communitiesInUse.size()} communities"
        [
                communities: communitiesInUse
        ]
    }

    def search( ) {
        Long communityId = params.long('communityId')
        if( !communityId ) {
            flash.message = "You didn't select a community. Try again!"
            flash.nature = 'WARNING'
            redirect action:'initSearch'
        }

        String q = params.q
        Boolean showInactive = authenticateService.isPrivileged( session )
        def activeScope = showInactive?'Include inactive assets':'Exclude inactive assets'
        Integer walkingDistance = params.int('walkingDistance')

        log.info "Search community ${communityId} for ${q}, ${activeScope}, ${walkingDistance} minutes"
        [
            communityId: communityId,
            walkingDistance: walkingDistance,
            q: q,
            assets: assetService.search( q, showInactive, communityId, walkingDistance ),
            suggestionCount: assetSuggestionService.countUnresolved( )
        ]
    }

    def list() {
        // TODO this code is non-DRY WRT AssetSuggestionController
        Long offset
        Integer max
        if( params.offset ) {
            offset = params.long('offset')
            max = params.int('max')
        } else {
            if( session.pagination ) {
                offset = session.pagination.offset
                max = session.pagination.max
            } else {
                offset = 0
                max = 5
            }
            params.offset = offset
            params.max = max
        }
        log.info "List assets offset ${offset} max ${max}"
        session.pagination = [ offset:offset, max:max ]

        [
            assets: Asset.list( max:max, offset:offset, sort:'name' ),
            assetCount: Asset.count( ),
            suggestionCount: assetSuggestionService.countUnresolved( )
        ]
    }

    def view( ){
        Long id = params.long('id')
        if( id ) {
            log.info "View asset ${id}"
            Asset asset = Asset.get( id )
            if( asset ) {
                [
                    asset: asset,
                    mapLink: mapService.locateOnMap( asset )
                ]
            } else {
                throw new Exception( "Asset ${id} not found")
            }
        } else {
            log.info 'Googlebot sometimes crawls to /asset/view, with no params'
            redirect controller:'uberTop', action:'index'
        }
    }

    def viewPublic( ){
        Long id = params.long('id')
        log.info "Public view asset ${id}"
        Asset asset = Asset.get( id )
        if( asset ) {
            [
                asset: asset,
                mapLink: mapService.locateOnMap( asset )
            ]
        } else {
            throw new Exception( "Asset ${id} not found")
        }
    }

    def edit( ){
        authenticateService.ensurePrivileged( session )
        Long id = params.long('id')
        log.info "Edit asset ${id}"
        Asset asset = Asset.get( id )
        def mapLink = mapService.locateOnMap( asset )
        [
            asset: asset,
            mapLink: mapLink
        ]
    }

    def save() {
        authenticateService.ensurePrivileged( session )

        // TODO Check for valid params
        normalizeUrl( params )
        if( !params.name ) {
            throw new RuntimeException( "asset.name is empty" )
        }

        log.info "Save of asset id ${params.id} requested"

        // If HTML checkbox is cleared then the params.active will not exist
        if( params.active ) {
            params['active'] = 'TRUE'
        } else {
            params['active'] = 'FALSE'
        }

        assetService.update( params )
        
        // TODO After saving changes, display paginated search results
        redirect action:'list'
    }

    // TODO The normalizeUrl function is also in AssetController
    def normalizeUrl( params ) {
        String url = params.url
        if( url ) {
            if( url.startsWith("http://") || url.startsWith("https://") ) {
                log.debug "We like ${url}"
            }
            else {
                log.debug "Prefixing ${url} with http://"
                params.url = "http://${url}"
            }
        } else {
            log.debug "Sadly there is no URL"
        }
    }
}

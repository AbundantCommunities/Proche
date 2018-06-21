package abcd

import grails.transaction.Transactional

@Transactional
class TagService {

    def getAssets( String tagText ) {
        Tag tag = Tag.findByText( tagText )
        def taggedAssets = TagAsset.findAllByTag( tag,  [sort:'sortOrder'] )
        log.info "For tag ${tagText} found ${taggedAssets.size()}"
        def assets = [ ]
        taggedAssets.each {
            assets << it.asset
        }
        return assets
    }
}

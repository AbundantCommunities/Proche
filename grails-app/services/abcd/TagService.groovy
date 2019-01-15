package abcd

import grails.transaction.Transactional

@Transactional
class TagService {

    def getAssets( String tagText ) {
        Tag tag = Tag.findByText( tagText )
        def taggedAssets = TaggedAsset.findAllByTag( tag,  [sort:'sortOrder'] )
        log.info "For tag ${tagText} found ${taggedAssets.size()}"
        def assets = [ ]
        taggedAssets.each {
            // If we pass actual Asset objects then groovy.json.JsonOutput
            // will barf in our controller.
            assets << [
                id:it.asset.id,
                name:it.asset.name,
                shortDescription:it.asset.shortDescription,
                description: it.asset.description,
                organization: it.asset.organization,
                communitityName: it.asset.community.name,
                zeroCost: it.asset.zeroCost
            ]
        }
        return assets
    }
}

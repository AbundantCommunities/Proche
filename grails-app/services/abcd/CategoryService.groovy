package abcd

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class CategoryService {
    // Grails injects the default DataSource
    def dataSource

    def getAll( ) {
        def categories = Category.listOrderByDescription( )
        log.info "Found ${categories.size()} categories}"
        return categories
    }

    def get( Long categoryId ) {
        Category category = Category.get( categoryId )
        log.info "Fetching assets of ${category}"
        return category
    }

    def removeAsset( Long assetId, Long categoryId ) {
        Category category = Category.get( categoryId )
        Asset asset = Asset.get( assetId )
        if( category in asset.categories ) {
            // asset.categories is a Hibernate PersistentSet
            println "asset.categories is a ${asset.categories.class.name}"
            log.info "Removing ${asset} from ${category}"
            def res = asset.categories.removeElement( category )
            println "Result of removeElement is ${res}"
            asset.save( failOnError: true )
            return asset
        } else {
            log.warn "${asset} is not in ${category}"
            return null
        }
    }

    def addAsset( Long assetId, Long categoryId ) {
        Category category = Category.get( categoryId )
        Asset asset = Asset.get( assetId )
        if( category in asset.categories ) {
            // asset.categories is a Hibernate PersistentSet
            log.info "Odd: ${asset} is already in ${category}"
        } else {
            log.info "Adding ${asset} to ${category}"
            asset.categories = asset.categories + category
            asset.save( failOnError: true )
        }
        return new Tuple2( category, asset )
    }

    /**
     * Get all assets that are NOT in a given category
     */
    def getOthers( Long categoryId ) {
        Category category = Category.get( categoryId )
        log.info "Fetching assets NOT in ${category}"

        def select = 
            """SELECT asset.id, asset.name, asset.description
               FROM asset
               WHERE asset.id NOT IN (SELECT asset_id FROM asset_categories WHERE category_id = :categoryId)
               ORDER BY asset.name, asset.id"""

        final Sql sql = new Sql(dataSource)
        def assets = sql.rows( select, [ categoryId:categoryId ] )
        log.info "Found ${assets.size()} not in ${category}"
        return new Tuple2( category, assets )
    }
}

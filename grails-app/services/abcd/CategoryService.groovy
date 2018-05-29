package abcd

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class CategoryService {

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
        if( asset in category.assets ) {
            // category.assets is a Hibernate PersistentSet
            log.info "Removing ${asset} from ${category}"
            def res = category.assets.removeElement( asset )
            println "Result of removeElement is ${res}"
            category.save( failOnError: true )
            return asset
        } else {
            log.warn "${asset} is not in ${category}"
            return null
        }
    }

    def getOthers( Long categoryId ) {
        Category category = Category.get( categoryId )
        log.info "Fetching assets NOT in ${category}"
        
        peeps = Person.executeQuery(
            """select p.id, p.firstNames, p.lastName, p.phoneNumber, p.emailAddress, a.text
             from Person p join p.family f join f.address a
             where (LOWER(a.text) like :q OR LOWER(a.note) like :q OR LOWER(f.name) like :q OR LOWER(f.note) like :q
             OR LOWER(p.firstNames) like :q OR LOWER(p.lastName) like :q OR LOWER(p.phoneNumber) like :q OR LOWER(p.emailAddress) like :q
             OR LOWER(p.note) like :q)
             and a.block.neighbourhood.id = :id order by p.firstNames, p.lastName, p.id""",
            [ q:searchTerm, id:neighbourhoodId, fromYear:fromYear, toYear:toYear ] )
    }
}

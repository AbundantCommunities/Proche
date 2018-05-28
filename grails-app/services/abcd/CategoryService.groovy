package abcd

import grails.transaction.Transactional

@Transactional
class CategoryService {

    def get( ) {
        def categories = Category.listOrderByDescription( )
        log.info "Found ${categories.size()} categories}"
        return categories
    }
}

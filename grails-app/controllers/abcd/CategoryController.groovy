package abcd

class CategoryController {

    def categoryService

    def index() {
        log.info "Show the categories"
        [
            categories: categoryService.get( )
        ]
    }
}

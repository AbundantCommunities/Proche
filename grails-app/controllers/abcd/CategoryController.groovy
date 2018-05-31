package abcd

class CategoryController {

    def categoryService

    def index() {
        log.info "Show the categories"
        [
            categories: categoryService.getAll( )
        ]
    }

    def get( ) {
        def categoryId = params.long("id")
        log.info "Get assets for category id ${categoryId}"
        [
            category: categoryService.get( categoryId )
        ]
    }

    def enter( ) {
        log.info "Get a blank form to enter a new category"
    }

    def save( ) {
        log.info "Save new category ${params.name}"
        Category category = categoryService.save( params.name, params.description)
        if( category ) {
            flash.message = "Removed Asset: ${category.name}"
            flash.nature = "SUCCESS"
        } else {
            flash.message = "Failed to add the new category"
            flash.nature = "WARNING"
        }
        redirect action:"index"
    }

    def removeAsset( ) {
        def assetId = params.long("assetId")
        def categoryId = params.long("id")
        Asset asset =  categoryService.removeAsset( assetId, categoryId )
        if( asset ) {
            flash.message = "Removed Asset: ${asset.name}"
            flash.nature = "SUCCESS"
        } else {
            flash.message = "FAILED to remove asset"
            flash.nature = "WARNING"
        }
        redirect action:"get", id:categoryId
    }

    def addAsset( ) {
        def assetId = params.long("assetId")
        def categoryId = params.long("id")
        def ( Category category, Asset asset ) = categoryService.addAsset( assetId, categoryId )
        flash.message = "Added ${asset.name} to Category ${category.name}"
        flash.nature = "SUCCESS"
        redirect action:"getOthers", id:categoryId
    }

    def getOthers( ) {
        def categoryId = params.long("id")
        log.info "Get assets NOT in category id ${categoryId}"
        def ( Category category, Object[] assets ) = categoryService.getOthers( categoryId )
        [
            category: category,
            assets: assets
        ]
    }
}

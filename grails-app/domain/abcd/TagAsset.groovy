package abcd
/**
 * Pairs a Tag with an Asset. We could let Grails look after this automagically
 * but we want to control the sort order of the assets associated with a given
 * Tag.
 */
class TagAsset {

    Tag tag
    Asset asset
    Integer sortOrder

    static constraints = {
    }
}

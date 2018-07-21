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
        // FIXME This unique-constraint fails to generate postgres equivalent
        // ... see HoneyNode
        // An asset can exist at most once for a given tag
        asset unique: ['tag']
    }
}

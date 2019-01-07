package abcd
/**
 * Pairs a Tag with an Asset. We want to allow assets to be sorted differently
 * depending on the tag, otherwise we would let Grails generate this table.
 */
class TaggedAsset {

    Asset asset
    Integer sortOrder

    static belongsTo = [tag: Tag]
    static mapping = {
        sort sortOrder: "asc"
    }

    static constraints = {
        // FIXME This unique-constraint fails to generate postgres equivalent
        // An asset can exist at most once for a given tag
        //        asset unique: ['tag']
    }
}

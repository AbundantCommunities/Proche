package abcd

import grails.transaction.Transactional
import java.net.URLEncoder

@Transactional
class AssetService {

    def firstLetters() {
        def assets = AssetSuggestion.list( [sort: 'name', order: 'asc'] )
        def result = [ ]
        Character previousLetter = null
        Integer count = 0
        assets.each{
            Character thisLetter = it.name.charAt(0)
            println "Read ${thisLetter}, previous was ${previousLetter}, count is ${count}"
            if( previousLetter ) {
                if( thisLetter == previousLetter ) {
                    println '    nothing new here'
                } else {
                    result << [ letter: previousLetter, count: count ]
                    count = 0
                }
            } else {
                println '    (nothing to compare to)'
            }
            previousLetter = thisLetter
            count++
        }
        if( previousLetter ) {
            result << [ letter: previousLetter, count: count ]
        }
        result
    }

    def search( String q, Integer offset ) {
        println "Asset Svc: search for ${q} offset ${offset}"
        def query = Asset.whereAny {
            name =~ "%${q}%"
            description =~ "%${q}%"
        }
        query.list( [sort: 'name', offset: offset, max: 10000] )
    }

    String locateOnMap( Asset asset ) {
        String loc = asset.location
        loc = URLEncoder.encode(loc, "UTF-8")
        "https://www.google.ca/maps/place/${loc},+Edmonton,+AB+T6C+3T8"
    }

    def byFirstLetter( firstLetter ) {
        def nextLetter = 'C'
        def query = Asset.where {
            name >= firstLetter
            name < nextLetter
        }
        def result = query.findAll( )
        println "Found ${result.size()} assets starting with ${firstLetter}"
    }
}

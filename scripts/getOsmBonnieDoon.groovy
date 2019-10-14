@Grab('com.xlson.groovycsv:groovycsv:1.1')
@Grab('ch.qos.logback:logback-classic:1.2.3')
@Grab('io.github.http-builder-ng:http-builder-ng-okhttp:1.0.4')

import static com.xlson.groovycsv.CsvParser.parseCsv
import static groovyx.net.http.HttpBuilder.configure
import groovy.json.JsonSlurper

def csvFile = new File('bdAddresses.csv')
def rawAddresses = [ ]

csvFile.withReader{ reader ->
    def addrs = parseCsv( reader )
    for(addr in addrs) {
        rawAddresses += addr[0]
    }
}
println "Retrieved ${rawAddresses.size()} addresses"

def jsonParser = new JsonSlurper( )

def http = configure {
//    request.uri = 'https://nominatim.openstreetmap.org'
    request.uri = 'https://us1.locationiq.com/v1'
}

rawAddresses.each{
    println "------------\n${it}"
    if( it.length() > 3 ) {
        def plussed = it.replaceAll(' ','+')
        def address = "${plussed}+NW,Edmonton,AB,Canada"

        def responseContent = http.get {
            request.uri.path = '/search.php'
            request.uri.query = [key:'d6c3db7495d0e9', format:'json', q:address]
        }

        // def json = jsonParser.parseText( responseContent )
        def json = responseContent
        println "Response content is ${json}"
        println "Response content class is ${json.class.name}"
        println "Response content length is ${json.size()}"
        json.each{
            println "  **  ${it}"
        }
        if( json.size() == 1 ) {
            if( (json[0].class=='building') || (json[0].class=='place') ) {
                println "AWESOME!\n%COORD, ${it}, ${json[0].lat}, ${json[0].lon}"
            } else {
                println "ERROR class is neither building nor place for ${it.id}: ${json}\n"
            }
        } else {
            println "ERROR Not exactly one item for ${it.id}: ${json}\n"
        }
        sleep 12000
    } else {
        println "ERROR ${it} is too short"
    }
}

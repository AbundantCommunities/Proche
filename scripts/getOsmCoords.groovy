@Grab('io.github.http-builder-ng:http-builder-ng-okhttp:1.0.3')
import static groovyx.net.http.HttpBuilder.configure
import groovy.sql.Sql
import groovy.json.JsonSlurper

def sql = Sql.newInstance('jdbc:postgresql://localhost/abcd', 'myapp', 'sloj92GOM', 'org.postgresql.Driver')
def rows = sql.rows('SELECT id, name, location FROM asset WHERE active ORDER BY id')
sql.connection.close( )

println "Retrieved ${rows.size()} assets"
def jsonParser = new JsonSlurper( )

def http = configure {
    request.uri = 'https://nominatim.openstreetmap.org'
}

rows.each{
    println "------------\nRow ${it}"
    if( it.location.length() > 3 ) {
        if( it.location.substring(it.location.length()-2).equals('NW') ) {
            def plussed = it.location.replaceAll(' ','+')
            def address = "${plussed},Edmonton,AB,Canada"

            def responseContent = http.get {
                request.uri.path = '/search'
                request.uri.query = [format:'json', q:address]
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
                    println "AWESOME!\n%COORD, ${it.id}, ${json[0].lat}, ${json[0].lon}"
                } else {
                    println "ERROR class is neither building nor place for ${it.id}: ${json}\n"
                }
            } else {
                println "ERROR Not exactly one item for ${it.id}: ${json}\n"
            }
            sleep 12000

        } else {
            println "ERROR id ${}: location ${it.location} does not end in NW"
        }
    } else {
        println "ERROR id ${it.id}: location ${it.location} is too short"
    }
}

return
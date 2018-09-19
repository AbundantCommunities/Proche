@Grab('io.github.http-builder-ng:http-builder-ng-okhttp:1.0.3')
import static groovyx.net.http.HttpBuilder.configure
import groovy.sql.Sql

def sql = Sql.newInstance('jdbc:postgresql://localhost/abcd', 'myapp', 'sloj92GOM', 'org.postgresql.Driver')
def rows = sql.rows('SELECT id, name, location FROM asset WHERE active ORDER BY id')
sql.connection.close( )

println "Retrieved ${rows.size()} assets"

def http = configure {
    request.uri = 'https://nominatim.openstreetmap.org'
}

rows.each{
    println "------------\nRow ${it}"
    if( it.location.length() > 3 ) {
        if( it.location.substring(it.location.length()-2).equals('NW') ) {
            def plussed = it.location.replaceAll(' ','+')
            def address = "${plussed},Edmonton,AB,Canada"

            def json = http.get {
                request.uri.path = '/search'
                request.uri.query = [format:'json', q:address]
            }
            println "RESPONSE for ${it.id} = ${json}\n"

        } else {
            println "ERROR id ${}: location ${it.location} does not end in NW"
        }
    } else {
        println "ERROR id ${it.id}: location ${it.location} is too short"
    }

    sleep 12000
}

return
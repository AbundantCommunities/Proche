@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
import org.locationtech.jts.io.WKTReader

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Geometry

import groovy.time.TimeCategory 
import groovy.time.TimeDuration

def ourLat = 53.52784
def ourLon = -113.47027

Coordinate myCoordinate = new Coordinate( ourLon, ourLat )
GeometryFactory factory = new GeometryFactory( )
Geometry myPoint = factory.createPoint( myCoordinate )

def csvFile = new File('/Users/theguy/Downloads/NEIGHBOURHOODS_SHAPE.csv')
// NUMBER,AREA_KM2,NAME,the_geom

def geomReader = new WKTReader()

csvFile.withReader{ reader ->
    def hoods = parseCsv( reader )
    def start = new Date( )
    for(hood in hoods) {
        // hood is a com.xlson.groovycsv.PropertyMapper
        // hood.columns is [const:0,  assetId:1,  longitude:2,  latitude:3]
        // hood.values is like [%COORD,  1018,  53.6039795357143,  -113.377735078571]
        // println "${hood.values[2]} is SOMEWHERE" // [${home.values[2]},${home.values[3]}]"
        def geom = geomReader.read( hood.values[3] )
        if( geom.contains(myPoint) ) {
            println "Am I in ${hood.values[2]}?"
        }
    }
    def stop = new Date( )
    TimeDuration td = TimeCategory.minus( stop, start )
    println "Took ${td} to search all neighbourhoods"
}

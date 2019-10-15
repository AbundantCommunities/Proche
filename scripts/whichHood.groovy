@Grab('org.locationtech.jts:jts-core:1.6.0')
@Grab('com.xlson.groovycsv:groovycsv:1.1')

import static com.xlson.groovycsv.CsvParser.parseCsv

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.io.WKTReader

// yegHoods.csv originated at https://data.edmonton.ca/dataset/Neighbourhood-Boundaries-2019/xu6q-xcmj
// I stripped out some columns, leaving the neighbourhood name and the MULTIPOLYGON string that specifies
// the neighbourhood's boundaries (lat and long points). The first line has column names.

// TODO use CsvParser for reading yegHood.csv
def yegHoods = new FileReader("yegHoods.csv")

nhBoundaries = [:]
def wktReader = new WKTReader( )
def skipCount = 0
def firstLine = true

for( String line in yegHoods) {
    if( firstLine ) {
        // skip headers
        firstLine = false
    } else {
        def comma = line.indexOf(',')
        def nhood = line.substring(0,comma)

        if( comma+1 == line.size() ) {
            // Line is like "Edgemont,"
            // println "No boundary data for ${nhood}"
            skipCount++
        } else {
            def polyStr = line.substring(comma+2,line.size()-1)
            Geometry mulPoly = wktReader.read( polyStr )
            nhBoundaries[nhood] = mulPoly
        }
    }
}

yegHoods.close( )
println "${skipCount} neighbourhoods skipped because no boundary data"
println "${nhBoundaries.size()} neighbourhood boundaries read"

def gf = new GeometryFactory( )

def csvFile = new File('neighbourLatLong.csv')

def foundHood = 0
def addrsRead = 0

csvFile.withReader{ reader ->
    def addrs = parseCsv( reader )
    for(addr in addrs) {
        addrsRead++
        Double lat = new Double( addr[1] )
        Double lon = new Double( addr[2] )

        def x = new Coordinate( lon, lat )
        def point = gf.createPoint( x )

        def found = false
        nhBoundaries.each {k, v ->
            if( v.contains(point) ) {
                found = true
                println "${addr[0]} is in ${k}"
            }
        }

        if( found ) {
            foundHood++
        } else {
            println "${addr[0]} is not in any neighbourhood"
        }
    }
}

println "Read ${addrsRead} addresses"
println "Located ${foundHood} addresses in a YEG neighbourhood"

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.io.WKTReader

// The CSV file originated at https://data.edmonton.ca/dataset/Neighbourhood-Boundaries-2019/xu6q-xcmj
// I stripped out some columns, leaving the neighbourhood name and the MULTIPOLYGON string that specifies
// the neighbourhood's boundaries (lat and long points). Line 1 has data, not column names.
def yegHoods = new FileReader("/Users/theguy/Downloads/yegHoods.csv")

nhBoundaries = [:]
def wktReader = new WKTReader( )
def skipCount = 0

for( String line in yegHoods) {
    def comma = line.indexOf(',')
    def nhood = line.substring(0,comma)

    if( comma+1 == line.size() ) {
        // Sometimes a nhood has no boundary data; line is like "Edgemont,"
        println "No boundary data for ${nhood}"
        skipCount++
    } else {
        def polyStr = line.substring(comma+2,line.size()-1)
        Geometry mulPoly = wktReader.read( polyStr )
        nhBoundaries[nhood] = mulPoly
    }
}

yegHoods.close( )
println "${skipCount} neighbourhoods skipped because no boundary data"
println "${nhBoundaries.size()} neighbourhood boundaries read"

// This lat+long pair is located in Bonnie Doon
def x = new Coordinate( -113.47027, 53.52784 )
def gf = new GeometryFactory( )
def point = gf.createPoint( x )
println "User location is ${point}"

nhBoundaries.each {k, v ->
    if( v.contains(point) ) {
        // Prints Bonnie Doon !!
        println "In ${k}"
    }
}

println "Tout fini"

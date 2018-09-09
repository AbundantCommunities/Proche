import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.geom.Polygon
import org.locationtech.jts.geom.Coordinate

// a Coordinate is simply a point on the plane, with optional height
// a Point is a Geometry

double top = 200.0
double bottom = 100.0
double left = 500.0
double right = 999.0

double topX = 999.0
double bottomX = 0.0
double leftX = 999.0
double rightX = 0.0

GeometryFactory factory = new GeometryFactory( )

Coordinate[ ] cs = new Coordinate[5];
cs[0]=new Coordinate( top, left );
cs[1]=new Coordinate( bottom, left );
cs[2]=new Coordinate( bottom,right );
cs[3]=new Coordinate( top,right );
cs[4]=new Coordinate( top,left );

Coordinate[ ] csX = new Coordinate[5];
csX[0]=new Coordinate( topX, leftX );
csX[1]=new Coordinate( bottomX, leftX );
csX[2]=new Coordinate( bottomX,rightX );
csX[3]=new Coordinate( topX,rightX );
csX[4]=new Coordinate( topX,leftX );

Coordinate myCoordinate = new Coordinate( 199.9, 998.99999 )
Geometry myPoint = factory.createPoint( myCoordinate )

Polygon poly = factory.createPolygon( cs );
Polygon polyX = factory.createPolygon( csX );

println "poly is ${poly}"
println "polyX is ${polyX}"

if( poly.contains(myPoint) ) {
    println "contains"
} else {
    println "OUTSIDE"
}

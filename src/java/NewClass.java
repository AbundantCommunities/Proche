import java.util.ArrayList;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom..impl.CoordinateArraySequence;

public class NewClass {

  public static void main(final String[] args) {

    final GeometryFactory gf = new GeometryFactory();

    final ArrayList<Coordinate> points = new ArrayList<Coordinate>();
    points.add(new Coordinate(-10, -10));
    points.add(new Coordinate(-10, 10));
    points.add(new Coordinate(10, 10));
    points.add(new Coordinate(10, -10));
    points.add(new Coordinate(-10, -10));
    final Polygon polygon = gf.createPolygon(new LinearRing(new CoordinateArraySequence(points
        .toArray(new Coordinate[points.size()])), gf), null);

    final Coordinate coord = new Coordinate(0, 0);
    final Point point = gf.createPoint(coord);

    System.out.println(point.within(polygon));

  }

}
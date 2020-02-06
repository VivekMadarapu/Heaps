import java.awt.*;
import java.util.Comparator;

public class PointManhattanDistanceComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return (Math.abs(p1.x) + Math.abs(p1.y) - (Math.abs(p2.x) + Math.abs(p2.y)));
    }
}


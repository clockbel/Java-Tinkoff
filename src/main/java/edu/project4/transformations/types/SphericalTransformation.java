package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r2 = point.x() * point.x() + point.y() * point.y();
        double newX = point.x() / r2;
        double newY = point.y() / r2;
        return new Point(newX, newY);
    }
}

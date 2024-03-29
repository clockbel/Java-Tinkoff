package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class DiamondTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double t = Math.atan(point.x() / point.y());
        double newX = Math.sin(t) * Math.cos(r);
        double newY = Math.sin(r) * Math.cos(t);
        return new Point(newX, newY);
    }
}

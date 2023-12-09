package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double t = Math.atan(point.x() / point.y());
        double newX = (t / Math.PI) * Math.sin(Math.PI * r);
        double newY = (t / Math.PI) * Math.cos(Math.PI * r);
        return new Point(newX, newY);
    }
}

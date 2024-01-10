package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class SpiralTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double t = Math.atan(point.x() / point.y());
        double newX = (1 / r) * (Math.cos(t) + Math.sin(r));
        double newY = (1 / r) * (Math.sin(t) - Math.cos(r));
        return new Point(newX, newY);
    }
}

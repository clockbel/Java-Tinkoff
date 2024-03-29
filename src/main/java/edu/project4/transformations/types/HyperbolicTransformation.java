package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class HyperbolicTransformation implements Transformation {
    private static final double COEF = 0.5;

    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double t = Math.atan(point.x() / point.y());
        double newX = Math.sin(t) / r;
        double newY = r * Math.cos(t);
        return new Point(COEF * newX, COEF * newY);
    }
}

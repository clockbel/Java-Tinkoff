package edu.project4.transformations.types;

import edu.project4.objects.Point;
import edu.project4.transformations.Transformation;

public class SinTransformation implements Transformation {
    private static final double COEF = 1.2;

    @Override
    public Point apply(Point point) {
        double newX = Math.sin(point.x());
        double newY = Math.sin(point.y());
        return new Point(COEF * newX, COEF * newY);
    }
}

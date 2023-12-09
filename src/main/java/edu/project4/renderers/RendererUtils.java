package edu.project4.renderers;

import edu.project4.objects.Point;
import edu.project4.transformations.Variation;
import java.security.SecureRandom;
import java.util.Random;

public final class RendererUtils {
    public static final double X_LIMIT = 1.777;
    public static final double Y_LIMIT = 1;
    public static final int MULTIPLIER = 2;
    public static final Random RANDOM = new SecureRandom();

    private RendererUtils() {
    }

    public static Point transform(Point point, Variation variation) {
        return variation.func().apply(variation.shift().apply(point));
    }

    public static Point rotate(Point point, double theta) {
        double rotatedX = point.x() * Math.cos(theta) - point.y() * Math.sin(theta);
        double rotatedY = point.x() * Math.sin(theta) + point.y() * Math.cos(theta);

        return new Point(rotatedX, rotatedY);
    }

    public static Point getRandomPoint() {
        double newX = RANDOM.nextDouble(-1 * X_LIMIT, X_LIMIT);
        double newY = RANDOM.nextDouble(-1 * Y_LIMIT, Y_LIMIT);
        return new Point(newX, newY);
    }
}

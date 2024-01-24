package edu.project4.transformations;

import edu.project4.objects.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class TransformationList {
    private static final Random RANDOM = new SecureRandom();
    private static final int COLOR_LIMIT = 256;
    private static final double BOUND = 2;
    private static final int VARIATIONS_AMOUNT = 16;

    private TransformationList() {
    }

    public static List<Variation> getVariations(Transformation transformation) {
        List<Variation> variations = new ArrayList<>(VARIATIONS_AMOUNT);
        for (int i = 0; i < VARIATIONS_AMOUNT; i++) {
            Color color = getRandomColor();
            Shift shift = getRandomShift();
            variations.add(new Variation(transformation, shift, color.r(), color.g(), color.b()));
        }
        return variations;
    }

    private static Color getRandomColor() {
        return new Color(RANDOM.nextInt(COLOR_LIMIT), RANDOM.nextInt(COLOR_LIMIT), RANDOM.nextInt(COLOR_LIMIT));
    }

    private static Shift getRandomShift() {
        double a = 0;
        double b = 0;
        double c;
        double d = 0;
        double e = 0;
        double f;
        boolean notCorrect = true;
        while (notCorrect) {
            a = RANDOM.nextDouble(-1, 1);
            b = RANDOM.nextDouble(-1, 1);
            d = RANDOM.nextDouble(-1, 1);
            e = RANDOM.nextDouble(-1, 1);
            notCorrect = a * a + d * d >= 1;
            notCorrect |= b * b + e * e >= 1;
            notCorrect |= a * a + d * d + b * b + e * e >= 1 + (a * e - b * d) * (a * e - b * d);
        }
        c = RANDOM.nextDouble(-1 * BOUND, BOUND);
        f = RANDOM.nextDouble(-1 * BOUND, BOUND);
        return new Shift(a, b, c, d, e, f);
    }
}

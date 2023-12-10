package edu.project4;

import edu.project4.objects.Image;
import edu.project4.objects.Pixel;
import edu.project4.renderers.MultiThreadRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.renderers.SingleThreadRenderer;
import edu.project4.transformations.types.SinTransformation;
import edu.project4.transformations.TransformationList;
import edu.project4.transformations.Variation;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRender {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int SAMPLES = 10000;
    private static final int ITER_PER_SAMPLES = 500;
    private static final int MAX_COLOR = 255;

    @Test
    void testSingleThreadRender() {
        // given
        Image image = Image.create(WIDTH, HEIGHT);
        List<Variation> variations = TransformationList.getVariations(new SinTransformation());
        Renderer renderer = new SingleThreadRenderer();

        // when
        renderer.render(image, variations, 1, SAMPLES, (short) ITER_PER_SAMPLES);

        // then
        for (int x = 0; x < image.width(); ++x) {
            for (int y = 0; y < image.height(); ++y) {
                Pixel pixel = image.pixel(x, y);
                assertNotNull(pixel);
                assertTrue(pixel.r() >= 0 && pixel.r() <= MAX_COLOR);
                assertTrue(pixel.g() >= 0 && pixel.g() <= MAX_COLOR);
                assertTrue(pixel.b() >= 0 && pixel.b() <= MAX_COLOR);
            }
        }
    }

    @Test
    void testMultiThreadRender() {
        Image image = Image.create(WIDTH, HEIGHT);
        List<Variation> variations = TransformationList.getVariations(new SinTransformation());
        Renderer renderer = new MultiThreadRenderer();
        renderer.render(image, variations, 1, SAMPLES, (short) ITER_PER_SAMPLES);
        for (int x = 0; x < image.width(); ++x) {
            for (int y = 0; y < image.height(); ++y) {
                Pixel pixel = image.pixel(x, y);
                assertNotNull(pixel);
                assertTrue(pixel.r() >= 0 && pixel.r() <= MAX_COLOR);
                assertTrue(pixel.g() >= 0 && pixel.g() <= MAX_COLOR);
                assertTrue(pixel.b() >= 0 && pixel.b() <= MAX_COLOR);
            }
        }
    }
}

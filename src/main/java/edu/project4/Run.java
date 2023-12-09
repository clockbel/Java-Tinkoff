package edu.project4;

import edu.project4.images.GammaCorrector;
import edu.project4.images.ImageFormat;
import edu.project4.images.ImageProcessor;
import edu.project4.images.ImageUtils;
import edu.project4.objects.Image;
import edu.project4.renderers.MultiThreadRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.transformations.TransformationList;
import edu.project4.transformations.Variation;
import edu.project4.transformations.types.PolarTransformation;
import java.nio.file.Path;
import java.util.List;

@SuppressWarnings("UncommentedMain")
public final class Run {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final int SAMPLES = 2_500_000;
    private static final int ITER_PER_SAMPLES = 300;

    private Run() {

    }

    public static void main(String[] args) {
        Image image = Image.create(WIDTH, HEIGHT);
        List<Variation> variations = TransformationList.getVariations(new PolarTransformation());
        Renderer renderer = new MultiThreadRenderer();
        renderer.render(image, variations, 1, SAMPLES, (short) ITER_PER_SAMPLES);
        ImageProcessor imageProcessor = new GammaCorrector();
        imageProcessor.process(image);
        ImageUtils.save(image, Path.of("1.png"), ImageFormat.PNG);
    }
}

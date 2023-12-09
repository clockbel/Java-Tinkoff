package edu.project4.images;

import edu.project4.objects.Image;
import edu.project4.objects.Pixel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private static final int BIG_SHIFT = 16;
    private static final int MED_SHIFT = 8;

    private ImageUtils() {
    }

    public static void save(Image image, Path filename, ImageFormat format) {
        try {
            ImageIO.write(imgToBufferedImage(image), format.name().toUpperCase(), filename.toFile());
        } catch (IOException ignored) {
        }
    }

    private static BufferedImage imgToBufferedImage(Image image) {
        BufferedImage bi = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.height(); i++) {
            for (int j = 0; j < image.width(); j++) {
                Pixel pixel = image.pixel(j, i);
                bi.setRGB(j, i, (pixel.r() << BIG_SHIFT) + (pixel.g() << MED_SHIFT) + pixel.b());
            }
        }
        return bi;
    }


}

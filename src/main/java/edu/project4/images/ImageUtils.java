package edu.project4.images;

import edu.project4.objects.Image;
import edu.project4.objects.Pixel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private static final int MAX = 255;
    private static final int A = 24;
    private static final int R = 16;
    private static final int G = 8;
    private static final int BLACK = MAX << A;

    private ImageUtils() {
    }

    public static void save(Image image, String filename, ImageFormat format) {
        BufferedImage bufferedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < image.width(); ++x) {
            for (int y = 0; y < image.height(); ++y) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() == 0) {
                    bufferedImage.setRGB(x, y, BLACK);
                    continue;
                }
                int color = (MAX << A) | (pixel.r() << R) | (pixel.g() << G) | pixel.b();
                bufferedImage.setRGB(x, y, color);
            }
        }

        File outputFile = new File(filename);
        try {
            ImageIO.write(bufferedImage, format.name(), outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

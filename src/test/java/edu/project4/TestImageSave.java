package edu.project4;

import edu.project4.images.ImageFormat;
import edu.project4.images.ImageUtils;
import edu.project4.objects.Image;
import edu.project4.objects.Pixel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestImageSave {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    @Test
    void testSave(@TempDir Path tempDir) {
        // given
        Image image = createTestImage();
        String filename = tempDir.resolve("test.png").toString();

        // when
        ImageUtils.save(image, filename, ImageFormat.PNG);

        // then
        File outputFile = new File(filename);
        assertTrue(outputFile.exists());
    }

    private Image createTestImage() {
        Image image = Image.create(WIDTH, HEIGHT);
        for (int x = 0; x < WIDTH; ++x) {
            for (int y = 0; y < HEIGHT; ++y) {
                image.setPixel(new Pixel(100, 150, 200, 1, 10), x, y);
            }
        }
        return image;
    }
}


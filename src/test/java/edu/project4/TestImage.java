package edu.project4;

import edu.project4.objects.Image;
import edu.project4.objects.Pixel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestImage {
    @Test
    @DisplayName("TestImage")
    void Test1() {
        Image image = Image.create(100, 200);
        image.setPixel(new Pixel(10,10, 10, 1, 2), 1, 1);
        assertEquals(100, image.width());
        assertEquals(200, image.height());
        assertTrue(image.contains(1, 1));
    }
    @Test
    @DisplayName("IncorrectTestImage")
    void Test2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Image.create(-100, -200));
        String extendMessage = "Incorrect width or height";
        String actualMessage = exception.getMessage();
        assertThat(extendMessage).isEqualTo(actualMessage);
    }
}

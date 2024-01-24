package edu.project4.objects;

public record Image(Pixel[][] data, int width, int height) {
    public static Image create(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Incorrect width or height");
        }
        Pixel[][] data = new Pixel[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                data[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new Image(data, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel pixel(int x, int y) {
        return contains(x, y) ? data[y][x] : null;
    }

    public void setPixel(Pixel newPixel, int x, int y) {
        data[y][x] = newPixel;
    }
}

package edu.project4.images;

import edu.project4.objects.Image;

@FunctionalInterface
public interface ImageProcessor {
    void process(Image image);
}

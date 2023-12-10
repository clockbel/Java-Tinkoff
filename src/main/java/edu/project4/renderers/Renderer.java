package edu.project4.renderers;

import edu.project4.objects.Image;
import edu.project4.transformations.Variation;
import java.util.List;

public interface Renderer {
    Image render(
        Image canvas,
        List<Variation> variations,
        int symmetry,
        int samples,
        short iterPerSample
    );
}

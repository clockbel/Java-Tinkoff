package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test1")
    void sampleFirst() {
        List<Integer> l = new ArrayList<>(List.of(1, 2, 3));
        Iterator<Integer> it = new BackwardIterator<>(l);
        int i = 3;
        while (it.hasNext()) {
            Integer cur = it.next();
            assertThat(cur).isEqualTo(i);
            i--;
        }
    }
}

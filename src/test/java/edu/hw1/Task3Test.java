package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("isNestableTest_1")
    void isNestableTest_1() {
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {0, 6};
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isTrue();
    }

    @Test
    @DisplayName("isNestableTest_2")
    void isNestableTest_2() {
        int[] array1 = new int[] {3, 1};
        int[] array2 = new int[] {4, 0};
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isTrue();
    }

    @Test
    @DisplayName("isNestableTest_3")
    void isNestableTest_3() {
        int[] array1 = new int[] {9, 9, 8};
        int[] array2 = new int[] {8, 9};
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isFalse();
    }

    @Test
    @DisplayName("isNestableTest_4")
    void isNestableTest_4() {
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {2, 3};
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isFalse();
    }

    @Test
    @DisplayName("isNestableTest_5")
    void isNestableTest_5() {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{};
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isFalse();
    }

    @Test
    @DisplayName("isNestableTest_6")
    void isNestableTest_6() {
        int[] array1 = new int[1];
        int[] array2 = new int[3];
        boolean a = Task3.isNestable(array1, array2);
        assertThat(a).isFalse();
    }
}

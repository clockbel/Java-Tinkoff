package edu.hw3;


import edu.hw3.Task1.AtbashCipher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        String string = "Hello world!";
        String result = "Svool dliow!";
        assertThat(AtbashCipher.atbash(string)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test2")
    public void Test2() {
        String string =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String result = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertThat(AtbashCipher.atbash(string)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test3")
    public void Test3() {
        assertThat(AtbashCipher.atbash(null)).isNull();
    }
}

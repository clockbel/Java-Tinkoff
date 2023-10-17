package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    @Test
    @DisplayName("TestDictionaryIsEmpty")
    void TestDictionaryIsEmpty() {
        String filePath = "dictionaryTestFiles\\emptyfile.txt";
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(dictionary.getFileAsIOStream(filePath));
       assertThat(dictionary.getRandomWord()).isEqualTo("Dictionary is empty");
    }
    @Test
    @DisplayName("TestIncorrectWord")
    void TestIncorrectWord() {
        String filePath = "dictionaryTestFiles\\incorrectWord.txt";
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(dictionary.getFileAsIOStream(filePath));
        assertThat(dictionary.getRandomWord()).isEqualTo("Incorrect word");
    }
    @Test
    @DisplayName("TestCorrectWord")
    void TestCorrectWord() {
        String filePath = "dictionaryTestFiles\\correctWord.txt";
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(dictionary.getFileAsIOStream(filePath));
        assertThat(dictionary.getRandomWord()).isEqualTo("correct");
    }

    @Test
    @DisplayName("TestLoseBreak")
    void TestLoseBreak() {
     Attempts attempts = new Attempts(10);
     assertThat(attempts.checkAttemptLose(10)).isFalse();
    }

    @Test
    @DisplayName("TestWinBreak")
    void TestWinBreak() {
        Attempts attempts = new Attempts(10);
        assertThat(attempts.checkAttemptWin("correct")).isFalse();
    }
}

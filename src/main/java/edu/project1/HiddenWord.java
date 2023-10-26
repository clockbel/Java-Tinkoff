package edu.project1;

import java.util.Arrays;

public class HiddenWord {
    String wordGame;
    char[] wordGameSecret;

    public HiddenWord(String wordGameForPlay) {
        char[] word = new char[wordGameForPlay.length()];
        Arrays.fill(word, '*');
        this.wordGame = wordGameForPlay;
        this.wordGameSecret = word;
    }

    public String getHiddenWord() {
        return String.valueOf(wordGameSecret);
    }

    public boolean replaceChar(char symbol) {
        boolean check = false;
        for (int i = 0; i < wordGameSecret.length; i++) {
            if (wordGame.toCharArray()[i] == symbol) {
                wordGameSecret[i] = symbol;
                check = true;
            }
        }
        return check;
    }
}

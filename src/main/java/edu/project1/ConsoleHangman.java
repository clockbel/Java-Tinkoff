package edu.project1;

import java.util.Objects;

public final class ConsoleHangman {
    private static final char INCORRECT_CHAR = '$';
    private static final int MAX_ATTEMPTS = 10;

    private ConsoleHangman() {
    }

    public static void hangmanStart() {
        String filePath = "dictionaryFiles\\words.txt";
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(dictionary.getFileAsIOStream(filePath));
        String word = dictionary.getRandomWord();
        boolean flagWord = !Objects.equals(word, "Dictionary is empty") && !Objects.equals(word, "Incorrect word");
        if (flagWord) {
            boolean check;
            char sym;
            int checkAttempts = 0;
            boolean flag = true;
            Attempts kol = new Attempts(MAX_ATTEMPTS);
            HiddenWord wordSecret = new HiddenWord(word);
            try {
                while (flag) {
                    Messege.statusGame(Status.WORD, wordSecret.getHiddenWord());
                    sym = Scan.scannerSymbol();
                    if (sym != INCORRECT_CHAR) {
                        check = wordSecret.replaceChar(sym);
                        if (!check) {
                            Messege.statusGame(Status.NOT_FOUND, "");
                            flag = kol.checkAttemptLose(++checkAttempts);
                        } else {
                            Messege.statusGame(Status.FOUND, "");
                            flag = kol.checkAttemptWin(wordSecret.getHiddenWord());
                        }
                    } else {
                        Messege.statusGame(Status.INCORRECT_CHAR, "");
                    }
                }
            } catch (Exception e) {
                Messege.statusGame(Status.WORD, "Exit game");
            }
            Messege.statusGame(Status.WORD, "Game word:" + word);
        } else {
            Messege.statusGame(Status.WORD, "Dictionary fail: " + word);
        }
    }
}

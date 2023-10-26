package edu.project1;

import java.util.Objects;

public final class ConsoleHangman {
    private static final char INCORRECT_CHAR = '$';
    private static final int MAX_ATTEMPTS = 10;

    private ConsoleHangman() {
    }

    public static void hangmanStart() {
        String filePath = "dictionaryFiles/words.txt";
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(dictionary.getFileAsIOStream(filePath));
        String word = dictionary.getRandomWord();
        boolean flagWord = !Objects.equals(word, "Dictionary is empty") && !Objects.equals(word, "Incorrect word");
        if (flagWord) {
            boolean check;
            char sym;
            int checkAttempts = 0;
            boolean flag = true;
            Status status;
            Attempts kol = new Attempts(MAX_ATTEMPTS);
            HiddenWord wordSecret = new HiddenWord(word);
            try {
                while (flag) {
                    Message.statusGame(Status.WORD, wordSecret.getHiddenWord());
                    sym = Scan.scannerSymbol();
                    if (sym != INCORRECT_CHAR) {
                        check = wordSecret.replaceChar(sym);
                        if (!check) {
                            status = Status.NOT_FOUND;
                            flag = kol.checkAttemptLose(++checkAttempts);
                        } else {
                            status = Status.FOUND;
                            flag = kol.checkAttemptWin(wordSecret.getHiddenWord());
                        }
                    } else {
                        status = Status.INCORRECT_CHAR;
                    }
                    Message.statusGame(status, "");
                }
            } catch (Exception e) {
                Message.statusGame(Status.WORD, "Exit game");
            }
            Message.statusGame(Status.WORD, "Game word:" + word);
        } else {
            Message.statusGame(Status.WORD, "Dictionary fail: " + word);
        }
    }
}

package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dictionary {
    private List<String> words;
    private static final int MAX_LENGHT_WORD = 3;

    private final static Logger LOGGER = LogManager.getLogger();

    public InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    public void readFile(InputStream is) {
        words = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public String getRandomWord() {
        String word;
        if (!words.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(words.size());
            String wordCheck = words.get(randomIndex);
            if (wordCheck.length() < MAX_LENGHT_WORD || !checkWord(wordCheck)) {
                word = "Incorrect word";
            } else {
                word = wordCheck;
            }
        } else {
            word = "Dictionary is empty";
        }
        return word;
    }

    private boolean checkWord(String word) {
        char[] wordForCheck = word.toCharArray();
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(wordForCheck[i])) {
                flag = false;
            }
        }
        return flag;
    }
}

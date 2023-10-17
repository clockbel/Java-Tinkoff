package edu.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dictionary {
    private List<String> words;
    private static final int MAX_LENGHT_WORD = 3;

    private final static Logger LOGGER = LogManager.getLogger();

    public Dictionary(String filePath) {
        words = new ArrayList<>();
        File f = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
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

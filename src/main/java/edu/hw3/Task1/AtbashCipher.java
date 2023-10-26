package edu.hw3.Task1;

import java.util.HashMap;

public final class AtbashCipher {
    private AtbashCipher() {

    }

    public static String atbash(String message) {
        if (message == null) {
            return null;
        }

        StringBuilder cipher = new StringBuilder();
        HashMap<Character, Character> lookupTable = generateMap();
        for (char letter : message.toCharArray()) {
            if (letter != ' ') {
                if (Character.isLetter(letter) && Character.toLowerCase(letter) == letter) {
                    cipher.append(lookupTable.get(letter));
                } else if (Character.isLetter(letter) && Character.toUpperCase(letter) == letter) {
                    cipher.append(Character.toUpperCase(lookupTable.get(Character.toLowerCase(letter))));
                } else {
                    cipher.append(letter);
                }
            } else {
                cipher.append(' ');
            }
        }
        return cipher.toString();

    }

    private static HashMap<Character, Character> generateMap() {
        HashMap<Character, Character> alphabetForCipher = new HashMap<>();
        alphabetForCipher.put('a', 'z');
        alphabetForCipher.put('b', 'y');
        alphabetForCipher.put('c', 'x');
        alphabetForCipher.put('d', 'w');
        alphabetForCipher.put('e', 'v');
        alphabetForCipher.put('f', 'u');
        alphabetForCipher.put('g', 't');
        alphabetForCipher.put('h', 's');
        alphabetForCipher.put('i', 'r');
        alphabetForCipher.put('j', 'q');
        alphabetForCipher.put('k', 'p');
        alphabetForCipher.put('l', 'o');
        alphabetForCipher.put('m', 'n');
        alphabetForCipher.put('n', 'm');
        alphabetForCipher.put('o', 'l');
        alphabetForCipher.put('p', 'k');
        alphabetForCipher.put('q', 'j');
        alphabetForCipher.put('r', 'i');
        alphabetForCipher.put('s', 'h');
        alphabetForCipher.put('t', 'g');
        alphabetForCipher.put('u', 'f');
        alphabetForCipher.put('v', 'e');
        alphabetForCipher.put('w', 'd');
        alphabetForCipher.put('x', 'c');
        alphabetForCipher.put('y', 'b');
        alphabetForCipher.put('z', 'a');
        return alphabetForCipher;
    }
}

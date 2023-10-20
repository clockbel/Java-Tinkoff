package edu.hw3;

import java.util.HashMap;

public final class Task1 {
    private Task1() {

    }

    public static String atbash(String message) {
        HashMap<Character, Character> lookupTable = new HashMap<Character, Character>() {{
            put('a', 'z');
            put('b', 'y');
            put('c', 'x');
            put('d', 'w');
            put('e', 'v');
            put('f', 'u');
            put('g', 't');
            put('h', 's');
            put('i', 'r');
            put('j', 'q');
            put('k', 'p');
            put('l', 'o');
            put('m', 'n');
            put('n', 'm');
            put('o', 'l');
            put('p', 'k');
            put('q', 'j');
            put('r', 'i');
            put('s', 'h');
            put('t', 'g');
            put('u', 'f');
            put('v', 'e');
            put('w', 'd');
            put('x', 'c');
            put('y', 'b');
            put('z', 'a');
        }};
        String cipher = "";
        for (char letter : message.toCharArray()) {
            if (letter != ' ') {
                if (Character.isLetter(letter) && Character.toLowerCase(letter) == letter) {
                    cipher += lookupTable.get(letter);
                } else if (Character.isLetter(letter) && Character.toUpperCase(letter) == letter) {
                    cipher += Character.toUpperCase(lookupTable.get(Character.toLowerCase(letter)));
                } else {
                    cipher += letter;
                }
            } else {
                cipher += ' ';
            }
        }
        return cipher;
    }
}

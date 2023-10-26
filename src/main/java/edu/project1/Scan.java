package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Scan {
    private Scan() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static char scannerSymbol() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Choose your character: ");
        String str = scanner.next();
        char symbol = '$';
        if (str.length() == 1 && Character.isLetter(str.toCharArray()[0])) {
            symbol = str.toCharArray()[0];
        }
        return symbol;
    }
}

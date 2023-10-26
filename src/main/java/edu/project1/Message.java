package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Message {
    private Message() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void statusGame(Status status, String word) {
        switch (status) {
            case WIN:
                LOGGER.info("You win!");
                break;
            case LOSE:
                LOGGER.info("You lose");
                break;
            case FOUND:
                LOGGER.info("Found char");
                break;
            case NOT_FOUND:
                LOGGER.info("Not found char");
                break;
            case INCORRECT_CHAR:
                LOGGER.info("Incorrect symbol");
                break;
            case WORD:
                LOGGER.info(word);
                break;
            default:
                break;
        }
    }
}

package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Attempts {
    int countAttemptsLose;
    private final static Logger LOGGER = LogManager.getLogger();

    public Attempts(int countAttempts) {
        this.countAttemptsLose = countAttempts;
    }

    public boolean checkAttemptLose(int attempt) {
        LOGGER.info("Attempt to check " + attempt + " from " + countAttemptsLose);
        boolean flag = true;
        if (attempt == countAttemptsLose) {
            Message.statusGame(Status.LOSE, "");
            flag = false;
        }
        return flag;
    }

    public boolean checkAttemptWin(String wordGame) {
        boolean flag = true;
        if (wordGame.indexOf('*') == -1) {
            Message.statusGame(Status.WIN, "");
            flag = false;
        }
        return flag;
    }
}

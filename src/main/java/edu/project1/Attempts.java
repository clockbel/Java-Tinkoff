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
        LOGGER.info("Attempt to check " + Integer.toString(attempt) + " from " + Integer.toString(countAttemptsLose));
        boolean flag = true;
        if (attempt == countAttemptsLose) {
            Messege.statusGame(Status.LOSE, "");
            flag = false;
        }
        return flag;
    }

    public boolean checkAttemptWin(String wordGame) {
        boolean flag = true;
        if (wordGame.indexOf('*') == -1) {
            Messege.statusGame(Status.WIN, "");
            flag = false;
        }
        return flag;
    }
}

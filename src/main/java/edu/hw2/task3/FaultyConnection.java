package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int FIRSTS_DIGIT_AFTER_POINT = 10;

    @Override
    public void execute(String command) {
        int random = (int) (Math.random() * FIRSTS_DIGIT_AFTER_POINT);
        if (random % 2 != 0) {
            LOGGER.info("ConnectionFaulty: DONE");
            LOGGER.info(command);
        } else {
            throw new ConnectionException("ConnectionFaulty: FAIL");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Closed!");
    }
}

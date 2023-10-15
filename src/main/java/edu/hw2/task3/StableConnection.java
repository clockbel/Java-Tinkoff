package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        LOGGER.info("ConnectionStable: DONE");
        LOGGER.info(command);
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Closed!");
    }
}

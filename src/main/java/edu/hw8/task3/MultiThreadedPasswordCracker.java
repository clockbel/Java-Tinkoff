package edu.hw8.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw8.task3.PasswordsFunctions.calculateString;
import static edu.hw8.task3.PasswordsFunctions.nextPassword;
import static edu.hw8.task3.PasswordsFunctions.getUsernameByHash;
import static edu.hw8.task3.PasswordsFunctions.md5Hash;

public class MultiThreadedPasswordCracker {
    private static Map<String, String> passwordDatabase;
    private static Map<String, String> crackDatabase = new HashMap<>();
    private static final AtomicBoolean PASSWORD_FOUND = new AtomicBoolean(false);
    private static int numThreads;
    private final static Logger LOGGER = LogManager.getLogger();

    public MultiThreadedPasswordCracker(Map<String, String> passwordDatabase, int numThreads) {
        MultiThreadedPasswordCracker.passwordDatabase = passwordDatabase;
        MultiThreadedPasswordCracker.numThreads = numThreads;
    }

    public Map<String, String> crack() {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        String password = "a";
        int lengthPassword = 1;
        while (!PASSWORD_FOUND.get()) {
            executorService.execute(new PasswordCrackerTask(password));
            password = nextPassword(lengthPassword, password.toCharArray());
            if (Objects.equals(password, calculateString(lengthPassword, "9"))) {
                lengthPassword += 1;
                password = calculateString(lengthPassword, "a");
            }
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        LOGGER.info("Время выполнения: " + (endTime - startTime) + " миллисекунд");
        return crackDatabase;
    }

    private record PasswordCrackerTask(String currentPassword) implements Runnable {

        @Override
        public void run() {
            String hash = md5Hash(currentPassword);
            if (passwordDatabase.containsValue(hash)) {
                String username = getUsernameByHash(hash, passwordDatabase);
                crackDatabase.put(username, currentPassword);
                PASSWORD_FOUND.set(true);
            }
        }
    }
}


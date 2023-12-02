package edu.hw8.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw8.task3.PasswordsFunctions.calculateString;
import static edu.hw8.task3.PasswordsFunctions.generatePasswords;
import static edu.hw8.task3.PasswordsFunctions.getUsernameByHash;
import static edu.hw8.task3.PasswordsFunctions.md5Hash;

public final class SingleThreadedPasswordCracker {
    private static Map<String, String> passwordDatabase;
    private static Map<String, String> crackDatabase = new HashMap<>();
    private final static Logger LOGGER = LogManager.getLogger();

    public SingleThreadedPasswordCracker(Map<String, String> passwordDatabase) {
        SingleThreadedPasswordCracker.passwordDatabase = passwordDatabase;
    }

    public Map<String, String> crack() {
        long startTime = System.currentTimeMillis();
        String password = "a";
        int lengthPassword = 1;
        do {
            String hash = md5Hash(password);
            if (passwordDatabase.containsValue(hash)) {
                String username = getUsernameByHash(hash, passwordDatabase);
                crackDatabase.put(username, password);
                passwordDatabase.remove(username, hash);
            }
            password = generatePasswords(lengthPassword, password.toCharArray());
            if (Objects.equals(password, calculateString(lengthPassword, "9"))) {
                lengthPassword += 1;
                password = calculateString(lengthPassword, "a");
            }
        } while (!passwordDatabase.isEmpty());
        long endTime = System.currentTimeMillis();
        LOGGER.info("Время выполнения: " + (endTime - startTime) + " миллисекунд");
        return crackDatabase;
    }

}



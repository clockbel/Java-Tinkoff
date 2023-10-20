package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    @DisplayName("DefaultConnectionManagerTest")
    void DefaultConnectionManagerTest() {
        ConnectionManager connectionManager = new DefaultConnectionManager();
        assertThat(connectionManager.getConnection()).isInstanceOf(Connection.class);
    }

    @Test
    @DisplayName("FaultyConnectionManagerTest")
    void FaultyConnectionManagerTest() {
        ConnectionManager connectionManager = new FaultyConnectionManager();
        assertThat(connectionManager.getConnection()).isInstanceOf(FaultyConnection.class);
    }
    @Test
    void TestExecutorFaultyConnection() {
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        boolean conncetionException = false;
        try {
            for (int i = 0; i < 15; i++) {
                commandExecutor.tryExecute("command - 1");
            }
        } catch (ConnectionException e) {
            conncetionException = true;
        }
        assertThat(conncetionException).isEqualTo(true);
    }
}

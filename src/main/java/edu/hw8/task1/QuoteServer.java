package edu.hw8.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuoteServer {
    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 5;
    private final static Logger LOGGER = LogManager.getLogger();

    private QuoteServer() {
    }

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOGGER.info("Сервер запущен на порту " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}

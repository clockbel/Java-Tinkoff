package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuoteClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8008;
    private final static Logger LOGGER = LogManager.getLogger();

    private QuoteClient() {

    }

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            while (true) {
                LOGGER.info("Ваня: ");
                String request = consoleReader.readLine();
                writer.println(request);

                String response = reader.readLine();
                LOGGER.info("Сервер: " + response);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final static Logger LOGGER = LogManager.getLogger();

    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String request;
            while ((request = reader.readLine()) != null) {
                LOGGER.info("Получен запрос: " + request);
                String response = getResponse(request);
                writer.println(response);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private String getResponse(String request) {
        String result;
        // Реализуйте логику выбора цитаты в зависимости от ключевых слов
        switch (request.toLowerCase()) {
            case "личности":
                result = "Не переходи на личности там, где их нет";
                break;
            case "оскорбления":
                result = "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами";
                break;
            case "глупый":
                result = "А я тебе говорил, что ты глупый? Так вот, я забираю "
                    + "свои слова обратно... Ты просто бог идиотизма.";
                break;
            case "интеллект":
                result = "Чем ниже интеллект, тем громче оскорбления";
                break;
            default:
                result = "Не понял запроса. Повторите.";
                break;
        }
        return result;
    }
}

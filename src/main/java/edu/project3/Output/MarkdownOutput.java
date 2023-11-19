package edu.project3.Output;

import edu.project3.LogAnalysis.LogAnalysis;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;

public final class MarkdownOutput {
    private MarkdownOutput() {
    }

    public static void printResult(String path, LocalDate from, LocalDate to, LogAnalysis logAnalysis) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/java/edu/project3/Result/result.md"))) {

            writer.println("#### Общая информация\n");
            writer.println("| Метрика                  | Значение    |");
            writer.println("|:------------------------:|------------:|");
            writer.printf("| Файл(-ы)                          | %-16s |%n", path);
            writer.printf("| Начальная дата                    | %-16s |%n", from != null ? from : "-");
            writer.printf("| Конечная дата                     | %-16s |%n", to != null ? to : "-");
            writer.printf("| Количество запросов               | %-16d |%n", logAnalysis.getTotalRequests());
            writer.printf("| Средний размер ответа в (байтах)  | %-16d |%n", logAnalysis.getAverageResponseSize());

            writer.println("\n#### Запрашиваемые ресурсы\n");
            writer.println("|     Ресурс      | Количество |");
            writer.println("|:---------------:|-----------:|");

            for (Map.Entry<String, Integer> entry : logAnalysis.sortedMap(logAnalysis.getResourceCountMap())
                .entrySet()) {
                String resource = String.format("%-150s", entry.getKey());
                String count = String.format("%-11d", entry.getValue());
                writer.println(String.format("|  %s | %s |", resource, count));
            }

            writer.println("\n#### Коды ответа\n");
            writer.println("| Код |          Имя          | Количество |");
            writer.println("|:---:|:---------------------:|-----------:|");

            for (Map.Entry<String, Integer> entry : logAnalysis.sortedMap(logAnalysis.getResponseCodeCountMap())
                .entrySet()) {
                String code = String.format("%-3s", entry.getKey());
                String name = String.format("%-24s", ResponseCode.getResponseCode(entry.getKey()));
                String count = String.format("%-13d", entry.getValue());
                writer.println(String.format("| %s | %s | %s |", code, name, count));
            }

            writer.println("\n#### Статистика по IP\n");
            writer.println("|      IP Address      | Количество запросов |");
            writer.println("|:---------------------:|---------------------:|");

            for (Map.Entry<String, Integer> entry : logAnalysis.sortedMap(logAnalysis.getIpAddressMap()).entrySet()) {
                String ipAddress = String.format("%-21s", entry.getKey());
                String requestCount = String.format("%-20d", entry.getValue());
                writer.println(String.format("| %s | %s |", ipAddress, requestCount));
            }

            writer.println("\n#### Статистика по UserAgent\n");
            writer.println("|         User-Agent         | Количество запросов |");
            writer.println("|:--------------------------:|---------------------:|");

            for (Map.Entry<String, Integer> entry : logAnalysis.sortedMap(logAnalysis.getUserAgentMap()).entrySet()) {
                String userAgent = String.format("| %-150s | %-12d |", entry.getKey(), entry.getValue());
                writer.println(userAgent);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

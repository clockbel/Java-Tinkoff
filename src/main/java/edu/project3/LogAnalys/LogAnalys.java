package edu.project3.LogAnalys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAnalys {
    private final List<Log> logs;
    private Map<String, Integer> resourceCountMap = new HashMap<>();
    private Map<Integer, Integer> responseCodeCountMap = new HashMap<>();

    private Map<String, Integer> ipAddressMap = new HashMap<>();

    private Map<String, Integer> userAgentMap = new HashMap<>();
    private int totalRequests;
    private long averageResponseSize;

    public LogAnalys(List<Log> logs) {
        this.logs = logs;
        calculateMetrics();
    }

    public void calculateMetrics() {
        // Реализация расчета метрик
        // Подсчет общего количества запросов
        totalRequests = logs.size();
        long totalResponseSize = 0;
        // Определение наиболее часто запрашиваемых ресурсов
        for (Log log : logs) {
            String resource = log.resource();
            resourceCountMap.put(resource, resourceCountMap.getOrDefault(resource, 0) + 1);

            String ipAddress = log.ip();
            ipAddressMap.put(ipAddress, ipAddressMap.getOrDefault(ipAddress, 0) + 1);

            String userAgent = log.userAgent();
            userAgentMap.put(userAgent, userAgentMap.getOrDefault(userAgent, 0) + 1);
            // Определение наиболее часто встречающихся кодов ответа
            int responseCode = log.responseCode();
            responseCodeCountMap.put(responseCode, responseCodeCountMap.getOrDefault(responseCode, 0) + 1);
            // Рассчет среднего размера ответа сервера
            totalResponseSize += log.responseSize();
        }
        averageResponseSize = totalRequests > 0 ? totalResponseSize / totalRequests : 0;

    }

    public Map<String, Integer> getResourceCountMap() {
        return resourceCountMap;
    }

    public Map<Integer, Integer> getResponseCodeCountMap() {
        return responseCodeCountMap;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public long getAverageResponseSize() {
        return averageResponseSize;
    }

    public Map<String, Integer> getIpAddressMap() {
        return ipAddressMap;
    }

    public Map<String, Integer> getUserAgentMap() {
        return userAgentMap;
    }
}

package edu.project3.LogAnalysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalysis {
    private final List<Log> logs;
    private Map<String, Integer> resourceCountMap = new HashMap<>();
    private Map<String, Integer> responseCodeCountMap = new HashMap<>();

    private Map<String, Integer> ipAddressMap = new HashMap<>();

    private Map<String, Integer> userAgentMap = new HashMap<>();
    private int totalRequests;
    private long averageResponseSize;

    public LogAnalysis(List<Log> logs) {
        this.logs = logs;
        calculateMetrics();
    }

    public void calculateMetrics() {
        if (logs.isEmpty()) {
            throw new RuntimeException("List log is empty");
        }
        totalRequests = logs.size();
        long totalResponseSize = 0;
        for (Log log : logs) {
            String resource = log.resource();
            resourceCountMap.put(resource, resourceCountMap.getOrDefault(resource, 0) + 1);

            String ipAddress = log.ip();
            ipAddressMap.put(ipAddress, ipAddressMap.getOrDefault(ipAddress, 0) + 1);

            String userAgent = log.userAgent();
            userAgentMap.put(userAgent, userAgentMap.getOrDefault(userAgent, 0) + 1);

            String responseCode = Integer.toString(log.responseCode());
            responseCodeCountMap.put(responseCode, responseCodeCountMap.getOrDefault(responseCode, 0) + 1);

            totalResponseSize += log.responseSize();
        }
        averageResponseSize = totalRequests > 0 ? totalResponseSize / totalRequests : 0;

    }

    public Map<String, Integer> getResourceCountMap() {
        return resourceCountMap;
    }

    public Map<String, Integer> getResponseCodeCountMap() {
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

    public Map<String, Integer> sortedMap(Map<String, Integer> inputMap) {
        return inputMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }
}

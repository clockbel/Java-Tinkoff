package edu.hw9.task1;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatsCollector {
    private final Map<String, List<Double>> metrics = new ConcurrentHashMap<>();
    private final static Logger LOGGER = LogManager.getLogger();
    public void push(String metricName, double[] values) {
        metrics.compute(metricName, (key, existingValues) -> {
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }
            for (double value : values) {
                existingValues.add(value);
            }
            return existingValues;
        });
    }
    public List<Statistic> stats() {
        List<Statistic> results = new ArrayList<>();

        for (Map.Entry<String, List<Double>> entry : metrics.entrySet()) {
            String metricName = entry.getKey();
            List<Double> values = entry.getValue();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Statistic> future = executorService.submit(() -> {
                double sum = 0.0;
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;

                for (double value : values) {
                    sum += value;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }
                if (values.isEmpty()) {
                    min = 0;
                    max = 0;
                }
                double average = values.isEmpty() ? 0.0 : sum / values.size();
                return new Statistic(metricName, sum, average, min, max);
            });

            try {
                Statistic result = future.get();
                results.add(result);
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.info(e.getMessage());
            } finally {
                executorService.shutdown();
            }
        }

        return results;
    }
}

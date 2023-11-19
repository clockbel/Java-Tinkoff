package edu.project3.LogAnalysis;

public record Log(String ip, String resource, int responseCode, int responseSize, String userAgent) {
}

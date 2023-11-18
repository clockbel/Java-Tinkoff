package edu.project3.LogAnalys;

public record Log(String ip, String resource, int responseCode, int responseSize, String userAgent) {
}

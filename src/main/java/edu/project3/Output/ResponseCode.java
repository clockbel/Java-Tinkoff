package edu.project3.Output;

public final class ResponseCode {
    private ResponseCode() {

    }

    @SuppressWarnings("MagicNumber")
    public static String getResponseCode(String code) {
        return switch (code) {
            case "200" -> "OK";
            case "206" -> "Partial Content";
            case "304" -> "Not Modified";
            case "403" -> "Forbidden";
            case "416" -> "Range Not Satisfiable";
            case "404" -> "Not Found";
            default -> "Unknown";
        };
    }
}

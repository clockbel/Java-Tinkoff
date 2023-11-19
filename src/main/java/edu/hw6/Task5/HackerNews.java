package edu.hw6.Task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int GOOD_STATUS = 200;

    private HackerNews() {

    }

    @SuppressWarnings("MagicNumber")
    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == GOOD_STATUS) {
                String[] idStrings = response.body().replaceAll("[\\[\\]]", "").split(",");
                long[] ids = new long[idStrings.length];

                for (int i = 0; i < idStrings.length; i++) {
                    ids[i] = Long.parseLong(idStrings[i].trim());
                }

                return ids;
            }

        } catch (Exception e) {
            LOGGER.info("Incorrect http");
        }
        return new long[0];
    }

    public static String news(long id) {
        try {
            String url = String.format(ITEM_URL_FORMAT, id);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == GOOD_STATUS) {
                String json = response.body();
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(json);

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }

        } catch (Exception e) {
            LOGGER.info("Incorrect work");
        }

        return "";
    }
}

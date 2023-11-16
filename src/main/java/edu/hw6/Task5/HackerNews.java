package edu.hw6.Task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String[] idStrings = response.body().replaceAll("[\\[\\]]", "").split(",");
                long[] ids = new long[idStrings.length];

                for (int i = 0; i < idStrings.length; i++) {
                    ids[i] = Long.parseLong(idStrings[i].trim());
                }

                return ids;
            }

        } catch (Exception e) {
            e.printStackTrace();
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

            if (response.statusCode() == 200) {
                String json = response.body();
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(json);

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        long[] topStories = hackerNewsTopStories();
        System.out.println(Arrays.toString(topStories));

        long newsId = 38251366;
        String newsTitle = news(newsId);
        System.out.println(newsTitle);
    }
}

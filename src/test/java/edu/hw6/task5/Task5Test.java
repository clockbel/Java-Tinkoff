package edu.hw6.task5;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    void testHackerNewsTopStories() {
        long[] topStories = HackerNews.hackerNewsTopStories();
        assertTrue(topStories.length > 0);
    }

    @Test
    void testNews() {
        long newsId = 38295016;
        String newsTitle = HackerNews.news(newsId);
        assertEquals("Earthtunes app lets you listen to Iceland's intensifying earthquake activity", newsTitle);
    }
}

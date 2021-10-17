package ru.tuanviet.javabox.parsers;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ru.tuanviet.javabox.News;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TopNewsArrayParserTest {
    TopNewsArrayParser topNews;


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNull() {
        topNews = new TopNewsArrayParser(null);
        List<News> newsList = topNews.getParsedNews();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfEmpty() {
        topNews = new TopNewsArrayParser("");
        List<News> newsList = topNews.getParsedNews();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNotValidArgument() {
        topNews = new TopNewsArrayParser("asd");
        List<News> newsList = topNews.getParsedNews();
    }




    @Test
    public void shouldParseJsonSingleArrayToNewsList() {
        topNews = new TopNewsArrayParser("[28852857]");
        List<News> newsList = topNews.getParsedNews();
        assertThat(newsList.get(0).getId()).isEqualTo("28852857");
    }

    @Test
    public void shouldParseJsonArrayToNewsList() {
        topNews = new TopNewsArrayParser("[28852857,28853915,28854592,28854701]");
        List<News> newsList = topNews.getParsedNews();
        assertThat(newsList).hasSize(4);
    }

}
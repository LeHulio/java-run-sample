package ru.tuanviet.javabox;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TopNewsTest {
    TopNews topNews;


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfStringIsEmpty() {
        List<News> newsList = null;
        topNews = new TopNews(newsList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfStringIsNull() {
        List<News> newsList = new ArrayList<>();
        topNews = new TopNews(newsList);
    }


}

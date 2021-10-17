package ru.tuanviet.javabox;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HttpFieldsFilterTest {
    HttpFieldsFilter fieldsFilter;
    TopNews topNews;

    @Before
    public void setUp() {
        fieldsFilter = new HttpFieldsFilter();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNull() {
        fieldsFilter.getFilteredList(topNews);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfEmpty() {
        List<News> news = new ArrayList<>();
        topNews = new TopNews(news);
        fieldsFilter.getFilteredList(topNews);
    }

    @Test
    public void shouldReturnDetailedNewsList() {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            newsList.add(new News("1" + i));
        }
        topNews = new TopNews(newsList);
        List<DetailedNews> detailedNews = fieldsFilter.getFilteredList(topNews);
    }

}
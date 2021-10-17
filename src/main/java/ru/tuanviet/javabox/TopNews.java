package ru.tuanviet.javabox;

import java.util.List;

public class TopNews {

    private List<News> newsList;

    public TopNews(List<News> parsedNewsList) {
        if (parsedNewsList == null || parsedNewsList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.newsList = parsedNewsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }
}

package ru.tuanviet.javabox;

import java.util.List;

public class ListFormatter {
    private static final String URL = "https://news.ycombinator.com/item?id=";

    public List<DetailedNews> fieldsFormatter(List<DetailedNews> newsListToFormat){
        for (DetailedNews news : newsListToFormat) {
            if (news.getUrl() == null || news.getUrl().isEmpty()) {
                news.setUrlIfIsEmpty(URL + news.getId());
            }
        }
        return newsListToFormat;
    }
}

package ru.tuanviet.javabox.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.tuanviet.javabox.DetailedNews;
import ru.tuanviet.javabox.News;

import java.util.List;

public class JsonObjectParser {


    public DetailedNews jsonObjectParser(String newsId) {
        if (newsId == null || "".equals(newsId)) {
            throw new IllegalArgumentException();
        }
        Gson gson = new Gson();
        DetailedNews news = null;
        try {
            news = gson.fromJson(newsId, DetailedNews.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
        return news;
    }
}

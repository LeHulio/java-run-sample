package ru.tuanviet.javabox.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ru.tuanviet.javabox.News;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TopNewsArrayParser  {
    private List<News> parsedNews;

    public TopNewsArrayParser(String news) {
        this.parsedNews = topNewsParser(news);
    }

    private List<News> topNewsParser(String topNewsIds) {
        if (topNewsIds == null || "".equals(topNewsIds)) {
            throw new IllegalArgumentException();
        }
        List<News> parsedNewsList = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = null;
        try {
            list = gson.fromJson(topNewsIds, listType);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
        for (String str : list) {
            parsedNewsList.add(new News(str));
        }
        return parsedNewsList;

    }

    public List<News> getParsedNews() {
        return parsedNews;
    }
}

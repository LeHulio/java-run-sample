package ru.tuanviet.javabox;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopNews {


    private List<News> newsList;

    public void topNewsParser(Top newsId) {
        if (newsId == null || "".equals(newsId.getNewsId())){
            throw new IllegalArgumentException();
        }
        newsList = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(newsId.getNewsId(), listType);
        int i = 0;
        for (String str : list){
            newsList.get(i).setId(str);
            i++;
        }

    }

    public List<News> getNewsList() {
        return newsList;
    }
}

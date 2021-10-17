package ru.tuanviet.javabox;

import ru.tuanviet.javabox.parsers.TopNewsArrayParser;

import java.util.List;

public class App {
    private static final String ADRESS = "https://hacker-news.firebaseio.com/v0/topstories.json";
    public static void main(String[] args) {
        App.start();

    }

    public static void start() {
        String response = new HttpClient(ADRESS).getResponse();
        TopNews topNews = new TopNews(new TopNewsArrayParser(response).getParsedNews());
        List<DetailedNews> detailedNews = new HttpFieldsFilter().getFilteredList(topNews);
        ListFormatter listFormatter = new ListFormatter();
        List<DetailedNews> filteredDetailedNews = listFormatter.fieldsFormatter(detailedNews);
        for (DetailedNews news : filteredDetailedNews) {
            System.out.println(news + "\n");
        }


    }
}

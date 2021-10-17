package ru.tuanviet.javabox;

import ru.tuanviet.javabox.parsers.JsonObjectParser;

import java.util.ArrayList;
import java.util.List;

public class HttpFieldsFilter {
    private final String adress = "https://hacker-news.firebaseio.com/v0/item/";
    private final String adressEndPoint = ".json?";

    public List<DetailedNews> getFilteredList(TopNews topNews) {
        if (topNews == null || topNews.getNewsList().isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<News> newsIds = topNews.getNewsList();
        List<DetailedNews> detailedNewsList = new ArrayList<>();
        DetailedNews detailedNews;
        JsonObjectParser objectParser = new JsonObjectParser();

        int count = 0;
        for (News news : newsIds) {
            String responseNews = new HttpClient(adress + news.getId() + adressEndPoint).getResponse();
            detailedNews = objectParser.jsonObjectParser(responseNews);
            if (count < 10 && checkRequiredFields(detailedNews)) {
                detailedNewsList.add(detailedNews);
                count++;
            }
            if (count == 10) {
                break;
            }
        }
        return detailedNewsList;

    }

    private boolean checkRequiredFields(DetailedNews detailedNews) {
        if ("story".equals(detailedNews.getType())) {
            if (!(detailedNews.getTitle().isEmpty() && detailedNews.getScore().isEmpty())) {
                return true;
            }
        }
        return false;
    }

}

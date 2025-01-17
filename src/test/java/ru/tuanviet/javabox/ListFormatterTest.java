package ru.tuanviet.javabox;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListFormatterTest {
    ListFormatter listFormatter;

    @Before
    public void setUp() {
        listFormatter = new ListFormatter();
    }
    @Test
    public void shouldReturnDetailedNewsList(){
        List<DetailedNews> newsList = new ArrayList<>();
        List<DetailedNews> newsList1 = listFormatter.fieldsFormatter(newsList);
        assertThat(newsList1).isEqualTo(newsList);
    }

    @Test
    public void shouldReturnFormattedList() {
        List<DetailedNews> newsListToFormat = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            newsListToFormat.add(new DetailedNews());
            if (i%2 != 0){
                newsListToFormat.get(i).setUrlIfIsEmpty("123");
            }
        }
        List<DetailedNews> finalList = listFormatter.fieldsFormatter(newsListToFormat);
        assertThat(finalList.get(2).getUrl()).isNotNull();
    }

    @Test
    public void shouldReturnFormattedListWithFilledUrl() {
        List<DetailedNews> newsListToFormat = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            newsListToFormat.add(new DetailedNews());
            if (i%2 != 0){
                newsListToFormat.get(i).setUrlIfIsEmpty("123");
            }
        }
        List<DetailedNews> finalList = listFormatter.fieldsFormatter(newsListToFormat);
        assertThat(finalList.get(2).getUrl()).isNotEmpty();
    }
}

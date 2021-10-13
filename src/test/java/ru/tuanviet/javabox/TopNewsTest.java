package ru.tuanviet.javabox;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class TopNewsTest {
    TopNews topNews;
    Top top;
    HttpClient httpClient;

    @Rule
    public WireMockRule wm = new WireMockRule(options().dynamicPort());

    @Before
    public void setUp() {
        top = new Top();
        topNews = new TopNews();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfStringIsEmpty() {
        top.setNewsId("");
        new TopNews().topNewsParser(top);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfStringIsNull() {
        new TopNews().topNewsParser(null);
    }

    @Test
    public void shouldParseJson(){
        final String topNewsUri = serviceWithResponse("/top-news", "top-news.json");
        httpClient = new HttpClient(wm.baseUrl() + topNewsUri);
        top.setNewsId(httpClient.getResponse());
        topNews.topNewsParser(top);
        List<News> newsList = topNews.getNewsList();
        assertThat(newsList.get(0).getId()).isEqualTo("28852857");

    }

    private String serviceWithResponse(String serviceUri, String serviceFile) {
        ResponseDefinitionBuilder response = aResponse().withBodyFile("topNews/" + serviceFile);

        givenThat(get(urlEqualTo(serviceUri)).willReturn(response));

        return serviceUri;

    }

}

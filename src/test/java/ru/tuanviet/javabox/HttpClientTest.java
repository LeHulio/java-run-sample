package ru.tuanviet.javabox;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpClientTest {
    HttpClient httpClient;

    @Rule
    public WireMockRule wm = new WireMockRule(options().dynamicPort());

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfNull() {
        httpClient = new HttpClient(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfEmpty() {
        httpClient = new HttpClient("");
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExceptionIfAdressIsNotValid() {
        httpClient = new HttpClient("asdsda");
    }

    @Test
    public void shouldReturnStringHttpResponse() {
        final String topNewsUri = serviceWithResponse("/top-news", "top-news.json");
        httpClient = new HttpClient(wm.baseUrl() + topNewsUri);
        assertThat(httpClient.getResponse()).isEqualTo("[28852857,28853915,28854592,28854701]");
    }


    private String serviceWithResponse(String serviceUri, String serviceFile) {
        ResponseDefinitionBuilder response = aResponse().withBodyFile("topNews/" + serviceFile);

        givenThat(get(urlEqualTo(serviceUri)).willReturn(response));

        return serviceUri;

    }


}

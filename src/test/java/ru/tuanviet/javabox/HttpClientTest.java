package ru.tuanviet.javabox;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class HttpClientTest {

    @Rule
    public WireMockRule wm = new WireMockRule(options().dynamicPort());

    @Test


}

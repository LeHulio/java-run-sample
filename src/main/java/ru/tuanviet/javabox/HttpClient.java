package ru.tuanviet.javabox;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpClient {
    private String response;

    public HttpClient(String adress) {
        response = getHttpResponse(adress);
    }


    private String getHttpResponse(String adress) {
        if (adress == null || "".equals(adress)) {
            throw new IllegalArgumentException();
        }
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .build();
        String url = HttpUrl
                .parse(adress)
                .newBuilder()
                .build()
                .toString();
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        String responseBody = null;
        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseBody;
    }

    public String getResponse() {
        return response;
    }

}

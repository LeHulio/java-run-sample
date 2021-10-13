package ru.tuanviet.javabox;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

public class HttpClient {
    private String response;

    public HttpClient(String str) {
        response = getHttpResponse(str);
    }

    public String getResponse() {
        return response;
    }

    private String getHttpResponse(String adress){
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
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        return responseBody;
    }

}

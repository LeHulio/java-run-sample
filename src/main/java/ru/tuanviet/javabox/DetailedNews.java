package ru.tuanviet.javabox;

public class DetailedNews extends News{
    private String id;
    private String score;
    private String title;
    private String type;
    private String url;


    @Override
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getScore() {
        return score;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public void setUrlIfIsEmpty(String url) {
        this.url = url;
    }
}

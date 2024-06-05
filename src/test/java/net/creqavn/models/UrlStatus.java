package net.creqavn.models;

public class UrlStatus {
    private String url;
    private int statusCode;

    public UrlStatus(String url, int statusCode) {
        this.url = url;
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "UrlStatus{" +
                "url='" + url + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}


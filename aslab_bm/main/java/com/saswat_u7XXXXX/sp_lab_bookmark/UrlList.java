package com.saswat_u7156387.sp_lab_bookmark;

public class UrlList {
    private String id;
    private String url;

    public UrlList(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

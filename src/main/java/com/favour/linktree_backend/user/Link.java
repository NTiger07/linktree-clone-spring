package com.favour.linktree_backend.user;

import org.springframework.data.annotation.Id;

public class Link {
    @Id
    private String id;
    private String imageUrl;
    private String title;
    private String url;
    private int position;

    // CONSTRUCTORS
    public Link() {}

    public Link(String id, String imageUrl, String title, String url, int position) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.url = url;
        this.position = position;
    }

    public Link(String imageUrl, String title, String url) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.url = url;
    }

    public Link(String title, String url, int position) {
        this.title = title;
        this.url = url;
        this.position = position;
    }

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

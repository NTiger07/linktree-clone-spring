package com.favour.linktree_backend.user;

import org.springframework.data.annotation.Id;

public class Link {
    @Id
    private String id;
    private String imageUrl;
    private String title;
    private String url;
    private int position;
    private boolean isActive;

    // CONSTRUCTORS
    public Link() {}

    public Link(String id, String imageUrl, String title, String url, int position, boolean isActive) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.url = url;
        this.position = position;
        this.isActive = isActive;
    }

    public Link(String imageUrl, String title, String url, int position, boolean isActive) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.url = url;
        this.position = position;
        this.isActive = isActive;
    }

    public Link(String title, String url, int position, boolean isActive) {
        this.title = title;
        this.url = url;
        this.position = position;
        this.isActive = isActive;
    }

    public Link(String title, String url, boolean isActive) {
        this.title = title;
        this.url = url;
        this.isActive = isActive;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}

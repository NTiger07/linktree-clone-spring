package com.favour.linktree_backend.user;


public class Social {
    private String platform;
    private String url;

    // CONSTRUCTOR
    public Social() {}
    
    public Social(String platform, String url) {
        this.platform = platform;
        this.url = url;
    }

    // GETTERS AND SETTERS
    public String getPlatform(){
        return platform;
    }
    public void setPlatform(String platform){
        this.platform = platform;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
}

package com.favour.linktree_backend.user;

import java.util.List;
// import jakarta.persistence.Id;

import org.springframework.data.annotation.Transient;


public class User {
    // @Id
    private Long id;
    private String name;
    private String profilePic;
    private String about;
    private List<Social> socials;
    private List<Link> links;
    @Transient
    private String password;


    // GETTERS AND SETTERS

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getProfilePic(){
        return profilePic;
    }
    public void setProfilePic(String profilePic){
        this.profilePic = profilePic;
    }
    public String getAbout(){
        return about;
    }
    public void setAbout(String about){
        this.about = about;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public List<Social> getSocials(){
        return socials;
    }
    public void setSocials(List<Social> socials){
        this.socials = socials;
    }
    public List<Link> getlinks(){
        return links;
    }
    public void setLinks(List<Link> links){
        this.links = links;
    }
}


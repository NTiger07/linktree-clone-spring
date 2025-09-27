package com.favour.linktree_backend.user;

import java.util.List;
// import jakarta.persistence.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String profilePic;
    private String about;
    private List<Social> socials;
    private List<Link> links;
    @Transient
    private String password;


    // CONSTRUCTORS

    public User(
        String id,
        String name,
        String email,
        String profilePic,
        String about,
        List<Social> socials,
        List<Link> links,
        String password
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.about = about;
        this.socials = socials;
        this.links = links;
        this.password = password;
    }

    public User(
        String name,
        String email,
        String profilePic,
        String about,
        List<Social> socials,
        List<Link> links,
        String password
    ) {
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.about = about;
        this.socials = socials;
        this.links = links;
        this.password = password;
    }
    
    public User(
        String id,
        String name,
        String email,
        String profilePic,
        String about,
        List<Link> links,
        String password
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.about = about;
        this.links = links;
        this.password = password;
    }

    public User(
        String id,
        String name,
        String email,
        String profilePic,
        String about,
        List<Social> socials,
        List<Link> links
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.about = about;
        this.socials = socials;
        this.links = links;
    }

    public User(
        String id,
        String name,
        String email,
        String profilePic,
        String about,
        List<Link> links
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.about = about;
        this.links = links;
    }

    // GETTERS AND SETTERS

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
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


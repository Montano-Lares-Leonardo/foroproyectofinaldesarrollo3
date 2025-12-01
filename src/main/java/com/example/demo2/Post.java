package com.example.demo2;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private final int postid;
    private String title;
    public String getDate(){
        if (edited) return "editado - " + datePosted;
        else return "" + datePosted;
    }

    private String text;
    private final int author;
    private String username;
    private boolean priv;
    private final Date datePosted;
    private boolean edited;

    public Post(int id, String title, String text, int author, String username, boolean priv, Date datePosted, boolean edited) {
        this.postid = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.username = username;
        this.priv = priv;
        this.datePosted = datePosted;
        this.edited = edited;
    }

    public int getUserID() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public int getPostid() {
        return postid;
    }
}

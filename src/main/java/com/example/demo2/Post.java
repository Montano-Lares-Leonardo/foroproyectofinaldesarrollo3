package com.example.demo2;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private final int postid;
    private String title;
    private String text;
    private final int author;
    private String username;
    private ArrayList<Integer> replies;
    private boolean priv;
    private ArrayList<Integer> allowed;
    private final Date datePosted;
    private Date dateEdited;
    private boolean edited;

    public Post(int id, String title, String text, int author, String username, ArrayList<Integer> replies, boolean priv, ArrayList<Integer> allowed, Date datePosted, Date dateEdited, boolean edited) {
        this.postid = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.username = username;
        this.replies = replies;
        this.priv = priv;
        this.allowed = allowed;
        this.datePosted = datePosted;
        this.dateEdited = dateEdited;
        this.edited = edited;
    }
}

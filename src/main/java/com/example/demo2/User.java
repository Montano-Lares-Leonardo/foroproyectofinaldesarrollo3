package com.example.demo2;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private final int userid;
    private String username;
    private String desc;
    private final Date joinDate;
    private int pfp;

    public User(int userid, String username, String desc, Date joinDate, int pfp) {
        this.userid = userid;
        this.username = username;
        this.desc = desc;
        this.joinDate = joinDate;
        this.pfp = pfp;
    }
}

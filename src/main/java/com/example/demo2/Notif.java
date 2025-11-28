package com.example.demo2;

public class Notif {
    private final int notifId;
    private boolean opened;
    private final int post;
    private String cause;

    public Notif(int notifId, boolean opened, int post, String cause) {
        this.notifId = notifId;
        this.opened = opened;
        this.post = post;
        this.cause = cause;
    }
}

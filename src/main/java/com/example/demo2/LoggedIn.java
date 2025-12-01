package com.example.demo2;

public class LoggedIn {
    private static User you;
    public static void logIn(int id){

    }
    public static User getYou(){
        return you;
    }

    public static int getID() {
        if (you == null) return 1;
        else return you.getID();
    }
}

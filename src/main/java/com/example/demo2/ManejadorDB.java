package com.example.demo2;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ManejadorDB {
    private static final String URL = "jdbc:mysql://auth-db559.hstgr.io:3306/u966749536_flan";
    private static final String USER = "u966749536_shampoo";
    private static final String PASS = "Equipoumizumi1";

    public ManejadorDB(){
    }

    public static Connection abrirConexion(){
        try {
            DriverManager.setLoginTimeout(10);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de sql: " + e.getSQLState());
            return null;
        }
    }

    public static void cerrarConexion(Connection conn){
        try{
            if (conn != null) conn.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de sql: " + e.getSQLState());
        }
    }

    public static ArrayList<Post> getPosts(String condition){
        try (Connection conn = abrirConexion();
             ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM POST p JOIN USURATO u ON u.user_ID = p.user_ID LEFT JOIN VISIBILITY v ON v.post_ID = p.post_ID WHERE ((v.user_ID = " + LoggedIn.getID() + ") OR (p.private = false))" + condition)){
            ArrayList<Post> posts = new ArrayList<>();
            while (rs.next()){
                posts.add(new Post(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(7),
                        rs.getString(10),
                        rs.getBoolean(6),
                        rs.getDate(4),
                        rs.getBoolean(5)
                        ));
            }
            cerrarConexion(conn);
            return posts;
        } catch (SQLException e){
            System.out.println(e.getSQLState());
            return null;
        }
    }
}

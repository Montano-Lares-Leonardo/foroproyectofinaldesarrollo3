package com.example.demo2;

import java.sql.*;
import java.util.ArrayList;

public class ManejadorDB {
    private final String URL = "jdbc:mysql://www.freackylandia.com:3306/u966749536_flan";
    private final String USER = "u966749536_developer";
    private final String PASS = "Equipoumizumi1";

    public ManejadorDB(){
    }

    public static void main(String[] args){
        new ManejadorDB().cerrarConexion(new ManejadorDB().abrirConexion());
    }

    public Connection abrirConexion(){
        try {
            DriverManager.setLoginTimeout(10);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ESO NO HISO NADA!!!");
            return null;
        }
    }

    public void cerrarConexion(Connection conn){
        try{
            if (conn != null) conn.close();
        } catch (SQLException e){
            System.out.println("ESO NO HISO NADA!!!");
            e.printStackTrace();
        }
    }

    public ArrayList<Post> getPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        String query = "GERARDO PON TU COSA AQUI!"; //TODO crear la base de datos >:(
        try (Connection conn = abrirConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ){

            while (rs.next()){ //recorrer cada linea del ResultSet
                //posts.add(new Post(
                //));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return posts;
    }

    public ArrayList<Post> getUsers(){
        ArrayList<Post> posts = new ArrayList<>();
        String query = "GERARDO PON TU COSA AQUI!"; //TODO crear la base de datos >:(
        try (Connection conn = abrirConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ){

            while (rs.next()){ //recorrer cada linea del ResultSet
                //posts.add(new Post(
                //));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return posts;
    }
}

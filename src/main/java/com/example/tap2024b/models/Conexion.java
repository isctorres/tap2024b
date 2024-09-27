package com.example.tap2024b.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static private String DB = "Spotify";
    static private String USER = "admin";
    static private String PWD = "1234567890";
    static private String HOST = "localhost";
    static private String PORT = "3306";
    public static Connection connection;

    public static void CrearConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB,USER,PWD);
            System.out.println("Conexión establecida a la Base de Datos :)");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
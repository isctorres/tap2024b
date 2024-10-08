package com.example.tap2024b.models;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    private int idCte;
    private String nomCte;
    private String telCte;
    private String emailCte;

    public int getIdCte() {
        return idCte;
    }

    public void setIdCte(int idCte) {
        this.idCte = idCte;
    }

    public String getNomCte() {
        return nomCte;
    }

    public void setNomCte(String nomCte) {
        this.nomCte = nomCte;
    }

    public String getTelCte() {
        return telCte;
    }

    public void setTelCte(String telCte) {
        this.telCte = telCte;
    }

    public String getEmailCte() {
        return emailCte;
    }

    public void setEmailCte(String emailCte) {
        this.emailCte = emailCte;
    }

    public int INSERT(){
        int rowCount;
        String query = "INSERT INTO tblCliente(nomCte,telCte,emailCte)" +
                " VALUES('"+this.nomCte+"','"+this.telCte+"','"+this.emailCte+"')";
        try{
            Statement stmt = Conexion.connection.createStatement();
            rowCount = stmt.executeUpdate(query);
        }catch (Exception e){
            rowCount = 0;
            e.printStackTrace();
        }
        return rowCount;
    }
    public void UPDATE(){

        String query = "UPDATE tblCliente SET nomCte = '"+this.nomCte+"'," +
                "telCte = '"+this.telCte+"', emailCte = '"+this.emailCte+"' " +
                "WHERE idCte = "+this.idCte;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void DELETE(){
        String query = "DELETE FROM tblCliente WHERE idCte = " + this.idCte;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<ClienteDAO> SELECTALL(){
        ClienteDAO objCte;
        String query = "SELECT * FROM tblCliente";
        ObservableList<ClienteDAO> listaC = FXCollections.observableArrayList();
        try{
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objCte = new ClienteDAO();
                objCte.idCte = res.getInt(1);
                objCte.nomCte = res.getString(2);
                objCte.telCte = res.getString(3);
                objCte.emailCte = res.getString(4);
                listaC.add(objCte);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return listaC;
    }
}

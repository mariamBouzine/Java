package org.example;

import java.sql.*;

public class daoFactory {
    private static Connection conx = null;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url  = "jdbc:mysql://localhost:3306/bditems";
    private static final String user  = "root";
    private static final String password  = "";

    private static void seConnecter(){
        try {
            System.out.println("Start of Connection, Loading Driver ... ");
            Class.forName(driver);
            conx = DriverManager.getConnection(url,user,password);
            System.out.println("Connection established .. ");
        }catch (ClassNotFoundException ex){
            System.out.println("Driver loading problem");
        }catch (SQLException ex){
            System.out.println("Connection problem URL Login or Password incorrect, Connection Failure !!!");
        }
    }
    public static Connection getConnection(){
        if(conx == null)
            seConnecter();
        return conx;
    }
}

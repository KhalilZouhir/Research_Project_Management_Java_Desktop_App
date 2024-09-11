package com.gpr.project_gpr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection con;
    private java.sql.PreparedStatement st;
    private java.sql.ResultSet rs;

    public  Connection getConnetion(){
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    System.out.println("pas de driver");
                }
                con =DriverManager.getConnection("jdbc:mysql:"
                        + "//localhost:3306/gestionprojet","root","");
                System.out.println("works");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur de connexion");
            }
            return con;

    }
}



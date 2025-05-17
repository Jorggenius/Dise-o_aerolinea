/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aerolinea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JORGE
 */
public class DataBaseConfig {
    private static DataBaseConfig instance;
    private Connection connection;

    private static final String URL  = "jdbc:mysql://localhost:3306/aerolinea";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    private DataBaseConfig() {
        connect();
    }
    
    

//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
      public static DataBaseConfig getInstance() {
        if (instance == null) {
            instance = new DataBaseConfig();
        }
        return instance;
    }
     public  Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     private void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author JORGE
 */
public class ControlRegistro {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public ControlRegistro() {

    }

    public static boolean register(String nombre,String password,
            int  edad) {
        String query = "INSERT INTO cliente (nombre, password, edad) "
                + "VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement ps = conn.prepareStatement(query)) {

            String hashedPassword = hashPassword(password);

            ps.setString(1, nombre);
            ps.setString(2, hashedPassword);
            ps.setInt(3, edad);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
      private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}



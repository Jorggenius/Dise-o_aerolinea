/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import org.mindrot.jbcrypt.BCrypt;
import service.ClienteService;

/**
 *
 * @author JORGE
 */
public class ControlLogin {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");
    ClienteService clienteService;
    ArrayList<Cliente> clientes;

    public ControlLogin() throws SQLException {
        clienteService = new ClienteService();
        clientes = clienteService.getClientes();
    }

    public static boolean login(String nombre, String password) {
        String query = "SELECT password FROM cliente WHERE nombre = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("password");
                System.out.println(password);
                System.out.println(storedPasswordHash);
                return checkPassword(password, storedPasswordHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
    
        public static Integer ObtenerID(String nombre, String password) {
    String query = "SELECT id, password FROM cliente WHERE nombre = ?";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int userId = rs.getInt("id"); // Obtener el ID del usuario
            String storedPasswordHash = rs.getString("password");

            System.out.println(password);
            System.out.println(storedPasswordHash);

            if (checkPassword(password, storedPasswordHash)) {
                return userId; // Retornar el ID si la contraseña es correcta
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Retornar null si el login falla
}
}

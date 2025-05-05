/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mycompany.aerolinea.DataBaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author JORGE
 */
public class ClienteRepository {

    public Cliente findById(int id) throws SQLException {
        String query = "SELECT * FROM cliente WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("password"),
                        resultSet.getInt("edad")
                );
            } else {
                return null;
            }
        }
    }

    public ArrayList<Cliente> findAll() throws SQLException {
        String query = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                clientes.add(new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("password"),
                        resultSet.getInt("edad")
                ));
            }
        }
        return clientes;
    }

    public void save(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nombre, passwor, edad) VALUES ('"
                + cliente.getNombre() + "', '" + cliente.getPassword()
                + "', '" + cliente.getPassword()  + "')";
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

}

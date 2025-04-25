/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mycompany.aerolinea.DataBaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Compra;

/**
 *
 * @author JORGE
 */
public class CompraRepository {

    public Compra findById(int id) throws SQLException {
        String query = "SELECT * FROM compra WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Compra(
                        resultSet.getInt("cliente_id"),
                        resultSet.getDate("fechaDevolucion")
                );
            } else {
                return null;
            }
        }
    }
    
    public ArrayList<Compra> findAll() throws SQLException {
        String query = "SELECT * FROM compra WHERE id";
        ArrayList<Compra> prestamos = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                prestamos.add(new Compra(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha")
                ));
            }
        }
        return prestamos;
    }
    
      public void save(Compra compra) throws SQLException {
        String query = "INSERT INTO prestamo (id ,fecha) VALUES ('"
                + compra.getId() + "', '" + compra.getFecha()+ "')";
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
      
        public ArrayList<Compra> findByCompraId(int ClienteId) throws SQLException {
    String query = "SELECT * FROM compra WHERE cliente_id = ?";
    ArrayList<Compra> compras = new ArrayList<>();
    try (Connection connection = DataBaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, ClienteId); // Se asigna el valor del clienteId en la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                compras.add(new Compra(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha")
                ));
            }
        }
    }
    return compras;
}
}

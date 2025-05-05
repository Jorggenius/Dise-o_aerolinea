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
import modelo.Tiquete;

/**
 *
 * @author JORGE
 */
public class TiqueteRepository {

    public Tiquete findById(int id) throws SQLException {
        String query = "SELECT * FROM tiquete WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Tiquete(
                        resultSet.getInt("id"),
                        resultSet.getString("destino"),
                        resultSet.getDate("fecha")
                );
            } else {
                return null;
            }
        }
    }

    public ArrayList<Tiquete> findAll() throws SQLException {
        String query = "SELECT * FROM tiquete";
        ArrayList<Tiquete> tiquetes = new ArrayList<>();
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                tiquetes.add(new Tiquete(
                        resultSet.getInt("id"),
                        resultSet.getString("destino"),
                        resultSet.getDate("fecha")
                ));
            }
        }
        return tiquetes;
    }

    public void save(Tiquete tiquete) throws SQLException {
        String query = "INSERT INTO tiquete (destino, fecha) VALUES ('"
                + tiquete.getDestino() + "', '" + tiquete.getFecha() + "')";
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
}

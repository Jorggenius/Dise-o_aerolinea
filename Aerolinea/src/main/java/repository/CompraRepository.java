/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mycompany.aerolinea.DataBaseConfig;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Compra;
import modelo.CompraBasica;
import modelo.Descuento;
import modelo.ICompra;

/**
 *
 * @author JORGE
 */
public class CompraRepository {
    
    int clienteId;

    public CompraRepository(int clienteId) {
        this.clienteId = clienteId;
//                System.out.println(clienteId);
        System.out.println( "Id Conseguir Repositorio " + clienteId);


    }
    
    

    public Compra findById(int id) throws SQLException {
        String query = "SELECT * FROM compra WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
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

        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                prestamos.add(new Compra(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha")
                ));
            }
        }
        return prestamos;
    }

    public void save(CompraBasica compra) throws SQLException {
        String query = "INSERT INTO compraBasica (id , id_cliente, fecha) VALUES ('"
                + compra.getId() + "', '" + clienteId + "', '" + compra.getFecha() + "')";
                        System.out.println( "Id guardar " + clienteId);

        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void saveDetalle(ICompra compra) throws SQLException {
        String query = "INSERT INTO decorer (fecha, id_cliente, detalle) VALUES ('"
                 + compra.getFecha() + "', '"+ clienteId + "', '" + compra.getDetalle() + "')";
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public ArrayList<CompraBasica> findByCompraId(int ClienteId) throws SQLException {
        String query = "SELECT * FROM compraBasica WHERE id_cliente = ?";
        ArrayList<CompraBasica> compras = new ArrayList<>();
        try (Connection connection = DataBaseConfig.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ClienteId); // Se asigna el valor del clienteId en la consulta
                    System.out.println( "Id Conseguir Metodo " + ClienteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    compras.add(new CompraBasica(
                            resultSet.getInt("id"),
                            resultSet.getDate("fecha")
                    ));
                }
            }
        }
            System.out.println( "Size metodo " + compras.size());
        return compras;
    }

//    public ArrayList<Descuento> findByCompraDecorerId(int ClienteId) throws SQLException {
//        String query = "SELECT * FROM decorer WHERE cliente_id = ?";
//        ArrayList<Descuento> compras = new ArrayList<>();
//        try (Connection connection = DataBaseConfig.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, ClienteId); // Se asigna el valor del clienteId en la consulta
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    compras.add(new Descuento(
//                            resultSet.getInt("id"),
//                            resultSet.getDate("fecha"),
//                            resultSet.getString("detalle")
//                    ));
//                }
//            }
//        }
//        return compras;
//    }
    public ArrayList<Descuento> findByCompraDecorerId(int clienteId) throws SQLException {
        String query = "SELECT * FROM decorer WHERE id_cliente = ?";
        ArrayList<Descuento> descuentos = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, clienteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int compraId = resultSet.getInt("id");
                    Date fecha = resultSet.getDate("fecha");

                    // Crea la compra básica desde decorer
                    CompraBasica compraBase = new CompraBasica(compraId, fecha);

                    // Decora con descuento
                    Descuento descuento = new Descuento(compraBase);

                    // Agrega al resultado
                    descuentos.add(descuento);
                }
            }
        }

        return descuentos;
    }
}

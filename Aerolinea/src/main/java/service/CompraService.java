/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import excepciones.InvalidUserDataException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Compra;
import repository.CompraRepository;
import validator.CompraValidator;

/**
 *
 * @author JORGE
 */
public class CompraService {

    int clienteId;

    public CompraService(int clienteId) {
        this.clienteId = clienteId;
    }
    
    private CompraRepository compraRepository = new CompraRepository();

    public Compra getCompraById(int id) throws SQLException {
        return compraRepository.findById(id);
    }

    public ArrayList<Compra> getCompra() throws SQLException {
        return compraRepository.findAll();
    }

    public ArrayList<Compra> getPrestamosCliente() throws SQLException {
        return compraRepository.findByCompraId(clienteId);
    }
    
      public void createCompra(Date fecha) throws SQLException, InvalidUserDataException {
        if (!CompraValidator.validateFecha(fecha)
                ) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Compra compra = new Compra(fecha);
        compraRepository.save(compra);
    }
}

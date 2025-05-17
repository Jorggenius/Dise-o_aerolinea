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
import modelo.CompraBasica;
import modelo.Descuento;
import modelo.ICompra;
import repository.CompraRepository;
import validator.CompraValidator;

/**
 *
 * @author JORGE
 */
public class CompraService {

    int clienteId;
    private CompraRepository compraRepository;

    public CompraService(int clienteId) {
        this.clienteId = clienteId;
        compraRepository = new CompraRepository(clienteId);
        System.out.println( "Id Conseguir Servicio " + clienteId);
    }

    public Compra getCompraById(int id) throws SQLException {
        return compraRepository.findById(id);
    }

    public ArrayList<Compra> getCompra() throws SQLException {
        return compraRepository.findAll();
    }

    public ArrayList<CompraBasica> getComprasBasicCliente() throws SQLException {
//        System.out.println(compraRepository.findByCompraId(clienteId).size());
        return compraRepository.findByCompraId(clienteId);
    }

    public ArrayList<Descuento> getComprasDecorerCliente() throws SQLException {
        return compraRepository.findByCompraDecorerId(clienteId);
    }

    public void createCompra(Date fecha) throws SQLException, InvalidUserDataException {
        if (!CompraValidator.validateFecha(fecha)) {
            throw new InvalidUserDataException("Invalid user data");
        }
        CompraBasica compra = new CompraBasica(fecha);
        compraRepository.save(compra);
    }

    public void createCompraDecorer(ICompra descuento) throws SQLException, InvalidUserDataException {
        if (!CompraValidator.validateFecha(descuento.getFecha())) {
            throw new InvalidUserDataException("Invalid user data");
        }
        ICompra decorer = new Descuento(descuento);
        compraRepository.saveDetalle(decorer);
    }
}

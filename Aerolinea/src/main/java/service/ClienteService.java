/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import excepciones.InvalidUserDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import repository.ClienteRepository;
import validator.ClienteValidator;

/**
 *
 * @author JORGE
 */
public class ClienteService {
    private ClienteRepository clienteRepository = new ClienteRepository();
    
    public Cliente getClienteById(int id) throws SQLException {
        return clienteRepository.findById(id);
    }
    
    public ArrayList<Cliente> getClientes()  throws SQLException{
        return clienteRepository.findAll();
    }

     public void createCliente(String nombre, String password, int edad) throws SQLException, InvalidUserDataException {
        if (!ClienteValidator.validateName(nombre)
                || !ClienteValidator.validatePassword(password) || !ClienteValidator.validateEdad(edad)
                ) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Cliente cliente = new Cliente(nombre, password, edad);
        clienteRepository.save(cliente);
    }
    
}

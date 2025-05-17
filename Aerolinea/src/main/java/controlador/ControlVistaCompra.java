/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepciones.InvalidUserDataException;
import java.sql.Date;
import java.sql.SQLException;
import modelo.ICompra;
import service.CompraService;

/**
 *
 * @author JORGE
 */
public class ControlVistaCompra {
    CompraService servicio;
    int idCliente;

    public ControlVistaCompra(int idCliente) {
        this.idCliente = idCliente;
//        System.out.println(idCliente);
        servicio = new CompraService(idCliente);
    }
    
    public void guardarCompra(Date fecha) throws SQLException, InvalidUserDataException{
        servicio.createCompra(fecha);
    }
    
    public void guardarCompraDecorer(ICompra decorer) throws SQLException, InvalidUserDataException{
        servicio.createCompraDecorer(decorer);
    }
    
}

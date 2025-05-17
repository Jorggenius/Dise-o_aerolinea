/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CompraBasica;
import modelo.Descuento;
import modelo.ICompra;
import service.CompraService;

/**
 *
 * @author JORGE
 */
public class ControlHistorial {

    CompraService servicio;
    int idCliente;
    ArrayList<CompraBasica> comprasB;
    ArrayList<Descuento> comprasD;

    public ControlHistorial(int idCliente) throws SQLException {
        this.idCliente = idCliente;
         System.out.println( "Id Conseguir Controlador " + idCliente);
        servicio = new CompraService(idCliente);
        comprasB = new ArrayList<>();
        comprasD = servicio.getComprasDecorerCliente();
                

    }

    public ArrayList<CompraBasica> getComprasB() throws SQLException {
        comprasB = servicio.getComprasBasicCliente();
        return comprasB ;
    }

    public ArrayList<Descuento> getComprasD() {
        return comprasD;
    }

    
}

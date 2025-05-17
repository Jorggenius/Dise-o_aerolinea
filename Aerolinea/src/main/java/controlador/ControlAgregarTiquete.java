/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepciones.InvalidUserDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tiquete;
import service.TiqueteService;

/**
 *
 * @author JORGE
 */
public class ControlAgregarTiquete {

    TiqueteService tiqueteService;
    ArrayList<Tiquete> tiquetes;

    public ControlAgregarTiquete() throws SQLException {
        tiqueteService = new TiqueteService();
        tiquetes = tiqueteService.getTiquetes();
    }

    public void registrarTiquete(Tiquete tiquete) throws InvalidUserDataException, SQLException {
        TiqueteService servicio = new TiqueteService();
        servicio.createTiquete(tiquete.getDestino(),
                tiquete.getFecha());
    }

     public ArrayList<Tiquete> getTiquetes() throws SQLException {
        return tiqueteService.getTiquetes();
    }
}

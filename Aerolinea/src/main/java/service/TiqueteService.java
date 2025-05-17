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
import modelo.Tiquete;
import repository.CompraRepository;
import repository.TiqueteRepository;
import validator.TiqueteValidator;

/**
 *
 * @author JORGE
 */
public class TiqueteService {

    private TiqueteRepository tiqueteRepository = new TiqueteRepository();

    public Tiquete getTiqueteById(int id) throws SQLException {
        return tiqueteRepository.findById(id);
    }

    public ArrayList<Tiquete> getTiquetes() throws SQLException {
        return tiqueteRepository.findAll();
    }
    
    public void createTiquete(String destio, Date fecha) throws SQLException, InvalidUserDataException {
        if (!TiqueteValidator.validateDestino(destio)
                || !TiqueteValidator.validateFecha(fecha)
                ) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Tiquete tiquete  = new Tiquete(destio, fecha);
        tiqueteRepository.save(tiquete);
    }
}

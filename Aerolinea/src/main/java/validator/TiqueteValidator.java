/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.sql.Date;

/**
 *
 * @author JORGE
 */
public class TiqueteValidator {
    public static boolean validateDestino(String destino) {
        return destino != null && !destino.trim().isEmpty();
    }
    public static boolean validateFecha(Date fecha) {
        return fecha != null;
    }
}

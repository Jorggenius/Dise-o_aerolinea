/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author JORGE
 */
public interface ICompra {
    double total();
    String getDetalle();
    int getId();
    Date getFecha();
    
}

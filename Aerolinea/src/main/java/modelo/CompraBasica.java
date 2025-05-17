/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author JORGE
 */
public class CompraBasica implements ICompra {

    private int id;
    private Date fecha;

    public CompraBasica(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }
    
    public CompraBasica(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public double total() {
        return 100.0; // Total base
    }

    @Override
    public String getDetalle() {
        return "Compra básica";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }
}

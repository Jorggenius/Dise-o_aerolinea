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
public abstract class CompraDecorator implements ICompra {
    protected ICompra compra;

    public CompraDecorator(ICompra compra) {
        this.compra = compra;
    }

    @Override
    public int getId() {
        return compra.getId();
    }

    @Override
    public Date getFecha() {
        return compra.getFecha();
    } 
}

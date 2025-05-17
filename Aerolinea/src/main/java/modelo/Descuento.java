/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class Descuento extends CompraDecorator {
    public Descuento(ICompra compra) {
        super(compra);
    }

    @Override
    
    public double total() {
        return compra.total() - 15.0; // Aplica descuento
    }

    @Override
    public String getDetalle() {
        return compra.getDetalle() + ", con descuento";
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class PagoConPayPal implements MetodoPago {

    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagando $" + cantidad + " con PayPal.");
    }
}

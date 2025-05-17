/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class ProcesadorDePagos {

    private MetodoPago metodo;

    public void setMetodoPago(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public void procesarPago(double cantidad) {
        if (metodo == null) {
            System.out.println("Error: No se ha configurado un método de pago.");
        } else {
            metodo.pagar(cantidad);
        }
    }
}

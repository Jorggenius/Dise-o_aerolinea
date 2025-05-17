/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class ObserverCompra implements IObservador{
    public void alertarCompra(String tiquete){
        System.out.println("Se aha realizado una compra a " + tiquete );
    }
}

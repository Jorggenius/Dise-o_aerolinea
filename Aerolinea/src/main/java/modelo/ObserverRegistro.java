/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class ObserverRegistro implements IObservador{
    public void alertarRegistro(String nombre){
        System.out.println("Se aha realizado el regisdtro de " + nombre );
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public interface ISujeto {
    void agregarObservador(IObservador o);
    void eliminarObservador(IObservador o);
    void notificarObservadorCompras();
    void notificarObservadorRegistros();
}

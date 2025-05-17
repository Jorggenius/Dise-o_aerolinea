/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author JORGE
 */
public class Admin implements ISujeto{
    private ArrayList<IObservador> observadores = new ArrayList<>();
    
    public void señalRegistro(String nombre){
       ObserverRegistro observerRegistro = new ObserverRegistro();
       observerRegistro.alertarRegistro(nombre);
    }
    
    
    public void señalCompra(String nombre){
        ObserverCompra observerCompra = new ObserverCompra();
        observerCompra.alertarCompra(nombre);
    }
    
    @Override
    public void agregarObservador(IObservador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(IObservador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadorCompras() {
        
    }
    
    @Override
    public void notificarObservadorRegistros() {
        
    }
    
}

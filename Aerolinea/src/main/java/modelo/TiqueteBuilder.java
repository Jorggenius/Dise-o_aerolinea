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
public class TiqueteBuilder {
     int id;
    String destino;
    Date fecha;

    public void reset() {
        this.id = 0;
        this.destino = "";
        this.fecha = null;
    }

    public TiqueteBuilder setId(int id) {
        this.id = id;
        return this;
    }
    
    public TiqueteBuilder setDestino(String destino) {
        this.destino = destino;
        return this;
    }
    
    public TiqueteBuilder setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }
    
     public Tiquete getTiquete() {
        Tiquete tiquete = new Tiquete(destino, fecha);
        reset();
        return tiquete;
    }
}
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
public class Tiquete {

    int id;
    String destino;
    Date fecha;

    public Tiquete(int id, String destino, Date fecha) {
        this.id = id;
        this.destino = destino;
        this.fecha = fecha;
    }

    public Tiquete(String destino, Date fecha) {
        this.destino = destino;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}

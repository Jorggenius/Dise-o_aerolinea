/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGE
 */
public class ClienteBuilder {

    int id;
    String nombre;
    String password;
    int edad;

    public void reset() {
        this.id = 0;
        this.nombre = "";
        this.password = "";
        this.edad = 0;
    }

    public ClienteBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ClienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ClienteBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public Cliente getCliente() {
        Cliente cliente = new Cliente(nombre, password, edad);
        reset();
        return cliente;
    }
}

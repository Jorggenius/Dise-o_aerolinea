/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author JORGE
 */
public class ClienteValidator {

    public static boolean validateName(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validatePassword(String contraseña) {
        return contraseña != null && !contraseña.trim().isEmpty();
    }
    
    public static boolean validateEdad(Integer edad) {
        return edad != null && edad > 0 && edad < 120;
    }
}

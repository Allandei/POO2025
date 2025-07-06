/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.mavenproject4;

/**
 *
 * @author Lenovo-User
 */
public class Conductor {
    private String cedula;
    private String nombre;
    private String licencia;
    private String telefono;
    private String correo;

    public Conductor(String cedula, String nombre, String licencia, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.licencia = licencia;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String toString() {
        return "Conductor{" + "cedula=" + cedula + ", nombre=" + nombre + ", licencia=" + licencia + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

    // COMPLETAR EL CODIGO CON EL METODO REGISTRAR TXT
}

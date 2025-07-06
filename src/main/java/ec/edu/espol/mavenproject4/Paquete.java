/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.mavenproject4;

/**
 *
 * @author Lenovo-User
 */
public class Paquete {
    private String codigo;
    private String descripcion;
    private double peso;
    private String destinatario;
    private String direccion;
    private String telefono;

    public Paquete(String codigo, String descripcion, double peso, String destinatario, String direccion, String telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String toString() {
        return "Paquete{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", peso=" + peso + ", destinatario=" + destinatario + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    public static void registrar(Paquete p) {
        // PENDIENTE REGISTRAR ARCHIVO TXT DEL PAQUETE
    }
}

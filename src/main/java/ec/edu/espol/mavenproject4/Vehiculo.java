/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.mavenproject4;

/**
 *
 * @author Lenovo-User
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private String tipo;
    private double capacidad;
    private boolean operativo;

    public Vehiculo(String placa, String modelo, String tipo, double capacidad, boolean operativo){
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.operativo = operativo;
    }
    public String getPlaca() {
        return placa;
    }
    public boolean isoperatito() {
        return operativo;
    }
    
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", modelo=" + modelo + ", tipo=" + tipo + ", capacidad=" + capacidad + ", operativo=" + operativo + '}';
    }
    public static void registrar(Vehiculo v){
        // PENDIENTE REGISTRAR ARCHIVO TXT DEL VEHICULO
    }

}


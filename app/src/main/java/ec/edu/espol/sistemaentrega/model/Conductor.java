package ec.edu.espol.sistemaentrega.model;

import java.io.Serializable;

public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String cedula;
    private String nombre;
    private String licencia;
    private String telefono;
    private String correo;
    private boolean disponible;
    private double calificacion;

    public Conductor(String cedula, String nombre, String licencia, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.licencia = licencia;
        this.telefono = telefono;
        this.correo = correo;
        this.disponible = true;
        this.calificacion = 5.0;
    }

    // Getters y setters
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conductor conductor = (Conductor) obj;
        return cedula.equals(conductor.cedula);
    }

    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
}

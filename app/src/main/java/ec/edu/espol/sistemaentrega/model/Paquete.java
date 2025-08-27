package ec.edu.espol.sistemaentrega.model;

import java.io.Serializable;
import java.util.Date;

public class Paquete implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String descripcion;
    private double peso;
    private String destinatario;
    private String direccion;
    private String telefono;
    private String estado;
    private Date fechaRegistro;
    private Date fechaEntrega;

    public Paquete(String codigo, String descripcion, double peso, String destinatario, String direccion, String telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = "Pendiente";
        this.fechaRegistro = new Date();
        this.fechaEntrega = null;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    public Date getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(Date fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + " (" + estado + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paquete paquete = (Paquete) obj;
        return codigo.equals(paquete.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}

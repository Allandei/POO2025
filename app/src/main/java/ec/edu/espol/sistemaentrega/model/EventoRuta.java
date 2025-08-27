package ec.edu.espol.sistemaentrega.model;

import java.io.Serializable;
import java.util.Date;

public class EventoRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String tipo;
    private String descripcion;
    private Date fechaHora;
    private String rutaId;
    private String ubicacion;
    private double latitud;
    private double longitud;
    private String severidad;

    public EventoRuta(String tipo, String descripcion, String rutaId) {
        this.id = generarId();
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaHora = new Date();
        this.rutaId = rutaId;
        this.ubicacion = "";
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.severidad = "Normal";
    }

    private String generarId() {
        return "EVT-" + System.currentTimeMillis();
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }
    
    public String getRutaId() { return rutaId; }
    public void setRutaId(String rutaId) { this.rutaId = rutaId; }
    
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
    
    public String getSeveridad() { return severidad; }
    public void setSeveridad(String severidad) { this.severidad = severidad; }

    @Override
    public String toString() {
        return tipo + " - " + descripcion + " (" + fechaHora + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EventoRuta evento = (EventoRuta) obj;
        return id.equals(evento.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

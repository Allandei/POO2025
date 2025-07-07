package ec.edu.espol.mavenproject4;
import java.util.*;


public class EventoRuta {
    private String tipo;
    private String descripcion;
    private Date fechaHora;
    private String rutaId;

    public EventoRuta(String tipo, String descripcion, Date fechaHora, String rutaId) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.rutaId = rutaId;
    }

    public String getTipo() { 
        return tipo; 
    }
    public String getDescripcion() { 
        return descripcion; 
    }
    public Date getFechaHora() { 
        return fechaHora; 
    }
    public String getRutaId() { 
        return rutaId; 
    }

    @Override
    public String toString() {
        return tipo + "," + descripcion + "," + fechaHora.getTime() + "," + rutaId;
    }
}
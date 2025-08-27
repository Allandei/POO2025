package ec.edu.espol.sistemaentrega.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String placa;
    private String modelo;
    private String tipo;
    private double capacidad;
    private boolean operativo;
    private String estadoGPS;
    private double latitud;
    private double longitud;

    public Vehiculo(String placa, String modelo, String tipo, double capacidad) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.operativo = true;
        this.estadoGPS = "Desconectado";
        this.latitud = 0.0;
        this.longitud = 0.0;
    }

    // Getters y setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public double getCapacidad() { return capacidad; }
    public void setCapacidad(double capacidad) { this.capacidad = capacidad; }
    
    public boolean isOperativo() { return operativo; }
    public void setOperativo(boolean operativo) { this.operativo = operativo; }
    
    public String getEstadoGPS() { return estadoGPS; }
    public void setEstadoGPS(String estadoGPS) { this.estadoGPS = estadoGPS; }
    
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    @Override
    public String toString() {
        return placa + " - " + modelo + " (" + tipo + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return placa.equals(vehiculo.placa);
    }

    @Override
    public int hashCode() {
        return placa.hashCode();
    }
}

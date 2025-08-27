package ec.edu.espol.sistemaentrega.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private Date fechaCreacion;
    private Vehiculo vehiculo;
    private Conductor conductor;
    private List<Paquete> paquetes;
    private String estado;
    private Date horaSalida;
    private Date horaEstimadaLlegada;
    private double distanciaTotal;
    private String rutaOptimizada;

    public Ruta(String id, Vehiculo vehiculo, Conductor conductor) {
        this.id = id;
        this.fechaCreacion = new Date();
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.paquetes = new ArrayList<>();
        this.estado = "Planificada";
        this.horaSalida = null;
        this.horaEstimadaLlegada = null;
        this.distanciaTotal = 0.0;
        this.rutaOptimizada = "";
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    
    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }
    
    public List<Paquete> getPaquetes() { return paquetes; }
    public void setPaquetes(List<Paquete> paquetes) { this.paquetes = paquetes; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Date getHoraSalida() { return horaSalida; }
    public void setHoraSalida(Date horaSalida) { this.horaSalida = horaSalida; }
    
    public Date getHoraEstimadaLlegada() { return horaEstimadaLlegada; }
    public void setHoraEstimadaLlegada(Date horaEstimadaLlegada) { this.horaEstimadaLlegada = horaEstimadaLlegada; }
    
    public double getDistanciaTotal() { return distanciaTotal; }
    public void setDistanciaTotal(double distanciaTotal) { this.distanciaTotal = distanciaTotal; }
    
    public String getRutaOptimizada() { return rutaOptimizada; }
    public void setRutaOptimizada(String rutaOptimizada) { this.rutaOptimizada = rutaOptimizada; }

    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    public void removerPaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }

    public int getCantidadPaquetes() {
        return this.paquetes.size();
    }

    public double getPesoTotal() {
        return this.paquetes.stream().mapToDouble(Paquete::getPeso).sum();
    }

    @Override
    public String toString() {
        return "Ruta " + id + " - " + vehiculo.getPlaca() + " (" + estado + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ruta ruta = (Ruta) obj;
        return id.equals(ruta.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

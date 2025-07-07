
package ec.edu.espol.mavenproject4;
public class Vehiculo {
    private String placa;
    private String modelo;
    private String tipo;
    private double capacidad;
    private boolean operativo;

    // Constructor principal
    public Vehiculo(String placa, String modelo, String tipo, double capacidad) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.operativo = true;
    }

    public Vehiculo(String placa, String modelo, String tipo, int capacidad) {
        this(placa, modelo, tipo, (double) capacidad);
    }

    // Getters y setters
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getTipo() { return tipo; }
    public double getCapacidad() { return capacidad; }
    public boolean isOperativo() { return operativo; }
    public void setOperativo(boolean operativo) { this.operativo = operativo; }

    @Override
    public String toString() {
        return placa + "," + modelo + "," + tipo + "," + capacidad + "," + operativo;
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
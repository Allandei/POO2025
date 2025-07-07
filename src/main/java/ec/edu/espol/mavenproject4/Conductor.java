
package ec.edu.espol.mavenproject4;

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
    public String getNombre() { 
        return nombre; 
    }
    public String getLicencia() { 
        return licencia; 
    }
    public String getTelefono() { 
        return telefono; 
    }
    public String getCorreo() { 
        return correo; 
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + licencia + "," + telefono + "," + correo;
    }

    // Método evitar duplicados de conductores por cédula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conductor conductor = (Conductor) obj;
        return cedula.equals(conductor.cedula);
    }
}
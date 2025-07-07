
package ec.edu.espol.mavenproject4;
import java.util.Date;

public class Asignacion {
    private Date fecha;
    private Vehiculo vehiculo;
    private Conductor conductor;

    public Asignacion(Date fecha, Vehiculo vehiculo, Conductor conductor) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
    }

    public Date getFecha() { return fecha; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public Conductor getConductor() { return conductor; }

    @Override
    public String toString() {
        return fecha.getTime() + "," + vehiculo.getPlaca() + "," + conductor.getCedula();
    }
}
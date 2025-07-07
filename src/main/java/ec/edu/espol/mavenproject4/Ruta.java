
package ec.edu.espol.mavenproject4;
import java.util.*;

public class Ruta {
    private String id;
    private Date fecha;
    private List<Paquete> paquetes;
    private Vehiculo vehiculo;
    private Conductor conductor;

    public Ruta(String id, Date fecha, Vehiculo vehiculo, Conductor conductor) {
        this.id = id;
        this.fecha = fecha;
        this.paquetes = new ArrayList<>();
        this.vehiculo = vehiculo;
        this.conductor = conductor;
    }

    public String getId(){
        return id;
    }

    public Date getFecha(){
        return fecha;
    }

    public List<Paquete> getPaquetes(){
        return paquetes;
    }
    

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public Conductor getConductor(){
        return conductor;
    }

    public void agregarPaquete(Paquete paquete){
        paquetes.add(paquete);
    }

    @Override
    public String toString(){
        return id + "-" + fecha.getTime() + "-" + vehiculo.getPlaca() + "-" + conductor.getCedula();
    }
}

package ec.edu.espol.sistemaentrega.data;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ec.edu.espol.sistemaentrega.model.Conductor;
import ec.edu.espol.sistemaentrega.model.EventoRuta;
import ec.edu.espol.sistemaentrega.model.Paquete;
import ec.edu.espol.sistemaentrega.model.Ruta;
import ec.edu.espol.sistemaentrega.model.Vehiculo;

public class DataManager {
    private static final String TAG = "DataManager";
    private static DataManager instance;
    private final Context context;
    private final ExecutorService executor;
    private final Handler mainHandler;

    // Archivos de datos
    private static final String VEHICULOS_FILE = "vehiculos.dat";
    private static final String CONDUCTORES_FILE = "conductores.dat";
    private static final String PAQUETES_FILE = "paquetes.dat";
    private static final String RUTAS_FILE = "rutas.dat";
    private static final String EVENTOS_FILE = "eventos.dat";

    private DataManager(Context context) {
        this.context = context.getApplicationContext();
        this.executor = Executors.newFixedThreadPool(4);
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static synchronized DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    // ========== VEHÍCULOS ==========
    public void guardarVehiculo(Vehiculo vehiculo, DataCallback<Void> callback) {
        executor.execute(() -> {
            try {
                List<Vehiculo> vehiculos = cargarVehiculosSync();
                vehiculos.add(vehiculo);
                guardarListaSync(vehiculos, VEHICULOS_FILE);
                mainHandler.post(() -> callback.onSuccess(null));
            } catch (Exception e) {
                Log.e(TAG, "Error guardando vehículo", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void cargarVehiculos(DataCallback<List<Vehiculo>> callback) {
        executor.execute(() -> {
            try {
                List<Vehiculo> vehiculos = cargarVehiculosSync();
                mainHandler.post(() -> callback.onSuccess(vehiculos));
            } catch (Exception e) {
                Log.e(TAG, "Error cargando vehículos", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    // ========== CONDUCTORES ==========
    public void guardarConductor(Conductor conductor, DataCallback<Void> callback) {
        executor.execute(() -> {
            try {
                List<Conductor> conductores = cargarConductoresSync();
                conductores.add(conductor);
                guardarListaSync(conductores, CONDUCTORES_FILE);
                mainHandler.post(() -> callback.onSuccess(null));
            } catch (Exception e) {
                Log.e(TAG, "Error guardando conductor", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void cargarConductores(DataCallback<List<Conductor>> callback) {
        executor.execute(() -> {
            try {
                List<Conductor> conductores = cargarConductoresSync();
                mainHandler.post(() -> callback.onSuccess(conductores));
            } catch (Exception e) {
                Log.e(TAG, "Error cargando conductores", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    // ========== PAQUETES ==========
    public void guardarPaquete(Paquete paquete, DataCallback<Void> callback) {
        executor.execute(() -> {
            try {
                List<Paquete> paquetes = cargarPaquetesSync();
                paquetes.add(paquete);
                guardarListaSync(paquetes, PAQUETES_FILE);
                mainHandler.post(() -> callback.onSuccess(null));
            } catch (Exception e) {
                Log.e(TAG, "Error guardando paquete", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void cargarPaquetes(DataCallback<List<Paquete>> callback) {
        executor.execute(() -> {
            try {
                List<Paquete> paquetes = cargarPaquetesSync();
                mainHandler.post(() -> callback.onSuccess(paquetes));
            } catch (Exception e) {
                Log.e(TAG, "Error cargando paquetes", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    // ========== RUTAS ==========
    public void guardarRuta(Ruta ruta, DataCallback<Void> callback) {
        executor.execute(() -> {
            try {
                List<Ruta> rutas = cargarRutasSync();
                rutas.add(ruta);
                guardarListaSync(rutas, RUTAS_FILE);
                mainHandler.post(() -> callback.onSuccess(null));
            } catch (Exception e) {
                Log.e(TAG, "Error guardando ruta", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void cargarRutas(DataCallback<List<Ruta>> callback) {
        executor.execute(() -> {
            try {
                List<Ruta> rutas = cargarRutasSync();
                mainHandler.post(() -> callback.onSuccess(rutas));
            } catch (Exception e) {
                Log.e(TAG, "Error cargando rutas", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    // ========== EVENTOS ==========
    public void guardarEvento(EventoRuta evento, DataCallback<Void> callback) {
        executor.execute(() -> {
            try {
                List<EventoRuta> eventos = cargarEventosSync();
                eventos.add(evento);
                guardarListaSync(eventos, EVENTOS_FILE);
                mainHandler.post(() -> callback.onSuccess(null));
            } catch (Exception e) {
                Log.e(TAG, "Error guardando evento", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void cargarEventos(DataCallback<List<EventoRuta>> callback) {
        executor.execute(() -> {
            try {
                List<EventoRuta> eventos = cargarEventosSync();
                mainHandler.post(() -> callback.onSuccess(eventos));
            } catch (Exception e) {
                Log.e(TAG, "Error cargando eventos", e);
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    // ========== MÉTODOS PRIVADOS SINCRÓNICOS ==========
    @SuppressWarnings("unchecked")
    private List<Vehiculo> cargarVehiculosSync() throws IOException, ClassNotFoundException {
        return (List<Vehiculo>) cargarListaSync(VEHICULOS_FILE);
    }

    @SuppressWarnings("unchecked")
    private List<Conductor> cargarConductoresSync() throws IOException, ClassNotFoundException {
        return (List<Conductor>) cargarListaSync(CONDUCTORES_FILE);
    }

    @SuppressWarnings("unchecked")
    private List<Paquete> cargarPaquetesSync() throws IOException, ClassNotFoundException {
        return (List<Paquete>) cargarListaSync(PAQUETES_FILE);
    }

    @SuppressWarnings("unchecked")
    private List<Ruta> cargarRutasSync() throws IOException, ClassNotFoundException {
        return (List<Ruta>) cargarListaSync(RUTAS_FILE);
    }

    @SuppressWarnings("unchecked")
    private List<EventoRuta> cargarEventosSync() throws IOException, ClassNotFoundException {
        return (List<EventoRuta>) cargarListaSync(EVENTOS_FILE);
    }

    private List<?> cargarListaSync(String filename) throws IOException, ClassNotFoundException {
        File file = new File(context.getFilesDir(), filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<?>) ois.readObject();
        }
    }

    private void guardarListaSync(List<?> lista, String filename) throws IOException {
        File file = new File(context.getFilesDir(), filename);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    // ========== INTERFACE CALLBACK ==========
    public interface DataCallback<T> {
        void onSuccess(T result);
        void onError(String error);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

package ec.edu.espol.mavenproject4;

import java.util.*;
import java.text.SimpleDateFormat;

public class SistemaEntrega {
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE RASTREO VEHICULAR ===");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Registrar Conductor");
        System.out.println("3. Asignar Vehículo a Conductor");
        System.out.println("4. Registrar Paquete a Entregar");
        System.out.println("5. Crear Ruta de Entrega");
        System.out.println("6. Iniciar Rastreo de Vehículo");
        System.out.println("7. Registrar Evento de Ruta");
        System.out.println("8. Consultar Historial de Vehículo");
        System.out.println("9. Generar Reporte de Entregas por Ruta");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
    }

    private static void procesarOpcion(int opcion) {
        switch(opcion) {
            case 1: registrarVehiculo(); break;
            case 2: registrarConductor(); break;
            case 3: asignarVehiculoConductor(); break;
            case 4: registrarPaquete(); break;
            case 5: crearRuta(); break;
            case 6: iniciarRastreo(); break;
            case 7: registrarEvento(); break;
            case 8: consultarHistorial(); break;
            case 9: generarReporte(); break;
            case 0: System.out.println("Saliendo del sistema..."); break;
            default: System.out.println("Opción inválida");
        }
        if (opcion != 0) esperarEnter();
    }

    private static void esperarEnter() {
        System.out.print("\nPresione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    private static void registrarVehiculo() {
        sc.nextLine();
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Capacidad: ");
        double capacidad = sc.nextDouble();

        Vehiculo vehiculo = new Vehiculo(placa, modelo, tipo, capacidad);
        Archivos.guardar("vehiculos.txt", vehiculo.toString());
        System.out.println("Vehículo registrado exitosamente");
    }

    private static void registrarConductor() {
        sc.nextLine();
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Licencia: ");
        String licencia = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        Conductor conductor = new Conductor(cedula, nombre, licencia, telefono, correo);
        Archivos.guardar("conductores.txt", conductor.toString());
        System.out.println("Conductor registrado exitosamente");
    }

    private static void asignarVehiculoConductor() {
        sc.nextLine();
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        System.out.print("Cédula del conductor: ");
        String cedula = sc.nextLine();

        Asignacion asignacion = new Asignacion(new Date(), new Vehiculo(placa, "", "", 0), new Conductor(cedula, "", "", "", ""));
        Archivos.guardar("asignaciones.txt", asignacion.toString());
        System.out.println("Asignación realizada exitosamente");
    }

    private static void registrarPaquete() {
        sc.nextLine();
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Destinatario: ");
        String destinatario = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Paquete paquete = new Paquete(codigo, descripcion, peso, destinatario, direccion, telefono);
        Archivos.guardar("paquetes.txt", paquete.toString());
        System.out.println("Paquete registrado exitosamente");
    }

    private static void crearRuta() {
        sc.nextLine();
        System.out.print("ID de ruta: ");
        String id = sc.nextLine();
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        System.out.print("Cédula del conductor: ");
        String cedula = sc.nextLine();

        Ruta ruta = new Ruta(id, new Date(), new Vehiculo(placa, "", "", 0), new Conductor(cedula, "", "", "", ""));
        Archivos.guardar("rutas.txt", ruta.toString());
        System.out.println("Ruta creada exitosamente");
    }

    private static void iniciarRastreo() {
        sc.nextLine();
        System.out.print("ID de ruta: ");
        String rutaId = sc.nextLine();
        System.out.print("Hora de salida (dd/MM/yyyy HH:mm): ");
        String horaSalidaStr = sc.nextLine();

        try {
            Date horaSalida = sdf.parse(horaSalidaStr);
            String registro = rutaId + "," + horaSalida.getTime();
            Archivos.guardar("rastreo.txt", registro);
            System.out.println("Rastreo iniciado exitosamente");
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto");
        }
    }

    private static void registrarEvento() {
        sc.nextLine();
        System.out.print("ID de ruta: ");
        String rutaId = sc.nextLine();
        System.out.print("Tipo de evento: ");
        String tipo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        EventoRuta evento = new EventoRuta(tipo, descripcion, new Date(), rutaId);
        Archivos.guardar("eventosRuta.txt", evento.toString());
        System.out.println("Evento registrado exitosamente");
    }

    private static void consultarHistorial() {
        sc.nextLine();
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();

        List<String> rutas = Archivos.leer("rutas.txt");
        for (String ruta : rutas) {
            if (ruta.contains(placa)) {
                System.out.println("Ruta encontrada: " + ruta);
            }
        }
    }

    private static void generarReporte() {
        sc.nextLine();
        System.out.print("ID de ruta: ");
        String rutaId = sc.nextLine();

        List<String> eventos = Archivos.leer("eventosRuta.txt");
        int totalEventos = 0;
        for (String evento : eventos) {
            if (evento.contains(rutaId)) {
                totalEventos++;
            }
        }

        String reporte = "Reporte para ruta " + rutaId + "\nTotal eventos: " + totalEventos;
        Archivos.guardar("reportes.txt", reporte);
        System.out.println(reporte);
    }
}
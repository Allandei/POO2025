/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.mavenproject4;

import java.util.Scanner;

/**
 *
 * @author Lenovo-User
 */
public class SistemaEntrega {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do{
            mostrarMenu();
            System.out.println("Seleccionar una opcion");
            
            while(!sc.hasNextInt()){
                System.out.println("Opción invalida");
                sc.next(); // limpiar entrada no válida
                mostrarMenu();
                System.out.println("Seleccione una opción: ");
            }
            
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el salto de línea
            
            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    registrarConductor;
                    break;
                case 3:
                    asignarVehiculoAConductor();
                    break;
                case 4:
                    registrarPaquete();
                    break;
                case 5:
                    crearRutaEntrega();
                    break;
                case 6:
                    iniciarRastreo();
                    break;
                case 7:
                    registrarEventoRuta();
                    break;
                case 8:
                    consultarHistorialVehiculo();
                    break;
                case 9:
                    generarReporte();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");    
            }
            
            System.out.println(); // espacio entre operaciones
            
        } while (opcion != 0);
         sc.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("----- MENÚ PRINCIPAL -----");
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
    }

    
}

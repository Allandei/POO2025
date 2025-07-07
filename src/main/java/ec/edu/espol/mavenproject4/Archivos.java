
package ec.edu.espol.mavenproject4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
    public static void guardar(String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public static List<String> leer(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        return lineas;
    }

    public static void limpiarArchivo(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            writer.print("");
        } catch (FileNotFoundException e) {
            System.out.println("Error al limpiar archivo: " + e.getMessage());
        }
    }
}
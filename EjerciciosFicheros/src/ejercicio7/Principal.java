package ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Principal {

    public static int menu() throws IOException {
        int opcion = 0;
        do {
            System.out.println("--- BIBLIOTECA ---");
            System.out.println("1. Añadir libro o revista");
            System.out.println("2. Gestionar préstamo");
            System.out.println("3. Gestionar devolución");
            System.out.println("4. Salir");
            try {
                opcion = Lecturas.leerEntero("Selecciona una opción: ");
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida");
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: añadirMaterial(); break;
                case 2: gestionarPrestamo(); break;
                case 3: gestionarDevolucion(); break;
                case 4: System.out.println("Saliendo..."); break;
            }
        } while (opcion != 4);
    }

    private static void añadirMaterial() throws IOException {
        File FICHERO_BIBLIOTECA = new File("biblioteca.txt");

        String tipo = Lecturas.leerOpcion("¿Qué quieres añadir? (L/R): ", new String[]{"L", "R"});

        if (tipo.equalsIgnoreCase("L")) {
            Libro libro = new Libro();
            libro.pedirDatos();
            libro.escribirFichero(FICHERO_BIBLIOTECA, true);
        } else {
            Revista revista = new Revista();
            revista.pedirDatos();
            revista.escribirFichero(FICHERO_BIBLIOTECA, true);
        }

        System.out.println("Material añadido correctamente.");
    }

    private static void gestionarPrestamo() throws IOException {
        File FICHERO_BIBLIOTECA = new File("biblioteca.txt");

        if (!FICHERO_BIBLIOTECA.exists()) {
            System.out.println("No existe el fichero biblioteca.txt");
            return;
        }

        int idMaterial = Lecturas.leerEntero("Introduce el id del material a prestar: ");

        FileReader fr = new FileReader(FICHERO_BIBLIOTECA);
        BufferedReader br = new BufferedReader(fr);

        boolean enc = false;
        boolean prestado = false;
        String linea = br.readLine();

        while (linea != null) {
            String[] datos = linea.split(",");
            int idLeido = Integer.parseInt(datos[0].trim());
            if (idLeido == idMaterial) {
                enc = true;
                prestado = Boolean.parseBoolean(datos[5].trim());
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ningún material con ese id.");
            return;
        }

        if (prestado) {
            System.out.println("El material ya está prestado.");
            return;
        }

        actualizarEstadoPrestamo(FICHERO_BIBLIOTECA, idMaterial, true);
        System.out.println("Préstamo realizado correctamente.");
    }

    private static void gestionarDevolucion() throws IOException {
        File FICHERO_BIBLIOTECA = new File("biblioteca.txt");

        if (!FICHERO_BIBLIOTECA.exists()) {
            System.out.println("No existe el fichero biblioteca.txt");
            return;
        }

        int idMaterial = Lecturas.leerEntero("Introduce el id del material a devolver: ");

        FileReader fr = new FileReader(FICHERO_BIBLIOTECA);
        BufferedReader br = new BufferedReader(fr);

        boolean enc = false;
        boolean prestado = false;
        String linea = br.readLine();

        while (linea != null) {
            String[] datos = linea.split(",");
            int idLeido = Integer.parseInt(datos[0].trim());
            if (idLeido == idMaterial) {
                enc = true;
                prestado = Boolean.parseBoolean(datos[5].trim());
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ningún material con ese id.");
            return;
        }

        if (!prestado) {
            System.out.println("El material no está prestado.");
            return;
        }

        actualizarEstadoPrestamo(FICHERO_BIBLIOTECA, idMaterial, false);
        System.out.println("Devolución realizada correctamente.");
    }

    private static void actualizarEstadoPrestamo(File FICHERO_BIBLIOTECA, int idMaterial, boolean nuevoPrestado) throws IOException {
        File fTemporal = new File("biblioteca_tmp.txt");

        FileReader fr = new FileReader(FICHERO_BIBLIOTECA);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(fTemporal, false);
        PrintWriter pw = new PrintWriter(fw);

        String linea = br.readLine();
        while (linea != null) {
            String[] datos = linea.split(",");
            int idLeido = Integer.parseInt(datos[0].trim());
            if (idLeido == idMaterial) {
                datos[5] = String.valueOf(nuevoPrestado);
                linea = String.join(",", datos);
            }
            pw.println(linea);
            linea = br.readLine();
        }

        br.close();
        fr.close();
        pw.flush();
        pw.close();
        fw.close();

        if (FICHERO_BIBLIOTECA.delete()) {
            fTemporal.renameTo(FICHERO_BIBLIOTECA);
        } else {
            System.err.println("Error al actualizar el fichero.");
        }
    }
}

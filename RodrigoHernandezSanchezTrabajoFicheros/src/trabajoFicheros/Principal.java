package trabajoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Principal {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean salir = false;
        do {
            System.out.println(" === CENTRO JUVENIL === ");
            System.out.println("1. Añadir una nueva actividad");
            System.out.println("2. Buscar actividades por sección");
            System.out.println("3. Realizar una inscripción");
            System.out.println("4. Exportar participantes de una actividad");
            System.out.println("5. Salir");
            System.out.print("Introduce una opción: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (IOException e) {
                    System.err.println("Solo puedes introducir números");
                }
            }

            switch (opcion) {
                case 1:System.out.println("=== AÑADIR ACTIVIDAD ===");añadirActividad();break;
                case 2:System.out.println("=== BUSCAR POR SECCIÓN ===");buscarPorSeccion();break;
                //case 3:System.out.println("=== REALIZAR INSCRIPCIÓN ===");realizarInscripcion();break;
                case 4:System.out.println("=== EXPORTAR PARTICIPANTES ===");exportarParticipantes();break;
                case 5:System.out.println("Salir");salir = true;break;
                default:System.out.println("Opción no válida");
            }

        } while (!salir);
    }

    //case1
    private static void añadirActividad() {
        Actividad actividad = new Actividad();
        actividad.pedirDatos();
        actividad.escribirActividad();
        System.out.println("Actividad guardada correctamente.");
    }

    //case 2
    private static void buscarPorSeccion() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String seccion = "";

        do {
            System.out.print("Introduce la sección a buscar (Chiqui, Preas, Centro): ");
            seccion = leer.readLine();
            if (!seccion.equalsIgnoreCase("Chiqui") &&!seccion.equalsIgnoreCase("Preas") && !seccion.equalsIgnoreCase("Centro")) {
                System.err.println("No has introducido una sección correcta");
            }
        } while (!seccion.equalsIgnoreCase("Chiqui") && !seccion.equalsIgnoreCase("Preas") &&!seccion.equalsIgnoreCase("Centro"));

        File f = new File("./actividades.txt");
        if (!f.exists()) {
            System.out.println("No existe el fichero actividades.txt");
            return;
        }

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        double precioTotal = 0;
        boolean hayActividades = false;

        System.out.println("SECCIÓN: " + seccion);

        while (linea != null) {
            Actividad actividad = new Actividad();
            actividad.leerActividad(linea);

            if (actividad.getSeccion().equalsIgnoreCase(seccion)) {
                hayActividades = true;
                System.out.println("ACTIVIDAD: " + actividad.getNombre());
                System.out.println("Precio: " + actividad.getPrecio() + "€");
                System.out.println("Plazas disponibles: " + actividad.getPlazasDisponibles());
                precioTotal += actividad.getPrecio();
            }

            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!hayActividades) {
            System.out.println("No hay actividades para esa sección.");
        } else {
            System.out.println("Total: " + precioTotal + "€");
        }
    }

    //Case3

    //case 4
    private static void exportarParticipantes() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce el id de la actividad que quieres exportar: ");
        int idActividad = Integer.parseInt(leer.readLine());

        File fActividades = new File("./actividades.txt");
        if (!fActividades.exists()) {
            System.out.println("No existe el fichero actividades.txt");
            return;
        }

        FileReader fr = new FileReader(fActividades);
        BufferedReader br = new BufferedReader(fr);

        Actividad actividadElegida = null;
        String linea = br.readLine();

        while (linea != null) {
            Actividad a = new Actividad();
            a.leerActividad(linea);
            if (a.getId() == idActividad) {
                actividadElegida = a;
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (actividadElegida == null) {
            System.out.println("No existe ninguna actividad con ese id.");
            return;
        }

        System.out.println("Actividad encontrada: " + actividadElegida.getNombre());
    }
}
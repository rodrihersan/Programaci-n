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
                case 3:System.out.println("=== REALIZAR INSCRIPCIÓN ===");realizarInscripcion();break;
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
        boolean enc  = false;

        System.out.println("SECCIÓN: " + seccion);

        while (linea != null) {
            Actividad actividad = new Actividad();
            actividad.leerActividad(linea);

            if (actividad.getSeccion().equalsIgnoreCase(seccion)) {
            	enc  = true;
                System.out.println("ACTIVIDAD: " + actividad.getNombre());
                System.out.println("Precio: " + actividad.getPrecio() + "€");
                System.out.println("Plazas disponibles: " + actividad.getPlazasDisponibles());
                precioTotal += actividad.getPrecio();
            }

            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc ) {
            System.out.println("No hay actividades para esa sección.");
        } else {
            System.out.println("Total: " + precioTotal + "€");
        }
    }

    //Case3 (sin terminar)
    private static void realizarInscripcion() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        File fActividades = new File("./actividades.txt");
        File fActividadesTemporales = new File("actividades_temp.txt");
        if (!fActividades.exists()) {
            System.out.println("No existe el fichero actividades.txt");
            return;
        }

        System.out.print("Introduce el id de la actividad a la que te quieres inscribir: ");
        int idActividadBuscar = Integer.parseInt(leer.readLine());
        int edad = 0;

        FileReader fr = new FileReader(fActividades);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        while (linea != null) {
            Actividad a = new Actividad();
            a.leerActividad(linea);
            
            if (a.getId() == idActividadBuscar) {
                if(a.getPlazasDisponibles() > 0) {
                	System.out.println("Introduce la edad: ");
                	edad = Integer.parseInt(leer.readLine());
                	
                	if(a.getSeccion().equalsIgnoreCase("Chiqui") && (edad < 8 || edad > 11) ||
                			a.getSeccion().equalsIgnoreCase("Preas") && (edad < 12 || edad > 13) || 
                			a.getSeccion().equalsIgnoreCase("Centro") && (edad < 14 || edad > 16)) {
                		
                    	System.out.println("No tienes la edad adecuada para inscribirte en esta actividad.");
                		
                	}
                }
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ninguna actividad con ese id.");
            return;
        }

        if (actividadElegida.getPlazasDisponibles() <= 0) {
            System.out.println("No quedan plazas disponibles para esa actividad.");
            return;
        }
    }
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

        boolean enc = false;
        Actividad actividadElegida = new Actividad();
        String linea = br.readLine();

        while (linea != null) {
            Actividad a = new Actividad();
            a.leerActividad(linea);
            if (a.getId() == idActividad) {
                actividadElegida = a;
                enc = true;
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ninguna actividad con ese id.");
            return;
        }

        File fInscripciones = new File("./inscripciones.txt");
        if (!fInscripciones.exists()) {
            System.out.println("No hay inscripciones registradas.");
            return;
        }

        FileReader fr2 = new FileReader(fInscripciones);
        BufferedReader br2 = new BufferedReader(fr2);

        File fExportar = new File("./" + actividadElegida.getNombre() + ".txt");
        enc = false;

        String linea2 = br2.readLine();
        while (linea2 != null) {
            String[] datos = linea2.split(";");
            int idActividadInscripcion = Integer.parseInt(datos[3]);

            if (idActividadInscripcion == idActividad) {
                enc = true;
                FileWriter fw = new FileWriter(fExportar, true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(datos[0] + ";" + datos[2]);
                pw.flush();
                pw.close();
                fw.close();
            }

            linea2 = br2.readLine();
        }

        br2.close();
        fr2.close();

        if (enc) {
            System.out.println("Inscripciones exportadas en: " + actividadElegida.getNombre() + ".txt");
        } else {
            System.out.println("No hay participantes inscritos en esa actividad.");
        }
    }
}
package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Viaje> viajes = new ArrayList<Viaje>();
        boolean salir = false;

        do {
            System.out.println("=== MENÚ VIAJES ===");
            System.out.println("4. Nueva propuesta");
            System.out.println("6. ¿Nos llega el dinero?");
            System.out.println("7. Salir");
            System.out.print("Introduce una opción: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.err.println("Solo puedes introducir números");
                }
            }

            switch (opcion) {
                case 4:
                    System.out.println("=== Nueva propuesta ===");
                    nuevaPropuesta(viajes);
                    break;
                case 6:
                    System.out.println("=== ¿Nos llega el dinero? ===");
                    nosLlegaElDinero(viajes);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!salir);
    }

    private static void nuevaPropuesta(ArrayList<Viaje> viajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String tipo = "";

        do {
            try {
                System.out.print("Tipo de viaje (Nacional/Internacional): ");
                tipo = leer.readLine();
                if (!tipo.equalsIgnoreCase("nacional") && !tipo.equalsIgnoreCase("internacional"))
                    System.out.println("Tienes que introducir un tipo válido");
            } catch (IOException e) {
                System.out.println("Has introducido mal algún dato, crack");
                e.printStackTrace();
            }
        } while (!tipo.equalsIgnoreCase("nacional") && !tipo.equalsIgnoreCase("internacional"));

        if (tipo.equalsIgnoreCase("nacional")) {
            ViajeNacional vn = new ViajeNacional();
            vn.pedirDatos();
            viajes.add(vn);
        } else {
            ViajeInternacional vi = new ViajeInternacional();
            vi.pedirDatos();
            viajes.add(vi);
        }
    }

    private static void nosLlegaElDinero(ArrayList<Viaje> viajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce tu presupuesto: ");
                double presupuesto = Double.parseDouble(leer.readLine());

                boolean hayAlguno = false;
                for (Viaje v : viajes) {
                    if (v instanceof ViajeInternacional) {
                        if (((ViajeInternacional) v).getCosteTotal() <= presupuesto) {
                            ((ViajeInternacional) v).mostrarDatos();
                            hayAlguno = true;
                        }
                    }
                }

                if (!hayAlguno)
                    System.out.println("No hay viajes internacionales dentro de tu presupuesto.");

                datosOK = true;
            } catch (IOException e) {
                System.out.println("Has introducido mal algún dato, crack");
                e.printStackTrace();
            }
        }
    }
}

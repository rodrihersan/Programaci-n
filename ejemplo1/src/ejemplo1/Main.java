package ejemplo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean salir = false;
        do {
            System.out.println("\n=== MENÚ VIAJES ===");
            System.out.println("8. Ver propuestas asequibles");
            System.out.println("9. Actualizar personas");
            System.out.println("10. Salir");
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
                case 8:
                    System.out.println("=== Ver propuestas asequibles ===");
                    verAsequibles();
                    break;
                case 9:
                    System.out.println("=== Actualizar personas ===");
                    actualizarPersonas();
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!salir);
    }

    private static void verAsequibles() {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        double maxPorPersona = 0;
        while (!datosOK) {
            try {
                System.out.print("Introduce precio máximo por persona: ");
                maxPorPersona = Double.parseDouble(leer.readLine());
                datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.err.println("Solo puedes introducir números");
            }
        }

        File f = new File("propuestas.txt");

        if (!f.exists()) {
            System.out.println("No existe propuestas.txt");
            return;
        }

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            boolean hayAlguna = false;

            while (linea != null) {
                Propuesta p = new Propuesta();
                p.leerPropuesta(linea);

                if (p.getPrecioPorPersona() <= maxPorPersona) {
                    p.mostrarDatos();
                    hayAlguna = true;
                }

                linea = br.readLine();
            }

            br.close();
            fr.close();

            if (!hayAlguna)
                System.out.println("No hay propuestas dentro de ese precio por persona.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actualizarPersonas() {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        File f = new File("propuestas.txt");

        if (!f.exists()) {
            System.out.println("No existe propuestas.txt");
            return;
        }

        File temp = new File("propuestas_temp.txt");

        try {
            boolean enc = false;
            while (!enc) {
                int idBuscado = -1;
                boolean datosOK = false;
                while (!datosOK) {
                    try {
                        System.out.print("Introduce el ID a buscar: ");
                        idBuscado = Integer.parseInt(leer.readLine());
                        datosOK = true;
                    } catch (NumberFormatException | IOException e) {
                        System.err.println("Solo puedes introducir números");
                    }
                }

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();

                while (linea != null) {
                    Propuesta p = new Propuesta();
                    p.leerPropuesta(linea);

                    if (p.getId() == idBuscado) {
                        enc = true;
                        System.out.println("Personas actuales: " + p.getPersonas());


                        int nuevoValor = 0;
                        boolean valorOK = false;
                        while (!valorOK) {
                            try {
                                do {
                                    System.out.print("Introduce el nuevo número de personas: ");
                                    nuevoValor = Integer.parseInt(leer.readLine());
                                    if (nuevoValor <= p.getPersonas())
                                        System.out.println("Debe ser mayor que el valor actual (" + p.getPersonas() + ").");
                                    else if (nuevoValor > 25)
                                        System.out.println("No puede superar 25 personas.");
                                } while (nuevoValor <= p.getPersonas() || nuevoValor > 25);
                                valorOK = true;
                            } catch (NumberFormatException | IOException e) {
                                System.err.println("Solo puedes introducir números");
                            }
                        }

                        p.setPersonas(nuevoValor);
                    }

                    p.escribirFichero(temp);
                    linea = br.readLine();
                }

                br.close();
                fr.close();

                if (!enc) {
                    System.out.println("ID no encontrado, inténtalo de nuevo.");
                    temp.delete();
                }
            }

            if (f.delete()) {
                temp.renameTo(f);
                System.out.println("Actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar el fichero.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
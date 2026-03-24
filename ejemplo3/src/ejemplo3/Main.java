package ejemplo3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;

        do {
            System.out.println("\n=== MENÚ LIBRERÍA ===");
            System.out.println("8. Ver libros asequibles");
            System.out.println("9. Actualizar copias");
            System.out.println("10. Salir");

            int opcion = Lecturas.leerEntero("Introduce una opción: ");

            switch (opcion) {
                case 8:
                    System.out.println("=== Ver libros asequibles ===");
                    verAsequibles();
                    break;
                case 9:
                    System.out.println("=== Actualizar copias ===");
                    actualizarCopias();
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
        double maxPorCopia = Lecturas.leerDouble("Introduce precio máximo por copia: ");

        File f = new File("libros.txt");

        if (!f.exists()) {
            System.out.println("No existe libros.txt");
            return;
        }

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            boolean hayAlguno = false;

            while (linea != null) {
                Libro l = new Libro();
                l.leerLibro(linea);

                if (l.getPrecioPorCopia() <= maxPorCopia) {
                    l.mostrarDatos();
                    hayAlguno = true;
                }

                linea = br.readLine();
            }

            br.close();
            fr.close();

            if (!hayAlguno)
                System.out.println("No hay libros dentro de ese precio.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actualizarCopias() {
        File f = new File("libros.txt");

        if (!f.exists()) {
            System.out.println("No existe libros.txt");
            return;
        }

        File temp = new File("libros_temp.txt");

        try {
            boolean enc = false;
            while (!enc) {
                int idBuscado = Lecturas.leerEntero("Introduce el ID a buscar: ");

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();

                while (linea != null) {
                    Libro l = new Libro();
                    l.leerLibro(linea);

                    if (l.getId() == idBuscado) {
                        enc = true;
                        System.out.println("Copias actuales: " + l.getCopias());

                        int nuevoValor;
                        do {
                            nuevoValor = Lecturas.leerEntero("Introduce el nuevo número de copias: ");
                            if (nuevoValor <= l.getCopias())
                                System.out.println("Debe ser mayor que el valor actual (" + l.getCopias() + ").");
                            else if (nuevoValor > 25)
                                System.out.println("No puede superar 25 copias.");
                        } while (nuevoValor <= l.getCopias() || nuevoValor > 25);

                        l.setCopias(nuevoValor);
                    }

                    l.escribirFichero(temp);
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

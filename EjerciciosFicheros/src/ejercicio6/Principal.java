package ejercicio6;

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
            System.out.println("\n=== CINE ===");
            System.out.println("1. Añadir pelicula");
            System.out.println("2. Realizar venta");
            System.out.println("3. Pelicula mas vendida");
            System.out.println("4. Listado por genero");
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
            case 1:
                System.out.println("=== AÑADIR PELICULA ===");
                Pelicula pelicula = new Pelicula();
                pelicula.pedirDatos();
                pelicula.escribirPelicula();
                System.out.println("Pelicula añadida correctamente.");
                break;

            case 2:
                System.out.println("=== REALIZAR VENTA ===");
                realizarVenta();
                break;

            case 3:
                System.out.println("=== PELICULA MAS VENDIDA ===");
                File ventas3 = new File("ventas.txt");
                if (ventas3.exists()) {
                    BufferedReader br3 = new BufferedReader(new FileReader(ventas3));
                    String linea3;

                    java.util.Map<Integer, int[]> mapa = new java.util.HashMap<>();

                    while ((linea3 = br3.readLine()) != null) {
                        String[] datos = linea3.split(",");
                        int id = Integer.parseInt(datos[0]);
                        int cantidad = Integer.parseInt(datos[1]);
                        double precioVenta = Double.parseDouble(datos[2]);

                        if (!mapa.containsKey(id)) {
                            mapa.put(id, new int[]{0, 0});
                        }
                        mapa.get(id)[0] += cantidad;
                        mapa.get(id)[1] += (int)(precioVenta * 100);
                    }
                    br3.close();

                    int idMasVendida = -1;
                    int maxEntradas = 0;
                    double recaudacionMasVendida = 0;

                    for (java.util.Map.Entry<Integer, int[]> entry : mapa.entrySet()) {
                        if (entry.getValue()[0] > maxEntradas) {
                            maxEntradas = entry.getValue()[0];
                            idMasVendida = entry.getKey();
                            recaudacionMasVendida = entry.getValue()[1] / 100.0;
                        }
                    }

                    File peliculas3 = new File("peliculas.txt");
                    BufferedReader brP = new BufferedReader(new FileReader(peliculas3));
                    String lineaP;
                    String tituloPelicula = "Desconocida";
                    while ((lineaP = brP.readLine()) != null) {
                        Pelicula p = new Pelicula();
                        p.leerPelicula(lineaP);
                        if (p.getId() == idMasVendida) {
                            tituloPelicula = p.getTitulo();
                        }
                    }
                    brP.close();

                    System.out.println("Pelicula mas vendida: " + tituloPelicula);
                    System.out.println("Total entradas vendidas: " + maxEntradas);
                    System.out.println("Recaudacion total: " + recaudacionMasVendida);
                } else {
                    System.out.println("No hay ventas registradas.");
                }
                break;

            case 4:
                System.out.println("=== LISTADO POR GENERO ===");
                File peliculas4 = new File("peliculas.txt");
                File ventas4 = new File("ventas.txt");

                if (peliculas4.exists() && ventas4.exists()) {
                    java.util.Map<Integer, Pelicula> mapaPeliculas = new java.util.HashMap<>();
                    BufferedReader brPel = new BufferedReader(new FileReader(peliculas4));
                    String lineaPel;
                    while ((lineaPel = brPel.readLine()) != null) {
                        Pelicula p = new Pelicula();
                        p.leerPelicula(lineaPel);
                        mapaPeliculas.put(p.getId(), p);
                    }
                    brPel.close();

                    java.util.Map<String, Double> recaudacionPorGenero = new java.util.HashMap<>();
                    BufferedReader brVen = new BufferedReader(new FileReader(ventas4));
                    String lineaVen;
                    while ((lineaVen = brVen.readLine()) != null) {
                        String[] datos = lineaVen.split(",");
                        int id = Integer.parseInt(datos[0]);
                        double precioVenta = Double.parseDouble(datos[2]);

                        if (mapaPeliculas.containsKey(id)) {
                            String genero = mapaPeliculas.get(id).getGenero();
                            recaudacionPorGenero.put(genero, recaudacionPorGenero.getOrDefault(genero, 0.0) + precioVenta);
                        }
                    }
                    brVen.close();

                    for (java.util.Map.Entry<String, Double> entry : recaudacionPorGenero.entrySet()) {
                        System.out.println("Genero: " + entry.getKey() + " | Recaudacion: " + entry.getValue());
                    }
                } else {
                    System.out.println("No hay datos suficientes para mostrar el listado.");
                }
                break;

            case 5:
                System.out.println("Salir");
                salir = true;
                break;

            default:
                System.out.println("Opción no válida");
            }

        } while (!salir);
    }

    private static void realizarVenta() throws NumberFormatException, IOException {
        File archivoPeliculas = new File("peliculas.txt");

        if (archivoPeliculas.exists()) {
            Venta venta = new Venta();
            venta.pedirVenta();

            File archivoTemporal = new File("peliculas_tmp.txt");
            FileWriter fw = new FileWriter(archivoTemporal, false);
            PrintWriter pw = new PrintWriter(fw);

            FileReader fr = new FileReader(archivoPeliculas);
            BufferedReader br = new BufferedReader(fr);

            boolean peliculaEncontrada = false;
            String lineaPelicula = br.readLine();

            while (lineaPelicula != null) {
                Pelicula pelicula = new Pelicula();
                pelicula.leerPelicula(lineaPelicula);

                if (pelicula.getId() == venta.getIdPelicula()) {
                    peliculaEncontrada = true;
                    if (pelicula.getEntradasDisponibles() >= venta.getCantidadVendidas()) {
                        int entradasDisponiblesActualizadas = pelicula.getEntradasDisponibles() - venta.getCantidadVendidas();
                        pelicula.setEntradasDisponibles(entradasDisponiblesActualizadas);
                        double precioTotal = venta.getCantidadVendidas() * pelicula.getPrecio();
                        venta.setPrecioTotal(precioTotal);
                        System.out.println("Venta realizada correctamente. Precio a pagar " + venta.getPrecioTotal());
                    } else {
                        System.out.println("No hay suficientes entradas disponibles para la película " + pelicula.getTitulo());
                        peliculaEncontrada = false;
                    }
                }

                pw.println(pelicula.getId() + "," + pelicula.getTitulo() + "," + pelicula.getGenero() + ","
                        + pelicula.getPrecio() + "," + pelicula.getEntradasDisponibles());

                lineaPelicula = br.readLine();
            }

            br.close();
            fr.close();
            pw.flush();
            pw.close();
            fw.close();

            if (peliculaEncontrada) {
                venta.escribirEntrada();
                if (archivoPeliculas.delete()) {
                    archivoTemporal.renameTo(archivoPeliculas);
                } else {
                    System.out.println("Error al actualizar el archivo de películas.");
                }
            } else {
                System.out.println("No se encontró la película con ID " + venta.getIdPelicula());
            }

        } else {
            System.out.println("No hay películas registradas. Debe registrar películas antes de realizar una venta.");
        }
    }
}

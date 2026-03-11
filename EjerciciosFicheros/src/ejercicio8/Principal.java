package ejercicio8;

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
            System.out.println("\n--- SERVICIO DE MÚSICA ---");
            System.out.println("1. Añadir nuevo contenido multimedia");
            System.out.println("2. Marcar podcast como escuchado");
            System.out.println("3. Crear playlist");
            System.out.println("4. Añadir canción o podcast a playlist");
            System.out.println("5. Borrar canción o podcast de playlist");
            System.out.println("6. Salir");
            try {
                opcion = Lecturas.leerEntero("Selecciona una opción: ");
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida");
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: añadirContenido(); break;
                case 2: marcarPodcastEscuchado(); break;
                case 3: crearPlaylist(); break;
                case 4: añadirAPlaylist(); break;
                case 5: borrarDePlaylist(); break;
                case 6: System.out.println("Saliendo..."); break;
            }
        } while (opcion != 6);
    }

    private static void añadirContenido() throws IOException {
        File FICHERO_CATALOGO = new File("catalogo.txt");
        String tipo = Lecturas.leerOpcion("¿Qué quieres añadir? (C/P): ", new String[]{"C", "P"});

        if (tipo.equalsIgnoreCase("C")) {
            Cancion cancion = new Cancion();
            cancion.pedirDatos();
            cancion.escribirFichero(FICHERO_CATALOGO, true);
        } else {
            Podcast podcast = new Podcast();
            podcast.pedirDatos();
            podcast.escribirFichero(FICHERO_CATALOGO, true);
        }

        System.out.println("Contenido añadido correctamente.");
    }

    private static void marcarPodcastEscuchado() throws IOException {
        File FICHERO_CATALOGO = new File("catalogo.txt");

        if (!FICHERO_CATALOGO.exists()) {
            System.out.println("No existe el fichero catalogo.txt");
            return;
        }

        String tituloBuscado = Lecturas.leerString("Introduce el título del podcast: ");

        FileReader fr = new FileReader(FICHERO_CATALOGO);
        BufferedReader br = new BufferedReader(fr);
        boolean enc = false;
        String linea = br.readLine();

        while (linea != null) {
            String[] datos = linea.split("-");
            if (datos[0].equalsIgnoreCase("P") && datos[1].trim().equalsIgnoreCase(tituloBuscado)) {
                enc = true;
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ningún podcast con ese título.");
            return;
        }

        File fTemporal = new File("catalogo_tmp.txt");
        FileReader fr2 = new FileReader(FICHERO_CATALOGO);
        BufferedReader br2 = new BufferedReader(fr2);
        FileWriter fw = new FileWriter(fTemporal, false);
        PrintWriter pw = new PrintWriter(fw);

        linea = br2.readLine();
        while (linea != null) {
            String[] datos = linea.split("-");
            if (datos[0].equalsIgnoreCase("P") && datos[1].trim().equalsIgnoreCase(tituloBuscado)) {
                Podcast p = new Podcast();
                p.leerPodcast(linea);
                p.setEscuchado(true);
                pw.println("P-" + p.getTitulo() + "-" + p.getArtista() + "-" + p.getGenero() + "-" + p.getDuracion() + "-" + p.getNumeroEpisodio() + "-" + p.isEscuchado());
            } else {
                pw.println(linea);
            }
            linea = br2.readLine();
        }

        br2.close();
        fr2.close();
        pw.flush();
        pw.close();
        fw.close();

        if (FICHERO_CATALOGO.delete()) {
            fTemporal.renameTo(FICHERO_CATALOGO);
        } else {
            System.err.println("Error al actualizar el fichero.");
        }

        System.out.println("Podcast marcado como escuchado.");
    }

    private static void crearPlaylist() throws IOException {
        File FICHERO_CATALOGO = new File("catalogo.txt");

        if (!FICHERO_CATALOGO.exists()) {
            System.out.println("No existe el fichero catalogo.txt");
            return;
        }

        String nombrePlaylist = Lecturas.leerString("Introduce el nombre de la playlist: ");
        File FICHERO_PLAYLIST = new File(nombrePlaylist + ".txt");

        boolean seguir = true;
        while (seguir) {
            String tituloBuscado = Lecturas.leerString("Introduce el título a añadir: ");

            FileReader fr = new FileReader(FICHERO_CATALOGO);
            BufferedReader br = new BufferedReader(fr);
            boolean enc = false;
            String linea = br.readLine();

            while (linea != null) {
                String[] datos = linea.split("-");
                if (datos[1].trim().equalsIgnoreCase(tituloBuscado)) {
                    enc = true;
                    FileWriter fw = new FileWriter(FICHERO_PLAYLIST, true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(linea);
                    pw.flush();
                    pw.close();
                    fw.close();
                }
                linea = br.readLine();
            }

            br.close();
            fr.close();

            if (!enc) {
                System.out.println("No existe ningún contenido con ese título.");
            } else {
                System.out.println("Añadido a la playlist.");
            }

            seguir = Lecturas.leerSiNo("¿Quieres añadir otro contenido?");
        }

        System.out.println("Playlist creada en: " + nombrePlaylist + ".txt");
    }

    private static void añadirAPlaylist() throws IOException {
        File FICHERO_CATALOGO = new File("catalogo.txt");

        if (!FICHERO_CATALOGO.exists()) {
            System.out.println("No existe el fichero catalogo.txt");
            return;
        }

        String nombrePlaylist = Lecturas.leerString("Introduce el nombre de la playlist: ");
        File FICHERO_PLAYLIST = new File(nombrePlaylist + ".txt");

        if (!FICHERO_PLAYLIST.exists()) {
            System.out.println("No existe esa playlist.");
            return;
        }

        String tituloBuscado = Lecturas.leerString("Introduce el título a añadir: ");

        FileReader fr = new FileReader(FICHERO_CATALOGO);
        BufferedReader br = new BufferedReader(fr);
        boolean enc = false;
        String linea = br.readLine();

        while (linea != null) {
            String[] datos = linea.split("-");
            if (datos[1].trim().equalsIgnoreCase(tituloBuscado)) {
                enc = true;
                FileWriter fw = new FileWriter(FICHERO_PLAYLIST, true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(linea);
                pw.flush();
                pw.close();
                fw.close();
            }
            linea = br.readLine();
        }

        br.close();
        fr.close();

        if (!enc) {
            System.out.println("No existe ningún contenido con ese título.");
        } else {
            System.out.println("Contenido añadido a la playlist.");
        }
    }

    private static void borrarDePlaylist() throws IOException {
        String nombrePlaylist = Lecturas.leerString("Introduce el nombre de la playlist: ");
        File FICHERO_PLAYLIST = new File(nombrePlaylist + ".txt");

        if (!FICHERO_PLAYLIST.exists()) {
            System.out.println("No existe esa playlist.");
            return;
        }

        // Mostrar contenido de la playlist
        FileReader fr = new FileReader(FICHERO_PLAYLIST);
        BufferedReader br = new BufferedReader(fr);
        System.out.println("Contenido de la playlist:");
        String linea = br.readLine();

        while (linea != null) {
            String[] datos = linea.split("-");
            System.out.println("Título: " + datos[1].trim() + " - Tipo: " + datos[0].trim());
            linea = br.readLine();
        }

        br.close();
        fr.close();

        String tituloBorrar = Lecturas.leerString("Introduce el título a borrar: ");

        File fTemporal = new File(nombrePlaylist + "_tmp.txt");
        FileReader fr2 = new FileReader(FICHERO_PLAYLIST);
        BufferedReader br2 = new BufferedReader(fr2);
        FileWriter fw = new FileWriter(fTemporal, false);
        PrintWriter pw = new PrintWriter(fw);

        boolean enc = false;
        boolean borrado = false;
        linea = br2.readLine();

        while (linea != null) {
            String[] datos = linea.split("-");
            if (datos[1].trim().equalsIgnoreCase(tituloBorrar) && !borrado) {
                enc = true;
                borrado = true;
            } else {
                pw.println(linea);
            }
            linea = br2.readLine();
        }

        br2.close();
        fr2.close();
        pw.flush();
        pw.close();
        fw.close();

        if (!enc) {
            System.out.println("No existe ningún contenido con ese título en la playlist.");
            fTemporal.delete();
        } else {
            if (FICHERO_PLAYLIST.delete()) {
                fTemporal.renameTo(FICHERO_PLAYLIST);
                System.out.println("Contenido eliminado de la playlist.");
            } else {
                System.err.println("Error al actualizar la playlist.");
            }
        }
    }
}

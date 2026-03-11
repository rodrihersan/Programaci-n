package ejercicio8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cancion {

    private String titulo;
    private String artista;
    private String genero;
    private double duracion;
    private String album;

    public void pedirDatos() throws IOException {
        this.titulo = Lecturas.leerString("Introduce el título: ");
        this.artista = Lecturas.leerString("Introduce el artista: ");
        this.genero = Lecturas.leerString("Introduce el género: ");
        this.duracion = Lecturas.leerDoubleMayorQue("Introduce la duración (minutos): ", 0);
        this.album = Lecturas.leerString("Introduce el álbum: ");
    }

    public void escribirFichero(File f, boolean añadir) throws IOException {
        FileWriter fw = new FileWriter(f, añadir);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("C-" + this.titulo + "-" + this.artista + "-" + this.genero + "-" + this.duracion + "-" + this.album);
        pw.flush();
        pw.close();
        fw.close();
    }

    public void leerCancion(String linea) {
        String[] datos = linea.split("-");
        this.titulo = datos[1].trim();
        this.artista = datos[2].trim();
        this.genero = datos[3].trim();
        this.duracion = Double.parseDouble(datos[4].trim());
        this.album = datos[5].trim();
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getDuracion() { return duracion; }
    public void setDuracion(double duracion) { this.duracion = duracion; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
}

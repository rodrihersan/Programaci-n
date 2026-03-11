package ejercicio8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Podcast {

    private String titulo;
    private String artista;
    private String genero;
    private double duracion;
    private int numeroEpisodio;
    private boolean escuchado;

    public void pedirDatos() throws IOException {
        this.titulo = Lecturas.leerString("Introduce el título: ");
        this.artista = Lecturas.leerString("Introduce el artista: ");
        this.genero = Lecturas.leerString("Introduce el género: ");
        this.duracion = Lecturas.leerDoubleMayorQue("Introduce la duración (minutos): ", 0);
        this.numeroEpisodio = Lecturas.leerEnteroMayorQue("Introduce el número de episodio: ", 0);
        this.escuchado = false;
    }

    public void escribirFichero(File f, boolean añadir) throws IOException {
        FileWriter fw = new FileWriter(f, añadir);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("P-" + this.titulo + "-" + this.artista + "-" + this.genero + "-" + this.duracion + "-" + this.numeroEpisodio + "-" + this.escuchado);
        pw.flush();
        pw.close();
        fw.close();
    }

    public void leerPodcast(String linea) {
        String[] datos = linea.split("-");
        this.titulo = datos[1].trim();
        this.artista = datos[2].trim();
        this.genero = datos[3].trim();
        this.duracion = Double.parseDouble(datos[4].trim());
        this.numeroEpisodio = Integer.parseInt(datos[5].trim());
        this.escuchado = Boolean.parseBoolean(datos[6].trim());
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getDuracion() { return duracion; }
    public void setDuracion(double duracion) { this.duracion = duracion; }
    public int getNumeroEpisodio() { return numeroEpisodio; }
    public void setNumeroEpisodio(int numeroEpisodio) { this.numeroEpisodio = numeroEpisodio; }
    public boolean isEscuchado() { return escuchado; }
    public void setEscuchado(boolean escuchado) { this.escuchado = escuchado; }
}

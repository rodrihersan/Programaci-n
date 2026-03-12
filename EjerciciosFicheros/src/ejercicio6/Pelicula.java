package ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private double precio;
    private int entradasDisponibles;

    public void pedirDatos() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce el id de la pelicula: ");
        this.id = Integer.parseInt(leer.readLine());

        System.out.println("Introduce el titulo: ");
        this.titulo = leer.readLine();

        System.out.println("Introduce el genero: ");
        this.genero = leer.readLine();

        System.out.println("Introduce el precio: ");
        this.precio = Double.parseDouble(leer.readLine());

        System.out.println("Introduce las entradas disponibles: ");
        this.entradasDisponibles = Integer.parseInt(leer.readLine());
    }

    public void escribirPelicula() throws IOException {
        File archivoPeliculas = new File("peliculas.txt");
        FileWriter fw = new FileWriter(archivoPeliculas, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(this.id + "," + this.titulo + "," + this.genero + "," + this.precio + "," + this.entradasDisponibles);
        pw.flush();
        pw.close();
    }

    public void leerPelicula(String linea) throws IOException {
        String[] datos = linea.split(",");
        this.id = Integer.parseInt(datos[0]);
        this.titulo = datos[1];
        this.genero = datos[2];
        this.precio = Double.parseDouble(datos[3]);
        this.entradasDisponibles = Integer.parseInt(datos[4]);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getEntradasDisponibles() { return entradasDisponibles; }
    public void setEntradasDisponibles(int entradasDisponibles) { this.entradasDisponibles = entradasDisponibles; }
}
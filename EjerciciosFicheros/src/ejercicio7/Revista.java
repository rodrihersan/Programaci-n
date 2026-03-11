package ejercicio7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Revista extends Material {

    private int numeroEdicion;

    public void pedirDatos() throws IOException {
        System.out.println("Introduce los datos de la revista:");

        do {
            this.id = Lecturas.leerEntero("ID: ");
            if (this.id <= 0) {
                System.out.println("El id debe ser mayor que cero.");
            }
        } while (this.id <= 0 || idRepetido(this.id));

        this.tipo = "R";
        this.titulo = Lecturas.leerString("Introduce el título: ");
        this.autor = Lecturas.leerString("Introduce el autor: ");

        do {
            this.anioPublicacion = Lecturas.leerEntero("Introduce el año de publicación: ");
            if (this.anioPublicacion <= 0) {
                System.out.println("El año debe ser mayor que cero.");
            }
        } while (this.anioPublicacion <= 0);

        this.prestado = false;

        do {
            this.numeroEdicion = Lecturas.leerEntero("Introduce el número de edición: ");
            if (this.numeroEdicion <= 0) {
                System.out.println("El número de edición debe ser mayor que cero.");
            }
        } while (this.numeroEdicion <= 0);
    }

    public void leerRevista(String linea) {
        String[] datos = linea.split(",");
        this.id = Integer.parseInt(datos[0].trim());
        this.tipo = datos[1].trim();
        this.titulo = datos[2].trim();
        this.autor = datos[3].trim();
        this.anioPublicacion = Integer.parseInt(datos[4].trim());
        this.prestado = Boolean.parseBoolean(datos[5].trim());
        this.numeroEdicion = Integer.parseInt(datos[6].trim());
    }

    public void escribirFichero(File f, boolean añadir) throws IOException {
        FileWriter fw = new FileWriter(f, añadir);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(this.id + "," + this.tipo + "," + this.titulo + "," + this.autor + "," + this.anioPublicacion + "," + this.prestado + "," + this.numeroEdicion);
        pw.flush();
        pw.close();
        fw.close();
    }

    public int getNumeroEdicion() { return numeroEdicion; }
    public void setNumeroEdicion(int numeroEdicion) { this.numeroEdicion = numeroEdicion; }
}

package ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Venta {
    private int idPelicula;
    private int cantidadVendidas;
    private double precioTotal;

    public void pedirVenta() throws NumberFormatException, IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce el id de la pelicula: ");
        idPelicula = Integer.parseInt(leer.readLine());

        System.out.println("Introduce la cantidad de entradas: ");
        cantidadVendidas = Integer.parseInt(leer.readLine());
    }

    public void escribirEntrada() throws IOException {
        File archivoVentas = new File("ventas.txt");
        FileWriter fw = new FileWriter(archivoVentas, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(this.idPelicula + "," + this.cantidadVendidas + "," + this.precioTotal);
        pw.flush();
        pw.close();
    }

    public int getIdPelicula() { return idPelicula; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public int getCantidadVendidas() { return cantidadVendidas; }
    public void setCantidadVendidas(int cantidadVendida) { this.cantidadVendidas = cantidadVendida; }
    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }
}

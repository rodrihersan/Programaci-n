package ejemplo1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Propuesta {
    private int id;
    private String destino;
    private int dias;
    private double costePorDia;
    private int personas;

    public void leerPropuesta(String linea) {
        String[] datos = linea.split(";");
        this.id = Integer.parseInt(datos[0].trim());
        this.destino = datos[1].trim();
        this.dias = Integer.parseInt(datos[2].trim());
        this.costePorDia = Double.parseDouble(datos[3].trim());
        this.personas = Integer.parseInt(datos[4].trim());
    }

    public void escribirFichero(File f) {
        try {
            FileWriter fw = new FileWriter(f, true); // true = append
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.id + ";" + this.destino + ";" + this.dias + ";" + this.costePorDia + ";" + this.personas);
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatos() {
        System.out.println("----------------");
        System.out.println("ID: " + id);
        System.out.println("Destino: " + destino);
        System.out.println("Días: " + dias);
        System.out.println("Coste/día: " + costePorDia);
        System.out.println("Personas: " + personas);
        System.out.println("Precio total: " + getPrecioTotal());
        System.out.println("Valoración: " + getValoracion());
    }

    public double getPrecioTotal() { return dias * costePorDia; }
    public double getPrecioPorPersona() { return getPrecioTotal() / personas; }

    public String getValoracion() {
        if (costePorDia < 50) return "Económico";
        else if (costePorDia < 100) return "Moderado";
        else return "Caro";
    }

    public int getId() { return id; }
    public int getPersonas() { return personas; }
    public void setPersonas(int personas) { this.personas = personas; }
}
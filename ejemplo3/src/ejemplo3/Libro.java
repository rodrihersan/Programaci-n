package ejemplo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private double precio;
    private int copias;

    public void leerLibro(String linea) {
        String[] datos = linea.split(";");
        this.id = Integer.parseInt(datos[0].trim());
        this.titulo = datos[1].trim();
        this.autor = datos[2].trim();
        this.precio = Double.parseDouble(datos[3].trim());
        this.copias = Integer.parseInt(datos[4].trim());
    }

    public void escribirFichero(File f) {
        try {
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.id + ";" + this.titulo + ";" + this.autor + ";" + this.precio + ";" + this.copias);
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatos() {
        System.out.println("----------------");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: " + precio);
        System.out.println("Copias: " + copias);
        System.out.println("Precio total: " + getPrecioTotal());
        System.out.println("Valoración: " + getValoracion());
    }

    public double getPrecioTotal() { return precio * copias; }
    public double getPrecioPorCopia() { return precio; }

    public String getValoracion() {
        if (precio < 10) {
        	return "Económico";
        	
        }else if (precio < 25) { 
        	return "Moderado";
        }else {
        	return "Caro";
        }
    }

    public int getId() { 
    	return id; 
    	}
    
    public int getCopias() { 
    	return copias; 
    	}
    
    public void setCopias(int copias) { 
    	this.copias = copias; 
    	}
}

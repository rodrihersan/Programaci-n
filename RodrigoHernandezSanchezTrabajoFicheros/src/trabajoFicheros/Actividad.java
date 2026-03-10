package trabajoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Actividad {
    private int id;
    private String nombre;
    private String seccion;
    private int plazasDisponibles;
    private double precio;

    public void pedirDatos() {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean todoOk = false;
        do {
            try {
                boolean idUnico = false;
                do {
                    System.out.print("ID: ");
                    this.id = Integer.parseInt(leer.readLine());
                    if(this.id <= 0) {
                        System.out.println("El id debe ser un número mayor que cero.");
                    } else if (estaRepetido(this.id)) {
                        System.out.println("ID Repetido");
                    } else {
                        idUnico = true;
                    }
                } while(!idUnico);

                System.out.print("Introduce el nombre de la actividad: ");
                this.nombre = leer.readLine();

                do {
                    System.out.print("Introduce la sección (Chiqui, Preas, Centro): ");
                    this.seccion = leer.readLine();
                    if (!this.seccion.equalsIgnoreCase("Chiqui") && !this.seccion.equalsIgnoreCase("Preas") && !this.seccion.equalsIgnoreCase("Centro")) {
                        System.out.println("No has introducido una sección correcta");
                    }
                } while (!this.seccion.equalsIgnoreCase("Chiqui") &&!this.seccion.equalsIgnoreCase("Preas") && !this.seccion.equalsIgnoreCase("Centro"));

                do {
                    System.out.print("Introduce el número de plazas disponibles: ");
                    this.plazasDisponibles = Integer.parseInt(leer.readLine());
                    if (this.plazasDisponibles <= 0) {
                        System.out.println("Las plazas deben ser un valor mayor que cero.");
                    }
                } while (this.plazasDisponibles <= 0);

                do {
                    System.out.print("Introduce el precio de la actividad: ");
                    this.precio = Double.parseDouble(leer.readLine());
                    if (this.precio <= 0) {
                        System.out.println("El precio debe ser un valor mayor que cero.");
                    }
                } while (this.precio <= 0);

                todoOk = true;
            } catch (Exception e) {
                System.err.println("Ha habido un error al registrar los datos. Intentelo de nuevo.");
            }
        } while (!todoOk);
    }

    private boolean estaRepetido(int idBuscado) {
        File f = new File("./actividades.txt");
        if (!f.exists()) return false;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split(";");
                if (Integer.parseInt(datos[0]) == idBuscado) {
                    br.close();
                    fr.close();
                    return true;
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("Error al leer actividades.txt");
        }
        return false;
    }

    public void escribirActividad() {
        try {
            File f = new File("./actividades.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.id + ";" + this.nombre + ";" + this.seccion + ";" + this.plazasDisponibles + ";" + this.precio);
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero.");
        }
    }

	    public void leerActividad(String linea) {
	        String[] datos = linea.split(";");
	        this.id = Integer.parseInt(datos[0]);
	        this.nombre = datos[1];
	        this.seccion = datos[2];
	        this.plazasDisponibles = Integer.parseInt(datos[3]);
	        this.precio = Double.parseDouble(datos[4]);
	    }

    public int getId() {
    	return id; 
    }
    
    public String getNombre() { 
    	return nombre; 
    }
    
    public String getSeccion() { 
    	return seccion; 
    }
    
    public int getPlazasDisponibles() { 
    	return plazasDisponibles;
    }
    
    public double getPrecio() { 
    	return precio; 
    }
    
}


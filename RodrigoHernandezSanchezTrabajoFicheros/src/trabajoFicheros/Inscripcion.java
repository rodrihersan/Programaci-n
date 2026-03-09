package trabajoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Inscripcion {

    private String nombreParticipante;
    private int edad;
    private String telefono;
    private int idActividad;

    public void pedirDatos(int edad, int idActividad) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean todoOk = false;
        do {
            try {
                System.out.println("Introduce los datos de tu inscripción");

                System.out.print("Introduce el nombre: ");
                this.nombreParticipante = leer.readLine();

                System.out.print("Introduce teléfono de contacto: ");
                this.telefono = leer.readLine();

                this.edad = edad;
                this.idActividad = idActividad;

                todoOk = true;
            } catch (Exception e) {
                System.err.println("Ha habido un error al registrar los datos. Intentelo de nuevo.");
            }
        } while (!todoOk);
    }

    public void guardarInscripcion() {
        try {
            File f = new File("./inscripciones.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.nombreParticipante + ";" + this.edad + ";" + this.telefono + ";" + this.idActividad);
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero de inscripciones.");
        }
    }
    
    public void setEdad(int edad) { 
    	this.edad = edad; 
    }

    public void setIdActividad(int idActividad) { 
    	this.idActividad = idActividad; 
    }
}

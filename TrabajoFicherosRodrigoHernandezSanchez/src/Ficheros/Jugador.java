package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Jugador {
	private int id;
	private String nombre;
	private int puntos;
	private int partidasJugadas;
	
	public void pedirDatos() throws IOException {
		do {
            this.id = Lecturas.leerEntero("ID: ");
            if (this.id <= 0) {
                System.err.println("El id debe ser mayor que cero.");
            }
        } while (this.id <= 0 || idRepetido(this.id));
		
		this.nombre = Lecturas.leerString("Introduce el nombre: ");
		
		do {
            this.puntos = Lecturas.leerEntero("Puntos iniciales: ");
            if (this.puntos < 0) {
                System.err.println("Los puntos iniciales no pueden ser negativos.");
            }
        } while (this.puntos < 0);
		
		do {
            this.partidasJugadas = Lecturas.leerEntero("Partidas jugadas: ");
            if (this.partidasJugadas < 0) {
                System.err.println("Las partidas jugadas no pueden ser negativas.");
            }
        } while (this.partidasJugadas < 0);
	}
	
	protected static boolean idRepetido(int id) throws IOException {
        boolean enc = false;
        File f = new File("jugadores.txt");
        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null && enc == false) {
                String[] datos = linea.split(";");
                int idLeido = Integer.parseInt(datos[0].trim());
                if (id == idLeido) {
                    enc = true;
                    System.err.println("ID Repetido");
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        }
        return enc;
    }
	
	
	public void escribirFichero() {
        try {
            FileWriter fw = new FileWriter("jugadores.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(id + ";" + nombre + ";" + puntos + ";" + partidasJugadas);
            pw.close();
            fw.close();
            System.out.println("Jugador guardado correctamente.");
        } catch (IOException e) {
            System.err.println("ERROR: No se pudo guardar el jugador.");
        }
    }
	
}

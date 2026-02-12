package Practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cancion extends Contenido{
	private String artista;
	private int streamGlobales;
	private int añoLanzamiento; //int 1950-2025
	
	@Override
	public void pedirDatos(Contenido[] contenidos, int pos) {
		super.pedirDatos(contenidos, pos);
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean datosOk = false;
        
        do {
            try {
                System.out.print("Introduce el artista: ");
                this.artista = leer.readLine();

                System.out.print("Introduce el número de streams globales: ");
                this.streamGlobales = Integer.parseInt(leer.readLine());

                do {
                    System.out.print("Introduce el año de lanzamiento (1950-2025): ");
                    this.añoLanzamiento = Integer.parseInt(leer.readLine());
                } while (añoLanzamiento < 1950 || añoLanzamiento > 2025);
                datosOk = true;
            } catch (NumberFormatException | IOException e) {
                System.err.println("Error en los datos de la canción.");
            }
        } while (!datosOk);
    }

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Artista: " + artista);
        System.out.println("Streams globales: " + streamGlobales);
        System.out.println("Año lanzamiento: " + añoLanzamiento);
    }
}
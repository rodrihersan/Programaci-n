package Practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Podcast extends Contenido{
	private String presentador;
    private int numeroEpisodio;
    private boolean tieneTranscripcion;
    
    
	@Override
	public void pedirDatos(Contenido[] contenidos, int pos) {
		super.pedirDatos(contenidos, pos);
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean datosOk = false;

        do {
            try {
                System.out.print("Introduce el nombre del presentador: ");
                this.presentador = leer.readLine();
                
                System.out.print("Introduce el número de episodio: ");
                this.numeroEpisodio = Integer.parseInt(leer.readLine());
                
                System.out.print("¿Tiene transcripción disponible? (S/N): ");
                String respuesta = leer.readLine();
                
                this.tieneTranscripcion = respuesta.equalsIgnoreCase("S");
                datosOk = true;
            } catch (NumberFormatException | IOException e) {
                System.err.println("Error en los datos del podcast.");
            }
        } while (!datosOk);
    }
	

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		
		System.out.println("Presentador: " + presentador);
        System.out.println("Episodio: " + numeroEpisodio);
        System.out.print("Transcripción: ");
        if (tieneTranscripcion) {
        	System.out.println("Sí");
        } else {
            System.out.println("No");
        }
    }    
}
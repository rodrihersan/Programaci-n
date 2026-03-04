package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Reseña {
	private String nombreJugador;
	private String nombreVideojuego;
	private int notaVideojuego;
	private String comentario;
	
	public void pedirDatos() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean todoOk = false;

		do {
			try {
				System.out.println("Introduce nombre jugador: ");
				this.nombreJugador = leer.readLine();
				
				System.out.println("Introduce nombre videojuego: ");
				this.nombreVideojuego = leer.readLine();
				
				do {
					System.out.println("Introduce nota videojuego (0-10): ");
					this.notaVideojuego = Integer.parseInt(leer.readLine());
					if(this.notaVideojuego <0 || this.notaVideojuego >10) {
						System.out.println("Nota inválida");
					}
				} while (this.notaVideojuego < 0 || this.notaVideojuego > 10);
				
				
				System.out.println("Introduce un pequeño comentario: ");
				this.comentario = leer.readLine();
				
				todoOk = true;
				
			} catch (Exception e) {
				System.err.println("ERROR");
			}

		} while (!todoOk);

	}
	
	public void escribirFichero() {
		try {
			File f = new File("./reseñas.txt");
			FileWriter fw = new FileWriter(f, true); 
			//true para que no se sobreescriban los datos. 
			//false (o se puede no poner nada, lo interpreta como false) para que si se sobreescriban los datos introducidos
			PrintWriter pw = new PrintWriter(fw);
			pw.println(nombreJugador + ";" + nombreVideojuego + ";" + notaVideojuego 
					+ ";" + comentario);
			
			pw.flush();
            pw.close();
            fw.close();
		} catch (IOException e) {
		System.err.println("ERROR");
		}
	}
	
	public String getNombreJugador()    { 
		return nombreJugador; 
	}
	
    public String getNombreVideojuego() { 
    	return nombreVideojuego; 
    }
    
    public int getNotaVideojuego() { 
    	return notaVideojuego; 
    }
    
    public String getComentario() { 
    	return comentario; 
    }
}

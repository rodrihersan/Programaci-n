package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import ejercicio1.Alumno;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		boolean salir = false;
		do {
			System.out.println("==== TIENDA DE VIDEOJUEGOS ====");
            System.out.println("1. Añadir una reseña");
            System.out.println("2. Mostrar listado de videojuegos y nota media");
            System.out.println("3. Exportar reseñas de un jugador");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:System.out.println("=== AÑADIR UNA RESEÑA NUEVA ===");añadirReseña();break;
			case 2:System.out.println("=== MOSTRAR LISTADO Y NOTA MEDIA ===");listadoVideojuegos();break;
			case 3:System.out.println("=== EXPORTAR RESEÑAS ===");exportarReseñas();break;
			case 4:System.out.println("Salir");salir = true;break;
			default:System.out.println("Opción no válida");
			}
			
		} while (!salir);
	}
	
	private static void añadirReseña() {
		Reseña r = new Reseña();
		r.pedirDatos();
		r.escribirFichero();
		System.out.println("Reseña añadida correctamente.");

	}
	
	private static void listadoVideojuegos() {
		ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
		
		File f = new File("./reseñas.txt");
		
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				
				String linea = br.readLine();
				
				while(linea != null) {
					String[] datos = linea.split(";");
					
					String nombreVideojuego = datos [1];
					int nota = Integer.parseInt(datos[2]);
					
					boolean enc = false;
					
					for(int i=0; i < videojuegos.size() && enc == false; i++) {
						if(videojuegos.get(i).getNombre().equalsIgnoreCase(nombreVideojuego)) {
							videojuegos.get(i).añadirNotas(nota);
							enc = true;
						}
					}
					
					if(!enc) {
						Videojuego nuevoVideojuego = new Videojuego(nombreVideojuego);
						nuevoVideojuego.añadirNotas(nota);
						videojuegos.add(nuevoVideojuego);
					}
					
					linea = br.readLine();
				}
				
				System.out.println("Listado de videojuegos y su nota media");
				for(Videojuego vid:videojuegos) {
					System.out.println(vid.getNombre()+ ": " + vid.calcularMedia());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }else {
        	System.out.println("No existe el fichero resenas.txt");
        }
	}
	
	private static void exportarReseñas() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		File f = new File("./reseñas.txt");
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				
	        	System.out.println("Introduce nombre del jugador");
	        	String nombreJugador = leer.readLine();
	        	File reseñasJugador = new File("./reseñas_" + nombreJugador+ ".txt");
	        	
	        	String linea = br.readLine();
	        	
	        	boolean enc = false;
	        	
	        	while(linea != null) {
	        		String[] datos = linea.split(";");
	        		
	        		String nombreJugadorReseña = datos[0];
	        		
	        		if(nombreJugador.equalsIgnoreCase(nombreJugadorReseña)) {
	        			enc = true;
	        			FileWriter fw = new FileWriter(ficheroReseñasJugador, true);
	        			PrintWriter pw = new PrintWriter(fw);
	        			
	        			pw.println(linea);
	        			pw.flush();
	        			pw.close();
	        			fr.close();
	        		}
	        		linea = br.readLine();
	        	}
	        	
	        	br.close();
	        	fr.close();
	        	
	        	if(enc) {
	        		System.out.println("Se ha creado el archivo");
	        	}else {
	        		System.out.println("No se ha encontrado el jugador");
	        	}
	        }catch(IOException e) {
	        	System.err.println("Error al leer el archivo");
	       }
		}	
	}
}
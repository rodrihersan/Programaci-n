package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			case 2:System.out.println("=== MOSTRAR LISTADO Y NOTA MEDIA ===");mostrarReseña();break;
			//case 3:System.out.println("=== EXPORTAR RESEÑAS ===");();break;
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
	
	private static void mostrarReseña() {
		File f = new File("./reseñas.txt");
		
		if (!f.exists()) {
            System.out.println("No existe el fichero resenas.txt");
            return;
        }
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		Reseña r = new Reseña();
		
		String linea = br.readLine();
		while (linea != null) {
			String[] v;
			ArrayList<String> juegos      = new ArrayList<String>();
	        ArrayList<Integer> sumas      = new ArrayList<Integer>();
	        ArrayList<Integer> contadores = new ArrayList<Integer>();

	        String linea = br.readLine();
	        while (linea != null) {
	            String videojuego = br.readLine().split(": ")[1];
	            int nota          = Integer.parseInt(br.readLine().split(": ")[1]);
	            br.readLine();
	            int pos = -1;
	            for (int i = 0; i < juegos.size(); i++) {
	                if (juegos.get(i).equalsIgnoreCase(videojuego)) {
	                    pos = i;
	                    break;
	                }
	            }

	            if (pos == -1) {
	                juegos.add(videojuego);
	                sumas.add(nota);
	                contadores.add(1);
	            } else {
	                sumas.set(pos, sumas.get(pos) + nota);
	                contadores.set(pos, contadores.get(pos) + 1);
	            }

	            linea = br.readLine();
	        }

	        br.close();
	        fr.close();

	        if (juegos.isEmpty()) {
	            System.out.println("No hay reseñas en el fichero.");
	            return;
	        }

	        System.out.println("Videojuego                     Nota Media");
	        System.out.println("------------------------------------------");
	        for (int i = 0; i < juegos.size(); i++) {
	            double media = (double) sumas.get(i) / contadores.get(i);
	            System.out.println(juegos.get(i) + " -> " + media);
	        }
	    }
		
		}
	}


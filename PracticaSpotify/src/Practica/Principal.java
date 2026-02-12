package Practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	static Contenido[] contenidos = new Contenido[20];
	static int pos = 0;
	
	public static int leerInt() throws IOException {
		 
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un nï¿½mero vï¿½lido: ");
			}
		}
		return num;
	}

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		do {
			System.out.println(" === SPOTIFY - GESTIÓN DE PLAYLISTS === ");
			System.out.println("1. Añadir contenido");
			System.out.println("2. Mostrar contenido por categoría ");
			System.out.println("3. Añadir contenido a playlist");
			System.out.println("4. Estadísticas del perfil.");
			System.out.println("5. Salir.");

			System.out.print("Introduce una opción: ");
			int opcion = leerInt();
			
			switch (opcion) {
			case 1:añadirContenido();break;
			case 2:mostrarPorCategoria();break;
			//case 3:añadirAPlaylist();break;
			//case 4:mostrarEstadisticas();break;
			case 5:salir = true;System.out.println("¡Que disfrutes de tu música!");break;
			default:System.out.println("Opción no válida.");
		}	
		}while (!salir);
	}
	
	//Case 1
	public static void añadirContenido() throws IOException {
		System.out.print(" === Añadir contenido === ");
		System.out.print("");
		System.out.print("¿Cuántos contenidos desea añadir?: ");
		int cantidad = Integer.parseInt(leer.readLine());

		for (int i = 0; i < cantidad; i++) {
			System.out.println("Añadiendo contenido " + (i + 1) + " de " + cantidad);
			System.out.print("Tipo de contenido (Canción o Podcast): ");
			String tipo = leer.readLine();

			System.out.println("Introduce los datos del nuevo contenido:");
			if (tipo.equalsIgnoreCase("Canción")) {
				contenidos[pos] = new Cancion();
	            contenidos[pos].pedirDatos(contenidos, pos);
	            pos++;
			} else if (tipo.equalsIgnoreCase("Podcast")) {
				contenidos[pos] = new Podcast();
	            contenidos[pos].pedirDatos(contenidos, pos);
	            pos++;
			} else {
				System.out.println("Tipo no válido. No se añadió ningún contenido.");
			}	
		}
	}
	
	//Case 2
	public static void mostrarPorCategoria() throws IOException {
		System.out.print(" === Mostrar contenido por categoría === ");
		System.out.print("");
	    System.out.print("Introduce la categoría (música-podcast-audiolibro-meditación): ");
	    String categoria = leer.readLine().toLowerCase();

	    int contador = 1;
	    boolean encontrado = false;
	    for (int i = 0; i < pos; i++) {
	        if (contenidos[i].getCategoria().equals(categoria)) {
	            System.out.println("Mostrando contenido " + contador);
	            contenidos[i].mostrarDatos();
	            contador++;
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        System.out.println("No se encontró contenido de esa categoría.");
	    }
	}
	
	//Case 3
	public static void añadirAPlaylist() throws IOException {
	    System.out.print("Introduce el título del contenido a añadir a la playlist: ");
	    String titulo = leer.readLine();

	    boolean encontrado = false;
	    for (int i = 0; i < pos; i++) {
	        if (contenidos[i].getTitulo().equalsIgnoreCase(titulo)) {
	            encontrado = true;

	            if (contenidos[i].isActiva()) {
	                System.out.println("El contenido ya está en la playlist.");
	                return;
	            }

	            int elementosEnPlaylist = Contenido.contarElementosPlaylist(contenidos, pos);
	            if (elementosEnPlaylist >= 15) {
	                System.out.println("La playlist ya tiene 15 elementos. No se puede añadir más.");
	                return;
	            }

	            contenidos[i].setActiva(true);
	            System.out.println("Contenido añadido correctamente a la playlist");
	            System.out.println("Elementos en la playlist: " + (elementosEnPlaylist + 1));
	            System.out.println("Duración total de la playlist: " + Contenido.calcularDuracionPlaylist(contenidos, pos) + " minutos");
	            return;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No se encontró el contenido con ese título.");
	    }
	}
	
	//Case 4 sin hacer
}

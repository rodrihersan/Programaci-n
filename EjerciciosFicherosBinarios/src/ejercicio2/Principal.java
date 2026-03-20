package ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("\n=== INVENTARIO ===");
			System.out.println("1. Añadir producto");
			System.out.println("2. Productos en stock");
			System.out.println("3.Mostar total inventario");
			System.out.println("5. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números.");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("-- Añadir producto --");
				añadirAnimal();
				break;
			case 2:
				System.out.println("-- Productos en stock --");
				//();
				break;
			case 3:
				System.out.println("-- Mostar total inventario --");
				//();
				break;
			case 5:
				System.out.println("Saliendo del programa. ¡Hasta pronto!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
			}

		} while (!salir);
	}
	
		private static void mayorPeso() {
			ArrayList<Animal> animales = cargarDatos();
			
			if(animales == null) {
				System.out.println("No hay animales en el fichero");
				return;
			}
			
			Animal mayorPeso = animales.get(0);
			for(Animal a : Animales)
		}
	
		private static void buscarPorEspecie() {
			String especieABuscar = Lecturas.leerString("Introduce la especie a buscar");
			
			ArrayList<Animal>animales = cargarDatos();
			
			if(animales==null) {
				System.out.println("No se han encontrado animales de esta especie");
			}else {
				boolean enc = false;
				for(Animal a : animales) {
					if(a.getEspecie().equalsIgnoreCase(especieABuscar)) {
						System.out.print(a.toString());
						enc = true;
					}
				}
				
				if(!enc) {
					System.out.println("No se han encontrado animales de esta especie");
				}
			}
		}
	
	
		
		private static void añadirAnimal() {
			ArrayList<Animal> animales = cargarDatos();
			Animal a = new Animal();
			a.pedirDatos();
			animales.add(a);
			a.escribir(animales);
		}
		
		private static ArrayList<Animal> cargarDatos(){
			ArrayList<Animal> animales = new ArrayList<>();
			
			File f = new File("animales.obj");
			if(!f.exists()) {
				return animales;
			}
			
			try {
				FileInputStream fos = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fos);
				try {
					while(true) {
						Animal a = (Animal) ois.readObject();
						animales.add(a);
					}
				}catch (EOFException | ClassNotFoundException e) {
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			return animales;
		}
	}
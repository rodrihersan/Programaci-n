package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		
		libro[] libros = new libro[3]; //creo array vacio
		
		/*crear esos objetos
		libro l1 = new libro();
		l1.pedirDatos();
		libros[0] = l1;
		
		libro l2 = new libro();
		l2.pedirDatos();
		libros[1] = l2;
		
		libro l3 = new libro();
		l3.pedirDatos();
		libros[2] = l3;
		
		for(int i = 0; i<libros.length; i++) {
			System.out.println(libros[i].getTitulo());
		}*/
		
		
		do {
			System.out.println("BANCO");
			System.out.println("1. Añadir libro");
			System.out.println("2. Mostar todos los libros");
			System.out.println("3. Buscar libro por id");
			System.out.println("4. Mostrar libros antiguos (más de 30 años desde la publicación)");
			System.out.println("5. Salir");
			System.out.println("Introduce una opcion: ");
			int opcion = Integer.parseInt(leer.readLine());
			
			switch (opcion) {
			case 1:
				System.out.println("--Añadir libros--");
				for(int i =0; i< libros.length;i++) {
					libro l = new libro();
					//OPCION1
					int id;
					if(i==0){//si es el primer libro
						id = 1;
					}else {
						id = libros[i-1].getId();
					}
					l.pedirDatos(libros[i-1].getId()+1);
					//OPCION2 l.pedirDatos(i+1) simplemente
					libros[i] = l;
				}
				break;
				
			case 2:
				System.out.println("--Mostar libros--");
				for(int i = 0; i<libros.length; i++) {
					System.out.println(libros[i].toString());
				}
				break;
				
			case 3:
				System.out.println("--Buscar libro por id--");
				System.out.println("Introduce id a buscar");
				int id = Integer.parseInt(leer.readLine());
				for(int i =0; i< libros.length;i++) {
					if(libros[i].getId() == id) {
						System.out.println(libros[i].toString());
					}
				}
				break;
				
			case 4:
				System.out.println("--Mostrar libros antiguos--");
				for(int i =0; i< libros.length;i++) {
					if(libros[i].tiene30Años())	
						System.out.println(libros[i].toString());
					}
				break;
			
			case 5: 
				salir=true;
				break;
				}
			} while (!salir);
		}
	}

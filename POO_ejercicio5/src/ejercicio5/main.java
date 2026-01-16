package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		
		producto[] productos = new producto[2]; //creo array vacio
		
		do {
			System.out.println("TIENDA");
			System.out.println("1. Añadir producto");
			System.out.println("2. Mostrar todos los productos");
			System.out.println("3. Vender producto (pedir id y cantidad)");
			System.out.println("4. Reabastecer producto");
			System.out.println("5. Mostrar productos sin stock");
			System.out.println("6. Salir");
			System.out.println("Introduce una opcion: ");
			int opcion = Integer.parseInt(leer.readLine());
			
			switch (opcion) {
			case 1:
				for(int i =0; i< productos.length ;i++) {
					producto p = new producto();
					int id;
					if(i==0){//si es el primer libro
						id = 1;
					}else {
						id = productos[i-1].getId();
					}
					p.pedirDatos(i+1);
					productos[i] = p;
				}
				break;
				
			case 2:
				System.out.println("--Mostar productos--");
				for(int i = 0; i<productos.length; i++) {
					System.out.println(productos[i].toString());
				}
				break;
				
			case 3:
				
			}
			} while (!salir);
		}	
}

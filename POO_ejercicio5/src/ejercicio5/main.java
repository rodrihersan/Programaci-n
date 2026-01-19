package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		producto[] productos = new producto[3];
		boolean salir = false;

		do {
			System.out.println("TIENDA");
			System.out.println("1.Añadir productos");
			System.out.println("2. Mostrar todos los productos");
			System.out.println("3. Vender producto (pedir id y cantidad)");
			System.out.println("4. Reabastecer producto");
			System.out.println("5. Mostrar productos sin stock");
			System.out.println("6. Salir");
			System.out.println("Introduce una opcion: ");
			int opcion = Integer.parseInt(leer.readLine());

			switch (opcion) {
			case 1:
				System.out.println("--Añadir productos--");
				for (int i = 0; i < productos.length; i++) { // Producto p: prodcutos
					productos[i] = new producto();
					productos[i].pedirDatos(i + 1);
				}
				break;
			case 2:
				System.out.println("--Mostrar datos--");
				for (int i = 0; i < productos.length; i++) {
					/* opcion 1 con get */
					System.out.println(productos[i].getNombre() + " " + productos[i].getStock() + " "
							+ productos[i].getPrecio() + " " + productos[i].getId());
					/* opcion 2 con metodo propio */
					productos[i].mostrarDatos();
				}
				break;
			case 3:
				System.out.println("--Vender producto--");
				System.out.print("Introduce el id del producto: ");
				int id = Integer.parseInt(leer.readLine());
				boolean enc = false;

				for (int i = 0; i < productos.length && !enc; i++) {
					if (productos[i].getId() == id) {
						/* Otra opcion era pedir la cantidad en .realzarVenta() */
						System.out.println("Introduce la cantidad que quieres comprar");
						int cantidadAVender = Integer.parseInt(leer.readLine());
						productos[i].realizarVenta(cantidadAVender);
						enc = true;
					}
				}

				if (enc == false) {
					System.out.println("No se ha encontrado el producto con ese ID");
				}
					break;
			case 4:
				System.out.println("--Restbalecer stock-");
				System.out.print("Introduce el id del producto: ");
				id = Integer.parseInt(leer.readLine());
				enc = false;

				for (int i = 0; i < productos.length && !enc; i++) {
					if (productos[i].getId() == id) {
						productos[i].reabastecerProducto();
						enc = true;
					}
				}

				if (enc == false) {
					System.out.println("No se ha encontrado el producto con ese ID");
				}
				break;
			case 5:
				System.out.println("--Prodcutos sin stock-");
				boolean hayProductosSinStock = false;
			
				for (int i = 0; i < productos.length; i++) {
					if (productos[i].comprobarStock() == false) {
						System.out.println(productos[i].getNombre());
						hayProductosSinStock = true;
					}
				}
				
				if(hayProductosSinStock == false) {
					System.out.println("Todos los productos de la tienda tienen stock");
				}
			

				break;
			case 6:
				System.out.println("Saliendo...");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}
	}

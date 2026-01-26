package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static final BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		ArrayList<Articulo> productos = new ArrayList<Articulo>();

		boolean salir = false;
		do {
			System.out.println("\n== TIENDA INFORMATICA ==");
			System.out.println("1.Añadir artículo");
			System.out.println("2.Mostrar todos");
			System.out.println("3. Buscar por ID");
			System.out.println("4. Vender Articulo");
			System.out.println("5. Mostrar códigos pares");
			System.out.println("6. Salir");
			System.out.println("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(LEER.readLine());
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				datosOK = true;
			}

			switch (opcion) {
			case 1:
				añadirProducto(productos);
				break;
			case 2:
				mostrarTodosLosDatos(productos);
				break;
			case 3:
				mostrarDatosArticulo(productos);
				break;
			case 4:
				realizarVenta(productos);
				break;
			case 5:
				mostrarArticulosPares(productos);
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

	private static void añadirProducto(ArrayList<Articulo> productos) throws IOException {
		boolean parar = false;
		System.out.println("--Registrar productos --");

		while (parar == false) {
			System.out.println("Introduce los datos del producto " + (productos.size() + 1));
			productos.add(new Articulo());
			productos.getLast().pedirDatos(productos);

			System.out.println("¿Desea introducir otro productos? (S/N)");
			char opcion = LEER.readLine().toUpperCase().charAt(0);
			if (opcion == 'N')
				parar = true;
		}

	}

	private static void mostrarTodosLosDatos(ArrayList<Articulo> productos) {
		System.out.println("--Mostrar productos --");
		for (Articulo a : productos) {
			a.mostrarDatos();
		}

	}

	// Este metodo devuelve un Articulo dado un ID que luego puedo usar en cualquier
	// otra clase.
	// Devuelve un objeto de la clase Articulo
	private static Articulo buscarPorId(ArrayList<Articulo> productos) {
		int id = -1;
		boolean todoOk = false;

		do {
			try {
				System.out.print("Introduce el id del articulo: ");
				id = Integer.parseInt(LEER.readLine());
				todoOk = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} while (todoOk != true);

		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getId() == id) {
				return productos.get(i);
			}
		}

		return null;
	}

	private static void mostrarDatosArticulo(ArrayList<Articulo> productos) {
		System.out.println("== Buscar por código == ");
		Articulo a = buscarPorId(productos);
		if (a != null)
			a.mostrarDatos();
		else
			System.out.println("Articulo no encontrado :(");

	}

	private static void realizarVenta(ArrayList<Articulo> productos) {
		System.out.println("== Realizar venta == ");
		Articulo a = buscarPorId(productos);
		//Si encontramos el articulo
		if (a != null) {
			//Pedimos la cantidad
			System.out.print("¿Cuantos articulos quieres de " + a.getNombre() + "?: ");
			int cantidad = -1;
			do {
				try {
					cantidad = Integer.parseInt(LEER.readLine());
					if(cantidad < 0)
						System.out.println("La cantidad debe ser un numero mayor que 0");
				} catch (NumberFormatException | IOException e) {
					System.err.println("La cantidad debe ser un numero");
				}
			} while (cantidad < 0);
			
			//Comprobamos que podemos realizar la venta (que hay stock suficiente)
			if(a.realizarVenta(cantidad) == false)
				System.out.println("No hay productos suficientes");
			else {
				//Si lo hay conseguimos el stock actual y le restamos la cantidad a vender
				//a.getStock devolvera 5, 6, el nunmero que sea
				//Con - cantidad le resyamos lo que vendemos. 6-2, 5-4, LO QUE SEA, y eso tendra un numero, 3, 4
				//Con set guardamos el resultado de la resta, guardando el stock actual 
				a.setStock(a.getStock()-cantidad);
				System.out.println("Venta realizada correctamente");
				System.out.println("Total a pagar: " + (cantidad * a.getPrecio()));
				System.out.println("Stock actualizado: " + a.getStock());
			}
		} else {
			System.out.println("Articulo no encontrado. No se puede realizar la venta");
		}

	}
	
	

	private static void mostrarArticulosPares(ArrayList<Articulo> productos) {
		System.out.println("== Articulos con ID PAR == ");
		boolean hayPares = false;
		for(Articulo a:productos) {
			//Recorro y si id % 2 == 0, significa que es PAR
			if(a.getId() % 2 == 0)
				a.mostrarDatos();
				hayPares = true; //Si encuentra algun par lo indico en este booleano
		}
		
		if(hayPares == false)
			System.out.println("No hay productos con ID par"); //Si no encuentra ninguno
		
	}

}
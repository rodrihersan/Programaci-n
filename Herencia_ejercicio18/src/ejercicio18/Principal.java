package ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

		boolean salir = false;
		do {
			System.out.println("\n=== TIENDA DE INFORMATICA Y TELEFONIA ===");
			System.out.println("1. Registrar Producto");
			System.out.println("2. Añadir Componente a Ordenador");
			System.out.println("3. Instalar App en Smartphone");
			System.out.println("4. Filtrar Ordenadores por Componente");
			System.out.println("5. Filtrar Smartphones por Aplicacion");
			System.out.println("6. Presupuesto de Garantia Extendida");
			System.out.println("7. Producto Top de Gama");
			System.out.println("8. Salir");
			System.out.print("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir numeros");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== Registrar Producto ===");
				registrarProducto(dispositivos);
				break;
			case 2:
				System.out.println("=== Añadir Componente a Ordenador ===");
				añadirComponente(dispositivos);
				break;
			case 3:
				System.out.println("=== Instalar App en Smartphone ===");
				instalarApp(dispositivos);
				break;
			case 4:
				System.out.println("=== Filtrar Ordenadores por Componente ===");
				filtrarOrdenadoresPorComponente(dispositivos);
				break;
			case 5:
				System.out.println("=== Filtrar Smartphones por Aplicacion ===");
				filtrarSmartphonesPorApp(dispositivos);
				break;
			case 6:
				System.out.println("=== Presupuesto de Garantia Extendida ===");
				presupuestoGarantia(dispositivos);
				break;
			case 7:
				System.out.println("=== Producto Top de Gama ===");
				productoTopGama(dispositivos);
				break;
			case 8:
				salir = true;
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}

	private static void registrarProducto(ArrayList<Dispositivo> dispositivos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipo = "";
		do {
			try {
				System.out.print("Introduce el tipo de dispositivo (Ordenador o Smartphone): ");
				tipo = leer.readLine();

				if (!tipo.equalsIgnoreCase("ordenador") && !tipo.equalsIgnoreCase("smartphone")) {
					System.out.println("El tipo no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipo.equalsIgnoreCase("ordenador") && !tipo.equalsIgnoreCase("smartphone"));

		if (tipo.equalsIgnoreCase("ordenador")) {
			Ordenador ordenador = new Ordenador();
			ordenador.pedirDatos(dispositivos);
			dispositivos.add(ordenador);
		} else {
			Smartphone smartphone = new Smartphone();
			smartphone.pedirDatos(dispositivos);
			dispositivos.add(smartphone);
		}

		System.out.println("Dispositivo registrado correctamente");
	}

	private static Dispositivo buscarDispositivoPorCodigo(ArrayList<Dispositivo> dispositivos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int codigo = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el codigo del dispositivo: ");
				codigo = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir numeros");
			}
		}

		for (Dispositivo dispositivo : dispositivos) {
			if (dispositivo.getCodigo() == codigo) {
				return dispositivo;
			}
		}

		System.out.println("No se ha encontrado el dispositivo");
		return null;
	}

	private static void añadirComponente(ArrayList<Dispositivo> dispositivos) {
		Dispositivo dispositivo = buscarDispositivoPorCodigo(dispositivos);

		if (dispositivo != null) {
			if (dispositivo instanceof Ordenador) {
				if (((Ordenador) dispositivo).añadirComponente()) {
					System.out.println("Componente añadido correctamente");
				}
			} else {
				System.out.println("El dispositivo no es un ordenador");
			}
		}
	}

	private static void instalarApp(ArrayList<Dispositivo> dispositivos) {
		Dispositivo dispositivo = buscarDispositivoPorCodigo(dispositivos);

		if (dispositivo != null) {
			if (dispositivo instanceof Smartphone) {
				if (((Smartphone) dispositivo).instalarApp()) {
					System.out.println("App instalada correctamente");
				}
			} else {
				System.out.println("El dispositivo no es un smartphone");
			}
		}
	}

	private static void filtrarOrdenadoresPorComponente(ArrayList<Dispositivo> dispositivos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String componente = "";

		try {
			System.out.print("Introduce el componente a buscar: ");
			componente = leer.readLine();
		} catch (IOException e) {
			System.err.println("Ha habido un error");
			return;
		}

		boolean enc = false;
		for (Dispositivo dispositivo : dispositivos) {
			if (dispositivo instanceof Ordenador) {
				if (((Ordenador) dispositivo).tieneComponente(componente)) {
					((Ordenador) dispositivo).mostrarDatos();
					enc = true;
				}
			}
		}

		if (!enc)
			System.out.println("No hay ordenadores con ese componente");
	}

	private static void filtrarSmartphonesPorApp(ArrayList<Dispositivo> dispositivos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String app = "";

		try {
			System.out.print("Introduce la app a buscar: ");
			app = leer.readLine();
		} catch (IOException e) {
			System.err.println("Ha habido un error");
			return;
		}

		boolean enc = false;
		for (Dispositivo dispositivo : dispositivos) {
			if (dispositivo instanceof Smartphone) {
				if (((Smartphone) dispositivo).tieneApp(app)) {
					((Smartphone) dispositivo).mostrarDatos();
					enc = true;
				}
			}
		}

		if (!enc)
			System.out.println("No hay smartphones con esa app");
	}

	private static void presupuestoGarantia(ArrayList<Dispositivo> dispositivos) {
		Dispositivo dispositivo = buscarDispositivoPorCodigo(dispositivos);

		if (dispositivo != null) {
			System.out.println("Presupuesto garantia extendida: " + dispositivo.calcularGarantiaExtendida());
		}
	}

	private static void productoTopGama(ArrayList<Dispositivo> dispositivos) {
		if (dispositivos.size() == 0) {
			System.out.println("No hay dispositivos registrados");
			return;
		}

		Dispositivo masCaro = dispositivos.get(0);
		for (Dispositivo dispositivo : dispositivos) {
			if (dispositivo.getPrecioBase() > masCaro.getPrecioBase()) {
				masCaro = dispositivo;
			}
		}

		System.out.println("=== Dispositivo mas caro ===");
		masCaro.mostrarDatos();
	}

}
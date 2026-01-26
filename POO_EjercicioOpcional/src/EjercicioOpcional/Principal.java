package EjercicioOpcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	private static void QuiénDaMás(Oferta[] postores) throws IOException {

		System.out.println("== ¿Quién da más?  ==");

		for (int i = 0; i < postores.length; i++) {
			System.out.println("-- Añadiendo oferta " + (i + 1) + "--");
			postores[i] = new Oferta();

			postores[i].añadirDatos(postores, i);

		}

	}

	private static void buscarPorNombre(Oferta[] postores) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean enc = false;
		System.out.println("Introduce nombre a buscar ");
		String nomBuscar = leer.readLine();
		for (Oferta postor : postores) {
			if (postor.getNombre().equalsIgnoreCase(nomBuscar)) {
				System.out.println("==POSTOR ENCONTRADO==");
				System.out.println(postor.toString());

				enc = true;
			}

		}

		if (enc == false) {
			System.out.println("Postor no encontrado");
		}

	}

	private static void mostrarDatos(Oferta[] postores) {
		for (Oferta postor : postores) {
			System.out.println(postor.toString());
		}
	}

	private static void congelandoPrecios(Oferta[] postores) {
		boolean enc = false;

		System.out.println("--RIDICULAS--");
		for (Oferta postor : postores) {
			if (postor.esOfertaRidicula()) {
				System.out.println(postor.toString());
				enc = true;
			}
		}
		if (!enc)
			System.out.println("Todas las ofertas son serias...Más o menos");

		System.out.println("--RESORT--");
		enc = false;
		for (Oferta postor : postores) {
			if (postor.isResort()) {
				System.out.println(postor.toString());
				enc = true;
			}
		}
		if (!enc)
			System.out.println("Ninguna tiene isResort");

	}

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		Oferta[] postores = new Oferta[3];

		boolean salir = false;
		do {
			System.out.println("== GESTIÓN DE OFERTAS POR GROENLANDIA  ==");
			System.out.println("1. ¿Quién da más? (Añadir oferta)");
			System.out.println("2  Nej tak (Mostrar todas las ofertas)");
			System.out.println("3. Congelando los precios (Filtros especiales) ");
			System.out.println("4. El interrogatorio del pingüino (Buscar por oferente)");
			System.out.println("5. Aranceles para todos (Salir)");
			System.out.println("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {

				try {
					opcion = Integer.parseInt(leer.readLine());
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir numeros");
				}

				datosOK = true;
			}

			switch (opcion) {
			case 1:
				System.out.println("===  AÑADIR NUEVA OFERTA  ===");
				QuiénDaMás(postores);
				break;
			case 2:
				System.out.println("===  TODAS LAS OFERTAS ===");
				mostrarDatos(postores);
				break;
			case 3:
				System.out.println("===  FILTROS OFERTAS RIDICULAS Y RESORT ===");
				congelandoPrecios(postores);
				break;
			case 4:
				System.out.println("===  BUSCAR POR NOMBRE  == ");
				buscarPorNombre(postores);
				break;
			case 5:
				// AQUI VA LA OPCION 5
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}
}
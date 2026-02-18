package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Deportista> deportistas  = new ArrayList<>();

		boolean salir = false;
		do {
			System.out.println("\n=== CLUB CALASANZ ===");
			System.out.println("1. Registrar Deportista");
			System.out.println("2. Añadir Torneo a Tenista");
			System.out.println("3. Mostrar todos los Deportistas");
			System.out.println("4. Buscar por Equipo");
			System.out.println("5. Ranking de Tenis");
			System.out.println("6.Estadísticas Globales");
			System.out.println("7. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:System.out.println("=== Registrar Deportista ===");registrarDeportista(deportistas);break;
			case 2:System.out.println("=== Añadir Torneo a Tenista ===");añadirTorneo(deportistas);break;
			case 3:System.out.println("===  Mostrar todos los Deportistas ===");mostrarDatos(deportistas);break;
			case 4:System.out.println("=== Buscar por Equipo ===");break;
			case 5:System.out.println("=== Ranking de Tenis ===");break;
			case 6:System.out.println("=== Estadísticas Globales ===");break;
			case 7:System.out.println("Salir");salir = true;break;
			default:System.out.println("Opción no válida");
			}

		} while (!salir);

	}

	private static void registrarDeportista(ArrayList<Deportista> deportistas) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOK = false;
		String tipoDeportista = "";
		while (!datosOK) {

			try {

				do {
					System.out.println("Introduce si quiere añadir un Futbolista o un Tenista");
					tipoDeportista = leer.readLine();
					if (!tipoDeportista.equalsIgnoreCase("futbolista") && !tipoDeportista.equalsIgnoreCase("tenista"))
						System.out.println("Tienes que introducir un tipo valido");
				} while (!tipoDeportista.equalsIgnoreCase("futbolista") && !tipoDeportista.equalsIgnoreCase("tenista"));

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
		
		if(tipoDeportista.equalsIgnoreCase("futbolista")) {
			Futbolista futbolista = new Futbolista();
			futbolista.pedirDatos(deportistas);
			deportistas.add(futbolista);
		}else {
			Tenista tenista = new Tenista();
			tenista.pedirDatos(deportistas);
			deportistas.add(tenista);
		}

	}
	
	private static void añadirTorneo(ArrayList<Deportista> deportistas) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int dniABuscar =-1;
		while(!datosOK) {
			try {
				do {
					System.out.println("Introduce dni a buscar: ");
					dniABuscar = Integer.parseInt(leer.readLine());
					if(dniABuscar < 0)
						System.out.println("el dni no puede ser negativo");
				}while(dniABuscar < 0);
				datosOK = true;
			} catch(IOException e) {
				System.out.println("Has introducido mal el dni");
				e.printStackTrace();
			}
		}
		boolean hallado = false;
		for(Deportista d: deportistas) {
			if(d.getDNI() == dniABuscar) {
				hallado = true;
				if(d instanceof Tenista) {
					((Tenista)d).añadirTorneo();
				}else {
					System.out.println("El deportista introducido no es un tenista");
				}
			}
		}
        if (!hallado) System.out.println("No se ha encontrado deportista con ese dni");
    }
	
	private static void mostrarDatos(ArrayList<Deportista> deportistas) throws IOException {
	}
}

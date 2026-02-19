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
			case 4:System.out.println("=== Buscar por Equipo ===");buscarPorEquipo(deportistas);break;			
			case 5:System.out.println("=== Ranking de Tenis ===");rankinTenis(deportistas);break;			
			case 6:System.out.println("=== Estadísticas Globales ===");mediaGoles(deportistas);break;
			case 7:System.out.println("Salir");salir = true;break;
			default:System.out.println("Opción no válida");
			}
		} while (!salir);
	}

	//Case 1
	private static void registrarDeportista(ArrayList<Deportista> deportistas) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOK = false;
		String tipoDeportista = "";
		while (!datosOK) {

			try {

				do {
					System.out.println("Introduce si quiere añador un Futbolista o un Tenista");
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
	
	//Case 2
	private static void añadirTorneo(ArrayList<Deportista> deportistas) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		boolean datosOK = false;
		int dniABuscar = 0;
		while (!datosOK) {

			try {
				do {
					System.out.print("Introduce dni a buscar: ");
					dniABuscar = Integer.parseInt(leer.readLine());
					if (dniABuscar < 0)
						System.out.println("el dni no puede ser negativa");
				} while (dniABuscar < 0);
			
				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal el dni");
				e.printStackTrace();
			}

		}
		
		boolean enc = false;
		for(Deportista d: deportistas) {
			if(d.getDNI() == dniABuscar) {
				enc = true;
				if(d instanceof Tenista) {
					((Tenista) d).añadirTorneo();
				}else {
					System.out.println("El deportista introducido no es un tenista");
				}
			}
		}
		
		if(!enc)
			System.out.println("No se ha encontrado deportista con tal dni");

		
	}
	
	//Case 3
	private static void mostrarDatos(ArrayList<Deportista> deportistas) {
		for(Deportista d: deportistas) {
			if(d instanceof Futbolista) {
				((Futbolista) d).mostrarDatos();
			}else {
				((Tenista) d).mostrarDatos();
			}
		}
		
	}
	
	//Case 4
	private static void buscarPorEquipo(ArrayList<Deportista> deportistas) {
	    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    String equipo = "";

	    try {
	        System.out.print("Introduce el nombre del equipo: ");
	        equipo = leer.readLine();
	    } catch (IOException e) {
	        System.out.println("Has introducido mal algún dato, crack");
	        e.printStackTrace();
	    }

	    boolean enc = false;
	    for (Deportista d : deportistas) {
	        if (d instanceof Futbolista) {
	            if (((Futbolista) d).getEquipo().equalsIgnoreCase(equipo)) {
	                ((Futbolista) d).mostrarDatos();
	                enc = true;
	            }
	        }
	    }

	    if (!enc)
	        System.out.println("No se ha encontrado ningún futbolista en ese equipo");
	}
	
	//Case 5
	private static void rankinTenis(ArrayList<Deportista> deportistas) throws NumberFormatException, IOException {
	    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    int ranking = 0;
	    
	    try {
	        System.out.print("Introduce el numero de tu ranking: ");
	        ranking = Integer.parseInt(leer.readLine());
	        if(ranking <= 0)
	        	System.out.println("El numero tiene que ser mayor de 0");
	    } catch (IOException e) {
	        System.out.println("Has introducido mal algún dato, crack");
	        e.printStackTrace();
	    }
	 
	    boolean enc = false;
	    for (Deportista d : deportistas) {
	    	if (d instanceof Tenista) {
	    		if (((Tenista)d).getPosicionRanking() <= ranking) {
	                ((Tenista)d).mostrarDatos();
	                enc = true;
	    		}
	    	}
	    }
	    if (!enc)
	        System.out.println("No se ha encontrado ningún tenista");
	}
	
	//Case 6
	private static void mediaGoles(ArrayList<Deportista> deportistas) {
		double numTotalGoles = 0;
		double numFutbolistas = 0;
		for(Deportista d: deportistas) {
			if(d instanceof Futbolista) {
				numTotalGoles += ((Futbolista) d).getNumGoles();
				numFutbolistas++;
			}
		}
		System.out.println("La media de goles es: " + (numTotalGoles/numFutbolistas));
	}
}

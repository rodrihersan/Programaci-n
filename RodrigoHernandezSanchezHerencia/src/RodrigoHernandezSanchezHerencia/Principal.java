package RodrigoHernandezSanchezHerencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        
        boolean salir = false;
        do {
            System.out.println("=== BASE DE DATOS SHIELD ===");
            System.out.println("1. ¡Vengadores, reuníos! (Registrar Personaje)");
			System.out.println("2. Yo soy Iron Man (Filtrar Héroes por Identidad Secreta)");
			System.out.println("3. Misión 616 (Enfrentamiento)");
			System.out.println("4. HYDRA (Salir)");
			System.out.print("Introduce una opción: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Solo puedes introducir numeros");
                }
            }

            switch (opcion) {
			case 1:
				System.out.println("=== REGISTRAR PERSONAJE  ===");
				añadirPersonaje(personajes);
				break;
			case 2:
				System.out.println("=== HÉROES CON IDENTIDAD SECRETA  ===");
				mostrarHeroes(personajes);
				break;
			case 3:
				System.out.println("=== BATALLA ÉPICA  ===");
				// AQUÍ VA LA OPCIÓN 3
				// CREA UN MÉTODO
				break;
			case 4:
				System.out.println("¡HYDRA se ha infiltrado en el sistema! ");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
        } while (!salir);
    }
	
	
	
	private static void añadirPersonaje(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String bando = "";
        int cantidad = 0;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("¿Cuantos personajes desea añadir?: ");
                cantidad = Integer.parseInt(leer.readLine());
                datosOK = true;
                
                do {
                    System.out.print("Introduce el bando (heroe/villano): ");
                    bando = leer.readLine();
                    if (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"))
                        System.out.println("Tiene que ser heroe o villano");
                } while (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"));

            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Añadiendo personaje " + (i + 1) + " de " + cantidad);
            String tipo = "";
            do {
                try {
                    System.out.print("Tipo de personaje (Heroe o Villano): ");
                    tipo = leer.readLine();
                    if (!tipo.equalsIgnoreCase("heroe") && !tipo.equalsIgnoreCase("villano"))
                        System.out.println("Tiene que ser Heroe o Villano");
                } catch (IOException e) {
                    System.out.println("Error leyendo datos");
                }
            } while (!tipo.equalsIgnoreCase("heroe") && !tipo.equalsIgnoreCase("villano"));

            if (tipo.equalsIgnoreCase("heroe")) {
                Heroe h = new Heroe();
                h.pedirDatos(personajes);
                personajes.add(h);
            } else {
                Villano v = new Villano();
                v.pedirDatos(personajes);
                personajes.add(v);
            }
        }
    }
	
	private static void mostrarHeroes(ArrayList<Personaje> personajes) {
		boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                personajes.get(i).mostrarDatos();
                enc = true;
            }
        }
        if (!enc)
            System.out.println("No hay heroes registrados");
    }
	
	
}


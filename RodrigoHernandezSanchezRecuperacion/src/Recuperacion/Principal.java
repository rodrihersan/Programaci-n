package Recuperacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		ArrayList<Viaje> viajes = new ArrayList<Viaje>();

		boolean salir = false;
		do {
			System.out.println("=== VIAJE DE FIN DE CURSO ===");
			System.out.println("--- BLOQUE B: HERENCIA ---");
			System.out.println("3. Nueva propuesta");
			System.out.println("4. ¿Nos llega el dinero?");
			System.out.println("7. Salir");

			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 7);

			switch (opcion) {
			case 3:System.out.println("=== NUEVA PROPUESTA ===");nuevaPropuesta(viajes);break;
			case 4:System.out.println("=== ¿NOS LLEGA EL DINERO? ===");viajesInternacionalesAsequibles(viajes);break;
			case 7:System.out.println("Saliendo del programa. ¡Hasta pronto!");salir = true;break;
			}
		} while (!salir);
	}
	
	public static void nuevaPropuesta(ArrayList<Viaje> viajes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoViaje = "";
		do {
			try {
				System.out.print("Introduce el tipo de viaje (Nacional o Internacional): ");
				tipoViaje = leer.readLine();

				if (!tipoViaje.equalsIgnoreCase("Nacional") && !tipoViaje.equalsIgnoreCase("Internacional")) {
					System.err.println("El tipo de viaje no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoViaje.equalsIgnoreCase("Nacional") && !tipoViaje.equalsIgnoreCase("Internacional"));
		
		int id = 1;
		if (viajes.size() > 0)
			id = viajes.getLast().getId() + 1;
			
		if (tipoViaje.equalsIgnoreCase("Nacional")) {
			ViajeNacional vn = new ViajeNacional();
			vn.pedirDatos(viajes);
			viajes.add(vn);
		} else {
			ViajeInternacional vi = new ViajeInternacional();
			vi.pedirDatos(viajes);
			viajes.add(vi);
		}
	}
	
	public static void viajesInternacionalesAsequibles(ArrayList<Viaje> viajes) throws NumberFormatException, IOException {
		boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce tu presupuesto: ");
                double presupuesto = Double.parseDouble(leer.readLine());

                boolean hayAlguno = false;
                for (Viaje v : viajes) {
                    if (v instanceof ViajeInternacional) {
                        if (((ViajeInternacional) v).getCosteTotal() <= presupuesto) {
                            ((ViajeInternacional) v).mostrarDatos();
                            hayAlguno = true;
                        }
                    }
                }

                if (!hayAlguno)
                    System.out.println("No hay viajes internacionales dentro de tu presupuesto. (pobre :P)");

                datosOK = true;
            } catch (IOException e) {
                System.out.println("Has introducido mal algún dato");
                e.printStackTrace();
            }
        }
	}
}
package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		boolean salir = false;
		do {
			System.out.println("\n=== FICHEROS ALUMNOS ===");
			System.out.println("1. Generar fichero granjero");
			System.out.println("2. Calcular factura");
			System.out.println("3.Generar otro fichero");
			System.out.println("4. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}
			
			switch (opcion) {
			case 1:
				System.out.println("=== AÑADIR UN ALUMNO NUEVO ===");
				generarFichero();
				break;
			case 2:
				System.out.println("=== CALCULAR MEDIA ===");
				calcularFactura();
				break;
			
			case 3: 
				System.out.println("");
			case 4:
				System.out.println("Salir");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
			
		}while(!salir);
}
	
	private static void generarFichero() {
		Granjero g = new Granjero();
		g.pedirDatos();
		g.escribirFichero();
	}
	
	private static void calcularFactura() {
		String [] tipos = {"Malas Hierbas", "Langostas", "Gusanos", "Todo"};
		double[] precios = {18, 36, 54, 90};
		double [] totales = new double[4];
		
		File f = new File("./granjeros.txt");
		
		if(!f.exists()) {
			System.out.println("No existe el fichero");
		}else {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			Sting linea = br.readLine();
			
			while(linea != null) {
				String v[];
				
				v = linea.split(": ");
				String nombre = v[1];
				
				
			}
		}
	}
}
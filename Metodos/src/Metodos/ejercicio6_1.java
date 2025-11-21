package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6_1 {
	

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		System.out.println("=== BIENVENIDO A CALCULADORA DE ENTRADAS DE CINE  ===");
		do {
			// MOSTRAR MENU
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1.Calcular precio según edad");
			System.out.println("2.  Calcular precio con descuento de miércoles (50%)");
			System.out.println("3. Calcular precio con combo palomitas + refresco (+5€)");
			System.out.println("4. Calcular precio para grupo de personas");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			int opcion = leerInt();
			switch (opcion) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				salir = true;
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);
	}
		

		public static int leerInt() throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(leer.readLine());
			return num;
		}
}
	
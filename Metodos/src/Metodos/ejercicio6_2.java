package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6_2 {

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
				opcion1();
				break;
			case 2:
				opcion2();
				break;
			case 3:
				opcion3();
				break;
			case 4:
				opcion4();
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
	
	
	public static void opcion1() throws NumberFormatException, IOException {
		System.out.println("Opcion 1");
		System.out.println("¿Cual es tu edad");
		int edad = leerInt();
		double precio = precioEntradaSegunEdad(edad);
		System.out.println("El precio es " + precio);
	}
	
	public static void opcion2() throws NumberFormatException, IOException {
		System.out.println("Opcion 2");
		System.out.println("Introduce el precio normal de la entrada:");
		double precioEntradaNormal = leerDouble();
		double precioFinalConDescuento = precioEntradaNormal - (precioEntradaNormal *0.50);
		System.out.println("Precio final: " + precioFinalConDescuento);
	}

	public static void opcion3() throws NumberFormatException, IOException {
		System.out.println("Opcion 3");
		System.out.println("Introduce el precio normal de la entrada:");
		double precioEntrada = leerDouble();
		double precioCombo = precioEntrada + 5.0;
		System.out.println("Precio combo: " + precioCombo);
	}
	
	public static void opcion4() throws NumberFormatException, IOException {
		System.out.println("Opcion 4");
		System.out.println("Cuantas personas sois: ");
		int numPersonas = leerInt();
		double totalPrecio = 0;
		for(int i = 0; i<numPersonas; i++) {
			System.out.println("Edad persona "+ (i+1) + " :");
			int edadPersona = leerInt();
			int precio = precioEntradaSegunEdad(edadPersona);
			totalPrecio = totalPrecio + precio;	
		}
		System.out.println("Precio final: " + totalPrecio);
	}
	
	public static int precioEntradaSegunEdad(int edad) {
		if(edad < 18) {
			return 5;
		}else if(edad >= 18 && edad <= 65) {
			return 8;
		}else {
			return 6;
		}
	}
	
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	public static Double leerDouble() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double num = Double.parseDouble(leer.readLine());
		return num;
	}
}
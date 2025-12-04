package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio39 {
	public static int leerInt() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un número válido: ");
			}
		}
		return num;
	}
	
//--------------------	
	public static int leerIntPositivo() throws IOException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El número no puede ser negativo. Intentalo de nuevo: ");
	        numero = leerInt();
	    }
	    return numero;
	}
	
//--------------------
	public static double leerDouble() throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double numero =0;
		boolean valido=false;
		
		while(!valido) {
			try {
				numero = Double.parseDouble(leer.readLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.err.print("ERROR. ");
	            System.out.println("Introduce un número válido");
	        }
	    }
	    return numero;
		}

//--------------------		
	public static double leerDoublePositivo() throws IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un número negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
        }
        return numero;
    }
	
//--------------------			
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	        // comprobamos si no es letra mayúscula ni minúscula
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false; // encontramos un carácter no permitido
	        }
	    }
	    return true; // todos los caracteres son letras
	}
	
//----------	
	public static String leerLinea() throws IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    String texto;

	    do {
	        texto = leer.readLine().trim(); // quitamos espacios al inicio y al final

	        if (texto.length() == 0) {
	            System.err.println("Debes escribir algo.");
	            System.out.print("Inténtalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        if (!esTextoValido(texto)) {
	            System.err.println("El nombre solo puede contener letras, sin números ni símbolos ni espacios en blanco.");
	            System.out.print("Inténtalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        break; // si pasa todas las comprobaciones, salimos del bucle

	    } while (true);

	    return texto;
	}

	public static void main(String[] args)throws NumberFormatException, IOException{
		int[][] ventas = new int[4][7]; // 4 productos, 7 días
        int opcion;
        boolean salir = false;
        
        do {
            System.out.println("\n--- MENU GESTIÓN DE VENTAS ---");
            System.out.println("1. Introducir ventas");
            System.out.println("2. Mostrar tabla completa");
            System.out.println("3. Ventas totales por producto");
            System.out.println("4. Ventas totales por día");
            System.out.println("5. Producto más vendido");
            System.out.println("6. Día con más ventas");
            System.out.println("7. Promedio de ventas por día");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = leerIntPositivo();

            switch (opcion) {

            case 1:introducirVentas(ventas);break;
            case 2:mostrarTabla(ventas);break;
            case 3:ventasPorProducto(ventas);break;
            case 4:ventasPorDia(ventas);break;
            case 5:productoMasVendido(ventas);break;
            case 6:diaMasVentas(ventas);break;
            case 7:promedioDiario(ventas);break;
            case 8:salir = true;System.out.println("¡Hasta luego!");break;
            default:System.err.println("Opción inválida.");
            }
            
        } while(!salir);
    }

	//Case1
	public static void introducirVentas(int[][] ventas) throws IOException{

        System.out.println("\nIntroduce ventas (solo números positivos):");

        for (int p = 0; p < 4; p++) {
            System.out.println("\nProducto " + (p + 1) + ":");

            for (int d = 0; d < 7; d++) {
                System.out.print("  Día " + (d + 1) + ": ");
                ventas[p][d] = leerIntPositivo();
            }
        }
        System.out.println("\nVentas registradas correctamente.");
}
	
	//case2
	public static void mostrarTabla(int[][] ventas) {

        System.out.println("\n--- TABLA DE VENTAS ---");

        for (int p = 0; p < 4; p++) {
            System.out.print("Producto " + (p + 1) + ": ");

            for (int d = 0; d < 7; d++)
                System.out.print(ventas[p][d] + " ");

            System.out.println();
        }
    }
	
	//case3
	public static void ventasPorProducto(int[][] ventas) {

        System.out.println("\n--- VENTAS TOTALES POR PRODUCTO ---");

        for (int p = 0; p < 4; p++) {

            int suma = 0;
            for (int d = 0; d < 7; d++)
                suma += ventas[p][d];

            System.out.println("Producto " + (p + 1) + ": " + suma);
        }
    }
	
	//Case4
	public static void ventasPorDia(int[][] ventas) {

        System.out.println("\n--- VENTAS TOTALES POR DÍA ---");

        for (int d = 0; d < 7; d++) {

            int suma = 0;
            for (int p = 0; p < 4; p++)
                suma += ventas[p][d];

            System.out.println("Día " + (d + 1) + ": " + suma);
        }
    }
	
	//Case5
	public static void productoMasVendido(int[][] ventas) {

        int mejorProducto = 0;
        int maxVentas = -1;

        for (int p = 0; p < 4; p++) {

            int suma = 0;
            for (int d = 0; d < 7; d++)
                suma += ventas[p][d];

            if (suma > maxVentas) {
                maxVentas = suma;
                mejorProducto = p;
            }
        }

        System.out.println("\nProducto más vendido: Producto " + (mejorProducto + 1) +
                           " con " + maxVentas + " ventas.");
    }
	
	//Case6
	public static void diaMasVentas(int[][] ventas) {

        int mejorDia = 0;
        int maxVentas = -1;

        for (int d = 0; d < 7; d++) {

            int suma = 0;
            for (int p = 0; p < 4; p++)
                suma += ventas[p][d];

            if (suma > maxVentas) {
                maxVentas = suma;
                mejorDia = d;
            }
        }

        System.out.println("\nDía con más ventas: Día " + (mejorDia + 1) +
                           " con " + maxVentas + " ventas.");
    }
	
	//case7
	public static void promedioDiario(int[][] ventas) {

        System.out.println("\n--- PROMEDIO DE VENTAS POR DÍA ---");

        for (int d = 0; d < 7; d++) {

            int suma = 0;
            for (int p = 0; p < 4; p++)
                suma += ventas[p][d];

            double promedio = suma / 4.0;

            System.out.println("Día " + (d + 1) + ": " + promedio);
        }
    }
}





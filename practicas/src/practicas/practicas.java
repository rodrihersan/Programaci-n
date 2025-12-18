package practicas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class practicas {
	
	public static double leerDouble() throws NumberFormatException, IOException{
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
	public static double leerDoublePositivo() throws NumberFormatException, IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un número negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
        }
        return numero;
    }
	
	public static int leerInt() throws NumberFormatException, IOException {
		 
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		
		do {
		System.out.println("=== BIENVENIDO A GESTIÓN DE VENTAS ===");
		System.out.println();
		System.out.println("--- MENÚ PRINCIPAL ---");
		System.out.println("1.Calcular IVA (21%) de un producto");
		System.out.println("2.Calcular descuento por comprar más de 3 figuras (10%)");
		System.out.println("3.Calcular cuánto falta para envío gratis (50€)");
		System.out.println("4.Mostrar tabla de precios (1-10 unidades)");
		System.out.println("5.Salir");
		System.out.println();
		System.out.println("Elige una opción (pon el número): ");
		int opcion = leerInt();
		
		switch (opcion) {
		case 1: opcion1(); break;
        //case 2: opcion2(equipos); break;
        //case 3: opcion3(equipos); break;
        case 4: opcion4(); break;
        case 5: salir = true; System.out.println("Saliendo..."); break;
        default: System.out.println("Opción no válida");
		}
	} while (!salir);
}
	
	//Case1
	public static void opcion1() throws NumberFormatException, IOException {
	System.out.println("=== CALCULAR IVA ===");
	System.out.println("Introduce el precio del producto: ");
	double precioProducto = leerDoublePositivo();
	System.out.println("Precio sin IVA: " + precioProducto);
	
	double ivaProducto = (precioProducto * 0.21);
	System.out.println("El IVA del producto es: " + ivaProducto);
	
	System.out.println("Precio con IVA: " + (precioProducto + ivaProducto));
}
	
	//Case2
	public static void opcion4() throws NumberFormatException, IOException {
	System.out.println("=== TABLA DE PRECIOS ===");
	System.out.println("Introduce el precio del producto: ");
	double precioProducto = leerDoublePositivo();
	
	System.out.println("--- Tabla de precios (sin IVA) ---");
	for(int i=0; i<11;i++) {
		System.out.println(i + " unidades: " + (precioProducto*i) + "(CON IVA: "+ 
		((precioProducto*i) +(precioProducto * 0.21)) + ")");
	}
	
	
	
	}
}


package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Factura> facturas = new ArrayList<>();
	static int contadorFacturas = 0;
	
	public static String leerLinea() throws IOException {
			
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		    String texto;
	
		    do {
		        texto = leer.readLine().trim();
	
		        if (texto.length() == 0) {
		            System.err.println("Debes escribir algo.");
		            System.out.print("Inténtalo de nuevo: ");
		            continue;
		        }
	
		        if (!esTextoValido(texto)) {
		            System.err.println("El nombre solo puede contener letras, sin números ni símbolos ni espacios en blanco.");
		            System.out.print("Inténtalo de nuevo: ");
		            continue;
		        }
		        break;
		    } while (true);
		    return texto;
		}
	
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	       
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false;
	        }
	    }
	    return true;
	}

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		char opcion;

		do {
			System.out.println("== MENÚ CONTABLE ==");
			System.out.println("A. Crear factura");
			System.out.println("B. Añadir concepto");
			System.out.println("C. Ver desglose");
			System.out.println("D. Calcular total");
			System.out.println("E. Factura más alta");
			System.out.println("F. Resumen contable");
			System.out.println("G. Ver todas las facturas");
			System.out.println("H. Salir");
			
			System.out.print("Selecciona una opción: ");
            opcion = leerLinea().toUpperCase().charAt(0);

			switch (opcion) {
				case 'A':registrarFactura(); break;
				case 'B':añadirConcepto();break;
				case 'C':verDesglose();break;
				case 'D':verTotal();break;
				case 'E':facturaMasAlta();break;
				case 'F':resumenContable();break;
				case 'G':verTodasLasFacturas(); break;
				case 'H':salir = true;System.out.print("SALIENDO");break;
			}
		} while (!salir);
	}
	
	private static void registrarFactura() {
		//ponemos <10 porque lo pide el ejercicio
		if (facturas.size() < 10) {
			Factura nuevaFactura = new Factura();
			nuevaFactura.pedirDatos(facturas.size() + 1);
			facturas.add(nuevaFactura);
			contadorFacturas++;
		} else {
			System.out.println("No caben más facturas.");
		}
	}
	
	private static void añadirConcepto() {
		int num = pedirInt("Introduce nº factura: ");
		for (Factura f : facturas) { 
			if (f != null && f.getNumero() == num) {
				f.añadirConcepto();
				return;
			}
		}
		System.out.println("Factura no encontrada.");
	}

	private static void verTotal() {
		int num = pedirInt("Introduce nº factura: ");
		for (Factura f : facturas) {
			if (f != null && f.getNumero() == num) {
				f.mostrarDesglose();
				return;
			}
		}
		System.out.println("Factura no encontrada.");
	}
	

	private static void verDesglose() {
		int num = pedirInt("Introduce nº factura: ");
		for (Factura f : facturas) {
			if (f != null && f.getNumero() == num) {
				System.out.println("El desglose de la factura " + num + " es: ");
				System.out.println( "            - " + f.totalSinIVA() + " € precio base");
				System.out.println( "            - " + f.totalSinIVA()*0.21 + " € precio del IVA sobre el precio base");
				System.out.println( "            - " + f.totalConIVA()+ " € precio total");
				return;
			}else {
				System.out.println("Factura no encontrada.");
			}
		}
	}

	private static void facturaMasAlta() {
		double max = -1;
		Factura fMasAlta = null;
		for (Factura f : facturas) {
			if (f != null && f.totalConIVA() > max) {
				max = f.totalConIVA();
				fMasAlta = f;
			}
		}
		if (fMasAlta != null) {
			System.out.println("La factura con mayor importe total es de: " + max + "€");
			fMasAlta.mostrarDesglose();
		}
	}

	private static void resumenContable() {
		double totalEmpresa = 0;
		for (Factura f : facturas) {
			if (f != null) {
				totalEmpresa += f.totalConIVA();
			}
		}
		System.out.println("Suma total de todas las facturas emitidas: " + totalEmpresa + "€");
	}

	private static int pedirInt(String m) {
		try {
			System.out.print(m);
			return Integer.parseInt(LEER.readLine());
		} catch (Exception e) {
			return -1;
		}
	}
	private static void verTodasLasFacturas() {
	    if (facturas.isEmpty()) {
	        System.out.println("No hay facturas registradas.");
	    } else {
	    	System.out.println(" --------------------------------------");
	        System.out.println("|   LISTADO DE TODAS LAS FACTURAS     |");
	        System.out.println(" --------------------------------------");
	        // Usamos el bucle for-each que ya usas en tus otros métodos
	        for (Factura f : facturas) {
	            // f no será null porque el ArrayList no tiene huecos vacíos
	            f.mostrarDesglose(); 
	            System.out.println("Total con IVA: " + f.totalConIVA() + "€");
	            System.out.println("------------------------------------");
	        }
	    }
	}
}

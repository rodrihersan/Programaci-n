package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
	static Factura[] facturas = new Factura[10]; // Array fijo de 10 objetos
	static int contadorFacturas = 0;
	
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
			System.out.println("G. Salir");
			
			System.out.print("Selecciona una opción: ");
            opcion = leerLinea().toUpperCase().charAt(0);

			switch (opcion) {
				case 'A':registrarFactura(); break;
				case 'B':añadirConcepto();break;
				case 'C':verDesglose();break;
				case 'D':verTotal();break;
				case 'E':facturaMasAlta();break;
				case 'F':resumenContable();break;
				case 'G':salir = true;System.out.print("SALIENDO");break;
			}
		} while (!salir);
	}
	
	private static void registrarFactura() {
		if (contadorFacturas < 10) {
			facturas[contadorFacturas] = new Factura();
			facturas[contadorFacturas].pedirDatos(contadorFacturas + 1);
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

	private static void verDesglose() {
		int num = pedirInt("Introduce nº factura: ");
		for (Factura f : facturas) {
			if (f != null && f.getNumero() == num) {
				f.mostrarDesglose();
				return;
			}
		}
		System.out.println("Factura no encontrada.");
	}

	private static void verTotal() {
		int num = pedirInt("Introduce nº factura: ");
		for (Factura f : facturas) {
			if (f != null && f.getNumero() == num) {
				System.out.println("El total de la factura " + num + " es: " + f.calcularTotalFinal() + "€");
				return;
			}
		}
		System.out.println("Factura no encontrada.");
	}

	private static void facturaMasAlta() {
		double max = -1;
		Factura fMasAlta = null;
		for (Factura f : facturas) {
			if (f != null && f.calcularTotalFinal() > max) {
				max = f.calcularTotalFinal();
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
				totalEmpresa += f.calcularTotalFinal();
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
	
	private static char pedirChar(String letra) {
		try {
			System.out.print(letra);
			String entrada = LEER.readLine();
			if (entrada.length() > 0) {
				return entrada.charAt(0); // Cogemos la primera letra
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ' ';
	}
}

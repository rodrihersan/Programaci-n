package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		ArrayList<Factura> facturas = new ArrayList<Factura>();

		boolean salir = false;

		do {
			System.out.println("\n== GESTION FACTURAS ==");
			System.out.println("1.Registrar factura");
			System.out.println("2.Añadir concepto");
			System.out.println("3. Ver desglose");
			System.out.println("4. Calcular total");
			System.out.println("5. Factura más alta");
			System.out.println("6. Resumen Contable");
			System.out.println("7. Salir");
			System.out.println("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(LEER.readLine());
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				datosOK = true;
			}

			switch (opcion) {
			case 1:
				crearFactura(facturas);
				break;
			case 2:
				añadirConcepto(facturas);
				break;
			case 3:
				verDesglose(facturas);
				break;
			case 4:
				mostrarTotal(facturas);
				break;
			case 5:
				facturaMasAlta(facturas);
				break;
			case 6:
				resumenContable(facturas);
				break;
			case 7:
				System.out.println("Saliendo...");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}



	


	private static void crearFactura(ArrayList<Factura> facturas) throws IOException {
		System.out.println("--AÑADIR FACTURA--");
		System.out.print("Introduce el nombre del cliente: ");
		String nombreCliente = LEER.readLine();
		int id = 1;
		if (facturas.size() > 0) {
			id = facturas.getLast().getId() + 1;
		}

		facturas.add(new Factura(id, nombreCliente));
		System.out.println("Cliente añadido con id: " + id);

	}

	private static Factura buscarFactura(ArrayList<Factura> facturas) {
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduzca un ID de factura a buscar: ");
				idABuscar = Integer.parseInt(LEER.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			datosOK = true;
		}

		for (Factura factura : facturas) {
			if (factura.getId() == idABuscar) {
				return factura;
			}
		}
		return null;

	}

	private static void añadirConcepto(ArrayList<Factura> facturas) {
		System.out.println("--AÑADIR CONCEPTO DE UNA FACTURA--");
		Factura factura = buscarFactura(facturas);
		if (factura != null)
			factura.añadirConcepto();
		else
			System.out.println("No se ha encontrado la factura");
	}

	private static void verDesglose(ArrayList<Factura> facturas) {
		System.out.println("--VER DESGLOSE DE  UNA FACTURA--");
		Factura factura = buscarFactura(facturas);
		if (factura != null)
			factura.mostrarDesgloseCompleto();
		else
			System.out.println("No se ha encontrado la factura");
	}

	

	private static void mostrarTotal(ArrayList<Factura> facturas) {
		System.out.println("--MOSTRAR TOTAL DE UNA FACTURA--");
		Factura factura = buscarFactura(facturas);
		if (factura != null)
			System.out.println(
					"La factura con ID " + factura.getId() +
					" tiene como total " + factura.calcularTotalFinal() + "€");

		else
			System.out.println("No se ha encontrado la factura");
	}
	
	
	private static void facturaMasAlta(ArrayList<Factura> facturas) {
		Factura facturaAlta = null;
		double importeTotalMasAlto = -1;
		
		for(Factura fact:facturas) {
			if(fact.calcularTotalFinal() > importeTotalMasAlto)
				importeTotalMasAlto =  fact.calcularTotalFinal();
			    facturaAlta = fact;
		}
		
		if(facturaAlta != null) {
			System.out.println("--IMPRIMIENDO DATOS DE LA FACTURA MÁS ALTA:--");
			facturaAlta.mostrarDesgloseCompleto();
		}else {
			System.out.println("No ha facturas para detemrinar la más alta");
		}
		
	}
	
	private static void resumenContable(ArrayList<Factura> facturas) {
		System.out.println("--RESUMEN CONTABLE--");
		for(Factura fact:facturas) {
			System.out.println("-- CLIENTE: " + fact.getCliente() +
							" - " + fact.calcularTotalFinal() + "€");
		}
	}


}
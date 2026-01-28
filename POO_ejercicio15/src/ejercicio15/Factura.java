package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Factura {
	private int numero;
	private String cliente;
	private String[] conceptos = new String[10];
	private double[] importes = new double[10];
	private int numConceptos;
	private final double IVA = 0.21;
	
	public void pedirDatos(int siguienteNumero) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.numero = siguienteNumero; // Secuencial automático
		
		try {
			System.out.println("Introduce el nombre del cliente: ");
			cliente = leer.readLine();
			numConceptos = 0;
			System.out.println("Factura nº " + numero + " creada para: " + cliente);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void añadirConcepto() {
		// Validamos que el array de 10 no esté lleno
		if (numConceptos >= 10) {
			System.out.println("Error: La factura ya tiene los 10 conceptos máximos.");
			return;
		}else {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Nombre del concepto:");
			conceptos[numConceptos] = leer.readLine();
			
			System.out.println("Importe de " + conceptos[numConceptos] + ":");
			importes[numConceptos] = Double.parseDouble(leer.readLine());

			numConceptos++; // Incrementamos el contador de elementos llenos
			System.out.println("Concepto añadido.");
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error en los datos.");
		}
		}
	}
	
	public double calcularSubtotal() {
		double subtotal = 0;
		for (int i = 0; i < numConceptos; i++) {
			subtotal += importes[i];
		}
		return subtotal;
	}

	public double calcularIVA() {
		return calcularSubtotal() * IVA;
	}

	public double calcularTotalFinal() {
		return calcularSubtotal() + calcularIVA();
	}

	public void mostrarDesglose() {
		System.out.println("--- DESGLOSE FACTURA Nº " + numero + " ---");
		System.out.println("Cliente: " + cliente);
		for (int i = 0; i < numConceptos; i++) {
			System.out.println("- " + conceptos[i] + ": " + importes[i] + "€");
		}
		System.out.println("Subtotal: " + calcularSubtotal() + "€");
		System.out.println("IVA (21%): " + calcularIVA() + "€");
		System.out.println("TOTAL: " + calcularTotalFinal() + "€");
	}

	public int getNumero() {
		return numero;
	}
}
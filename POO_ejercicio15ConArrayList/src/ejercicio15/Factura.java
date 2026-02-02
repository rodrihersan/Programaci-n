package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factura {
	private int id;
	private String cliente;
	private String[] conceptos = new String[10];
	private double[] importes = new double[10];
	private int numConceptos;
	private final double IVA = 0.21;
	
	
	public Factura(int id, String cliente) {
		this.id = id;
		this.cliente = cliente;
	}

	public void añadirConcepto() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numConceptos < conceptos.length) {
			boolean datosOk = false;
			do {
			try {
				System.out.print("Introduce el concepto a añadir: ");
				conceptos[numConceptos] = leer.readLine();
				System.out.print("Introduce el importe a añadir: ");
				importes[numConceptos] = Double.parseDouble(leer.readLine());
				numConceptos++;
				datosOk=true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algun dato mal");
			}
			}while(datosOk == false);

		} else {
			System.out.println("No se pueden añadir más conceptos");
		}
	}
	
	private double calcularSubtotal() {
		double subtotal = 0;
		if (numConceptos < conceptos.length) {
			for(double importe:importes) {
				subtotal = subtotal+importe;
			}
		}
	
		return subtotal;
	}
	
	private double calcularIva() {
		return calcularSubtotal() * IVA;
		
	}
	
	public double calcularTotalFinal() {
		return calcularSubtotal() + calcularIva();
		
	}
	
	public void mostrarDesgloseCompleto() {
		System.out.println("---- MOSTRANDO FACTURA " + id + " ----");
		System.out.println("Cliente: " + cliente);
		System.out.println("------------");
		
		for(int i=0; i<numConceptos; i++) {
			System.out.println("\t-" + conceptos[i] + ": " + importes[i] + "€");
		}
		
		System.out.println("------------");
		System.out.println("Total: " + calcularTotalFinal() + "€");
		
		
		
	}

	public int getId() {
		return id;
	}

	public String getCliente() {
		return cliente;
	}
	
	
	
	


}
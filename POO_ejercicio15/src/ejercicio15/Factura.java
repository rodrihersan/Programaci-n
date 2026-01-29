package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Factura {
	private int numero; // número de factura
    private String cliente;
    private String[] conceptos = new String[10]; // máximo 10 conceptos
    private double[] precios = new double[10];
    private int numConceptos = 0; // contador de conceptos añadidos
    
    public void pedirDatos(int numeroFactura) {
        this.numero = numeroFactura; // número automático

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Introduce el nombre del cliente: ");
            cliente = leer.readLine();
            System.out.println("Factura nº " + numero + " creada para: " + cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumero() {
        return numero;
    }

    public void añadirConcepto() {
        if (numConceptos >= conceptos.length) {
            System.out.println("No se pueden añadir más conceptos.");
            return;
        }

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Introduce el concepto: ");
            conceptos[numConceptos] = leer.readLine();
            System.out.print("Introduce el precio: ");
            precios[numConceptos] = Double.parseDouble(leer.readLine());
            numConceptos++;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al añadir concepto.");
        }
    }

    public void mostrarDesglose() {
        System.out.println("Factura nº " + numero + " - Cliente: " + cliente);
        for (int i = 0; i < numConceptos; i++) {
            System.out.println(conceptos[i] + ": " + precios[i] + "€");
        }
    }

    public double calcularTotalFinal() {
        double total = 0;
        for (int i = 0; i < numConceptos; i++) {
            total += precios[i];
        }
        return total;
    }

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
}
package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factura {
	private int numero;
    private String cliente;
    private String[] conceptos = new String[10];
    private double[] precios = new double[10];
    private int numConceptos = 0;
    private double IVA = 0.21;
    
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
            System.out.println(conceptos[i] + ": " + (precios[i]+precios[i]*0.21));
        }
    }

    public double totalSinIVA() {
        double total = 0;
        for (int i = 0; i < numConceptos; i++) {
            total += precios[i];
        }
        return total;
    }
    
    public double totalConIVA() {
        double total = 0;
        for (int i = 0; i < numConceptos; i++) {
            total += precios[i];
        }
        return total+total*IVA;
    }
}

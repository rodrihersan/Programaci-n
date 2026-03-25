package Recuperacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Viaje {
	private int id;
	private String destino;
	private String transporte;
	private int duracionDias;
	private double precio;
	private int numPersonas;
	private String[] propuestas = new String[4];
	private int numPropuestas;
	
	protected void pedirDatos(ArrayList<Viaje> viajes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		while (!datosOK) {
			try {
				this.id = id;
				System.out.print("Propuesta " + this.id + ":");
				this.destino = Lecturas.leerString("Introduce el destino: ");
				
				do {
					System.out.println("Introduce el transporte (Tren / Autobus / Avion / Coche: ");
					transporte = leer.readLine();
					if (!transporte.equalsIgnoreCase("Tren") && !transporte.equalsIgnoreCase("Autobus") 
							&& !transporte.equalsIgnoreCase("Coche") && !transporte.equalsIgnoreCase("Avion") )
						System.out.println("Tienes que introducir un tipo valido");
				} while (!transporte.equalsIgnoreCase("Tren") && !transporte.equalsIgnoreCase("Autobus") 
						&& !transporte.equalsIgnoreCase("Coche") && !transporte.equalsIgnoreCase("Avion"));
				
				do {
					System.out.println("Introduce los dias de estancia: ");
					this.duracionDias = Integer.parseInt(leer.readLine());
					if (duracionDias <= 0)
						System.err.println("los dias tienen que ser mayores que cero");
				} while (duracionDias <= 0);
				
				do {
					this.precio = Lecturas.leerDouble("Introduce el precio por persona: ");
					if (precio <= 0)
						System.err.println("El precio tienen que ser mayor que cero");
				} while (precio <= 0);
				
				do {
					System.out.println("Introduce el numero de personas: ");
					this.numPersonas = Integer.parseInt(leer.readLine());
					if (numPersonas <= 0)
						System.err.println("El numero de persona tiene que ser mayor que cero");
				} while (numPersonas <= 0);
				
				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}
		}
	}
	
	public boolean añadirPropuestas() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numPropuestas < 4) {
			boolean datosOK = false;
			while (!datosOK) {
				try {
					System.out.println("Introduce las propuestas " + this.numPropuestas);
					propuestas[numPropuestas] = leer.readLine();
					numPropuestas++;
					datosOK = true;
					} catch (IOException e) {
							System.err.println("Solo puedes introducir números");
						}
					}
					return true;
				} else {
					return false;
				}
			}
	
	protected void mostrarDatos() {
        System.out.println("----------------");
        System.out.println("Id: " + this.id);
        System.out.println("Destino: " + this.destino);
        System.out.println("Transporte: " + this.transporte);
        System.out.println("Dias: " + this.duracionDias);
        System.out.println("Precio por persona: " + this.precio);
        System.out.println("Numero de personas: " + this.numPersonas);
        if(numPropuestas == 0)
			System.out.println("Propuestas: Sin Propuestas.");
		else {
			System.out.print("Propuestas: ");
			for(String propuesta: propuestas) {
				System.out.print(propuesta + " ");
			}
		}
    }

	public int getId() {
		return id;
	}
	
    public double getCosteTotal() { 
    	return duracionDias * precio; 
    }

	public String getDestino() {
		return destino;
	}

	public String getTransporte() {
		return transporte;
	}

	public int getDuracionDias() {
		return duracionDias;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public String[] getPropuestas() {
		return propuestas;
	}

	public int getNumPropuestas() {
		return numPropuestas;
	}
}
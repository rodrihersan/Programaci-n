//clase padre

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vehiculo {
	private int id;
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private double precio;
	
	
	public void pedirDatos(int id) throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		
		//aqui se hace sin validar, para simplificar
		//se debe validar con TR (try catch) y demas.
		System.out.println("Introduce la marca: ");
		this.marca = leer.readLine();
		
		System.out.println("Introduce la modelo: ");
		this.modelo = leer.readLine();
		
		System.out.println("Introduce año fabricacion: ");
		this.añoFabricacion = Integer.parseInt(leer.readLine());
		
		System.out.println("Introduce año fabricacion: ");
		this.precio = Double.parseDouble(leer.readLine());
	}
	
	public void mostrarDatos() {
		System.out.println("Vehiculo ID: " + id);
		System.out.println("------------------");
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Año fabricacion: " + añoFabricacion);
		System.out.println("Precio: " + precio);						
	}	 
}
package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class producto {
	private int id;
	private String nombre;
	private double precio;
	private int stock;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre del producto: ");
				nombre = leer.readLine();
				do {
					System.out.println("Introduce el precio del producto: ");
					precio = Double.parseDouble(leer.readLine());
					if (precio < 0)
						System.out.println("Tienes que introducir un precio positivo");
				} while (precio < 0);
				
				do {
					System.out.println("Introduce el stock del producto: ");
					stock = Integer.parseInt(leer.readLine());
					if (stock < 0)
						System.out.println("Tienes que introducir un stock positivo");
				} while (stock < 0);
				
				datosOK = true;
			} catch (Exception e) {
				System.err.println("Has introducido algun dato mal");
				System.out.println("");
			}
		}

	}
	
	
	public boolean comprobarStock() {
		if (stock > 0)
			return true;
		else
			return false;
		
	}
	
	
	public void realizarVenta(int cantidad) {
		if(comprobarStock() && stock >= cantidad) {
			stock = stock - cantidad;
			System.out.println("Venta realizada. El nuevo stock de " + nombre + " es " + stock);
			System.out.println("Total a pagar " + (cantidad * precio) + "€");
		}else {
			System.out.println("No se puede realizar la venta. No hay stock suficiente");
		}
	}
	
	public void reabastecerProducto() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int cantidadARebastecer;
		do {
			System.out.println("Introduce cuantos stock nuevo hay de " + nombre);
			cantidadARebastecer = Integer.parseInt(leer.readLine());
			if (cantidadARebastecer < 0)
				System.out.println("Tienes que introducir un stock positivo");
		} while (cantidadARebastecer < 0);
		
		stock = stock + cantidadARebastecer;
		
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre del producto: " + nombre + 
							"\n\t ID: " + id + 
							"\n\t Stock: " + stock + 
							"\n\t Precio: " + precio);	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
	
package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class producto {
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	
	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		System.out.print("Introduce el nombre del prodcuto: ");
		nombre = leer.readLine();
		System.out.print("Introduce el precio: ");
		precio = Double.parseDouble(leer.readLine());
		System.out.print("Introduce el stock: ");
		stock = Integer.parseInt(leer.readLine());
	}
	
	/*public void comprobarStock() {
		if (stock > 0) {
			System.out.println("Hay stock de este producto");
		}else if (stock == 0) {
			System.out.println("No queda nada de stock de este producto");
		}else {
			System.out.println("El valor introducio no es valido");
		}
	} OPCION1 (Rodrigo)*/
	
	public boolean comprobarStock() {
		if (stock > 0) {
			return true;
		}else {
			return false;
		}
	} //OPCION2 (Adri)
	
	
	public void venta(int cantVendido) {
		if (comprobarStock() == true && stock >= cantVendido) {
			stock = stock - cantVendido;
		} else {
			System.out.println("No se puede vender el producto, no hay stock suficiente");
		}
	}
	
	public int reabastecer(int cantAñadida) {
		return stock = stock + cantAñadida;
		}


	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
}
	
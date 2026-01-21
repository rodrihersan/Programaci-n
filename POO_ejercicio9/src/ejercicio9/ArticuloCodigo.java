package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ArticuloCodigo {
	private int codigo;
    private String nombre;
    private double precio;
    private int stock;
	
	public void pedirDatos(ArrayList<ArticuloCodigo>  articulos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		codigo = generarCodigoUnico(articulos);
		System.out.print("Nombre: ");
        nombre = leer.readLine();

        System.out.print("Precio: ");
        precio = Double.parseDouble(leer.readLine());

        System.out.print("Stock: ");
        stock = Integer.parseInt(leer.readLine());
    }
	
	 public static int generarCodigoUnico(ArrayList<ArticuloCodigo> articulos) {
	        Random rand = new Random();
	        int cod;
	        boolean repetido;

	        do {
	            cod = rand.nextInt(100) + 1;
	            repetido = false;

	            for (ArticuloCodigo a : articulos) {
	                if (a.getCodigo() == cod) {
	                    repetido = true;
	                    break;
	                }
	            }
	        } while (repetido);

	        return cod;
	    }
	 
	 public boolean vender(int cantidad) {
	        if (stock >= cantidad) {
	            stock -= cantidad;
	            return true;
	            }
	        return false;
	        }
	 
	 public int getCodigo() {
	        return codigo;
	    }
	 
	 
	 public void mostrarFicha() {
	        System.out.println("Código: " + codigo +" Nombre: " 
	 + nombre + " Precio: " + precio + " Stock: " + stock);
	        }
	 
	 public boolean codigoEsPar() {
	        return codigo % 2 == 0;
	        }
	}
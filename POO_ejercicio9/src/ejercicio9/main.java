package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)throws IOException  {
        ArrayList<ArticuloCodigo> articulos = new ArrayList<>();
        int opcion;
		
        do {
            System.out.println("--- MENÚ ---");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Buscar por código");
            System.out.println("4. Vender artículo");
            System.out.println("5. Mostrar códigos pares");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(leer.readLine());
            
            switch (opcion) {
            case 1:añadirArticulo(articulos);break;
            
            case 2:mostrarTodos(articulos);break;
            
            case 3:buscarPorCodigo(articulos);break;
            	
            case 4:venderArticulo(articulos);break;
            	
            case 5:mostrarCodigosPares(articulos);break;
            	  
            case 6:System.out.println("Saliendo :c");break;
            
            default:System.out.println("Opción no válida");
        }
    } while (opcion != 6);
}
	
	private static void añadirArticulo(ArrayList<ArticuloCodigo> articulos) throws IOException {
	    if (articulos.size() < 20) {
	        ArticuloCodigo a = new ArticuloCodigo();
	        a.pedirDatos(articulos);
	        articulos.add(a);
	        System.out.println("Artículo añadido correctamente.");
	    } else {
	        System.out.println("Inventario lleno.");
	    }
	}
	
	private static void mostrarTodos(ArrayList<ArticuloCodigo> articulos) {
	    for (int i = 0; i < articulos.size(); i++) {
	        articulos.get(i).mostrarFicha();
	    }
	}
	
	private static void buscarPorCodigo(ArrayList<ArticuloCodigo> articulos) throws IOException {
	    System.out.print("Código a buscar: ");
	    int cod = Integer.parseInt(leer.readLine());
	    boolean encontrado = false;

	    for (int i = 0; i < articulos.size(); i++) {
	        if (articulos.get(i).getCodigo() == cod) {
	            articulos.get(i).mostrarFicha();
	            encontrado = true;
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Artículo no encontrado.");
	    }
	}
	
	private static void venderArticulo(ArrayList<ArticuloCodigo> articulos) throws IOException {
	    System.out.print("Código: ");
	    int cod = Integer.parseInt(leer.readLine());
	    System.out.print("Cantidad: ");
	    int cantidad = Integer.parseInt(leer.readLine());
	    boolean encontrado = false;

	    for (int i = 0; i < articulos.size(); i++) {
	        if (articulos.get(i).getCodigo() == cod) {
	            if (articulos.get(i).vender(cantidad)) {
	                System.out.println("Venta realizada.");
	            } else {
	                System.out.println("Stock insuficiente.");
	            }
	            encontrado = true;
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Artículo no encontrado.");
	    }
	}
	
	private static void mostrarCodigosPares(ArrayList<ArticuloCodigo> articulos) {
	    for (int i = 0; i < articulos.size(); i++) {
	        if (articulos.get(i).getCodigo() % 2 == 0) {
	            articulos.get(i).mostrarFicha();
	        }
	    }
	}
}
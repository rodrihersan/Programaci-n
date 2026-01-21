package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

	public static void main(String[] args)throws IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
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
            
            case 1:
                if (articulos.size() < 20) {
                    ArticuloCodigo a = new ArticuloCodigo();
                    a.pedirDatos(articulos);
                    articulos.add(a);
                    System.out.println("Artículo añadido.");
                } else {
                    System.out.println("Inventario lleno.");
                }
                break;
                
            case 2: 
            	for (ArticuloCodigo a : articulos) {
                    a.mostrarFicha();
                }
                break;
                
            case 3:
                System.out.print("Código a buscar: ");
                int cod = Integer.parseInt(leer.readLine());
                boolean encontrado = false;

                for (ArticuloCodigo a : articulos) {
                    if (a.getCodigo() == cod) {
                        a.mostrarFicha();
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Artículo no encontrado.");
                }
                break;
                
            case 4:
            	System.out.print("Código: ");
                cod = Integer.parseInt(leer.readLine());
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(leer.readLine());

                encontrado = false;
                for (ArticuloCodigo a : articulos) {
                    if (a.getCodigo() == cod) {
                        if (a.vender(cantidad)) {
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
                break;
                
            case 5:
            	for (ArticuloCodigo a : articulos) {
                    if (a.codigoEsPar()) {
                        a.mostrarFicha();
                    }
                }
                break;
                
            case 6:
            	System.out.println("Saliendo :c");
                break;

            default:
                System.out.println("Opción incorrecta.");
            }
        } while (opcion != 6);
	}
}
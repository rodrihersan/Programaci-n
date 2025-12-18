package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		
		//ejercicio1
		boolean salir = false;
		int precio;
		System.out.println("=== BIENVENIDO A GESTIÓN DE VENTAS ===");
		System.out.println();
		System.out.println("--- MENÚ PRINCIPAL ---");
		System.out.println("1.Calcular IVA (21%) de un producto");
		System.out.println("2.Calcular descuento por comprar más de 3 figuras (10%)");
		System.out.println("3.Calcular cuánto falta para envío gratis (50€)");
		System.out.println("4.Mostrar tabla de precios (1-10 unidades)");
		System.out.println("5.Salir");
		System.out.println();
		System.out.println("Elige una opción (pon el número): ");
		int numero = Integer.parseInt(lector.readLine());
		
		
		switch(numero) {
		
		case 1:
			System.out.println("=== CALCULAR EL IVA ===");
			System.out.println("Introduce el precio del producto: ");
			double precioProducto = Double.parseDouble(lector.readLine());
			System.out.println("El precio sin IVA es: "+precioProducto+" euros");
			double precioSoloIVA = precioProducto*21/100;
			System.out.println("IVA (21%): "+precioSoloIVA+" euros");
			System.out.println("Precio final con IVA: "+(precioSoloIVA+precioProducto)+" euros");
		break;
		
		case 2:
			System.out.println("=== CALCULAR DESCUENTO POR FIGURAS ===");
			System.out.println("Introduce el número de figuras: ");
			int figura = Integer.parseInt(lector.readLine());
			System.out.println("Introduce el precio total: ");
			double precioFigura = Double.parseDouble(lector.readLine());
			if(figura >= 3) {
				double descuentoFigura = precioFigura*10/100;
				System.out.println("Usted tiene una oferta del 10% sobre el total de las figuras."
						+ "Su precio final seria de: "+(precioFigura-descuentoFigura)+" euros");
			}else {
				System.out.println("Al no haber comprado 3 figuras no tiene opción de descuento."
						+ "Su precio final es de: "+precioFigura+" euros");
				}
		break;
		
		case 3: 
			System.out.println("=== CALCULAR ENVÍO GRATIS ===");
			System.out.println("Introduce el importe de su compra: ");
			double importeEnvio = Double.parseDouble(lector.readLine());
			if(importeEnvio >= 50) {
				System.out.println("Su envío es gratis. :)");
			}else {
				System.out.println("No tiene el envio gratis. Necesita "+(50-importeEnvio)+" euros más para el envio gratis.");
			}
		break;
		
		case 4:
			System.out.println("=== TABLA DE PRECIOS ===");
			System.out.println("Diga el precio de su producto: ");
			double precioUnitario = Double.parseDouble(lector.readLine());
			double IVA=(0.21);
			
			System.out.println("--- Tabla de precios (sin IVA) ---");
			for(int unidades = 0; unidades<11;unidades++) {
				double precioSinIVA = precioUnitario*unidades;
				double precioConIVA = (precioSinIVA + (precioSinIVA*IVA));
				if(unidades >= 4) {
					double descuento = precioConIVA * 0.10; // 10% de descuento
	                double precioDescuento = precioConIVA - descuento;
	                System.out.println(unidades + " unidades: " + precioSinIVA + "€ (con IVA: " +
                            precioConIVA + "€) Precio con descuento: " + precioDescuento + "€ (Descuento: -" + descuento + "€)");
				} else {
					System.out.println(unidades + " unidades: " + precioSinIVA + "€ (con IVA: " + precioConIVA + "€)");
				}
			}
			break;
		case 5:
			salir=true;
			System.out.println("Hasta luego!");
		break;
		
		default:
			System.out.println("opcion invalido");
			}		
		}
	}

package ejerciciosTipoExamenWD;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;



public class ejercicio6 {



	public static void main(String[] args) throws NumberFormatException, IOException{

		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;

        while (!salir) {

		System.out.println("== BIENVENIDO A TU CALCULADORA DE VIAJES ===");

		System.out.println();

		System.out.println();

		System.out.println("--- MENÚ PRINCIPAL ---");

		System.out.println("1. Calcular coste de gasolina\r\n"

				+ "2. Planificar paradas\r\n"

				+ "3. Tiempo estimado de llegada\r\n"

				+ "4. Contador de peajes\r\n"

				+ "5. Salir\r\n");

		System.out.println("Elige una opción: ");

		int opcion = Integer.parseInt(lector.readLine());

		

		switch(opcion) {

		case 1:

			//System.out.println("¿Va a pagar con tarjeta? Responda Si o no (S/N)");

			//String pago = lector.readLine(); 

			

			//if(pago.equalsIgnoreCase("si")){

			System.out.println("== CALCULAR COSTE DE GASOLINA ==");

			System.out.println("Introduce la distancia del viaje en km: ");

			double distancia = Double.parseDouble(lector.readLine());

			System.out.println("Introduce el consumo del coche (litros/100km): ");

			double consumoLitros = Double.parseDouble(lector.readLine());

			System.out.println("Introduce el precio por litro: ");

			double precioLitro = Double.parseDouble(lector.readLine());

			if(distancia >300) {

			System.out.println("--- CÁLCULO DE COMBUSTIBLE ---");

			System.out.println();

			System.out.println("Se le aplicara un descuento por superar los 300Km");

			System.out.println("Distancia: "+distancia+" km");

			double litrosNecesario = ((consumoLitros/100)*distancia);

			System.out.println("Litros necesarios: "+litrosNecesario+" litros");

			double coste = (litrosNecesario*precioLitro);

			System.out.println("Coste sin descuento: "+coste+" euros");

			double descuento = coste*0.05;

			System.out.println("Descuento tarjeta (5%): "+descuento);

			double costeTotal = coste-descuento;

			System.out.println("Coste total: "+costeTotal+" euros");

		}else {

			System.out.println("--- CÁLCULO DE COMBUSTIBLE ---");

			System.out.println();

			System.out.println("No se le apicará un descuento, al no superar los 300Km");

			System.out.println("Distancia: "+distancia+" km");

			double litrosNecesario = ((consumoLitros/100)*distancia);

			System.out.println("Litros necesarios: "+litrosNecesario+" litros");

			double coste = (litrosNecesario*precioLitro);

			System.out.println("Coste sin descuento: "+coste+" euros");

			}

			System.out.println();



		break;

		

		case 2: 

			

			System.out.println("=== PLANIFICAR PARADAS ===");

			System.out.println("Introduce la distancia total del viaje en km: ");

			distancia = Double.parseDouble(lector.readLine());

			System.out.println("Introduce las paradas que haras");

			double cantidadParadas = Double.parseDouble(lector.readLine());

			double paradasCada = (distancia/cantidadParadas);

			System.out.println("Paradas cada: "+(paradasCada)+" kilometros");

			System.out.println();

			System.out.println("--- PLAN DE PARADAS ---");

			System.out.println("Distancia total: "+distancia+" kilometros");

			System.out.println("Paradas necesarias: "+cantidadParadas);

			System.out.println("Paradas cada: "+paradasCada+" kilometros");

			double inicioParada=0;

			for(int parada = 1; parada <= cantidadParadas; parada++) {

				System.out.println("-- Parada "+parada+ " --");

				inicioParada =inicioParada+paradasCada;

				System.out.println("\t- Parada "+parada+ ": " +inicioParada);

				}

			System.out.println();



		break;

		

		case 3:

			System.out.println("=== TIEMPO ESTIMADO DE LLEGADA ===");

			System.out.println("Introduce la hora de salida (0-23): ");

			int hora = Integer.parseInt(lector.readLine());

			System.out.println("Introduce la distancia en km: ");

			distancia = Integer.parseInt(lector.readLine());

			System.out.println("Introduce la velocidad media en km/h: ");

			int velocidad = Integer.parseInt(lector.readLine());

			 if(hora < 0 || hora > 23) {

			        System.out.println("No existe esa hora. Solo de 0 a 23");

			    } else {

			        double tiempoHoras = distancia / velocidad; // tiempo en horas

			        int horasViaje = (int) tiempoHoras;              // parte entera de horas

			        int minutosViaje = (int) Math.round((tiempoHoras - horasViaje) * 60); // minutos restantes



			        int horaLlegada = hora + horasViaje;

			        int minutoLlegada = minutosViaje;



			        // Ajustar si pasa de 23h

			        boolean alDiaSiguiente = false;

			        if(horaLlegada > 23) {

			            horaLlegada = horaLlegada - 24;

			            alDiaSiguiente = true;

			        }



			        System.out.println();

			        System.out.println("--- ESTIMACIÓN DE LLEGADA ---");

			        System.out.println("Hora de salida: " + hora + ":00");

			        System.out.println("Duración del viaje: " + horasViaje + " horas y " + minutosViaje + " minutos");

			        if(alDiaSiguiente) {

			            System.out.println("Hora estimada de llegada: " + horaLlegada + ":" + (minutoLlegada<10?"0"+minutoLlegada:minutoLlegada) + " (al día siguiente)");

			        } else {

			            System.out.println("Hora estimada de llegada: " + horaLlegada + ":" + (minutoLlegada<10?"0"+minutoLlegada:minutoLlegada));

			        }

			    }

			    System.out.println();

			break;

		

		case 4:

			double totalPeaje=0;

			System.out.println("=== CONTADOR DE PEAJES ===");

			System.out.println("¿Cuántos peajes hay en tu ruta?");

			int peaje = Integer.parseInt(lector.readLine());

			for(int i=1; i<=peaje; i++) {

				System.out.println("Peaje "+i+" :");

				double valorPeaje = Double.parseDouble(lector.readLine());

				totalPeaje+=valorPeaje;

			}

			System.out.println("--- RESUMEN DE PEAJES ---");

			if(totalPeaje>=20) {

				System.out.println("Total de peajes sin descuento: " + totalPeaje + " €");

				System.out.println("Descuento aplicado (10%): "+(totalPeaje*0.10));

				System.out.println("Total de peajes con descuento: "+(totalPeaje-(totalPeaje*0.10))+" euros");	

			}else {

				System.out.println("Total de peajes sin descuento: " + totalPeaje + " €");

			}

			System.out.println();

		break;



		case 5:

			salir = true;

			System.out.println("¡Buen viaje y conduce seguro!");

			System.out.println();



		break;

		

		default :

			System.out.println("Opcion inexistente. Vuelva a elegir una opcion valida.");

			}

		}

	}

}
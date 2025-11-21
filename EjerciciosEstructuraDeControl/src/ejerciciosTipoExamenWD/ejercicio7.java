package ejerciciosTipoExamenWD;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;



public class ejercicio7 {



	public static void main(String[] args) throws NumberFormatException, IOException{

		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;

		while (!salir) {

		System.out.println("==== BIENVENIDO AL TORNEO DE AJEDREZ CIUDAD DE SALAMANCA ===");

		System.out.println();

		System.out.println("--- MENÚ PRINCIPAL ---");

		System.out.println("1. Registrar jugador\r\n"

				+ "2. Simular partidas de una ronda\r\n"

				+ "3. Registrar tiempo de partidas\r\n"

				+ "4. Generador de aperturas\r\n"

				+ "5. Salir");

		System.out.println("Elige una opción: ");

		int opcion = Integer.parseInt(lector.readLine());

		

		switch(opcion) {

		

		case 1:

			System.out.println("==== REGISTRAR JUGADOR ===");

			System.out.println("Introduce el nombre completo: ");

			String nombreCompleto = lector.readLine();

			System.out.println("Introduce los años de experiencia: ");

			int añosExperiencia = Integer.parseInt(lector.readLine());

			System.out.println("Introduce la categoría (principiante/intermedio/avanzado): ");

			String categoria = lector.readLine();



			//principiante + experiencia

			if(categoria.equalsIgnoreCase("principiante") && añosExperiencia>5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 100");

				System.out.println("Bonus por experiencia: 200");

				int puntos=300;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");

				}

				System.out.println();

			//principiante	solo

			}else if(categoria.equalsIgnoreCase("principiante")&& añosExperiencia<=5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 100");

				System.out.println("Bonus por experiencia: 0");

				int puntos=100;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");}

				System.out.println();

			//intermedio solo	

			}else if(categoria.equalsIgnoreCase("intermedio")&& añosExperiencia<=5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 500");

				System.out.println("Bonus por experiencia: 0");

				int puntos=500;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");}

				System.out.println();

			//intermedio + experiencia

			}else if(categoria.equalsIgnoreCase("intermedio")&& añosExperiencia>5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 500");

				System.out.println("Bonus por experiencia: 200");

				int puntos=700;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");}

				System.out.println();

			//avanzado + experiencia

			}else if(categoria.equalsIgnoreCase("avanzado")&& añosExperiencia>5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 1000");

				System.out.println("Bonus por experiencia: 200");

				int puntos=1200;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");}

				System.out.println();

			//avanzado solo

			}else if(categoria.equalsIgnoreCase("avanzado")&& añosExperiencia<=5) {

				System.out.println("Nombre: "+nombreCompleto);

				System.out.println("Categoría: "+categoria);

				System.out.println("Puntos base: 1000");

				System.out.println("Bonus por experiencia: 0");

				int puntos=1000;

				System.out.println("Puntos totales: "+puntos);

				if(puntos<400) {

					System.out.println("Ranking bronce");

				}else if(puntos>=400 && puntos <=800) {

					System.out.println("Ranking plata");

				}else {

					System.out.println("Ranking oro");}

			}else {

				System.out.println("Datos incorrectos");

				System.out.println();

			}

		break;

		

		case 2:

			System.out.println("=== SIMULAR PARTIDAS DE UNA RONDA ===");

			System.out.println("¿Cuántos jugadores participan? (debe ser número par): ");

			int participantes = Integer.parseInt(lector.readLine());

			if(participantes % 2 !=0) { //valida que el resto sea distinto 0(serian imapres)

				System.out.println("El número de jugadores debe ser par.");

			    break;

			}

			System.out.println("--- RONDA DE PARTIDAS ---");

			int Partidasnumero = participantes/2;

			int victorias = 0;

			int empates = 0;

			for (int i = 1; i <= Partidasnumero; i++) {

			    int resultado = (int)(Math.random() * 3) + 1;

			    System.out.println("Partida " + i + " (Jugador " + ((i * 2) - 1) + " vs Jugador " + (i * 2) + "):");

			    switch (resultado) {

			        case 1:

			            System.out.println("Resultado: Gana Jugador " + ((i * 2) - 1) + " (+3 puntos)");

			            victorias++;

			            break;

			        case 2:

			            System.out.println("Resultado: Gana Jugador " + (i * 2) + " (+3 puntos)");

			            victorias++;

			            break;

			        case 3:

			            System.out.println("Resultado: Empate (+1 punto para cada uno)");

			            empates++;

			            break;

			    }

			}

			System.out.println("--- RESUMEN DE LA RONDA ---");

			System.out.println("Total de partidas jugadas: " + Partidasnumero);

			System.out.println("Victorias: " + victorias);

			System.out.println("Empates: " + empates);

		break;

		

		case 3:

			System.out.println("=== REGISTRAR TIEMPO DE PARTIDAS ===");

			System.out.println("¿Cuántas partidas se jugaron hoy?: ");

			int numeroPartidas = Integer.parseInt(lector.readLine());

			int partidasValidas =0;		// contar partidas válidas

			int partidasInvalidas=0;

			int sumaTiempos=0;	 		// sumar los minutos de partidas válidas

				for(int i= 1; i<=numeroPartidas;i++) {

					System.out.println("Duración de la partida "+i+" (0-60 min):");

					int tiempo = Integer.parseInt(lector.readLine());

					

					if(tiempo <= 0 || tiempo >60) {

					System.out.println("\tPartida cancelada o tiempo inválido");

					System.out.println();

					partidasInvalidas++;

					}else {

						partidasValidas++;

				        sumaTiempos += tiempo;

					}

				}

				// Calcular y mostrar tiempo medio

				System.out.println("--- ESTADÍSTICAS DE TIEMPO ---");

				System.out.println("Número de partidas válidas: " + partidasValidas);

				System.out.println("-Partidas canceladas: " + partidasInvalidas);

				System.out.println("Tiempo total: "+sumaTiempos+" minutos");

				if (partidasValidas > 0) {

				    double tiempoMedio = (double) sumaTiempos / partidasValidas;

				    System.out.println("Tiempo medio de las partidas válidas: " + tiempoMedio + " min");

				    System.out.println();

				}else {

				    System.out.println("No hubo partidas válidas.");}

				System.out.println();

		break;

		

		case 4:

			System.out.println("=== GENERADOR DE APERTURAS ===");

			int colores = (int) (Math.random() * 3) + 1;

		    int estrategia = (int) (Math.random() * 5) + 1;

		    int dificultad = (int) (Math.random() * 10) + 1;

		    String colorApertura;

		    String estrategiaApertura;

		    char sugerencia;

		    // Asignar color usando switch

		    switch(colores) {

		        case 1: 

		        	colorApertura = "Blancas"; 

		        	break;

		        case 2: 

		        	colorApertura = "Negras"; 

		        	break;

		        case 3: 

		        	colorApertura = "Mixta"; 

		        	break;

		        default: 

		        	colorApertura = "Desconocido";

		    }

		    // Asignar estrategia usando switch

		    switch(estrategia) {

		        case 1: 

		        	estrategiaApertura = "Agresiva"; 

		        	break;

		        case 2: 

		        	estrategiaApertura = "Defensiva"; 

		        	break;

		        case 3: 

		        	estrategiaApertura = "Italiana"; 

		        	break;

		        case 4: 

		        	estrategiaApertura = "Española"; 

		        	break;

		        case 5: 

		        	estrategiaApertura = "India"; 

		        	break;

		        default: 

		        	estrategiaApertura = "Desconocida"; 

		    }

		    // Mostrar la sugerencia

		    System.out.println("Apertura sugerida: " + colorApertura + " " + estrategiaApertura);

		    System.out.println("Nivel de dificultad: " + dificultad + "/10");

		    // Preguntar si quiere otra sugerencia

		    System.out.print("¿Quieres otra sugerencia? (S/N): ");

		    sugerencia = lector.readLine().toLowerCase().charAt(0);

		    while(sugerencia == 's') {

		    	colores = (int) (Math.random() * 3) + 1;

			    estrategia = (int) (Math.random() * 5) + 1;

			    dificultad = (int) (Math.random() * 10) + 1;

			    // Asignar color usando switch

			    switch(colores) {

			        case 1: 

			        	colorApertura = "Blancas"; 

			        	break;

			        case 2: 

			        	colorApertura = "Negras"; 

			        	break;

			        case 3: 

			        	colorApertura = "Mixta"; 

			        	break;

			        default: 

			        	colorApertura = "Desconocido";

			    }

			    // Asignar estrategia usando switch

			    switch(estrategia) {

			        case 1: 

			        	estrategiaApertura = "Agresiva"; 

			        	break;

			        case 2: 

			        	estrategiaApertura = "Defensiva"; 

			        	break;

			        case 3: 

			        	estrategiaApertura = "Italiana"; 

			        	break;

			        case 4: 

			        	estrategiaApertura = "Española"; 

			        	break;

			        case 5: 

			        	estrategiaApertura = "India"; 

			        	break;

			        default: 

			        	estrategiaApertura = "Desconocida"; 

			    }

			    // Mostrar la sugerencia

			    System.out.println("Apertura sugerida: " + colorApertura + " " + estrategiaApertura);

			    System.out.println("Nivel de dificultad: " + dificultad + "/10");

			    // Preguntar si quiere otra sugerencia

			    System.out.print("¿Quieres otra sugerencia? (S/N): ");

			    sugerencia = lector.readLine().toLowerCase().charAt(0);

		    }

		break;

		case 5:

			System.out.println("Saliendo del sistema");

			salir = true;

		break;

		

		default :

			System.out.println("Numero invalido");

			}

		}

	}

}

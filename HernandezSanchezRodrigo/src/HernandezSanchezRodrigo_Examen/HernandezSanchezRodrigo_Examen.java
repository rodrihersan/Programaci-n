package HernandezSanchezRodrigo_Examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HernandezSanchezRodrigo_Examen {
	
	 public static int leerInt() throws IOException {
		 
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = 0;
			boolean valido = false;
			while (!valido) {
				try {
					num = Integer.parseInt(leer.readLine());
					valido = true;
				} catch (NumberFormatException e) {
					System.err.print("ERROR. ");
					System.out.println("Introduce un n�mero v�lido: ");
				}
			}
			return num;
		}
		
	//--------------------	
		public static int leerIntPositivo() throws IOException {
		    int numero = leerInt();
		    while (numero < 0) {
		        System.err.print("ERROR. ");
		        System.out.println("El n�mero no puede ser negativo. Intentalo de nuevo: ");
		        numero = leerInt();
		    }
		    return numero;
		}
		
	//--------------------
		public static double leerDouble() throws IOException{
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			double numero =0;
			boolean valido=false;
			
			while(!valido) {
				try {
					numero = Double.parseDouble(leer.readLine());
		            valido = true;
		        } catch (NumberFormatException e) {
		            System.err.print("ERROR. ");
		            System.out.println("Introduce un n�mero v�lido");
		        }
		    }
		    return numero;
			}

	//--------------------		
		public static double leerDoublePositivo() throws IOException {
	        double numero = leerDouble();
	        while (numero < 0) {
	        	System.err.print("No puedes introducir un n�mero negativo.");
	        	System.out.println(" Intentalo de nuevo: ");
	            numero = leerDouble();
	        }
	        return numero;
	    }
		
	//--------------------			
		public static boolean esTextoValido(String texto) {
		    for (int i = 0; i < texto.length(); i++) {
		        char c = texto.charAt(i);

		        // comprobamos si no es letra may�scula ni min�scula
		        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
		            return false; // encontramos un car�cter no permitido
		        }
		    }
		    return true; // todos los caracteres son letras
		}
		
	//----------	
		public static String leerLinea() throws IOException {
			
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		    String texto;

		    do {
		        texto = leer.readLine().trim(); // quitamos espacios al inicio y al final

		        if (texto.length() == 0) {
		            System.err.println("Debes escribir algo.");
		            System.out.print("Int�ntalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }

		        if (!esTextoValido(texto)) {
		            System.err.println("El nombre solo puede contener letras, sin n�meros ni s�mbolos ni espacios en blanco.");
		            System.out.print("Int�ntalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }
		        break; // si pasa todas las comprobaciones, salimos del bucle
		    } while (true);
		    return texto;
		}
	
	public static void main(String[] args)throws NumberFormatException, IOException {
		String[] participantes = new String[6];
        String[] tentadores = new String[6];
        int[][]  tentacion = new int[6][6];
        
        boolean salir = false;
        int opcion;
        do {
            System.out.println("\n---LA ISLA DE LAS TENTACIONES JAVA---");
            System.out.println("1. Llegada a la villa");
            System.out.println("2. �Hay m�s im�genes!");
            System.out.println("3. Hoguera de Confrontaci�n");
            System.out.println("4. La luz de la tentaci�n");
            System.out.println("5. Montoya, por favor");
            System.out.print("Selecciona una opci�n: ");

            opcion = leerIntPositivo();

            switch (opcion) {
                case 1:cargaDeDatos(participantes, tentadores, tentacion);break;
                case 2:actualizarTentacion(participantes, tentadores, tentacion);break;
                case 3:matrizYEstadisticas(participantes, tentadores, tentacion);break;
                case 4:alarma(participantes, tentadores, tentacion);break;
                case 5:salir = true;System.out.println("Montoya, por favor\r\n"
                		+ "Nos vemos en la pr�xima edici�n");break;
                default:System.err.println("Opci�n no v�lida.");
            }
        } while (!salir);
    }
//Case1
	public static void cargaDeDatos(String[] participantes, String[] tentadores, int[][] tentacion) throws IOException {
		System.out.println("\n--- LLEGADA A LA VILLA ---");
		
		System.out.println("\n---Introducir los 6 participantes---");
		for (int i = 0; i < participantes.length; i++) {
			System.out.print("Participantes " + (i + 1) + ": ");
			participantes[i] = leerLinea();
			}
				
		System.out.println("\n---Introducir los 6 tentadores---");
		for (int i = 0; i < tentadores.length; i++) {
			System.out.print("Tentadores " + (i + 1) + ": ");
			tentadores[i] = leerLinea();
			}
		for (int i = 0; i < tentacion.length; i++) {
            for (int j = 0; j < tentacion[i].length; j++) {
            	tentacion[i][j] = 0;
            }
        }
		System.out.println("�Todos los participantes y tentadores han llegado a la villa!");
    }
	
//Case2
	public static void actualizarTentacion(String[] participantes, String[] tentadores, int[][] tentacion) throws IOException {
		System.out.println("\n--- Introducir grado tentaci�n ---");

		System.out.println("Participantes");
		for(int i=0; i<participantes.length; i++) {
			System.out.println(i + ". " + participantes[i]);
			}
		
		int posParticipante = -1;
		boolean activo;
		do {
			activo = true;
			System.out.println("Introduce el �ndice de los participantes (0-5): ");
			posParticipante = leerIntPositivo();
			if(posParticipante<0 || posParticipante>5) {
				System.out.println("El numero introducido no esta entre 0 y 5");
			}
		}while(posParticipante<0 ||  posParticipante>5 || activo == false);
		
		System.out.println("Tentadores");
		for(int i=0; i<tentadores.length; i++) {
			System.out.println(i + ". " + tentadores[i]);
			}
		
		int posTentador = -1;
		boolean activo2;
		do {
			activo2 = true;
			System.out.println("Introduce el �ndice de los tentadores (0-5): ");
			posTentador = leerIntPositivo();
			if(posTentador<0 || posTentador>5) {
				System.out.println("El numero introducido no esta entre 0 y 5");
			}
		}while(posTentador<0 ||  posTentador>5 || activo2 == false);
		
		if(posParticipante != -1 && posTentador != -1) {
			System.out.println("Introduce el grado de tentacion para el participante " + posParticipante +
					" y el tentador " + posTentador);
			tentacion[posParticipante][posTentador] = leerIntPositivo();
			if(tentacion[posParticipante][posTentador] <0) {
				System.err.println("No se puede introducir numeros negativos");
			}else if (tentacion[posParticipante][posTentador] >100) {
				System.err.println("Al ser un numero mayor de 100 se aplicar� solamente 100");
				tentacion[posParticipante][posTentador] = 100;
			}else {
			System.out.println("Grado de tentacion aplicado correctamente");
			}
			
		}else {
			System.out.println("No se ha pdido registrar el grado de tentacion porque "
					+ "no se ha encontrado al participante o tentador");
		}
	}
	
//Case3
	public static void matrizYEstadisticas(String[] participantes, String[] tentadores, int[][] tentacion)throws IOException {
		System.out.println("--- HOGUERA DE CONFRONTACI�N ---");		
		System.out.println("---MATRIZ DE TENTACI�N---");
		
		System.out.print("\t\t");
		for(int i=0; i<tentadores.length; i++) {
			System.out.print(tentadores[i] + "\t\t");
		}
		System.out.println("");
		
		for(int f=0; f<tentacion.length; f++) {
			System.out.print(participantes[f] + "\t\t");
			for(int c=0; c<tentacion[f].length; c++) {
				System.out.print(tentacion[f][c] + "\t\t" );
			}
			System.out.println();
		}
		int posConMasTentacion = -1;
		int tentacionMayor = -1;
		for(int f=0; f<tentacion.length; f++) {
			int sumaTentacion = 0;
			for(int c=0; c<tentacion[f].length; c++) {
				sumaTentacion += tentacion[f][c];
				if(sumaTentacion > tentacionMayor) {
					posConMasTentacion = f;
					tentacionMayor = sumaTentacion;
				}
			}
		}
		
		System.out.println("El participante que m�s tentacion tiene es " + participantes[posConMasTentacion] + " con " 
		                            + tentacionMayor);
		
		int conexionMayor = -1;
		int posConConexionMayor = -1;
		for(int c=0; c<tentacion[0].length; c++) {
			int sumaTentacion = 0;
			for(int f=0; f<tentacion.length; f++) {
				sumaTentacion += tentacion[f][c];
				if(sumaTentacion > conexionMayor) {
					posConConexionMayor = f;
					conexionMayor = sumaTentacion;
					if(conexionMayor >100) {
						conexionMayor=100;
					}
				}
			}
		}
		
		System.out.println("El participante con mayor conexion es "+ tentadores[posConConexionMayor] + " y " + participantes[posConMasTentacion] + " con " + conexionMayor);
	}
		
//case4 
	public static void alarma (String[] participantes, String[] tentadores, int[][] tentacion)throws IOException {
		System.out.println("\n--- LA LUZ DE LA TENTACI�N ---");	
		System.out.println("Introduce el umbral de alarma (1-100): ");
		int umbral = leerIntPositivo();
		if(umbral <1 || umbral > 100) {
			System.err.println("No puedes poner ese valor. Solo entre 1-100");
			return;
		}
			
		System.out.println();
		System.out.println("\nBUSCANDO CONEXIONES PELIGROSAS...");
		
		boolean perdida = false;
		for(int f=0; f<tentacion.length; f++) {
			for(int c=0; c<tentacion[f].length; c++) {
				if(tentacion[f][c] >= umbral) {
					System.out.println("�ALARMA! Los participantes que mas tentacion tienen son  " + participantes[f] + " y el tentador " + tentadores[c]+ " tienen un nivel de tentacion de "
							+ tentacion[f][c] );
				}else {
					System.out.println("Noche tranquila. La isla duerme. Por ahora... :P");
				}
				perdida = true;
			}
		}
	}
}
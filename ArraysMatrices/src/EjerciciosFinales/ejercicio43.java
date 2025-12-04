package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio43 {
	
//MÉTODOS AUXILIARES
	public static char leerChar() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		char palabra = leer.readLine().toUpperCase().charAt(0);
		return palabra;
	}
	
	public static boolean hayDuplicados(String nombre, String[] nombresEquipo) {
		boolean hayDuplicados = false;
		for(int i=0; i<nombresEquipo. length; i++) {
			if(nombresEquipo[i] != null) {
				if(nombresEquipo[i].equalsIgnoreCase(nombre)) {
					hayDuplicados = true;
					System.out.println("El nombre esta duplicado.");
				}
			}
		}
		return hayDuplicados;
	}

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
				System.out.println("Introduce un número válido: ");
			}
		}
		return num;
	}
	
//--------------------	
	public static int leerIntPositivo() throws IOException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El número no puede ser negativo. Intentalo de nuevo: ");
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
	            System.out.println("Introduce un número válido");
	        }
	    }
	    return numero;
		}

//--------------------		
	public static double leerDoublePositivo() throws IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un número negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
        }
        return numero;
    }
	
//--------------------			
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char palabra = texto.charAt(i);

	        // comprobamos si no es letra mayúscula ni minúscula
	        if (!((palabra >= 'a' && palabra <= 'z') || (palabra >= 'A' && palabra <= 'Z'))) {
	            return false; // encontramos un carácter no permitido
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
	            System.out.print("Inténtalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        if (!esTextoValido(texto)) {
	            System.err.println("El nombre solo puede contener letras, sin números ni símbolos ni espacios en blanco.");
	            System.out.print("Inténtalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        break; // si pasa todas las comprobaciones, salimos del bucle

	    } while (true);

	    return texto;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		
		int[][] puntuaciones = new int[8][7];
		String[] nombresEquipo = new String[8];
		int[] estadoEquipos = new int[8];
		
		do {
			System.out.println();
		System.out.println("1. REGISTRO DE EQUIPOS ");
		System.out.println("2. REGISTRAR PUNTUACIÓN ");
		System.out.println("3. TABLA DE CLASIFICACIÓN ");
		System.out.println("4. ANÁLISIS DE RENDIMIENTO ");
		System.out.println("5. DESCALIFICAR EQUIPO ");
		System.out.println("6. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:opcion1(puntuaciones,nombresEquipo,estadoEquipos);break;
		case 2:opcion2(puntuaciones,nombresEquipo,estadoEquipos);break;
		case 3:opcion3(puntuaciones,nombresEquipo,estadoEquipos);break;
		case 4:opcion4(puntuaciones,nombresEquipo,estadoEquipos);break;
		case 5:opcion5(puntuaciones,nombresEquipo,estadoEquipos);break;
		case 6:salir = true;System.out.println("¡Hasta luego!");break;
		default:System.err.println("Opción no válida.");
			}
		}while(!salir);
	}
	
//Case1
	public static void opcion1(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws IOException {
		System.out.println("--- REGISTRO DE EQUIPOS ---");
		System.out.println();
		
		for(int i=0; i<nombresEquipo.length; i++) {
			String nombre;
			do {
				System.out.println("Introduce nombre del equipo " + (i+1)+" : ");
				nombre = leerLinea();
			}while(hayDuplicados(nombre, nombresEquipo));
			nombresEquipo[i] = nombre;
		}
		
		for(int f=0; f<puntuaciones.length; f++) {
			for(int c=0; c<puntuaciones[f].length; c++) {
				puntuaciones[f][c] = 0;
			}
		}
		
		for(int i=0; i<estadoEquipos.length; i++) {
			estadoEquipos[i] = 0;
	}
		System.out.println("¡Todos los equipos han sido registrados!");
		System.out.println("Matriz de puntuaciones inicializada correctamente.");
	}
	
//case2
	public static void opcion2(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws NumberFormatException, IOException {
		System.out.println("--- REGISTRAR PUNTUACIÓN ---");
		System.out.println();

		System.out.println("EQUIPOS");
		for(int i=0; i<nombresEquipo.length; i++) {
			System.out.print(i + ". " + nombresEquipo[i]);
			if(estadoEquipos[i] == 0) {
				System.out.println(" [ACTIVO]");
			}else if(estadoEquipos[i]==1){
			System.out.println("[Descalificado]");
			}
			}
		
		int posEquipo = -1;
		boolean activo;
		do {
			activo = true;
			System.out.println("Introduce el índice del equipo (0-7): ");
			posEquipo = leerIntPositivo();
			if(posEquipo<0 || posEquipo>7) {
				System.out.println("El numero introducido no esta entre 0 y 7");
			}else {
				if(estadoEquipos[posEquipo] == 1) {
					System.err.println("Este equipo está descalificado y no puede competir.");
					activo = false;
				}
			}
				
		}while(posEquipo<0 ||  posEquipo>7 || activo == false);
		
		int numeroJornada = -1;
		do {
			System.out.println("Introduce el numero de jornada (0-7): ");
			numeroJornada = leerIntPositivo();
			if(numeroJornada<0 || numeroJornada>7) 
				System.err.println("El numero introducido no esta entre 0 y 7");
				
		}while(numeroJornada<0 ||  numeroJornada>7);
		
		int puntuacionObtenida = -1;
		do {
			System.out.println("Introduce la puntuacion (0-100): ");
			puntuacionObtenida = leerIntPositivo();
			if(puntuacionObtenida<0 || puntuacionObtenida>100) 
				System.err.println("El numero introducido no esta entre 0 y 100");
				
		}while(puntuacionObtenida<0 ||  puntuacionObtenida>100);
		
		
		puntuaciones[posEquipo][numeroJornada] = puntuacionObtenida;
		System.out.println("Registrado correctamente. El equipo " + nombresEquipo[posEquipo] + 
				" ha obtenido en la jornada " + numeroJornada + " la puntuacion " + puntuacionObtenida);
	}
	
//case3
	public static void opcion3(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws NumberFormatException, IOException{
		System.out.println("--- TABLA DE CLASIFICACIÓN ---");
		
		System.out.print("\t\t");
		for(int i=0; i<puntuaciones[0].length; i++) {
			System.out.print("J"+ i+"\t\t");
		}
		System.out.println("TOTAL");
		for(int f = 0; f<puntuaciones.length;f++) {
			System.out.print(nombresEquipo[f]+"\t\t");
			int total = 0;
			for(int c = 0; c<puntuaciones[f].length;c++) {
				System.out.print(puntuaciones[f][c]+"\t\t");
				total+=puntuaciones[f][c];
			}
			System.out.println(total);
		}
	}
//CAse4
		public static void opcion4(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws NumberFormatException, IOException {
			System.out.println("--- ANÁLISIS DE RENDIMIENTO ---");
			int posequipo=-1;
			do {
				System.out.println("Introduce el indice del quipo(0-7): ");
				 posequipo= leerInt();
				 if(posequipo<0 || posequipo>7) {
					 System.out.println("El numero no esta entre 0 y 7.");
				 }
			}while(posequipo<0 || posequipo>7);
			String nombreEquipo1 = " hola";
			for(int i = 0; i<nombresEquipo.length;i++) {
				 nombreEquipo1= nombresEquipo[posequipo];
			}
			System.out.println("EQUIPO: "+ nombreEquipo1);
			
			boolean activo = false;
			for(int i = 0; i<estadoEquipos.length;i++) {
				
				if(estadoEquipos[posequipo]==0) {
					activo = true;
				}else {
					activo= false;
				}
			}
			if(activo == true) {
				System.out.println("Estado: Activo");
			}else {
				System.out.println("Estado: Desactivo");
			}
			System.out.println("PUNTUACIONES POR JORNADA: ");
			
			int totalPuntos=0;
			int puntos = 0;
			int numMayor = 0;
			int posiscion = 0;
			int numMenor = 0;
			int posiscion2 = 0;
			
			for (int j = 0; j < puntuaciones[posequipo].length; j++) {
	             puntos = puntuaciones[posequipo][j];
	            totalPuntos += puntos;
	            System.out.println("Jornada "+(j+1)+" :"+ puntos);
			}
			for (int j = 0; j < puntuaciones[posequipo].length; j++) {
	            
				if(puntuaciones[posequipo][j]>numMayor) {
					numMayor = puntuaciones[posequipo][j];
					posiscion = j;
				}

				if(puntuaciones[posequipo][j]<numMenor) {
					numMenor = puntuaciones[posequipo][j];
					posiscion2 = j;
				}
			}
			double media= totalPuntos/7;
			System.out.println("PUNTUACIÓN TOTAL: "+totalPuntos);
			System.out.println("MEJOR JORNADA: Jornada "+posiscion+" con "+numMayor);
			System.out.println("PEOR JORNADA: Jornada "+posiscion2+" con "+numMenor);
			System.out.println("PROMEDIO: "+media+" puntos por jornada");
		}
		
//Case5
		public static void opcion5(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws NumberFormatException, IOException {
			
			System.out.println("--- DESCALIFICAR EQUIPO ---");
			System.out.println("EQUIPOS ACTIVOS:");
			for(int i = 0; i<nombresEquipo.length;i++) {
				System.out.println(i+". "+nombresEquipo[i]);
			}
			int equipoADescalificar=0;
				do {
				System.out.println("Introduce el índice del equipo a descalificar (0-7): ");
				 equipoADescalificar = leerInt();
				 if(equipoADescalificar<0 || equipoADescalificar>7) {
					 System.out.println("El numero no esta entre 0 y 7.");
					}
				}while(equipoADescalificar<0 || equipoADescalificar>7);
				if(estadoEquipos[equipoADescalificar]==0) {
					System.out.println("¿Estás seguro de descalificar a "+nombresEquipo[equipoADescalificar]+"? (S/N): ");
					char descalificado = leerChar();
					if(descalificado=='S'){
						estadoEquipos[equipoADescalificar]=1;
						System.out.println(nombresEquipo[equipoADescalificar]+" ha sido descalificado del torneo");
					}else if(descalificado=='N') {
						System.out.println("No se descalificara al equipo.");
					}
				}else if(estadoEquipos[equipoADescalificar]==1) {
					System.out.println("Su equipo ya esta descalificado.");
				}
			}
		}
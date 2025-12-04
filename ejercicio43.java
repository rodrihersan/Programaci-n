import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio43 {
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}
		public static int leerInt() throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(leer.readLine());
			return num;
		}
		public static char leerChar() throws IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			char palabra = leer.readLine().toUpperCase().charAt(0);
			return palabra;
		}
		

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String [] nombreEquipo = new String [8];
		int [][] puntuaciones = new int [8][7];
		int [] estadoEquipos = new int [8];
		
		boolean salir = false;
		
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
		case 1:
			menu1(nombreEquipo,puntuaciones,estadoEquipos);
		break;
		case 2:
			menu2(nombreEquipo,puntuaciones,estadoEquipos);
		break;
		case 3:
			menu3(nombreEquipo,puntuaciones,estadoEquipos);
		break;
		case 4:
			menu4(nombreEquipo,puntuaciones,estadoEquipos);
		break;
		case 5:
			menu5(nombreEquipo,puntuaciones,estadoEquipos);
		break;
		case 6:
		salir = true;
			System.out.println("¡Hasta luego!");
		break;
			}
		}while(!salir);
	}
	public static void menu1(String [] nombreEquipo, int[][] puntuaciones, int[] estadoEquipos) throws IOException {
		System.out.println("--- REGISTRO DE EQUIPOS ---");
		System.out.println();
		for (int i = 0; i < nombreEquipo.length; i++) {
			String nombre1;
			do {
			System.out.println("Introduce el nombre del equipo "+(i+1)+" :");
			nombre1 = leerString();
			
			if (nombre1.isEmpty()) {
				System.out.println("El nombre del alumno no puede estar vacío.");
					}
			}while (nombre1.isEmpty() || hayDuplicados(nombre1, nombreEquipo));
				nombreEquipo[i] = nombre1;
			}
		for(int f = 0; f<puntuaciones.length;f++) {
			for(int c = 0; c<puntuaciones[f].length;c++) {
				puntuaciones[f][c]= 0;
			}
		}
		for (int i = 0; i < estadoEquipos.length; i++) {
			estadoEquipos[i]=0;
		}
		System.out.println("¡Todos los equipos han sido registrados!");
		System.out.println("Matriz de puntuaciones inicializada correctamente.");
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
	public static void menu2(String [] nombre, int[][] puntuaciones, int[] estadoEquipos) throws NumberFormatException, IOException  {
		System.out.println("--- REGISTRAR PUNTUACIÓN ---");
		System.out.println();
		System.out.println("EQUIPOS: ");
		for(int i = 0; i<nombre.length;i++) {
			System.out.println(i+". "+nombre[i]);
			if(estadoEquipos[i]==0) {
				System.out.println("[Activo]");
			}else if(estadoEquipos[i]==1){
				System.out.println("[Descalificado]");
			}
		}
		int posequipo=-1;
		boolean activo;
		do {
			activo= true;
			System.out.println("Introduce el indice del quipo(0-7): ");
			 posequipo= leerInt();
			 if(posequipo<0 || posequipo>7) {
				 System.out.println("El numero no esta entre 0 y 7.");
			 }else {
				 if(estadoEquipos[posequipo]==1) {
					 System.out.println("Este equipo está descalificado y no puede competir.");
					 activo = false;
				 }
			 }
		}while(posequipo<0 || posequipo>7 || activo == false);
		
		int numJornada = -1;
		do {
			System.out.println("Introduce el numero de la jornada del quipo(0-7): ");
			numJornada= leerInt();
			 if(numJornada<0 || numJornada>7) {
				 System.out.println("El numero no esta entre 0 y 7.");
			 }
		}while(numJornada<0 || numJornada>7);
		
		int puntuacionObtenida = -1;
		do {
			System.out.println("Introduce la puntuacion de la jornada(0-100): ");
			puntuacionObtenida= leerInt();
			 if(puntuacionObtenida<0 || puntuacionObtenida>7) {
				 System.out.println("El numero no esta entre 0 y 100.");
			 }
		}while(puntuacionObtenida<0 || puntuacionObtenida>100);
		
		puntuaciones[posequipo][numJornada-1]=puntuacionObtenida;
		System.out.println("¡Puntuación registrada! TeamDragons obtuvo "+puntuacionObtenida+" puntos en la jornada "+numJornada);
	}
	public static void menu3(String [] nombre, int[][] puntuaciones, int[] estadoEquipos) {
		System.out.println("--- TABLA DE CLASIFICACIÓN ---");
		
		System.out.print("\t\t");
		for(int i=0; i<puntuaciones[0].length; i++) {
			System.out.print("J"+ i+"\t\t");
		}
		System.out.println("TOTAL");
		for(int f = 0; f<puntuaciones.length;f++) {
			System.out.print(nombre[f]+"\t\t");
			int total = 0;
			for(int c = 0; c<puntuaciones[f].length;c++) {
				System.out.print(puntuaciones[f][c]+"\t\t");
				total+=puntuaciones[f][c];
			}
			System.out.println(total);
		}
	}
	public static void menu4(String[] nombreEquipo, int[][] puntuaciones, int[] estadoEquipos) throws NumberFormatException, IOException {
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
		for(int i = 0; i<nombreEquipo.length;i++) {
			 nombreEquipo1= nombreEquipo[posequipo];
		}
		System.out.println("EQUIPO: "+ nombreEquipo1);
		
		boolean activo;
		for(int i = 0; i<estadoEquipos.length;i++) {
			
			if(estadoEquipos[posequipo]==0) {
				activo = true;
			}else {
				activo= false;
			}
		}
		if(activo = true) {
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
	public static void menu5(String[] nombreEquipo, int[][] puntuaciones, int[] estadoEquipos) throws NumberFormatException, IOException {
		
		System.out.println("--- DESCALIFICAR EQUIPO ---");
		System.out.println("EQUIPOS ACTIVOS:");
		for(int i = 0; i<nombreEquipo.length;i++) {
			System.out.println(i+". "+nombreEquipo[i]);
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
				System.out.println("¿Estás seguro de descalificar a "+nombreEquipo[equipoADescalificar]+"? (S/N): ");
				char descalificado = leerChar();
				if(descalificado=='S'){
					estadoEquipos[equipoADescalificar]=1;
					System.out.println(nombreEquipo[equipoADescalificar]+" ha sido descalificado del torneo");
				}else if(descalificado=='N') {
					System.out.println("No se descalificara al equipo.");
				}
			}else if(estadoEquipos[equipoADescalificar]==1) {
				System.out.println("Su equipo ya esta descalificado.");
			}			
	}
}




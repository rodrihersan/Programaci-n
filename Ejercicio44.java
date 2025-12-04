import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio44 {

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		
		int[][] faltas = new int[4][5];
		String[] alumnos = new String[4];
		String[] modulos  = new String[4];
		
		do {
			System.out.println("FALTAS COLEGIO");
			System.out.println("Opción 1: Registro de Alumnos Y Asignaturas");
			System.out.println("Opción 2: Registrar una falta..");
			System.out.println("Opción 3: Mostrar tabla");
			System.out.println("Opción 4: Perdida ev. continua");
			
			int opcion = leerInt("Introduce una opcion: ");
			
			switch(opcion) {
			case 1:
				opcion1(modulos, alumnos);
				break;
			case 2:
				opcion2(alumnos, modulos, faltas);
				break;
			case 3:
				opcion3(alumnos, modulos, faltas);
				break;
			case 4:
				opcion4(alumnos, modulos, faltas);
				break;
			default:
				System.out.println("Opcion no valida");
			}
			
		}while(!salir);

	}
	


	public static void opcion4(String[] alumnos, String[] modulos, int[][] faltas) {
		System.out.println("--EVALAUCION CONTINUA---");
		
		boolean perdida = false;
		for(int f=0; f<faltas.length; f++) {
			for(int c=0; c<faltas[f].length; c++) {
				if(faltas[f][c] >= 5) {
					System.out.println("El alumno " + alumnos[f] + "en la asignatura "
							   + modulos[c] + " ha perdido la evaluacion contunua pq tiene " + 
							   faltas[f][c] + "faltas");
					perdida = true;
				}
			}
		}
		
		if(perdida == false)
			System.out.println("Nadie ha perdido la evaluacion continua. Aun");
		
	}



	//OPCION 1
	public static void opcion1(String[] modulos, String[] alumnos) throws IOException {
		System.out.println("--REGISTRAR ALYUMNOS Y MODULOS---");
		
		for(int i = 0; i<alumnos.length; i++) {
			do {
				alumnos[i] = leerString("Introduce el nombre del alumno" + (i+1) + ": ");
				if(alumnos[i].isEmpty())
					System.out.println("El nombre del alumno no puede quedar vacio");
			}while(alumnos[i].isEmpty());
		}
		
		for(int i = 0; i<modulos.length; i++) {
			do {
				modulos[i] = leerString("Introduce el nombre del modulo" + (i+1) + ": ");
				if(modulos[i].isEmpty())
					System.out.println("El nombre del modulo no puede quedar vacio");
			}while(modulos[i].isEmpty());
		}
		
		//NO HACE FALTA INICIALIZAR LA MATRIZ PQ YA ES 0 AL SER DE INT
	}
	
	//opcion 2
	public static void opcion2(String[] alumnos, String[] modulos, int[][] faltas) throws IOException {
		System.out.println("---REGISTRAR FALTA ---");
		
		String nombre = leerString("Introduce el nombre del alumno a poner la falta: " );
		int indiceAlumno = -1;
		for(int i = 0; i<alumnos.length; i++) {
			if(nombre.equalsIgnoreCase(alumnos[i]))
				indiceAlumno = i;
			
		}
		if(indiceAlumno == -1)
			System.out.println("No se ha encontrado el alumno en la lista");
		
		String modulo = leerString("Introduce el nombre del modulo a poner la falta: " );
		int indiceModulo = -1;
		for(int i = 0; i<modulos.length; i++) {
			if(modulo.equalsIgnoreCase(modulos[i]))
				indiceModulo = i;
			
		}
		if(indiceModulo == -1)
			System.out.println("No se ha encontrado el modulo en la lista");
		
		if(indiceAlumno != -1 && indiceModulo != -1) {
			faltas[indiceAlumno][indiceModulo] = leerInt("Introduce el numero de faltas para el alumno " + nombre +
					" en la asignatura " + modulo);
			System.out.println("Falta registrada correctamente");
		}else {
			System.out.println("No se ha pdido registrar la falta pq "
					+ "no se ha encontrado el alumno o el modulo");
		}
	}

	//OPCION 3
	public static void opcion3(String[] alumnos, String[] modulos, int[][] faltas) {
		System.out.println("-- MOSTRAR TABLA -- ");
		
		System.out.print("\t\t");
		for(int i=0; i<modulos.length; i++) {
			System.out.print(modulos[i] + "\t\t");
		}
		System.out.println("");
		
		for(int f=0; f<faltas.length; f++) {
			System.out.print(alumnos[f] + "\t\t");
			for(int c=0; c<faltas[f].length; c++) {
				System.out.print(faltas[f][c] + "\t\t" );
			}
			System.out.println();
		}
		
		int posConMasFaltas = -1;
		int faltasMayor = -1;
		for(int f=0; f<faltas.length; f++) {
			int sumaFaltas = 0;
			for(int c=0; c<faltas[f].length; c++) {
				sumaFaltas += faltas[f][c];
				if(sumaFaltas > faltasMayor) {
					posConMasFaltas = f;
					faltasMayor = sumaFaltas;
				}
			}
		}
		
		System.out.println("El alumno que más faltas tiene es " + alumnos[posConMasFaltas] + " con " 
		                            + faltasMayor);
		
		int moduloMayor = -1;
		int posConModuloMasFaltas = -1;
		for(int c=0; c<faltas[0].length; c++) {
			int sumaFaltas = 0;
			for(int f=0; f<faltas.length; f++) {
				sumaFaltas += faltas[f][c];
				if(sumaFaltas > moduloMayor) {
					posConModuloMasFaltas = f;
					moduloMayor = sumaFaltas;
				}
			}
		}
		
		System.out.println("El modulo que más faltas tiene es " + modulos[posConModuloMasFaltas] + " con " 
                + moduloMayor);
		
		
	}

	//Metodos leer
	public static int leerInt(String mensaje) throws IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean valido = false;
		int num = -1;
		do {
			try {
				System.out.print(mensaje);
				num = Integer.parseInt(leer.readLine());
				valido = true;
			}catch(NumberFormatException e) {
				System.out.println("Introduce un numero valido");
			}
		}while(!valido);
		return num;
	}
	
	public static String leerString(String mensaje) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		return leer.readLine();
	}
}
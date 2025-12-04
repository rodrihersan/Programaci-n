package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.IOException;

public class ejercicio44 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		String[] alumnos = new String[4];
        String[] modulos = new String[5];
        int[][] faltas = new int [4][5];
        
        boolean salir = false;
        int opcion;

        do {
            System.out.println("--- CONTROL DE ASISTENCIA FP DAW ---");
            System.out.println();
            System.out.println("1. Rellenar alumnos y módulos + inicializar faltas");
            System.out.println("2. Registrar falta");
            System.out.println("3. Mostrar tabla completa");
            System.out.println("4. Mostrar alumnos que pierden evaluación continua");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = leerIntPositivo();

            switch (opcion) {

                case 1:rellenarDatos(alumnos, modulos, faltas);break;
                case 2:registrarFalta(alumnos, modulos, faltas);break;
                case 3:mostrarTabla(alumnos, modulos, faltas);break;
                case 4:mostrarPerdidaEvaluacion(alumnos, modulos, faltas);break;
                case 5:salir = true;System.out.println("Saliendo...");break;
                default:System.err.println("Opción no válida.");
            }
        } while (!salir);
    }

//case1
	
	public static void rellenarDatos(String[] alumnos, String[] modulos, int[][] faltas) throws IOException {
		System.out.println("---REGISTRO ALUMNOS Y MODULO---");
		System.out.println();
		
        System.out.println("--- INTRODUCIR ALUMNOS ---");
        System.out.println();
        
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print("Alumno " + (i + 1) + ": ");
            alumnos[i] = leerLinea();
        }

        System.out.println("--- INTRODUCIR MÓDULOS ---");
        System.out.println();
        
        for (int i = 0; i < modulos.length; i++) {
            System.out.print("Módulo " + (i + 1) + ": ");
            modulos[i] = leerLinea();
        }

        // Inicializar matriz a 0 (NO HACE FALTA HACERLO PORQUE LA MATRIZ EMPIEZA EN 0 YA)	
        for (int i = 0; i < faltas.length; i++) {
            for (int j = 0; j < faltas[i].length; j++) {
                faltas[i][j] = 0;
            }
        }

        System.out.println("Datos cargados e inicializados correctamente.");
    }

//case2
	
	 public static void registrarFalta(String[] alumnos, String[] modulos, int[][] faltas) throws IOException {

	        System.out.println("--- REGISTRAR FALTA ---");
	        System.out.println();
	        
	        System.out.print("Nombre del alumno: ");
	        int indiceAlumno = -1;
	        String alumno = leerLinea();
	        
	        for(int i=0; i<alumnos.length;i++) {
	        	if(alumno.equalsIgnoreCase(alumnos[i]))
	        		indiceAlumno = i;
	        }
	        if(indiceAlumno == -1)
	        	System.out.println("No se ha encontrado el alumno en la lista");
	        
	        System.out.print("Nombre del modulo: ");
	        String modulo = leerLinea();
	        int indiceModulo = -1;
	        
	        for(int i=0; i<modulo.length();i++) {
	        	if(modulo.equalsIgnoreCase(modulos[i]))
	        		indiceModulo = i;
	        }
	        if(indiceAlumno == -1)
	        	System.out.println("No se ha encontrado el modulo en la lista");
	        
	        if(indiceAlumno != -1 && indiceModulo != -1) {
	        	System.out.println("Introduce el numero de faltas para el alumno " + alumno + "en la asignatura " + modulo);
	        	faltas[indiceAlumno][indiceModulo] = leerIntPositivo();
	        	System.out.println("Falta registrada correctamente");
	        }else {
	        	System.out.println("No se ha podido registrar la falta porque no se ha encontrado el alumno o modulo");
	        }
	 }

	        /*int posAlumno = buscar(alumno, alumnos);
	        if (posAlumno == -1) {
	            System.err.println("El alumno no existe.");
	            return;
	        }

	        System.out.print("Nombre del módulo: ");
	        String modulo = leerLinea();

	        int posModulo = buscar(modulo, modulos);
	        if (posModulo == -1) {
	            System.err.println("El módulo no existe.");
	            return;
	        }

	        System.out.print("Número de faltas a añadir: ");
	        int n = leerIntPositivo();

	        faltas[posAlumno][posModulo] += n;

	        System.out.println("Faltas registradas correctamente.");*/
	    //}
	 
//case3
	 
	 public static void mostrarTabla(String[] alumnos, String[] modulos, int[][] faltas) {
		 System.out.println("--- TABLA DE FALTAS ---");
		 System.out.println();
		 
		    System.out.print("\t");

		    // ENCABEZADOS
		    for (int i = 0; i < modulos.length; i++) {
		        System.out.print(modulos[i] + "\t");
		    }
		    System.out.println("");

		    // FILAS
		    for (int f = 0; f < faltas.length; f++) {
		        System.out.print(alumnos[f] + "\t");

		        for (int c = 0; c < faltas.length; c++) {
		            System.out.print(faltas[f][c] + "\t");
		        }
		        System.out.println();
		    }
	// Alumno con más faltas TOTAL
	        int posConMasFaltas = -1;
	        int faltasMayor = -1;
	        for (int f = 0; f < faltas.length; f++) {
	            int sumaFaltas = 0;
	            for (int c = 0; c < faltas[f].length; c++) {
	            	sumaFaltas += faltas[f][c];
	            }
	            if (sumaFaltas > faltasMayor) {
	            	posConMasFaltas = f;
	            	faltasMayor = sumaFaltas;
	            }
	        }
	        System.out.println("Alumno con más faltas: " + alumnos[posConMasFaltas] + " con " + faltasMayor + " faltas)");

	    // Módulo más faltado
	        int moduloMayor = -1;
	        int posConModuloMasFaltas = -1;
	        for (int c = 0; c < faltas[0].length; c++) {
	        	int sumaFaltas =0;
	        	for(int f=0; f<faltas.length; f++) {
	        		sumaFaltas += faltas[f][c];
	        		if(sumaFaltas > moduloMayor) {
	        			posConModuloMasFaltas = f;
	        			faltasMayor = sumaFaltas;
	        		}
	        	}
	        }
	        System.out.println("El modulo que más faltas tiene es " + modulos[posConModuloMasFaltas] + " con " 
	                + moduloMayor);
	 	}
	          
//Case4
	    public static void mostrarPerdidaEvaluacion(String[] alumnos, String[] modulos, int[][] faltas) {
	        System.out.println("--- ALUMNOS QUE PIERDEN EVALUACIÓN CONTINUA ---");
	        System.out.println();
	        
	        boolean perdida = false;
	        for (int f = 0; f < alumnos.length; f++) {
	            for (int c = 0; c < modulos.length; c++) {
	                if (faltas[f][c] >= 5) {
	                    System.out.println(alumnos[f] + " ha perdido EC en " + modulos[c] + " (" + faltas[f][c] + " faltas)");
	                    perdida = true;
	                }
	            }
	        }
	        if (perdida == false) {
	            System.out.println("Ningún alumno ha perdido evaluación continua.");
	        }
	    }
	    
//MÉTODOS AUXILIARES
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
        char c = texto.charAt(i);

        //distinto abc.. mayus y minus
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
            return false;
        }
    }
    return true;
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

	public static int buscar(String texto, String[] array) {
	    for (int i = 0; i < array.length; i++) {
	        if (texto.equalsIgnoreCase(array[i])) {
	            return i;
	        }
	    }
	    return -1;
	}
}


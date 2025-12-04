package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio45 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] autoresLibros = new String[3];
        String[] tituloLibros = new String[4];
        int[][] prestado = new int [4][3];
        
        boolean salir = false;
        int opcion;

        do {
            System.out.println("--- CONTROL DE PRESTAMOS BIBLIOTECA ---");
            System.out.println();
            System.out.println("1. Rellenar alumnos y módulos + inicializar faltas");
            System.out.println("2. Registrar falta");
            System.out.println("3. Mostrar tabla completa");
            System.out.println("4. Mostrar alumnos que pierden evaluación continua");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = leerIntPositivo();

            switch (opcion) {

                case 1:rellenarDatos(autoresLibros, tituloLibros, prestado);break;
                //case 2:registrarFalta(alumnos, modulos, faltas);break;
                //case 3:mostrarTabla(alumnos, modulos, faltas);break;
                //case 4:mostrarPerdidaEvaluacion(alumnos, modulos, faltas);break;
               case 5:salir = true;System.out.println("Saliendo...");break;
                default:System.err.println("Opción no válida.");
            }
        } while (!salir);
    }
	
//Case1	
	public static void rellenarDatos(String[] autoresLibros, String[] tituloLibros, int[][] prestado) throws IOException {
		System.out.println("---REGISTRO AUTORES Y LIBROS---");
		System.out.println();
		
        System.out.println("--- INTRODUCIR AUTORES ---");
        System.out.println();
        
        for (int i = 0; i < autoresLibros.length; i++) {
            System.out.print("Autores " + (i + 1) + ": ");
            autoresLibros[i] = leerLinea();
        }

        System.out.println("--- INTRODUCIR LIBROS ---");
        System.out.println();
        
        for (int i = 0; i < tituloLibros.length; i++) {
            System.out.print("Libros " + (i + 1) + ": ");
            tituloLibros[i] = leerLinea();
        }

        // Inicializar matriz a 0 (NO HACE FALTA HACERLO PORQUE LA MATRIZ EMPIEZA EN 0 YA)	
        for (int i = 0; i < prestado.length; i++) {
            for (int j = 0; j < prestado[i].length; j++) {
            	prestado[i][j] = 0;
            }
        }

        System.out.println("Datos cargados e inicializados correctamente.");
    }
	
//Case2
	
	public static void registrarFalta(String[] autoresLibros, String[] tituloLibros, int[][] prestado) throws IOException {

        System.out.println("--- REGISTRAR FALTA ---");
        System.out.println();
        
        System.out.print("Nombre del autor: ");
        int indiceAutor = -1;
        String autor = leerLinea();
        
        for(int i=0; i<autor.length;i++) {
        	if(autor.equalsIgnoreCase(autor[i]))
        		indiceAutor = i;
        }
        if(indiceAutor == -1)
        	System.out.println("No se ha encontrado el alumno en la lista");
        
        System.out.print("Nombre del libro: ");
        String libro = leerLinea();
        int indiceLibro = -1;
        
        for(int i=0; i<libro.length();i++) {
        	if(libro.equalsIgnoreCase(libro[i]))
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
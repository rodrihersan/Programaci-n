package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio45 {
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

	        // comprobamos si no es letra mayúscula ni minúscula
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
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

	public static void main(String[] args) throws NumberFormatException, IOException{
		 String[] autores = new String[4];
	        String[] titulos = new String[3];
	        int[][] prestamos = new int[4][3];

	        boolean salir = false;
	        int opcion;

	        do {
	            System.out.println("\n--- SISTEMA DE PRÉSTAMOS DE BIBLIOTECA ---");
	            System.out.println("1. Rellenar autores y títulos + inicializar matriz");
	            System.out.println("2. Registrar préstamo");
	            System.out.println("3. Mostrar tabla");
	            System.out.println("4. Mostrar libros best-seller (>35 préstamos)");
	            System.out.println("5. Salir");
	            System.out.print("Selecciona una opción: ");

	            opcion = leerIntPositivo();

	            switch (opcion) {
	                case 1:rellenarDatos(autores, titulos, prestamos); break;
	                case 2:registrarPrestamo(autores, titulos, prestamos);break;
	                case 3:mostrarTabla(autores, titulos, prestamos);break;
	                case 4:mostrarBestSellers(autores, titulos, prestamos);break;
	                case 5:salir = true;System.out.println("Saliendo...");break;
	                default:System.err.println("Opción no válida.");
	            }
	        } while (!salir);
	    }
	
//case1
	public static void rellenarDatos(String[] autores, String[] titulos, int[][] prestamos) throws IOException {

        System.out.println("--- INTRODUCIR AUTORES ---");
        System.out.println();
        
        for (int i = 0; i < autores.length; i++) {
            System.out.print("Autor " + (i + 1) + ": ");
            autores[i] = leerLinea();
        }

        System.out.println("--- INTRODUCIR TÍTULOS ---");
        System.out.println();
        for (int i = 0; i < titulos.length; i++) {
            System.out.print("Título " + (i + 1) + ": ");
            titulos[i] = leerLinea();
        }

        // Inicializar la matriz. 
        for (int i = 0; i < prestamos.length; i++) {
            for (int j = 0; j < prestamos[i].length; j++) {
                prestamos[i][j] = 0;
            }
        }
        System.out.println("Datos cargados correctamente.");
    }
	
//case2
	public static void registrarPrestamo(String[] autores, String[] titulos, int[][] prestamos) throws IOException {
		System.out.println("---REGISTRAR PRESTAMO ---");
		System.out.println();
		
		System.out.println("Introduce el nombre del autor: ");
		String autor = leerLinea();
		int indiceAutor = -1;
		
		for(int i = 0; i<autores.length; i++) {
			if(autor.equalsIgnoreCase(autores[i])) {
				indiceAutor = i;
				}
			}
		
		if(indiceAutor == -1) {
			System.err.println("No se ha encontrado al autor en la lista");
			}
		
		System.out.println("Introduce el nombre del título del libro: ");
		String titulo = leerLinea();
		int indiceTitulo = -1;
		
		for(int i = 0; i<titulos.length; i++) {
			if(titulo.equalsIgnoreCase(titulos[i])) {
				indiceTitulo = i;
				}
			}
		
		if(indiceTitulo == -1) {
			System.err.println("No se ha encontrado el título en la lista");
			}
		
		 if (indiceAutor != -1 && indiceTitulo != -1) {
			 System.out.print("Introduce el número de préstamos: ");
			 int veces = leerIntPositivo();

			 prestamos[indiceAutor][indiceTitulo] += veces;

			 System.out.println("Préstamo registrado correctamente.");
		 }else{
			 System.err.println("No se ha podido registrar el préstamo porque autor o título no son válidos.");
			 }
		 }
	
//Case3
public static void mostrarTabla(String[]autores, String[]titulos, int[][]prestamos) {
	System.out.println("---MOSTRAR TABLA---");
	System.out.print("\t");
	
	for(int i=0; i<titulos.length; i++) {
		System.out.print(titulos[i] + "\t");
	}
	System.out.println("");
	
	for(int f=0; f<autores.length; f++) {
		System.out.print(autores[f] + "\t\t");
		for(int c=0; c<prestamos[f].length; c++) {
			System.out.print(prestamos[f][c] + "\t\t" );
		}
		System.out.println();
	}
	
	int posAutorMasPrestamos = -1;
	int maxPrestamosAutor = -1;
	for(int f=0; f<prestamos.length; f++) {
		int sumaPrestamos = 0;
		for(int c=0; c<prestamos[f].length; c++) {
			sumaPrestamos += prestamos[f][c];
		}
			if(sumaPrestamos > maxPrestamosAutor) {
				posAutorMasPrestamos = f;
				maxPrestamosAutor = sumaPrestamos;	
		}
	}
	if (posAutorMasPrestamos != -1) {
	System.out.println("El autor que más se presta es " + autores[posAutorMasPrestamos] + " con " 
	                            + maxPrestamosAutor + " préstamos.");
	}
	
	int posTituloMenosPrestado = -1;
	int minPrestamos = -1;
	int totalPrestamosGeneral = 0; // Para comprobar si la matriz está vacía
			
	for(int c=0; c<prestamos[0].length; c++) {
		int sumaPrestamos = 0;
		for(int f=0; f<prestamos.length; f++) {
			sumaPrestamos += prestamos[f][c];
		}
		totalPrestamosGeneral += sumaPrestamos;
		if(minPrestamos == -1 || sumaPrestamos < minPrestamos) { 
			posTituloMenosPrestado = c;
			minPrestamos = sumaPrestamos;
		}
	}
	
	if (totalPrestamosGeneral > 0) {
        System.out.println("El libro que menos se presta es " + titulos[posTituloMenosPrestado] + " con " 
                + minPrestamos+ " préstamos.");
    } else {
         System.out.println("No hay préstamos registrados para calcular el más/menos prestado.");
    }
}
//CASE4
	public static void mostrarBestSellers(String[] autores, String[] titulos, int[][] prestamos) {
	    System.out.println("--BEST-SELLERS---");
	    System.out.println();
	
	    boolean bestseller = false;
	    for(int f=0; f<prestamos.length; f++) {
	        for(int c=0; c<prestamos[f].length; c++) {
	            if(prestamos[f][c] > 35) {
	                System.out.println("El libro " + titulos[c] + " del autor " 
	                    + autores[f] + " ha sido prestado " + prestamos[f][c] + " veces y es un best-seller");
	                bestseller = true;
	            }
	        }
	    }
	    if(bestseller == false)
	        System.out.println("Ningún libro ha superado los 35 préstamos. Aún :)");
	    }
	}


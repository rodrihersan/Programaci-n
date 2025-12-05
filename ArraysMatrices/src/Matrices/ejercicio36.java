package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio36 {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		char [][] butacas = new char [6][8];
		
		for(int fila = 0; fila<butacas.length; fila++)
			for(int columna = 0; columna < butacas[fila].length;columna++)
				butacas[fila][columna] = 'L';
		do {
			System.out.println("=== RESERVA DE ASIENTOS ===");
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("--- MENÚ PRINCIPAL ---");
			System.out.println("1. Mostrar mapa de asientos");
			System.out.println("2. Reservar asiento");
			System.out.println("3. Cancelar reserva");
			System.out.println("4. Contar asientos libres y ocupados");
			System.out.println("5. Mostrar qué fila tiene más asientos libres");
			System.out.println("6. Comprobar si una fila específica está completamente llena");
			System.out.println("7. Mostrar porcentaje de ocupación del cine");
			System.out.println("8. Reiniciar sala");
			System.out.println("9. Salir");
			
			System.out.print("Elige una opción: ");
			int opcion = leerIntPositivo();

			switch (opcion) {			
				case 1:mapaAsientos(butacas);break;
				case 2:reservaAsientos(butacas);break;
				case 3:cancelarReserva(butacas);break;
				case 4:contarAsientos(butacas);break;
				case 5:mostrarAsientosFila(butacas);break;
				case 6:comprobarFilaLlena(butacas);break;
				case 7:porcentajeOcupacion(butacas);break;
				case 8:reiniciarSala(butacas);break;
				case 9:salir = true;
				System.out.println("Saliendo de la aplicación");break;
				default:System.err.println("Opción no válida");
				}
			} while (!salir);
		}
	
	//case1
	public static void mapaAsientos(char[][] butacas) throws NumberFormatException, IOException {

		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				System.out.print(butacas[fila][columna] + "|");
			}
			System.out.println();
		}
	}
		
	//Case2
	public static void reservaAsientos(char[][] butacas)  throws NumberFormatException, IOException{
		System.out.print("Introduce la fila");
		int f = leerIntPositivo();
		
		System.out.print("Introduce la columna");
		int c = leerIntPositivo();
		
		boolean encontrado = false;
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(fila == f && columna == c) {
					encontrado = true;
					if(butacas[fila][columna] == 'L') {
						butacas[fila][columna] = 'X';
						System.out.println("Asiento reservado correctamente");
					}else {
						System.out.println("No se puede reservar asiento. Esta ocupado");
					}
				}
			}
		}
		if(encontrado == false)
			System.out.println("Has introducido una fila y/o una columna que no existen");
		}
	
	//Case3
	public static void cancelarReserva(char[][] butacas)  throws NumberFormatException, IOException{
		System.out.print("Introduce la fila");
		int f = leerIntPositivo();
		
		System.out.print("Introduce la columna");
		int c = leerIntPositivo();
		
		boolean encontrado = false;
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(fila == f && columna == c) {
					encontrado = true;
					if(butacas[fila][columna] == 'X') {
						butacas[fila][columna] = 'L';
					}else {
						System.out.println("Reserva cancelada correctamente");
					}System.out.println("No se puede cancelar porque ya esta libre");
				}
			}
		}
		if(encontrado == false)
			System.out.println("Has introducido una fila y una columna que no existen");
		}

	//case4
	public static void contarAsientos(char[][] butacas)  throws NumberFormatException, IOException{
		int asientosLibres = 0;
		int asientosOcupados = 0;
		
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(butacas[fila][columna] == 'L') {
					asientosLibres++;
				}else if(butacas[fila][columna] == 'X'){
					asientosOcupados++;
				}
			}
		}
		System.out.println("Asientos totales: " + (asientosLibres+asientosOcupados));
		System.out.println("Asientos libres: "+ (asientosLibres));
		System.out.println("Asientos ocupados: "+ (asientosOcupados));
	}
	
	//case5
	public static void mostrarAsientosFila(char[][] butacas)  throws NumberFormatException, IOException{
		int filaMax = 0;
        int maxLibres = -1;

        for (int fila = 0; fila < butacas.length; fila++) {
            int contador = 0;
            for (int col = 0; col < butacas[fila].length; col++)
                if (butacas[fila][col] == 'L')
                    contador++;

            if (contador > maxLibres) {
                maxLibres = contador;
                filaMax = fila;
            }
        }

        System.out.println("La fila con más asientos libres es la " + filaMax + " con " + maxLibres + " libres.");
    }

	//case6
	public static void comprobarFilaLlena(char[][] butacas) throws IOException {
		System.out.println("Introduce la fila a comprobar (0-5): ");
        int f = leerIntPositivo();
        if (f < 0 || f >= butacas.length) {
            System.out.println("Fila inválida.");
            return;
        }

        boolean llena = true;
        for (int col = 0; col < butacas[f].length; col++)
            if (butacas[f][col] == 'L')
                llena = false;

        if (llena)
            System.out.println("La fila " + f + " está completamente llena.");
        else
            System.out.println("La fila " + f + " tiene asientos libres.");
    }
	
	//case7
	public static void porcentajeOcupacion(char[][] butacas) {
        int ocupados = 0;
        int total = butacas.length * butacas[0].length;

        for (int fila = 0; fila < butacas.length; fila++)
            for (int col = 0; col < butacas[fila].length; col++)
                if (butacas[fila][col] == 'X')
                    ocupados++;

        double porcentaje = (ocupados * 100.0) / total;
        System.out.printf("Porcentaje de ocupación: %.2f%%\n", porcentaje);
    }
	
	//case8
	 public static void reiniciarSala(char[][] butacas) {
	        for (int fila = 0; fila < butacas.length; fila++)
	            for (int col = 0; col < butacas[fila].length; col++)
	                butacas[fila][col] = 'L';
	        System.out.println("Sala reiniciada. Todos los asientos están libres.");
	    }
	}
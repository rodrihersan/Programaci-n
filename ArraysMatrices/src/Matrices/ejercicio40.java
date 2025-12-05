package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio40 {
	
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

	public static void main(String[] args)throws NumberFormatException, IOException {
		int[][] tablero = new int[3][3]; 
        int opcion;
        boolean salir = false;
        
        do {
        	System.out.println("\n--- MENU TRES EN RAYA ---");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Mostrar tablero");
            System.out.println("3. Turno jugador 1 (X)");
            System.out.println("4. Turno jugador 2 (O)");
            System.out.println("5. Comprobar ganador");
            System.out.println("6. Comprobar empate");
            System.out.println("7. Reiniciar partida");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = leerIntPositivo();

            switch (opcion) {

            case 1:iniciarJuego(tablero);break;
            //case 2:mostrarTablero(tablero);break;
            //case 3:jugarTurno(tablero, 1);break;
            //case 4:jugarTurno(tablero, 2);break;
            //case 5:comprobarGanador(tablero);break;
            //case 6:comprobarEmpate(tablero);break;
            //case 7:iniciarJuego(tablero);System.out.println("Partida reiniciada.");break;
            case 8:salir = true;System.out.println("Saliendo...");break;
            default:System.err.println("Opción inválida.");
            }
        } while(!salir);
    }
	
	//case1
	public static void iniciarJuego(int[][] tablero) {
        for (int f = 0; f < 3; f++)
            for (int c = 0; c < 3; c++)
                tablero[f][c] = 0;

        System.out.println("Juego iniciado.");
    }
	
	//case2
	public static void mostrarTablero(int[][] tablero) {

        System.out.println("\n--- TABLERO ---");

        for (int f = 0; f < 3; f++) {

            for (int c = 0; c < 3; c++) {

                if (tablero[f][c] == 0)
                    System.out.print("- ");
                else if (tablero[f][c] == 1)
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }

            System.out.println();
        }
    }
	
	//case3y4
	 public static void jugarTurno(int[][] tablero, int jugador) throws IOException {

	        System.out.println("\nTurno del jugador " + jugador + 
	                           (jugador == 1 ? " (X)" : " (O)") );

	        int fila, columna;

	        do {
	            System.out.print("Fila (0-2): ");
	            fila = leerIntPositivo();

	            System.out.print("Columna (0-2): ");
	            columna = leerIntPositivo();

	            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
	                System.err.println("Coordenadas fuera del tablero.");
	            } else if (tablero[fila][columna] != 0) {
	                System.err.println("La casilla ya está ocupada.");
	            } else {
	                break;
	            }

	        } while (true);

	        tablero[fila][columna] = jugador;
	        System.out.println("Movimiento registrado.");
	    }
	 
	 //case5
	 public static void comprobarGanador(int[][] tablero) {

	        // Filas
	        for (int f = 0; f < 3; f++) {
	            if (tablero[f][0] != 0 &&
	                tablero[f][0] == tablero[f][1] &&
	                tablero[f][1] == tablero[f][2]) {

	                System.out.println("Ganador: Jugador " + tablero[f][0]);
	                return;
	            }
	        }

	        // Columnas
	        for (int c = 0; c < 3; c++) {
	            if (tablero[0][c] != 0 &&
	                tablero[0][c] == tablero[1][c] &&
	                tablero[1][c] == tablero[2][c]) {

	                System.out.println("Ganador: Jugador " + tablero[0][c]);
	                return;
	            }
	        }

	        // Diagonal principal
	        if (tablero[0][0] != 0 &&
	            tablero[0][0] == tablero[1][1] &&
	            tablero[1][1] == tablero[2][2]) {

	            System.out.println("Ganador: Jugador " + tablero[0][0]);
	            return;
	        }

	        // Diagonal inversa
	        if (tablero[0][2] != 0 &&
	            tablero[0][2] == tablero[1][1] &&
	            tablero[1][1] == tablero[2][0]) {

	            System.out.println("Ganador: Jugador " + tablero[0][2]);
	            return;
	        }

	        System.out.println("No hay ganador todavía.");
	    }
	 
	 //case6
	 public static void comprobarEmpate(int[][] tablero) {

	        for (int f = 0; f < 3; f++)
	            for (int c = 0; c < 3; c++)
	                if (tablero[f][c] == 0) {
	                    System.out.println("Aún no hay empate, quedan casillas libres.");
	                    return;
	                }

	        // Si está lleno, revisar si había ganador
	        System.out.println("El tablero está lleno. Si no hay ganador, es empate.");
	    }	 
}

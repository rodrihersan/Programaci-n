package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio38 {

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
		boolean salir = false;
		
		int[][] tablero = new int[5][5];          		// minas y números
        boolean[][] descubiertas = new boolean[5][5]; 	// casillas destapadas
        
		do{
            System.out.println("\n--- MENÚ BUSCAMINAS ---");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Mostrar tablero oculto");
            System.out.println("3. Descubrir casilla");
            System.out.println("4. Mostrar casillas descubiertas");
            System.out.println("5. Comprobar si ha ganado");
            System.out.println("6. Ver solución");
            System.out.println("7. Reiniciar juego");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            int op = leerInt();

            switch (op) {
                case 1: iniciarJuego(tablero,descubiertas); break;
                case 2: mostrarOculto(); break;
                case 3: descubrirCasilla(tablero,descubiertas); break;
                case 4: mostrarDescubiertas(tablero,descubiertas); break;
                case 5: comprobarVictoria(tablero,descubiertas); break;
                case 6: verSolucion(tablero); break;
                case 7: reiniciar(tablero,descubiertas); break;
                case 8: salir = true;System.out.println("¡Hasta luego!");break;
                default:System.err.println("Opción no válida.");
            }
        }while(!salir);
	}
	
	//case1
	public static void iniciarJuego(int[][] tablero, boolean[][] descubiertas) {

        // limpiar tablero
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = 0;
                descubiertas[i][j] = false;
            }

        // colocar 5 minas
        int minas = 0;
        while (minas < 5) {

            int f = (int) (Math.random() * 5);
            int c = (int) (Math.random() * 5);

            if (tablero[f][c] != -1) {
                tablero[f][c] = -1;
                minas++;
            }
        }
        System.out.println("Juego iniciado, minas colocadas.");
    }
	
	//case2
	public static void mostrarOculto() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print("? ");
            System.out.println();
        }
    }
	
	//case3
	public static void descubrirCasilla(int[][] tablero, boolean[][] descubiertas) throws IOException {

        System.out.println("Introduce fila (0-4): ");
        int f = leerIntPositivo();
        while (f < 0 || f > 4) {
            System.err.println("ERROR. Valor fuera de rango.");
            f = leerIntPositivo();
        }

        System.out.println("Introduce columna (0-4): ");
        int c = leerIntPositivo();
        while (c < 0 || c > 4) {
            System.err.println("ERROR. Valor fuera de rango.");
            c = leerIntPositivo();
        }

        if (tablero[f][c] == -1) {
            System.out.println("¡¡BOOM!! Game Over.");
            descubiertas[f][c] = true;
            return;
        }

        // contar minas alrededor
        int cuenta = 0;

        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {

                if (i >= 0 && i < 5 && j >= 0 && j < 5) {
                    if (tablero[i][j] == -1)
                        cuenta++;
                }
            }
        }
        tablero[f][c] = cuenta;
        descubiertas[f][c] = true;

        System.out.println("Casilla destapada: " + cuenta + " minas cerca.");
    }
	
	//case4
	public static void mostrarDescubiertas(int[][] tablero, boolean[][] descubiertas) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (descubiertas[i][j]) {
                    if (tablero[i][j] == -1)
                        System.out.print("* ");
                    else
                        System.out.print(tablero[i][j] + " ");
                } else {
                    System.out.print("? ");
                }
            }
            System.out.println();
        }
    }
	
	//case5
	 public static void comprobarVictoria(int[][] tablero, boolean[][] descubiertas) {

	        for (int i = 0; i < 5; i++)
	            for (int j = 0; j < 5; j++)
	                if (tablero[i][j] != -1 && !descubiertas[i][j]) {
	                    System.out.println("Todavía no has ganado.");
	                    return;
	                }

	        System.out.println("¡¡HAS GANADO!!");
	    }
	 
	 //case6
	 public static void verSolucion(int[][] tablero) {

	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {

	                if (tablero[i][j] == -1)
	                    System.out.print("* ");
	                else
	                    System.out.print(tablero[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	 
	 //case7
	 public static void reiniciar(int[][] tablero, boolean[][] descubiertas) {
	        iniciarJuego(tablero, descubiertas);
	    }
}



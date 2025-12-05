package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio37 {

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
			
			int[][] notas = new int[5][4];
		    boolean salir = false;

		    do {
		        System.out.println("\n--- MENÚ ---");
		        System.out.println("1. Introducir notas");
		        System.out.println("2. Mostrar tabla");
		        System.out.println("3. Media por alumno");
		        System.out.println("4. Media por asignatura");
		        System.out.println("5. Mejor alumno");
		        System.out.println("6. Mejor asignatura");
		        System.out.println("7. Alumnos que aprobaron todo");
		        System.out.println("8. Alumnos con suspensos");
		        System.out.println("9. Modificar nota");
		        System.out.println("10. Salir");
		        System.out.print("Opción: ");

		        int op = leerInt();

		        switch (op) {
		            case 1:introducirNotas(notas);break;
		            case 2:mostrarTabla(notas);break;
		            case 3:mediaPorAlumno(notas);break;
		            case 4:mediaPorAsignatura(notas);break;
		            case 5:mejorAlumno(notas);break;
		            case 6:mejorAsignatura(notas);break;
		            case 7:aprobaronTodo(notas);break;
		            case 8:algunSuspenso(notas);break;
		            case 9: modificarNota(notas);break;
		            case 10:salir = true; System.out.println("Saliendo...");break;
		            default:System.err.println("Opción no válida.");
		        }
		} while (!salir);
	}
		//case1
		public static void introducirNotas(int[][] notas) throws IOException {
	        System.out.println("-- INTRODUCIR NOTAS --");

	        for (int i = 0; i < notas.length; i++) {
	            System.out.println("Alumno " + (i + 1));
	            for (int j = 0; j < notas[i].length; j++) {
	                System.out.print("  Asignatura " + (j + 1) + ": ");

	                int nota = leerIntPositivo();
	                while (nota < 0 || nota > 10) {
	                    System.err.println("La nota debe estar entre 0 y 10.");
	                    System.out.print("  Asignatura " + (j + 1) + ": ");
	                    nota = leerIntPositivo();
	                }
	                notas[i][j] = nota;
	            }
	        }   
	    }
		
		//case2
		public static void mostrarTabla(int[][] notas) {
	        System.out.println("-- TABLA COMPLETA --");

	        for (int i = 0; i < notas.length; i++) {
	            System.out.print("Alumno " + (i + 1) + ": ");
	            for (int j = 0; j < notas[i].length; j++) {
	                System.out.print(notas[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
		
		//case3		
		public static void mediaPorAlumno(int[][] notas) {
	        System.out.println("-- MEDIA DE CADA ALUMNO --");

	        for (int i = 0; i < notas.length; i++) {
	            int suma = 0;
	            for (int j = 0; j < notas[i].length; j++) {
	                suma += notas[i][j];
	            }
	            double media = suma / 4.0;
	            System.out.println("Alumno " + (i + 1) + ": " + media);
	        }
	    }
		
		//case4
		public static void mediaPorAsignatura(int[][] notas) {
	        System.out.println("-- MEDIA DE CADA ASIGNATURA --");

	        for (int j = 0; j < notas[0].length; j++) {
	            int suma = 0;
	            for (int i = 0; i < notas.length; i++) {
	                suma += notas[i][j];
	            }
	            double media = suma / 5.0;
	            System.out.println("Asignatura " + (j + 1) + ": " + media);
	        }
	    }
		
		//case5
		public static void mejorAlumno(int[][] notas) {
	        int posMejor = -1;
	        double mejorMedia = -1;

	        for (int i = 0; i < notas.length; i++) {
	            int suma = 0;
	            for (int j = 0; j < notas[i].length; j++) suma += notas[i][j];
	            double media = suma / 4.0;

	            if (media > mejorMedia) {
	                mejorMedia = media;
	                posMejor = i;
	            }
	        }

	        System.out.println("El mejor alumno es el Alumno " + (posMejor + 1)
	                + " con media " + mejorMedia);
	    }
		
		//case6
		public static void mejorAsignatura(int[][] notas) {
	        int posMejor = -1;
	        double mejorMedia = -1;

	        for (int j = 0; j < notas[0].length; j++) {
	            int suma = 0;
	            for (int i = 0; i < notas.length; i++) suma += notas[i][j];

	            double media = suma / 5.0;

	            if (media > mejorMedia) {
	                mejorMedia = media;
	                posMejor = j;
	            }
	        }

	        System.out.println("La mejor asignatura es la " + (posMejor + 1)
	                + " con media " + mejorMedia);
	    }

		//case7
		public static void aprobaronTodo(int[][] notas) {
	        int contador = 0;

	        for (int i = 0; i < notas.length; i++) {
	            boolean todoAprobado = true;

	            for (int j = 0; j < notas[i].length; j++) {
	                if (notas[i][j] < 5) {
	                    todoAprobado = false;
	                }
	            }

	            if (todoAprobado) contador++;
	        }

	        System.out.println("Alumnos que aprobaron todo: " + contador);
	    }
		
		//case8
		public static void algunSuspenso(int[][] notas) {
	        System.out.println("-- ALUMNOS CON ALGÚN SUSPENSO --");

	        for (int i = 0; i < notas.length; i++) {
	            boolean haySuspenso = false;

	            for (int j = 0; j < notas[i].length; j++) {
	                if (notas[i][j] < 5) {
	                    haySuspenso = true;
	                }
	            }

	            if (haySuspenso) {
	                System.out.println("Alumno " + (i + 1));
	            }
	        }
	    }
		
		//case9
		public static void modificarNota(int[][] notas) throws IOException {
	        System.out.println("-- MODIFICAR NOTA --");

	        int alumno = 0;
	        int asignatura = 0;

	        do {
	            System.out.print("Número de alumno (1-5): ");
	            alumno = leerIntPositivo();
	        } while (alumno < 1 || alumno > 5);

	        do {
	            System.out.print("Número de asignatura (1-4): ");
	            asignatura = leerIntPositivo();
	        } while (asignatura < 1 || asignatura > 4);

	        System.out.print("Nueva nota (0-10): ");
	        int nota = leerIntPositivo();
	        while (nota < 0 || nota > 10) {
	            System.err.println("La nota debe estar entre 0 y 10.");
	            System.out.print("Nueva nota (0-10): ");
	            nota = leerIntPositivo();
	        }

	        notas[alumno - 1][asignatura - 1] = nota;

	        System.out.println("Nota modificada correctamente.");
	    }
}
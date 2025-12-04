package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio42 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] candidatos = new String[4];
        String[] ciudades = new String[6];
        int[][] votos = new int[4][6];
        
        boolean salir = false;
        int opcion;

        do {
            System.out.println("--- SISTEMA DE VOTACIONES ---");
            System.out.println("1. Introducir nombres de candidatos y ciudades");
            System.out.println("2. Registrar votos (matriz completa)");
            System.out.println("3. Mostrar tabla de votos");
            System.out.println("4. Total de votos por candidato");
            System.out.println("5. Total de votos por ciudad");
            System.out.println("6. Mostrar ganador general");
            System.out.println("7. Mostrar ganador en cada ciudad");
            System.out.println("8. Ciudad con mayor participación");
            System.out.println("9. Comprobar si algún candidato ganó en todas las ciudades");
            System.out.println("10. Mostrar diferencia entre 1º y 2º lugar");
            System.out.println("11. Salir");
            
            System.out.println("Selecciona una opción: ");
            opcion = leerIntPositivo();
            
            switch (opcion) {
            case 1: introducirNombres(candidatos, ciudades); break;
            case 2: registrarVotos(candidatos, ciudades, votos); break;
            case 3: mostrarTabla(candidatos, ciudades, votos); break;
            case 4: totalPorCandidato(candidatos, votos); break;
            case 5: totalPorCiudad(ciudades, votos); break;
            case 6: mostrarGanadorGeneral(candidatos, votos); break;
            case 7: ganadorPorCiudad(candidatos, ciudades, votos); break;
            case 8: ciudadMayorParticipacion(ciudades, votos); break;
            case 9: candidatoGanoTodas(candidatos, ciudades, votos); break;
            case 10: diferenciaPrimeroSegundo(candidatos, votos); break;
            case 11: salir = true;System.out.println("Saliendo..."); break;
            default: System.err.println("Opción no válida.");
        }

    } while (!salir);
}
	
//case1
	 public static void introducirNombres(String[] candidatos, String[] ciudades) throws IOException {
	        System.out.println("--- INTRODUCIR CANDIDATOS ---");
	        System.out.println();
	        
	        for (int i = 0; i < candidatos.length; i++) {
	            String nombre;
	            
	            System.out.print("Candidato " + (i + 1) + ": ");
	            nombre = leerLinea();
	                
	            candidatos[i] = nombre;
	        }

	        System.out.println("--- INTRODUCIR CIUDADES ---");
	        System.out.println();
	        for (int i = 0; i < ciudades.length; i++) {
	            String ciudad;
	            
	            System.out.print("Ciudad " + (i + 1) + ": ");            
	            ciudad = leerLinea();
	            
	            ciudades[i] = ciudad;
	        }
	    }
	 
//case2
	 public static void registrarVotos(String[] candidatos, String[] ciudades, int[][] votos) throws IOException {
	        
		 System.out.println("--- REGISTRAR VOTOS ---");
		 System.out.println();
		 
		 for (int i = 0; i < candidatos.length; i++) {
			 System.out.println("Votos para " + candidatos[i] + ":");
			 for (int j = 0; j < ciudades.length; j++) {
				 System.out.print("Votos en " + ciudades[j] + ": ");
				 votos[i][j] = leerIntPositivo();
	            }
	        }
	    }

//Case3
	 public static void mostrarTabla(String[] candidatos, String[] ciudades, int[][] votos) {
	        System.out.println("--- TABLA DE VOTOS ---");
	        System.out.println();

	        System.out.print("\t");
	        for (int j = 0; j < ciudades.length; j++) {
	            System.out.print(ciudades[j] + "\t");
	        }
	        System.out.println();

	        for (int i = 0; i < candidatos.length; i++) {
	            System.out.print(candidatos[i] + "\t");
	            for (int j = 0; j < ciudades.length; j++) {
	                System.out.print(votos[i][j] + "\t");
	            }
	            System.out.println();
	        }
	    }

//case4
	    public static void totalPorCandidato(String[] candidatos, int[][] votos) {
	        System.out.println("--- TOTAL POR CANDIDATO ---");
	        System.out.println();
	        
	        for (int i = 0; i < candidatos.length; i++) {
	            int total = 0;
	            for (int j = 0; j < votos[i].length; j++) {
	                total += votos[i][j];
	            }
	            System.out.println(candidatos[i] + ": " + total + " votos");
	        }
	    }

//case5
	    public static void totalPorCiudad(String[] ciudades, int[][] votos) {
	        System.out.println("--- TOTAL POR CIUDAD ---");
	        System.out.println();
	        
	        for (int j = 0; j < ciudades.length; j++) {
	            int total = 0;
	            for (int i = 0; i < votos.length; i++) {
	                total += votos[i][j];
	            }
	            System.out.println(ciudades[j] + ": " + total + " votos");
	        }
	    }

//case6
	    public static void mostrarGanadorGeneral(String[] candidatos, int[][] votos) {
	        int max = -1;
	        String ganador = "";

	        for (int i = 0; i < candidatos.length; i++) {
	            int total = 0;
	            for (int j = 0; j < votos[i].length; j++) {
	                total += votos[i][j];
	            }
	            if (total > max) {
	                max = total;
	                ganador = candidatos[i];
	            }
	        }

	        System.out.println("Ganador general: " + ganador + " con " + max + " votos.");
	    }

//case7
	    public static void ganadorPorCiudad(String[] candidatos, String[] ciudades, int[][] votos) {
	        System.out.println("--- GANADOR POR CIUDAD ---");
	        System.out.println();
	        for (int j = 0; j < ciudades.length; j++) {
	            int max = -1;
	            String ganador = "";

	            for (int i = 0; i < candidatos.length; i++) {
	                if (votos[i][j] > max) {
	                    max = votos[i][j];
	                    ganador = candidatos[i];
	                }
	            }
	            System.out.println(ciudades[j] + ": " + ganador);
	        }
	    }

//case8
	    public static void ciudadMayorParticipacion(String[] ciudades, int[][] votos) {
	        int max = -1;
	        int pos = -1;

	        for (int j = 0; j < ciudades.length; j++) {
	            int total = 0;
	            for (int i = 0; i < votos.length; i++) {
	                total += votos[i][j];
	            }
	            if (total > max) {
	                max = total;
	                pos = j;
	            }
	        }

	        System.out.println("Ciudad con mayor participación: " + ciudades[pos] + " (" + max + " votos)");
	    }

//case9
	    public static void candidatoGanoTodas(String[] candidatos, String[] ciudades, int[][] votos) {
	        System.out.println("--- CANDIDATO QUE GANÓ TODAS LAS CIUDADES ---");
	        System.out.println();
	        boolean encontrado = false;

	        for (int i = 0; i < candidatos.length; i++) {
	            boolean ganadorEnTodas = true;

	            for (int j = 0; j < ciudades.length && ganadorEnTodas; j++) {
	                for (int k = 0; k < candidatos.length; k++) {
	                    if (votos[k][j] > votos[i][j]) {
	                        ganadorEnTodas = false;
	                        break;
	                    }
	                }
	            }

	            if (ganadorEnTodas) {
	                System.out.println(candidatos[i] + " ganó en todas las ciudades.");
	                encontrado = true;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("Ningún candidato ganó en todas las ciudades.");
	        }
	    }

//case10
	    public static void diferenciaPrimeroSegundo(String[] candidatos, int[][] votos) {
	        int[] totales = new int[candidatos.length];

	        for (int i = 0; i < candidatos.length; i++) {
	            int suma = 0;
	            for (int j = 0; j < votos[i].length; j++) {
	                suma += votos[i][j];
	            }
	            totales[i] = suma;
	        }

	        int primero = -1, segundo = -1;
	        int max1 = -1, max2 = -1;

	        for (int i = 0; i < totales.length; i++) {
	            if (totales[i] > max1) {
	                max2 = max1;
	                segundo = primero;

	                max1 = totales[i];
	                primero = i;
	            } else if (totales[i] > max2) {
	                max2 = totales[i];
	                segundo = i;
	            }
	        }

	        System.out.println("Diferencia entre 1º y 2º: " + (max1 - max2) + " votos");
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
}
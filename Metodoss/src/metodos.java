import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class metodos {

	public static void main(String[] args) {
	}
		
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
					System.out.println("Introduce un n�mero v�lido: ");
				}
			}
			return num;
		}
		
	//--------------------	
		public static int leerIntPositivo() throws IOException {
		    int numero = leerInt();
		    while (numero < 0) {
		        System.err.print("ERROR. ");
		        System.out.println("El n�mero no puede ser negativo. Intentalo de nuevo: ");
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
		            System.out.println("Introduce un n�mero v�lido");
		        }
		    }
		    return numero;
			}

	//--------------------		
		public static double leerDoublePositivo() throws IOException {
	        double numero = leerDouble();
	        while (numero < 0) {
	        	System.err.print("No puedes introducir un n�mero negativo.");
	        	System.out.println(" Intentalo de nuevo: ");
	            numero = leerDouble();
	        }
	        return numero;
	    }
		
	//--------------------			
		public static boolean esTextoValido(String texto) {
		    for (int i = 0; i < texto.length(); i++) {
		        char c = texto.charAt(i);

		        // comprobamos si no es letra may�scula ni min�scula
		        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
		            return false; // encontramos un car�cter no permitido
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
		            System.out.print("Int�ntalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }

		        if (!esTextoValido(texto)) {
		            System.err.println("El nombre solo puede contener letras, sin n�meros ni s�mbolos ni espacios en blanco.");
		            System.out.print("Int�ntalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }
		        break; // si pasa todas las comprobaciones, salimos del bucle
		    } while (true);
		    return texto;
		}
	}
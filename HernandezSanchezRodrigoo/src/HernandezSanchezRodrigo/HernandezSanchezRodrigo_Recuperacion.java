package HernandezSanchezRodrigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HernandezSanchezRodrigo_Recuperacion {
	
	public static int leerInt() throws NumberFormatException, IOException {
		 
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un numero valido: ");
			}
		}
		return num;
	}
	
//--------------------	
	public static int leerIntPositivo() throws IOException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El numero no puede ser negativo. Intentalo de nuevo: ");
	        numero = leerInt();
	    }
	    return numero;
	}
	
//--------------------
	public static double leerDouble() throws NumberFormatException, IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double numero =0;
		boolean valido=false;
		
		while(!valido) {
			try {
				numero = Double.parseDouble(leer.readLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.err.print("ERROR. ");
	            System.out.println("Introduce un numero valido");
	        }
	    }
	    return numero;
		}

//--------------------		
	public static double leerDoublePositivo() throws NumberFormatException, IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un numero negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
        }
        return numero;
    }
	
//--------------------			
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	        // comprobamos si no es letra mayï¿½scula ni minï¿½scula
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false; // encontramos un carï¿½cter no permitido
	        }
	    }
	    return true; // todos los caracteres son letras
	}
	
//----------	
	public static String leerLinea() throws NumberFormatException, IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    String texto;

	    do {
	        texto = leer.readLine().trim(); // quitamos espacios al inicio y al final

	        if (texto.length() == 0) {
	            System.err.println("Debes escribir algo.");
	            System.out.print("Intentalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        if (!esTextoValido(texto)) {
	            System.err.println("El nombre solo puede contener letras, sin numeros ni simbolos ni espacios en blanco.");
	            System.out.print("Intentalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }
	        break; // si pasa todas las comprobaciones, salimos del bucle
	    } while (true);
	    return texto;
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		boolean salir = false;
	    char opcion;
	    
		do {
            System.out.println("\n---Ejercicio 8---");
            System.out.println("A. Registro de Carta a los Reyes Magos");
            System.out.println("B. Decoración de las calles");
            System.out.println("C. Generador de Villancicos ");            
            System.out.println("D. Salir");
            System.out.print("Selecciona una opcion: ");
           
            opcion = leerLinea().toUpperCase().charAt(0);
            switch (opcion) {
                case 'A':opcionA();break;
                case 'B':opcionB();break;
                case 'C':opcionC();break;
                case 'D':salir = true;System.out.println("adios");break;
                default:System.err.println("Opcion no valida.");
            }
        } while (!salir);
	}

	//Case1
	public static void opcionA() throws NumberFormatException, IOException{
		System.out.println("=== CARTA A LOS REYES MAGOS ===");
		System.out.println("Introduce tu nombre: ");
		 String nombre = leerLinea();
		 
		 System.out.println("Introduce tu edad: ");
		 int edad = leerIntPositivo();
		 String categoria = "";
		 if (edad >= 0 && edad <= 7 ) {
             categoria = "Infantil";
         } else if (edad >= 8 && edad <= 12) {
             categoria = "Niños";
         } else if (edad >= 13 && edad <= 17) {
             categoria = "Adolescentes";
         } else if (edad >18) {
             categoria = "Adulto";
         } else {
        	 System.err.println("La edad no puede ser negativa");
         }
		 
		 System.out.println("Introduce tu presupuesto: ");
		 double presupuesto = leerDoublePositivo();
		 String lista = "";
		 if (presupuesto < 30) {
             lista = "Modesta";
         } else if (presupuesto >= 30 && presupuesto <= 70) {
        	 lista = "Normal";
         } else if (presupuesto > 70) {
        	 lista = "Premium";
         } else {
        	 System.out.println("El presupuesto no puede ser negativo. Eres pobre :P");
         }
		 
		 System.out.println("¿Has sido bueno? Introduce S o N: ");
		 String bueno = leerLinea();
			while (!bueno.equals("S") && !bueno.equals("N")) {
				System.err.println("Dato erróneo. Debes escribir exactamente 'S' o 'N'.");
				System.out.print("¿Has sido bueno? Introduce S o N: ");
				bueno = leerLinea();
			}
			double presupuestoFinal;
			if (bueno.equalsIgnoreCase("S")) {
				System.out.println("Tu presupuesto es: " + presupuesto);
				presupuestoFinal = presupuesto;
			} else {
				System.out.println("Tu presupuesto es: " + (presupuesto - (presupuesto*0.30)));
				presupuestoFinal = (presupuesto - (presupuesto*0.30));
			}
			
			System.out.println("--- CARTA REGISTRADA ---");
			String ultimo = nombre.substring(nombre.length() - 1).toLowerCase();
			String codigo = nombre.substring(0, 2).toUpperCase() + edad + ultimo;
			System.out.println("Tu codigo es: " + codigo);
			System.out.println("Tu categoria es: " + categoria);
			System.out.println("Tu presupuesto final es: " + presupuestoFinal);
			System.out.println("Tipo de lista: " + lista);	
	}
	
	//Case2
	public static void opcionB() throws NumberFormatException, IOException{
		 System.out.println("Introduzca el número de calles: ");
		 int calles = leerIntPositivo();
		 
		 System.out.println("Introduzca el número de adornos por calle: ");
		 int adornos = leerIntPositivo();
		 
		 int totalBolas = 0;
		 int totalEstrellas=0;
		 int totalCampanas=0;
		 int totalAdornos=0;
		 int completados=0;
		 
		 for(int i = 1; i<=calles; i++) {
			 totalBolas = 0;
			 totalEstrellas=0;
			 totalCampanas=0;
			 totalAdornos=0;
			 completados=0;
			 System.out.println("-- Calle " + i +" ---");
			 for(int j = 1; j<=adornos; j++) {
				 System.out.println("Colocando adorno "+j+ " de la calle "+i);
			 System.out.println("Ingrese tipo de adorno (Bola, Estrella, Campana o Fin): ");
			 String adorno = leerLinea();
			 if(adorno.equals("FIN")) {
			 while (!adorno.equals("Bola") && !adorno.equals("Estrella") && !adorno.equals("Campana")) {
				 System.err.print("Dato erróneo. ");
				 System.out.println("Debes escribir exactamente Bola, Estrella, Campana o FIN si quiere terminar.");					
				 System.out.print("Ingrese tipo de adorno (Bola, Estrella, Campana): ");
				 adorno = leerLinea();
			 }
			 
			 if (adorno.equals("Bolas")) {
				 Integer.parseInt(adorno);
				 totalBolas++;
				 totalAdornos++;
             } else if (adorno.equals("Estrella")){
            	 Integer.parseInt(adorno);
            	 totalEstrellas++;
            	 totalAdornos++;
             } else if (adorno.equals("Campana")) {
            	 Integer.parseInt(adorno);
            	 totalCampanas++;
            	 totalAdornos++;
             }
			 totalAdornos+=Integer.parseInt(adorno);;
			 }
		 }
		 System.out.println("--RESUMEN DE LA INSTALACIÓN ---");
		 System.out.println("Total de adornos colocados: "+ totalAdornos);
		 System.out.println("Total de Bolas colocadas: "+totalBolas);
		 System.out.println("Total de Estrella colocadas: "+totalEstrellas);
		 System.out.println("Total de Campana colocadas: "+totalCampanas);
		 }
	} //se que esta mal peor bueno se intento c:
	
	//Case3
	public static void opcionC() throws NumberFormatException, IOException{
		System.out.println("=== GENERADOR DE VILLANCICOS ===");
		int adjetivo = (int) Math.floor(Math.random() * 4) + 1;
	    int sustantivo = (int) Math.floor(Math.random() * 4) + 1;
	    int dificultad = (int) (Math.random() * 10) + 1;
	    String adjetivos;
	    String sustantivos;
	    char otroVillancico;
	    
	    switch(adjetivo) {
	    case 1: adjetivos = "Alegre"; break;	  
        case 2: adjetivos = "Blanca"; break;
        case 3: adjetivos = "Dulce"; break;
        case 4: adjetivos = "Mágica";break;
        default:adjetivos = "Desconocido";
        }
	    
	    switch(sustantivo) {	    
        case 1: sustantivos = "Navidad"; break;
        case 2: sustantivos = "Noche"; break;
        case 3: sustantivos = "Campana"; break;
        case 4: sustantivos = "Estrella";break;
        default:sustantivos = "Desconocido";
        }
	
	    System.out.println("Villancico: " + adjetivos + " " + sustantivos);
	    System.out.println("Nivel de popularidad: " + dificultad + "/10");
	    System.out.print("¿Quieres otra villancico? Responda Si o No: ");
	    otroVillancico = leerLinea().toLowerCase().charAt(0);
	    do {
	    	adjetivo = (int) Math.floor(Math.random() * 4) + 1;
		    sustantivo = (int) Math.floor(Math.random() * 4) + 1;
		    dificultad = (int) (Math.random() * 10) + 1;
		    
		    switch(adjetivo) {
		    case 1: adjetivos = "Alegre"; break;	  
	        case 2: adjetivos = "Blanca"; break;
	        case 3: adjetivos = "Dulce"; break;
	        case 4: adjetivos = "Mágica";break;
	        default:adjetivos = "Desconocido";
	        }
		    
		    switch(sustantivo) {	    
	        case 1: sustantivos = "Navidad"; break;
	        case 2: sustantivos = "Noche"; break;
	        case 3: sustantivos = "Campana"; break;
	        case 4: sustantivos = "Estrella";break;
	        default:sustantivos = "Desconocido";
	        }
		
		    System.out.println("Villancico: " + adjetivos + " " + sustantivos);
		    System.out.println("Nivel de popularidad: " + dificultad + "/10");
		    System.out.print("¿Quieres otra villancico? Responda exactamente S o N: ");
		    otroVillancico = leerLinea().toLowerCase().charAt(0);
	    }while(otroVillancico == 's');
	}
}

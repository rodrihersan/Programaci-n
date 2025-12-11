package coleccionesDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio9 {
	
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


	public static void main (String[] args) throws NumberFormatException, IOException {
		ArrayList<String> playList = new ArrayList<>();
		
		boolean salir = false;
	    char opcion;
	    
		do {
            System.out.println("\n---Ejercicio 6---");
            System.out.println("A. Añadir canción al final");
            System.out.println("B. Añadir canción al inicio de la playlist");
            System.out.println("C. Mostrar todas las canciones (numeradas desde 1)");
            System.out.println("D. Eliminar canción por posición");
            System.out.println("E. Buscar canción por nombre");
            System.out.println("F. Mover una canción a otra posición (pedir posición origen y destino)");
            System.out.println("G. Mostrar la primera y última canción de la playlist");
            System.out.println("H. Mostrar total de canciones");
            System.out.println("I. Shuffle");
            System.out.println("J. Eliminar canciones duplicadas");
            System.out.println("K. Salir");
            
            System.out.print("Selecciona una opción: ");
            opcion = leerLinea().toUpperCase().charAt(0);
            switch (opcion) {
                case 'A':opcionA(playList);break;
                case 'B':opcionB(playList);break;
                case 'C':opcionC(playList);break;
                case 'D':opcionD(playList);break;
                case 'E':opcionE(playList);break;
                case 'F':opcionF(playList);break;
                case 'G':opcionG(playList);break;
                case 'H':opcionH(playList);break;
                case 'I':opcionI(playList);break;
                case 'J':opcionJ(playList);break;
                case 'K':salir = true;System.out.println("adios");break;
                default:System.err.println("Opción no válida.");
            }
        } while (!salir);
	}
	
		//case1
		public static void opcionA(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Añadir canción al final--");
			System.out.println("Introduce una cancion a la lista");
			String cancion = leerLinea();
			playList.add(cancion);
		}
		
		//Case2
		public static void opcionB(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Añadir canción al inicio de la playlist--");
			System.out.println("Introduce nombre de la cancion: ");
			String cancion = leerLinea();
			playList.add(0, cancion);
		}
	
		//case3
		public static void opcionC(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Mostrar todas las canciones--");
			
			for(int i =0; i<playList.size(); i++) {
				System.out.println("Cancion " +(i+1)+" : "+ playList.get(i));
			}
		}
		
		//case4
		public static void opcionD(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Eliminar canción por posición--");
			int posicion;
			do {
				System.out.println("Introduce una posicion: ");
				posicion = leerIntPositivo();
			}while(posicion<0 && posicion> playList.size());
			playList.remove(posicion-1);
		}
		
		//case5
		public static void opcionE(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Buscar canción por nombre--");
			
			System.out.println("Introduce nombre cancion: ");
			String cancion = leerLinea();
			
			if(playList.contains(cancion)) {
				for(int i=0; i<playList.size();i++) {
					if(playList.get(i).equalsIgnoreCase(cancion)) {
						System.out.println("La cancion esta en la posicion: "+i);
					}
				}
			}else {
				System.out.println("La cancion  no esta en la playList");
			}/*FORMA 2
			boolean enc = false;
			for(int i =0; i<playList.size();i++){
			if(playList.get(i).equalsIgnoreCase(cancion)) {
				System.out.println("La cancion esta en la posicion: "+i);
				enc=true;
				}		
			if(!enc)
				System.out.println("La cancion no esta")
				}*/
		}
		
		//Case6
		public static void opcionF(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Mover una canción a otra posición--");
			int pos1 = -1;
			do {
				System.out.println("Introduce una posicion: ");
				pos1 = leerIntPositivo();
			}while(pos1<0 && pos1> playList.size());
			
			int pos2 = -1;
			do {
				System.out.println("Introduce una posicion: ");
				pos2 = leerIntPositivo();
			}while(pos2<0 && pos2> playList.size());
			
			/*String temporal1 = playList.get(pos1);
			String temporal2 = playList.get(pos2);
			
			playList.remove(pos1);
			playList.remove(pos2);
			
			playList.add(pos1,temporal2);
			playList.add(pos2, temporal1);*/
			System.out.println(playList);
			Collections.swap(playList,pos1,pos2);
			System.out.println(playList);
		}
		
		//case7
		public static void opcionG(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Mostrar la primera y última canción de la playlist--");
			
			System.out.println("Cancion primera: "+playList.getFirst());//.get(0);
			System.out.println("Cancion ultima: "+playList.getLast());//.get(playList.size()-1;
		}
		
		//Case8
		public static void opcionH(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Mostrar total canciones--");
			System.out.println("El total de canciones es: "+playList.size());
		}
		
		//Case9
		public static void opcionI(ArrayList<String> playList) throws NumberFormatException, IOException{
			System.out.println("--Shuffle--");
			System.out.println(playList);//ordenada
			System.out.println("Mezclando canciones");
			Collections.shuffle(playList);// lo desordena
			System.out.println(playList);//imprime desordenada
		}
		
		//Case10
		public static void opcionJ(ArrayList<String> playList) throws NumberFormatException, IOException{
			ArrayList<String> playListSinDuplicados = new ArrayList<>();
			System.out.println(playList);
			
			for(String cancion:playList) {
				if(!playListSinDuplicados.contains(cancion)) {
					playListSinDuplicados.add(cancion);
				}
			}
			System.out.println(playListSinDuplicados);
		}
	}
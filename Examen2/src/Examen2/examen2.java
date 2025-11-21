package Examen2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class examen2 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		 BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		 boolean salir = false;
	     while (!salir) {
	    	 System.out.println("==Servicios streaming CALASANZ+==");
	    	 System.out.println();
	    	 System.out.println("1: Creador de perfil de usuario");
	    	 System.out.println("2: Maratón de series");
	    	 System.out.println("3: Calificar series y capítulos");
	    	 System.out.println("4: Sistema de recomendaciones");
	    	 System.out.println("5: Salir");
	    	 System.out.println("Elige una opción: ");
	    	 int numeroOpcion = Integer.parseInt(lector.readLine());
	    	 
	    	 switch(numeroOpcion) {
	    	 case 1:
	    		 System.out.println("=== CREADOR DE PERFIL DE USUARIO ===");
	    		 System.out.println("Introduce tu nombre: ");
	    		 String nombre = lector.readLine();
	    		 System.out.println("Introduce tu género favorito: ");
	    		 String genero = lector.readLine();
	    		 System.out.println("Introduce tu edad: ");
	    		 int edad = Integer.parseInt(lector.readLine());
	    		 int precioBase=7;
	    		 System.out.println("Introduce el precio base mensual: " + precioBase);	
	    		 System.out.println("Introduce el número de perfiles: ");
	    		 int numeroPerfil = Integer.parseInt(lector.readLine());
	    		 System.out.println("¿Quieres calidad 4K? (S/N): ");
	    		 String calidad = lector.readLine();
	    		 
	    		 nombre= nombre.toUpperCase().substring(0, 3);
	    		 genero=genero.toLowerCase().substring(0, 2);
	    		 int precioMensual= precioBase+(3*numeroPerfil);
	    		 int precioMensual4K = (precioBase+(3*numeroPerfil)+5);
	    		 System.out.println("--- PERFIL CREADO ---");
	    		 System.out.println("ID usuario: "+nombre+genero+edad);
	    		
	    		 if(numeroPerfil>5) {
	    			 if(calidad.equalsIgnoreCase("si")) {
	    	    		 System.out.println("Precio mensual se te reduce un 10%: "+((precioMensual4K)-((precioMensual4K)*0.10))+" euros");
	    	    		 }else {
	    	    			 System.out.println("No se te descuenta. Precio mensual: "+(precioMensual)+" euros");
	    	    		 }
	  
	    		 }else if(numeroPerfil >0 && numeroPerfil <=5) {
	    			 if(calidad.equalsIgnoreCase("si")) {
	    	    		 System.out.println("Precio mensual: "+(precioMensual4K)+" euros");
	    	    		 }else {
	    	    			 System.out.println("Precio mensual: "+(precioMensual)+" euros");	 
	    	    		 }
	    		 } else{
	    			 System.out.println("No puedes tener 0 perfiles o perfiles negativos");

	    		 }
	    		 if(edad >=0 && edad <=7) {
	    			 System.out.println("plan infantil");
	    		 }else if(edad >=8 && edad <=12) {
	    			 System.out.println("plan infantil");
	    		 }else if(edad>=13 && edad <=17) {
	    			 System.out.println("juvenil");
	    		 }else if(edad>=18) {
	    			 System.out.println("todas las peliculas");
	    		 }else {
	    			 System.out.println("No puede introducir una edad negativa");
	    		 }
	    		 if(precioMensual <10 || precioMensual4K<10) {
	    			 System.out.println("plan básico");
	    		 }else if(precioMensual >=10 && precioMensual<=15 || precioMensual4K>=10 && precioMensual4K <=15){
	    			 System.out.println("plan Estándar");
	    		 }else {
	    			 System.out.println("plan Premium");
	    		 }
	    		 System.out.println();
	    		 break;	    		 
	    	 
	    	 case 2:
	    		 System.out.println("=== MARATÓN DE SERIES ===");
	    		 System.out.println("Introduce el número total de capítulos de la serie: ");
	    		int capitulosSerie = Integer.parseInt(lector.readLine());
	    		int totalCapitulosVisto=0;
	    		int sumaMinutos=0;
	    		
	    		for(int i=1;i<=capitulosSerie;i++) {
	    			System.out.println("Reproduciendo episodio "+i+ " de un total de "+capitulosSerie);
	    			System.out.println("Introduce la duración en minutos del capítulo "+i+"  (0 para parar): ");
	    			int minutos = Integer.parseInt(lector.readLine());
	    				if(minutos==0) {
	    					System.out.println("Has dejado de reproducir. Paramos.");
	    					break;
	    				}else {
	    					//System.out.println("Felicidades, has visto toda la serie");
	    					totalCapitulosVisto++;
	    					sumaMinutos +=minutos;
	    				}
	    				System.out.println("Felicidades, has visto toda la serie");
	    		}
	    		int sinVer= capitulosSerie-totalCapitulosVisto;
	    		
	    		System.out.println();
                System.out.println("--- RESUMEN ---");
                System.out.println("Has completado " + totalCapitulosVisto + " capítulos");
                System.out.println("Te faltan por reproducir " + sinVer + " capítulos");
                System.out.println("Total de minutos reproducidos: " + sumaMinutos);
                System.out.println();
                break;
                
	    	 case 3:
	    		 
	    		 System.out.println("=== NOTA SAGA COMPLETA ===");
	                
	    		 	System.out.println("Introduce el nombre de la saga: ");
	                String nombreSaga = lector.readLine();
	                
	                System.out.println("Introduce el número de libros de la saga: ");
	                int numeroLibrosSaga = Integer.parseInt(lector.readLine());
	                
	                System.out.println("Introduce el número de capítulos por saga: ");
	                int numeroCapitulos=Integer.parseInt(lector.readLine());
	                
	                System.out.println();
	                double sumaValoracion=0;
	                double sumaValoracionCapitulo=0;

	                for(int i=1;i<=numeroLibrosSaga;i++) {
	                	System.out.println("--- LIBRO "+i+" ---");
	                    for(int j=1;j<=numeroCapitulos;j++)	{	                    	
	                    System.out.println("Introduce la nota (0-10) del captiulo"+j+" :");	                    
	                    int valoracion = Integer.parseInt(lector.readLine());
	                    
	                    if (valoracion < 0 || valoracion > 10) {
	                        System.out.println("Valoración inválida, debe estar entre 1 y 10. Se contará como 0.");
	                        valoracion = 0;
	                    }

	                    System.out.println("Valoración capitulo " + j + " : " + valoracion);
	                    sumaValoracion += valoracion;
	                    System.out.println("Media del capitulo "+ j + " :"+(sumaValoracion/valoracion));	
	                    
	                    }
	                }
	                double mediaSaga = sumaValoracion / numeroLibrosSaga;
	                System.out.println("--- VALORACIÓN DE LA SAGA \"" + nombreSaga + "\" ---");
	                System.out.println("Media de la saga: " + mediaSaga);

	 
	    	
	    	 
	    		 
	     

	                
	         break;
	         
	    	 case 4:
	    		 System.out.println("=== SISTEMA DE RECOMENDACIONES ===");
	                int adjetivo = (int) (Math.random() * 5) + 1;
	                int sustantivo = (int) (Math.random() * 5) + 1;	
	                int puntuacion = (int) (Math.random() * 10) + 1;
	                String adjetivoAleatorio;
	                String sustantivoAleatorio;

	                
	                switch(adjetivo) {
	                    case 1: adjetivoAleatorio = "Increíble"; break;
	                    case 2: adjetivoAleatorio = "Épico"; break;
	                    case 3: adjetivoAleatorio = "Misterioso"; break;
	                    case 4: adjetivoAleatorio = "Oscuro"; break;
	                    case 5: adjetivoAleatorio = "Último"; break;
	                    default: adjetivoAleatorio = "Desconocido";
	                }
	                switch(sustantivo) {
	                    case 1: sustantivoAleatorio = "Viaje"; break;
	                    case 2: sustantivoAleatorio = "Secreto"; break;
	                    case 3: sustantivoAleatorio = "Destino"; break;
	                    case 4: sustantivoAleatorio = "Horizonte"; break;
	                    case 5: sustantivoAleatorio = "Reino"; break;
	                    default: sustantivoAleatorio = "Desconocido";
	                }

	                System.out.println("Recomendacion: " + adjetivoAleatorio + " " + sustantivoAleatorio);
	                System.out.println("Puntuacion: " + puntuacion + "/10");

	                System.out.print("¿Quieres otra recomendación? Responda solo con S/N: ");
	                String respuesta = lector.readLine();

	                while(respuesta.equalsIgnoreCase("S")) {
	                    adjetivo = (int) (Math.random() * 5) + 1;
	                    sustantivo = (int) (Math.random() * 5) + 1;
	                    puntuacion = (int) (Math.random() * 5) + 1;

	                    switch(adjetivo) {
	                        case 1: adjetivoAleatorio = "Gran"; break;
	                        case 2: adjetivoAleatorio = "Pequeño"; break;
	                        case 3: adjetivoAleatorio = "Nuevo"; break;
	                        case 4: adjetivoAleatorio = "Viejo"; break;
	                        case 5: adjetivoAleatorio = "Último"; break;
	                        default: adjetivoAleatorio = "Desconocido";
	                    }
	                    switch(sustantivo) {
	                        case 1: sustantivoAleatorio = "Libro"; break;
	                        case 2: sustantivoAleatorio = "Historia"; break;
	                        case 3: sustantivoAleatorio = "Misterio"; break;
	                        case 4: sustantivoAleatorio = "Aventura"; break;
	                        case 5: sustantivoAleatorio = "Secreto"; break;
	                        default: sustantivoAleatorio = "Desconocido";
	                    }

	                    System.out.println("Recomendacion: " + adjetivoAleatorio + " " + sustantivoAleatorio);
	                    System.out.println("Puntuacion: " + puntuacion + "/10");
	                    System.out.print("¿Quieres otra recomendación? (S/N): ");
	                    respuesta = lector.readLine();
	                }
	            break;

	    	 case 5:
	    
	    		 System.out.println("“Gracias por usar CALASANZ+. ¡Nos vemos en tu próxima maratón!” ");
	    		 salir = true;
	    		 
	         break;
	         
	    	 default:
	    		 System.out.println("Numero invalido");
	    	 }
	     }
	}
}

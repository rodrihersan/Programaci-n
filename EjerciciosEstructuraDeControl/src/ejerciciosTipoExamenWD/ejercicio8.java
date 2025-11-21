package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {

    public static void main(String[] args) throws NumberFormatException, IOException{
        // TODO Auto-generated method stub
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        while (!salir) {
            System.out.println("==== BIENVENIDO A TU BIBLIOTECA PERSONAL ===");
            System.out.println();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Catalogar libro\r\n"
                    + "2. Sesión de lectura\r\n"
                    + "3. Valorar saga completa\r\n"
                    + "4. Recomendación aleatoria\r\n"
                    + "5. Salir");
            System.out.println("Elige una opción: ");
            int numero = Integer.parseInt(lector.readLine());
            
            switch(numero) {
            
            case 1:
                System.out.println("==== CATALOGAR LIBRO ===");
                System.out.println("Introduce el título del libro: ");
                String tituloLibro = lector.readLine();
                System.out.println("Introduce el número de páginas: ");
                int numeroPaginas = Integer.parseInt(lector.readLine());
                System.out.println("Introduce el año de publicación: ");
                int añoPublicacion = Integer.parseInt(lector.readLine());
                System.out.println("Introduce el género: ");
                String genero = lector.readLine();
                //CONVIERTE EL GENERO A MAYUSUCULAS
                genero = genero.toUpperCase();
                //PONEMOS COMILLAS PARA QUE DETECTE EL STING Y LUEGO QUE PILLE LA PRIMERA LETRA Y LA HAGA GRANDE
                String primeraLetra = "" + Character.toUpperCase(tituloLibro.charAt(0));
                int codigoAño = añoPublicacion%100;
                int tiempoLectura = numeroPaginas*2; // total en minutos
                int horas = tiempoLectura/60;       // división entera → horas completas
                int minutos = tiempoLectura%60;     // resto → minutos sobrantes
                System.out.println();
                System.out.println("--- LIBRO CATALOGADO ---");
                System.out.println();
                System.out.println("Titulo: "+tituloLibro);
                System.out.println("Codigo estanteria: "+genero+codigoAño+primeraLetra);
                System.out.println("Tiempo estimado de lectura: "+horas+" horas"+minutos+" minutos");
                System.out.println();
                break;
                
            case 2:
                System.out.println("=== SESIÓN DE LECTURA ===");
                System.out.println("¿Cuántos capítulos tiene el libro?");
                int capitulosLibro = Integer.parseInt(lector.readLine());
                int totalCapitulosLeidos=0;
                int sumaPaginasLeidas=0;
                
                for(int i=1;i<=capitulosLibro;i++) {
                    System.out.println("Capítulo "+i+" - Páginas leídas (0 para dejar de leer):");
                    int paginasLeidas = Integer.parseInt(lector.readLine());
                    
                    if(paginasLeidas==0) {
                        System.out.println("Has dejado de leer");
                        break; // Salimos del bucle si deja de leer
                    } else {
                        totalCapitulosLeidos++;
                        sumaPaginasLeidas += paginasLeidas;
                    }
                }

                int totalCapitulosNoLeidos = capitulosLibro - totalCapitulosLeidos;

                System.out.println();
                System.out.println("--- RESUMEN DE LECTURA ---");
                System.out.println("Has completado " + totalCapitulosLeidos + " capítulos");
                System.out.println("Te faltan por leer " + totalCapitulosNoLeidos + " capítulos");
                System.out.println("Total de páginas leídas hoy: " + sumaPaginasLeidas);
                System.out.println();
            break;
            
            case 3:
                System.out.println("=== VALORAR SAGA COMPLETA ===");
                System.out.println("Introduce el nombre de la saga: ");
                String nombreSaga = lector.readLine();
                System.out.println("Introduce el número de libros de la saga: ");
                int numeroLibrosSaga = Integer.parseInt(lector.readLine());
                System.out.println();
                double sumaValoracion=0;
                for(int i=1;i<=numeroLibrosSaga;i++) {
                    System.out.println("--- LIBRO "+i+" ---");
                    System.out.println("Introduce la valoración (1-10): ");
                    double valoracion = Double.parseDouble(lector.readLine());
                    if (valoracion < 1 || valoracion > 10) {
                        System.out.println("Valoración inválida, debe estar entre 1 y 10. Se contará como 0.");
                        valoracion = 0;
                    }

                    System.out.println("Valoración libro " + i + ": " + valoracion);
                    sumaValoracion += valoracion;
                }

                double mediaSaga = sumaValoracion / numeroLibrosSaga;
                System.out.println("--- VALORACIÓN DE LA SAGA \"" + nombreSaga + "\" ---");
                System.out.println("Media de la saga: " + mediaSaga);

                if (mediaSaga > 8) {
                    System.out.println("Clasificación: Imprescindible");
                } else if (mediaSaga >= 6) {
                    System.out.println("Clasificación: Recomendable");
                } else {
                    System.out.println("Clasificación: Prescindible");
                }
                System.out.println();
            break;
/*case 3: forma Javi
            System.out.println("3. Valorar Saga Completa");
            
            //Adrian ha dicho que un ejercicio del examen era como lo que esta aqui debajo.
            
            double notaMediaTemporada = 0;
            double notasDeLosCapitulos = 0;
            
            double notaCapitulo = 0;
            double notaMediaSerie = 0;
            
            double notaMediaSerieFinal= 0;
            
            double sumaNotaMediaTemporada = 0;
        
        System.out.println("¿Cuantos temporadas tiene la serie que estas viendo?");
            int temporadasSerie = Integer.parseInt(br.readLine());
            
        for (int i = 0; i < temporadasSerie; i++) {
            
            notasDeLosCapitulos = 0;
            
            System.out.println("¿Cuantos capitulos tiene " + (i+1) + " temporada?");
                int capitulosTemporada = Integer.parseInt(br.readLine());
                
                
                for (int j = 0; j < capitulosTemporada; j++) {
                    
            System.out.println("¿Que nota le das al " + (j+1) + "º capitulo de la temporada " + (i+1));
                    notaCapitulo = Double.parseDouble(br.readLine());
                    
                while (notaCapitulo < 0 || notaCapitulo > 10) {
                    System.out.println("Lo sieto pero la nota introducida no es valida, solo valen notas del 1 al 10");
                    notaCapitulo = Double.parseDouble(br.readLine());
                    
                }
                
                notasDeLosCapitulos += notaCapitulo;
                
                notaMediaTemporada = notasDeLosCapitulos / capitulosTemporada;
                    
                }
                
                System.out.println("La nota Media de la temporada es de: " + notaMediaTemporada);
                
                sumaNotaMediaTemporada += notaMediaTemporada;       
        }
        
        notaMediaSerie = sumaNotaMediaTemporada / temporadasSerie;
        
        
        
        System.out.println("La nota media de la serie es: " + notaMediaSerie);
        
            break;*/
            case 4: //igual ejer7
                System.out.println("=== RECOMENDACIÓN ALEATORIA ===");
                int adjetivo = (int) (Math.random() * 5) + 1;
                int sustantivo = (int) (Math.random() * 5) + 1;
                int puntuacion = (int) (Math.random() * 5) + 1;
                String adjetivoAleatorio;
                String sustantivoAleatorio;

                // Generar primera sugerencia
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

                System.out.println("Título sugerido: " + adjetivoAleatorio + " " + sustantivoAleatorio);
                System.out.println("Valoración: " + puntuacion + "/5 estrellas");

                System.out.print("¿Quieres otra recomendación? (S/N): ");
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

                    System.out.println("Título sugerido: " + adjetivoAleatorio + " " + sustantivoAleatorio);
                    System.out.println("Valoración: " + puntuacion + "/5 estrellas");
                    System.out.print("¿Quieres otra recomendación? (S/N): ");
                    respuesta = lector.readLine();
                }
            break;
                
            case 5:
                System.out.println("¡Feliz lectura!");
                salir = true;
                break;
            
            default:
                System.out.println("Numero invalido");
                }
            }
        }
    }
package examenFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("\n=== CONSEJO DE PROGRAMADORES DE CYL ===");
			System.out.println("1. Añadir candidato");
			System.out.println("2. Ver candidatos de un partido");
			System.out.println("3. Actualizar votos de un candidato");
			System.out.println("4. Exportar acta final de resultados");
			System.out.println("5. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números.");
				}
			}

			switch (opcion) {
			case 1:System.out.println("-- AÑADIR CANDIDATO --");añadirCandidato();break;
			case 2:System.out.println("-- BUSCAR POR PARTIDO --");buscarCandidatoPorNombre();break;
			case 3:System.out.println("-- ACTUALIZAR VOTOS --");actualizarVotos();break;
			case 4:System.out.println("-- EXPORTAR ACTA FINAL --");exportarActaFinal();break;
			case 5:System.out.println("Saliendo del programa. ¡Hasta pronto!");salir = true;break;
			default:System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
			}

		} while (!salir);
	}
	
	//case1
    private static void añadirCandidato() throws IOException {
    	File fichero_candidatos = new File("candidatos.txt");
        Candidato candidato = new Candidato();
        candidato.pedirCandidato();
        candidato.escribirFichero(fichero_candidatos, true);
        System.out.println("Valores añadidos correctamente.");
    }

    //Case2
    public static void buscarCandidatoPorNombre() throws IOException {
		File fichero_electorales = new File("candidatos.txt");

		if (fichero_electorales.exists()) {
			String partido;

			partido = Lecturas.leerOpcion("Introduce el partido a buscar (AJE / PJS / PCD / MIAF):",
					new String[] { "AJE", "PJS", "PCD", "MIAF" });

			System.out.println("Partido: " + partido);

			FileReader fr = new FileReader(fichero_electorales);
			BufferedReader br = new BufferedReader(fr);
			int votosTotales = 0;
			boolean enc = false;
			String linea = br.readLine();

			while (linea != null) {
				Candidato candidato = new Candidato();
				candidato.leerCandidato(linea);

				if (candidato.getPartido().equalsIgnoreCase(partido)) {
					enc = true;
					System.out.println("ID: " + candidato.getId());
					System.out.println("Nombre: " + candidato.getNombre());
					System.out.println("Partido: " + candidato.getPartido());
					System.out.println("Votos: " + candidato.getVotos());
					votosTotales += candidato.getVotos();
				}

				linea = br.readLine();
			}
			br.close();
			fr.close();

			if (!enc) {
	            System.out.println("No hay candidatos para ese partido.");
	        } else {
	            System.out.println("VOTOS TOTALES: " + votosTotales);
	        }
			} else {
				System.err.println("No existe el fichero candidatos.txt");
			}
	}
    
    //Case3
    public static void actualizarVotos() throws IOException {
		File fichero_candidatos = new File("candidatos.txt");

	    if (!fichero_candidatos.exists()) {
	        System.err.println("No existe el fichero candidatos.txt");
	        return;
	    }

	    boolean enc = false;
	    int idCandidato;
	    
	    do {
	        idCandidato = Lecturas.leerEntero("Introduce el id del candidato: ");
	        enc = false;

	        FileReader fr = new FileReader(fichero_candidatos);
	        BufferedReader br = new BufferedReader(fr);
	        String linea = br.readLine();

	        while (linea != null) {
	        	Candidato c = new Candidato();
	            c.leerCandidato(linea);
	            if (c.getId() == idCandidato) {
	                enc = true;
	            }
	            linea = br.readLine();
	        }

	        br.close();
	        fr.close();

	        if (!enc) {
	            System.out.println("No existe ningún candidato con ese id.");
	        }

	    } while (!enc);
	    
	    FileReader fr = new FileReader(fichero_candidatos);
	    BufferedReader br = new BufferedReader(fr);
	    Candidato candidatoActual = new Candidato();
	    String linea = br.readLine();

	    while (linea != null) {
	        Candidato candidato = new Candidato();
	        candidato.leerCandidato(linea);
	        if (candidato.getId() == idCandidato) {
	            candidatoActual = candidato;
	        }
	        linea = br.readLine();
	    }
	    
	    br.close();
	    fr.close();

	    
    }
    //Case4
    private static void exportarActaFinal() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		File fichero_candidatos  = new File("candidatos.txt");
        if (!fichero_candidatos.exists()) {
            System.err.println("No existe el fichero candidatos.txt");
            return;
        }
        
        FileReader fr = new FileReader(fichero_candidatos);
		BufferedReader br = new BufferedReader(fr);
		
		File finalActa = new File("acta_final.txt");
	    FileWriter fw = new FileWriter(finalActa, false);
	    PrintWriter pw = new PrintWriter(fw);

	    String linea = br.readLine();
	    int totalVotos = 0;
	    Candidato ganador = new Candidato();
	    ganador.setVotos(-1);
	    
	    while (linea != null) {
	    	Candidato candidato = new Candidato();
	        candidato.leerCandidato(linea);

	        System.out.println("Candidato: " + candidato.getNombre() + " - Partido: " + candidato.getPartido() + " - Votos: " + candidato.getVotos());
	        pw.println("Candidato: " + candidato.getNombre() + " - Partido: " + candidato.getPartido() + " - Votos: " + candidato.getVotos());

	        totalVotos += candidato.getVotos();

	        if (candidato.getVotos() > ganador.getVotos()) {
	            ganador = candidato;
	        }

	        linea = br.readLine();
	    }

	    br.close();
	    fr.close();
	    
	    System.out.println("Total votos: " + totalVotos);
	    System.out.println("Ganador: " + ganador.getNombre() + " (" + ganador.getPartido() + ") con " + ganador.getVotos() + " votos.");

	    pw.println("Total votos: " + totalVotos);
	    pw.println("Ganador: " + ganador.getNombre() + " (" + ganador.getPartido() + ") con " + ganador.getVotos() + " votos.");

	    pw.flush();
	    pw.close();
	    fw.close();

	    System.out.println("Acta final exportada en: acta_final.txt");
	    }
    }
    

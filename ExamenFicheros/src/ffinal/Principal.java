package ffinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Principal {

	public static int menu() throws IOException {
		int opcion = 0;

		do {
			System.out.println("--- Elecciones ---");
			System.out.println("1. Añadir candidato");
			System.out.println("2. Ver candidatos de un partido");
			System.out.println("3. Actualizar votos");
			System.out.println("4. Exportar acta final");
			System.out.println("5. Salir");

			try {
				opcion = Lecturas.leerEntero("Selecciona una opción: ");
			} catch (NumberFormatException e) {
				System.out.println("La opcion introducida no es valida");
				opcion = 0;
			}

		} while (opcion < 1 || opcion > 5);
		return opcion;

	}

	public static void main(String[] args) throws IOException {
		int opcion;
		File FICHERO_CANDIDATOS = new File("candidatos.txt");
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				Candidato candidato = new Candidato();
				candidato.pedirCandidato();
				candidato.escribirFichero(FICHERO_CANDIDATOS, true);
				break;
			case 2:buscarCandidatoPorNombre();break;
			case 3:actualizarVotos();break;
			case 4:exportarActaFinal();break;
			case 5:
				System.out.println("Saliendo...");
				break;
			}
		} while (opcion != 5);

	}
	
	public static void buscarCandidatoPorNombre() throws IOException {
		File FICHERO_ELECTORALES = new File("candidatos.txt");

		if (FICHERO_ELECTORALES.exists()) {
			String partido;

			partido = Lecturas.leerOpcion("Introduce el partido a buscar (AJE / PJS / PCD / MIAF):",
					new String[] { "AJE", "PJS", "PCD", "MIAF" });

			System.out.println("Partido: " + partido);

			FileReader fr = new FileReader(FICHERO_ELECTORALES);
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
				System.out.println("Fichero de elecciones no encontrado.");
			}
	}
	
	public static void actualizarVotos() throws IOException {
		File FICHERO_CANDIDATOS = new File("candidatos.txt");

	    if (!FICHERO_CANDIDATOS.exists()) {
	        System.out.println("No existe el fichero candidatos.txt");
	        return;
	    }

	    boolean enc = false;
	    int idCandidato;

	    do {
	        idCandidato = Lecturas.leerEntero("Introduce el id del candidato: ");
	        enc = false;

	        FileReader fr = new FileReader(FICHERO_CANDIDATOS);
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

	    FileReader fr = new FileReader(FICHERO_CANDIDATOS);
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

	    int nuevosVotos;
	    do {
	        nuevosVotos = Lecturas.leerEntero("Introduce los nuevos votos: ");
	        if (nuevosVotos < candidatoActual.getVotos()) {
	            System.out.println("Los nuevos votos no pueden ser menores que los actuales (" + candidatoActual.getVotos() + ").");
	        }
	    } while (nuevosVotos < candidatoActual.getVotos());

	    File fTemporal = new File("candidatos_tmp.txt");
	    FileReader fr2 = new FileReader(FICHERO_CANDIDATOS);
	    BufferedReader br2 = new BufferedReader(fr2);
	    FileWriter fw = new FileWriter(fTemporal, false);
	    PrintWriter pw = new PrintWriter(fw);

	    linea = br2.readLine();
	    while (linea != null) {
	        Candidato c = new Candidato();
	        c.leerCandidato(linea);
	        if (c.getId() == idCandidato) {
	            c.setVotos(nuevosVotos);
	        }
	        pw.println(c.getId() + "-" + c.getNombre() + "-" + c.getPartido() + "-" + c.getVotos());
	        linea = br2.readLine();
	    }

	    br2.close();
	    fr2.close();
	    pw.flush();
	    pw.close();
	    fw.close();

	    if (FICHERO_CANDIDATOS.delete()) {
	        fTemporal.renameTo(FICHERO_CANDIDATOS);
	    } else {
	        System.err.println("Error al actualizar el fichero.");
	    }

	    System.out.println("Votos actualizados correctamente.");
	}

	public static void exportarActaFinal() throws IOException {
		File FICHERO_CANDIDATOS  = new File("candidatos.txt");
		
		if (!FICHERO_CANDIDATOS.exists()) {
	        System.out.println("No existe el fichero candidatos.txt");
	        return;
	    }

			FileReader fr = new FileReader(FICHERO_CANDIDATOS);
			BufferedReader br = new BufferedReader(fr);
			
			File fActa = new File("acta_final.txt");
		    FileWriter fw = new FileWriter(fActa, false);
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
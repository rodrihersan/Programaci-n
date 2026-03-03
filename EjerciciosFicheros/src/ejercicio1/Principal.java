package ejercicio1;

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
			System.out.println("\n=== FICHEROS ALUMNOS ===");
			System.out.println("1. Añadir un alumno nuevo");
			System.out.println("2. Imprimir por pantalla la nota media");
			System.out.println("3.Generar otro fichero");
			System.out.println("4. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== AÑADIR UN ALUMNO NUEVO ===");
				añadirAlumno();
				break;
			case 2:
				System.out.println("=== CALCULAR MEDIA ===");
				calcularMedia();
				break;
			case 3:
				System.out.println("=== CREAR NUEVO FICHERO ===");
				crearFichero();
				break;
			case 4:
				System.out.println("Salir");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void añadirAlumno() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int res = 0; //res= respuesta
		char masAlumnos = 'A';
		boolean añadir = false;

		do {
			try {

				System.out.println("Introduce 1 si desea sobreescribir los datos o 2 si desea añadirlos a los existentes");
				res = Integer.parseInt(leer.readLine());

			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} while (res != 1 && res != 2);

		if (res == 1) {
			añadir = false;
		} else {
			añadir = true;
		}

		do {
			Alumno alumno = new Alumno();
			alumno.pedirDatos();
			alumno.guardar(añadir);

			do {
				System.out.println("¿Quiere añadir otro alumno? (S/N)");
				try {
					masAlumnos = leer.readLine().toUpperCase().charAt(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (masAlumnos != 'S' && masAlumnos != 'N');

			añadir = true;

		} while (masAlumnos == 'S');

	}

	private static void calcularMedia() throws IOException {
		File f = new File("./alumnos.txt");

		// (1) COMPROBAR QUE EL FICHERO EXISTE
		if (f.exists()) {
			// (2) CREO EL OBJETO FILEREADER y BUFFEREDREADER
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			// (3) VOY A CREARME OBJETO ALUMNO
			Alumno a = new Alumno();

			// (4) LEO LA PRIMERA LINEA DEL FICHERO
			String linea = br.readLine();

			while (linea != null) {
				String[] v;

				// (5) RECOGO EL NUMERO DE EXPEDIENTE DEL ALUMNO
				v = linea.split(": "); // SPLIT DEVUELVE UN ARRAY DIVIDIENDO EL STRING POR LO QUE SE PASE.
				a.setExpediente(Integer.parseInt(v[1])); // V[1] CONTIENE EL NUM EXPEDIENTE EN STRING

				// (6) LEEMOS SIGUIENTE LINEA Y EXTREMOS EL NOMBRE DEL ALUMNO
				linea = br.readLine();
				v = linea.split(": ");
				a.setNombre(v[1]); // v[1] contiene el nombre

				// (7) EXTRAEMOS LAS NOTAS
				linea = br.readLine(); // ESTA LINEA SOLO TIENE "NOTAS"
				double[] notas = new double[3];

				// (8) VOY LEYENDO LAS 3 NOTAS
				for (int i = 0; i < 3; i++) {
					linea = br.readLine();
					notas[i] = Double.parseDouble(linea);
				}

				a.setNotas(notas); // GUARDO LA NOTA EN ALUMNO

				// (9) IMPRIMIR DATOS

				System.out.println("La media del alumno " + a.getNombre() + " con expediente " + a.getExpediente()
						+ " tiene una media de " + a.calcularMedia());

				// (10) LEO LA SIGUIENTE LINEA. QUE O BIEN ES OTRO ALUMNO O ES EL FINAL DEL
				// FICHERO
				linea = br.readLine();

			}

			br.close();
			fr.close();

		} else {
			System.out.println("NO EXISTE EL FICHERO ALUMNOS.TXT");
		}

	}

	private static void crearFichero() throws IOException {
		File f = new File("./alumnos.txt");

		// (1) Leer ficheros alumnos.txt
		if (f.exists()) {
			// (1.1) CREO EL OBJETO FILEREADER y BUFFEREDREADER
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			// (1.2) LEO EL FICHERO

			String linea = br.readLine();

			while (linea != null) {
				String[] v;

				// (1.3) BUSCO LA LINEA QUE EMPIEZA POR NOMBRE.
				// DEVUELVE TRUE SI ES LA LINEA "NOMBRE"
				if (linea.startsWith("NOMBRE")) {

					// (1.4) LEEMOS SIGUIENTE LINEA Y EXTREMOS EL NOMBRE DEL ALUMNO
					v = linea.split(": ");
					String nombre = v[1]; // v[1] contiene el nombre

					// (2) Comprobamos si esta reptido. Devuelve falso si no esta
					if (comprobarSiElNombreEsta(nombre) == false) {
						escribirNombre(nombre);
					}

				}
				linea = br.readLine();
			}

			br.close();
			fr.close();
			
			System.out.println("Fichero creado :)");
		} else {
			System.out.println("No existe el fichero alumnos.txt");
		}

	}

	// (2) METODO PARA COMPROBAR SI UN NOMBRE ESTA EN nombres.txt
	private static boolean comprobarSiElNombreEsta(String nombre) throws IOException {
		File f = new File("./nombres.txt");

		if (f.exists()) {
			// (2.2) CREO EL OBJETO FILEREADER y BUFFEREDREADER
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			// (2.3) LEO EL FICHERO
			String linea = br.readLine();

			while (linea != null) {
				// Cada linea es un nombre
				// Comprobamos si el nombre leido coincide con el que le hemos pasado
				if (linea.equalsIgnoreCase(nombre)) {
					br.close();
					return true;
				}

				linea = br.readLine();
			}
			// Si salimos del bucle sabemos que el nombre no esta en fichero
			br.close();
			return false;

		} else {
			// Si no existe el fichero, el nombre no esta.
			// Devolvemos falso
			return false;
		}

	}

	// (3) METODO QUE ESCRIBE NOMBRE
	private static void escribirNombre(String nombre) throws IOException {
		// (3.1) Creamos FIle
		File f = new File("./nombres.txt");
		FileWriter fw = new FileWriter(f, true); // No sobreescribimos, sino añadimos. append = true
		PrintWriter pw = new PrintWriter(fw);
		
		// (3.2) Escribimos el nombre
		pw.println(nombre);
		
		// (3.3) Cerramos el fichero
		pw.close();
		fw.close();

	}

}
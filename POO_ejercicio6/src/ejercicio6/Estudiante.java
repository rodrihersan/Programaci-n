package ejercicio6;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Estudiante {
	private int id;
	private String nombre;
	private int edad;
	private int curso;
	private float notaMedia;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre del estudiante: ");
				nombre = leer.readLine();
				do {
					System.out.println("Introduce la edad: ");
					edad = Integer.parseInt(leer.readLine());
					if (edad < 18)
						System.out.println("Tienes que introducir un edad mayor de 18");
				} while (edad < 18);

				do {
					System.out.println("Introduce el curso del estudiante: ");
					curso = Integer.parseInt(leer.readLine());
					if (curso != 1 && curso !=2)
						System.out.println("Curso solo puede ser 1 o 2");
				} while (curso != 1 && curso != 2);

				do {
					System.out.println("Introduce la nota media del estudiante: ");
					notaMedia = (float) Double.parseDouble(leer.readLine());
					if (notaMedia < 0 || notaMedia > 10)
						System.out.println("Tienes que introducir una nota entre 1 y 10");
				} while (notaMedia < 0 ||  notaMedia > 10);

				datosOK = true;
			} catch (Exception e) {
				System.err.println("Has introducido algun dato mal");
				System.out.println("");
			}
		}

	}

	//Este metodo y el de si esta aprobado es el mismo
	public boolean notaMediaAprobada() {
		if (notaMedia >= 5) {
				return true;
		}else {
			return false;
		}
	}
	
	public String notaEscrita() {
		if(notaMedia >= 9) {
			return "Sobresaliente";
		}else if(notaMedia < 9 && notaMedia >= 7) {
			return "Notable";
		}else if(notaMedia < 7 && notaMedia >= 6) {
			return "Bien";
		}else if(notaMedia < 6 && notaMedia >= 5) {
			return "Suficiente";
		}else {
			return "Insuficiente";
		}
	}
	
	public void mostrarDatos() {
		System.out.println("ESTUDIANTE " + id);
		System.out.println("\tNombre: " + nombre);
		System.out.println("\tEdad: " + edad);
		System.out.println("\tCurso: " + curso);
		System.out.println("\tNota Media: " + notaMedia);
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCurso() {
		return curso;
	}

}
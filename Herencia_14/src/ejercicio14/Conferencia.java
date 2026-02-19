package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conferencia extends Evento {
	private static final double TARIFA_PAGO = 25.0;

	private String ponente;
	private String[] nombresParticipantes = new String[50];
	private String[] emailsParticipantes = new String[50];
	private int numParticipantes;
	private boolean esGratuita;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el nombre del ponente: ");
				this.ponente = leer.readLine();

				String gratuita = "";
				do {
					System.out.print("¿La conferencia es gratuita? (si/no): ");
					gratuita = leer.readLine();
					if (!gratuita.equalsIgnoreCase("si") && !gratuita.equalsIgnoreCase("no"))
						System.out.println("Solo puedes introducir si o no");
				} while (!gratuita.equalsIgnoreCase("si") && !gratuita.equalsIgnoreCase("no"));

				this.esGratuita = gratuita.equalsIgnoreCase("si");
				numParticipantes = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirParticipante() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numParticipantes >= 50) {
			System.out.println("Se ha alcanzado el límite de 50 participantes");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre del participante: ");
				nombresParticipantes[numParticipantes] = leer.readLine();

				System.out.print("Introduce el email del participante: ");
				emailsParticipantes[numParticipantes] = leer.readLine();

				numParticipantes++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean buscarParticipante(String nombre) {
		for (int i = 0; i < numParticipantes; i++) {
			if (nombresParticipantes[i].equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	public double calcularRecaudacion() {
		if (esGratuita)
			return 0;
		return numParticipantes * TARIFA_PAGO;
	}

	public int getNumAsistentes() {
		return numParticipantes;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Conferencia");
		System.out.println("Ponente: " + this.ponente);
		System.out.println("Gratuita: " + (esGratuita ? "Sí" : "No"));
		System.out.println("Participantes registrados: " + this.numParticipantes);
		System.out.println("----------------------------");
	}

}
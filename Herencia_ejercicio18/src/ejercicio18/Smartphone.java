package ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Smartphone extends Dispositivo {
	private String sistemaOperativo;
	private int bateria;
	private String[] apps = new String[30];
	private int numApps;

	public void pedirDatos(ArrayList<Dispositivo> dispositivos) {
		super.pedirDatos(dispositivos);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el sistema operativo: ");
				this.sistemaOperativo = leer.readLine();

				boolean bateriaOk = false;
				while (!bateriaOk) {
					try {
						System.out.print("Introduce la capacidad de la bateria (mAh): ");
						this.bateria = Integer.parseInt(leer.readLine());
						bateriaOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				numApps = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean instalarApp() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numApps >= 30) {
			System.out.println("No se pueden instalar mas apps, limite de 30 alcanzado");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre de la app a instalar: ");
				apps[numApps] = leer.readLine();
				numApps++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean tieneApp(String app) {
		for (int i = 0; i < numApps; i++) {
			if (apps[i].equalsIgnoreCase(app)) {
				return true;
			}
		}
		return false;
	}

	public double calcularGarantiaExtendida() {
		return super.calcularGarantiaExtendida() + (getMesesGarantia() * 3);
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Smartphone");
		System.out.println("Sistema operativo: " + this.sistemaOperativo);
		System.out.println("Bateria: " + this.bateria + " mAh");
		System.out.println("Apps instaladas: ");
		for (int i = 0; i < numApps; i++) {
			System.out.println("  - " + apps[i]);
		}
		System.out.println("----------------------------");
	}

}
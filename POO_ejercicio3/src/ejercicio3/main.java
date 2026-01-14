package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		Cuenta c1 = null;
		Cuenta c2 = null;

		do {
			System.out.println("BANCO");
			System.out.println("1. Crear cuenta");
			System.out.println("2. Ingresar");
			System.out.println("3. Retirar");
			System.out.println("4. Ver datos");
			System.out.println("5. Salir");
			System.out.println("Introduce una opcion: ");
			int opcion = Integer.parseInt(leer.readLine());

			switch (opcion) {
			case 1:
				System.out.println("Crear cuenta");
				/* OPCION 1: PEDIR DATOS AQUI */
				System.out.print("Introduce el nombre del titular: ");
				String titular = leer.readLine();
				System.out.print("Introduce el saldo: ");
				double saldo = Double.parseDouble(leer.readLine());
				c1 = new Cuenta(titular, saldo);

				/* OPCION 2: PEDIR DATOS en la clase */
				c2 = new Cuenta();
				c2.pedirDatos();
				break;
			case 2:
				if (c1 != null) {
					System.out.print("Inserte la cantidad a ingresar: ");
					double aIngresar = Double.parseDouble(leer.readLine());
					c1.ingresarSaldo(aIngresar);
					c2.ingresarSaldo(aIngresar);
				} else {
					System.out.println("Cree una cuenta antes con la opcion 1");
				}

				break;
			case 3:
				if (c1 != null) {
					System.out.print("Inserte la cantidad a retirar: ");
					double aRetirar = Double.parseDouble(leer.readLine());
					c1.retirarSaldo(aRetirar);
					c2.retirarSaldo(aRetirar);
				} else {
					System.out.println("Cree una cuenta antes con la opcion 1");
				}

				break;
			case 4:
				if (c1 != null) {
					/*OPCION 1 - GET*/
					System.out.println("Titular: " + c1.getTitular() + " saldo " + c1.getSaldo());
					System.out.println("Titular: " + c2.getTitular() + " saldo " + c2.getSaldo());
					/*OPCION 3 - ocn metodo */
					c1.obtenerDatos();
					c2.obtenerDatos();
				} else {
					System.out.println("Cree una cuenta antes con la opcion 1");
				}


			}

		} while (!salir);
	}

}
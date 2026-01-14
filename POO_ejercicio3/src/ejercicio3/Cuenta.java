package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cuenta {
	private String titular;
	private double saldo;

	// CREAR CLASE
	/* Aqui podemos tener dos opciones, usar el constructor o no */
	/* OPCION 1 - Usamos el constructor y pedimos los datos en el main */
	public Cuenta(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	/*
	 * OPCION 2- O como los datos son algo propio de la clase Cuenta, podemos
	 * pedirlos aqui
	 */
	public void pedirDatos() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Introduce el nombre del titular: ");
		titular = leer.readLine();
		System.out.print("Introduce el saldo: ");
		saldo = Double.parseDouble(leer.readLine());
	}

	/*
	 * En este caso pq he declaro el constructor antes necesitare el vacio. Si no lo
	 * declaro, java lo crea automaticamente
	 */
	public Cuenta() {
	}

	public void ingresarSaldo(double cantAIngresar) {
		saldo = saldo + cantAIngresar;
		System.out.println("El nuevo saldo es:" + saldo);
	}

	public void retirarSaldo(double cantARetirar) {
		if (saldo >= cantARetirar) {
			saldo = saldo - cantARetirar;
			System.out.println("El nuevo saldo es:" + saldo);
		} else {
			System.out.println("No se puede retirar el saldo, no hay fondos suficientes :(");
		}

	}

	// OBTENER DATOS
	/* Opcion 1 - Con getters */
	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	/* Opcion 2 - Metodo */
	public void obtenerDatos() {
		System.out.println("Titular de la cuenta: " + titular + " y saldo: " + saldo);
	}

}
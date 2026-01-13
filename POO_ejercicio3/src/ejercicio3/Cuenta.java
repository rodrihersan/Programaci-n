package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cuenta {
	private String titular;
	private double saldo;
	
	public void ingresarSaldo(double cantAIngresar) {
		saldo = saldo + cantAIngresar;
		System.out.println("El nuevo saldo es: " + saldo);
	}
	
	public void retirarSaldo(double cantARetirar) {
		if(saldo >= cantARetirar) {
			saldo = saldo - cantARetirar;
			System.out.println("El nuevo saldo es: "+saldo);
		}else {
			System.out.println("No se puede retirar el saldo, no hay fondos suficientes");
		}
	}
	//CRAR CLASE
			/*Aqui podemos tener dos opciones, usar el constrcutor o no*/
			/*OPCION1: usamos constructor y pedimos los datos en el main*/
		
		public Cuenta(String titular, double saldo) {
			this.titular = titular;
			this.saldo = saldo;
		}
		
			/*OPCION2: como los datos son algo propio de la cuenta, podemos pedirlos aqui*/
		public void pedirDatos()  throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Introduce el nombre del titular: ");
		titular = leer.readLine();
		System.out.print("Introduce el saldo: ");
		saldo = Double.parseDouble(leer.readLine());
		}
		/*En este caso porque he declarado el constructor antes necesitare el vacio. Si no lo declaro
		 *  java lo crea automaticamente
		 */
		public Cuenta() {}
		
		//OBTENER DATOS
			/*Opcion1 - con getters */
		public String getTitular() {
			return titular;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
			/*Opcion2 - con Metodo*/
		public void obtenerDatos() {
			System.out.println("Titular de la cuenta: " + titular + "y saldo: "+ saldo);
		}
	}
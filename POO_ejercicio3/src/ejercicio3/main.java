package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
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
			System.out.println("Inserte una opcion:");
			int opcion = Integer.parseInt(leer.readLine());
			
			switch(opcion) {
			case 1:
				System.out.println("1. Crear cuenta");
				/*OPcion1: pedir datos aqui*/
				System.out.print("Introduce el nombre del titular: ");
				String titular = leer.readLine();
				System.out.print("Introduce el saldo: ");
				double saldo = Double.parseDouble(leer.readLine());
				c1 = new Cuenta(titular,saldo);
				
				/*OPCION2: Pedir datos de clase*/
				c2 = new Cuenta();
				c2.pedirDatos();
			break;
			
			case 2:
				if(c1 != null) {
				System.out.println("Inserte cantidad a Ingresar");
				double aIngresar = Double.parseDouble(leer.readLine());
				c1.ingresarSaldo(aIngresar);
				c2.ingresarSaldo(aIngresar);
				}else {
					System.out.println("Cree una cuenta antes, con la opcion 1");
				}
			
			case 3:
				System.out.println("Inserte cantidad a Retirar");
				double aRetirar = Double.parseDouble(leer.readLine());
				if(c1 != null) {
				c1.ingresarSaldo(aRetirar);
				c2.ingresarSaldo(aRetirar);
				}else {
					System.out.println("Cree una cuenta antes, con la opcion 1");
				}
			
			case 4: 
				if(c1 != null) {
					/*Opcion1 - con get */
					System.out.println("Titular: "+ c1.getTitular()+ " saldo "+ c1.getSaldo());
					System.out.println("Titular: "+ c2.getTitular()+ " saldo "+ c2.getSaldo());
					/*OPCION3: CON METODO*/
					c1.obtenerDatos();
					c2.obtenerDatos();
				}else {
					System.out.println("Cree una cuenta antes en la opcion1");
				}
				}
			}while(!salir);
		}
	}

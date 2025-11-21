package Condicionales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicios_6_9{

	public static void main(String[] args) throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		
		//6.Diseñar un algoritmo que determine cuál es el mayor de tres números 
		//introducidos por teclado
		
		System.out.println("Dame 3 numeros: ");
		int numero1;
		int numero2;
		int numero3;
		numero1 = Integer.parseInt(lector.readLine());
		numero2 = Integer.parseInt(lector.readLine());
		numero3 = Integer.parseInt(lector.readLine());
		if(numero1 > numero2 && numero1 >numero3) 
			System.out.println("Numero 1 es el mayor");
		else if(numero2 > numero1 && numero2 > numero3) {
			System.out.println("Numero 2 es el mayor");
		}else if(numero3 > numero2 && numero3 > numero1){
			//se podria poner solamente else (sin el if) pero no hay que poner la
			//condición (lo que va dentro de los parentesis)
			// }else{
			//System.out.println("Numero 3 es el mayor");}
			System.out.println("Numero 3 es el mayor");}
		
		//7.Escribe un programa que lea una calificación numérica entre 0 y 10, y la transforma en
		//calificación alfabética, escribiendo el resultado:
		//de 0 a <3 Muy Deficiente
		//de 3 a <5 Insuficiente
		//de 5 a <6 Bien
		//de 6 a <9 Notable
		//de 9 a 10 Sobresaliente
		System.out.print("Dame una nota: ");
		double nota = Double.parseDouble(lector.readLine());
		
		if (nota <= 3)
			System.out.println("Tu nota es: Muy deficiente");
		else if (nota > 3 && nota <=5) {
			System.out.println("Tu nota es: Insuficiente");}
		else if (nota > 5 && nota <=6) {
			System.out.println("Tu nota es: Bien");}
		else if (nota > 6 && nota <=9) {
			System.out.println("Tu nota es: Notable");}
		else {
			System.out.println("Tu nota es: Sobresaliente");
		}
	
		//8.Escribir un programa que lea un año indicar si es bisiesto. Un año es bisiesto si es un
		//número divisible por 4, pero no si es divisible por 100, excepto que también sea divisible
		//por 400.
		
		System.out.print("Dame un año y te digo si es bisiesto o no: ");
		double año = Double.parseDouble(lector.readLine());
		
		if((año % 4 == 0 && año % 100 != 0) || (año % 400 ==0)) {
			//las barras || es "o"
			System.out.println("Año bisiesto");}
		else {
			System.out.println("No lo es");
		}
			
		
		//9.Realizar un algoritmo que muestre en pantalla el interés producido por una cuenta
		//corriente, según los siguientes datos:
		//Por un saldo hasta 1.000.000 se abonará un 5% de interés.
		//Por un saldo entre 1.000.001 y 2.000.000 se abonará un 7% de interés.
		//Por un saldo entre 2.000.001 y 5.000.000 se abonará un 8% de interés.
		//Por un saldo de más de 5.000.000 se abonará un 9% de interés.
		//El saldo será un dato introducido por teclado
		
		System.out.print("Indique su saldo: ");
		double saldo = Double.parseDouble(lector.readLine());
		
		if(saldo <= 1000)
			System.out.print("El interes de su saldo es: " + (saldo*(5.0/100.01)) + " euros");
		//si pones 5/100 no lo detecta por el tema decimales. entonces ponemos:
		//5.0/100.0 o 0.05
		else if (saldo >= 1000.001 && saldo <=2000.000) {
			System.out.print("El interes de su saldo es: " + (saldo*(0.07)) + " euros");}
		else if (saldo >=2000.001 && saldo <= 5000.000) {
			System.out.print("El interes de su saldo es: " + (saldo*(0.08)) + " euros");}
		else {
			System.out.print("El interes de su saldo es: " + (saldo*(0.09)) + " euros");}
		}		
	}

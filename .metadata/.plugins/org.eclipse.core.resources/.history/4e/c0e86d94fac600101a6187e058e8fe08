package Condicionales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicios_12_14y18_19 {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		
		//12. Escribir un ejercicios que dado una fecha de nacimiento, día y mes, nos devuelva el signo
		//del zodiaco. Podemos tener en cuenta la siguiente lógica, en un mes solo puede haber dos
		//signos, y podemos tomar el día 21 como referencia. Por ejemplo, en Enero, si naciste antes
		//del 21 eres Capricornio y si naciste el 21 o algún día posterior del mes de Enero, eres
		//Acuario.

		System.out.println("Dame la fecha de nacimiento. 1º:dia 2º:mes");
		double dia = Double.parseDouble(lector.readLine());
		double mes = Double.parseDouble(lector.readLine());
		
		if(mes == 1) {
			if(dia <=21) {
				System.out.println("Eres capricornio");}
				else if (dia>21 && dia<=31) {
					System.out.println("Eres acuario");}}
		if(mes == 2) {
			if(dia <=21) {
				System.out.println("Eres tauro");}
			else if (dia>21 && dia<=31) {
				System.out.println("Eres geminis");}}
		//asi todo el rato ......
		
		//13. Algoritmo que calcule el sueldo de una persona dependiendo del número de horas que
		//haya trabajado. Si el número de horas trabajadas es menor de 40, el sueldo se calculará
		//multiplicando el número de horas por 1000; si el nº de horas trabajadas excede de 40, las
		//primeras 40 se pagan a 1000 pesetas y las que excedan se le pagan a 1500. El número de
		//horas trabajadas es introducido por el usuario
		System.out.print("Dime el numero de horas trabajadas: ");
		double horas = Double.parseDouble(lector.readLine());
		double horasNormales = 40;
		double horasExtras = (horas - horasNormales);
		if(horas <= 40)
			System.out.print("Usted cobrará: " + (horas*1000) + " pesetas.");
		
		else {
			System.out.print("Usted cobrará: " + ((horasNormales*1000) + (horasExtras*1500))+ " pesetas.");}
		
		
		//14.La asociación de vinicultores tiene como política fijar un precio inicial al kilo de uva, la cual
		//se clasifica en tipos A y B, y además en tamaños 1 y 2. Cuando se realiza la venta del
		//producto, ésta es de un solo tipo y tamaño, se requiere determinar cuánto recibirá un
		//productor por la uva que entrega en un embarque, considerando lo siguiente:
		//si es de tipo A, se le cargan 20 céntimos al precio inicial cuando es de tamaño 1; y 30
		//céntimos si es de tamaño 2.
		//Si es de tipo B, se rebajan 30 céntimos cuando es de tamaño 1, y 50 céntimos
		//cuando es de tamaño 2.
		//Realice un algoritmo para determinar la ganancia obtenida.
		System.out.print("Precio inicial por kilo: ");
		double precioInicial = Double.parseDouble(lector.readLine());

		System.out.print("Dime que tipo de uva tienes, 'a' o 'b': ");
		char TipoUva = lector.readLine().charAt(0);
		//Devuelve primera letra introducida por el usuario en formato char
		
		System.out.print("Dime que tamaño de uva tienes, '1' o '2': ");
		int tamaño = Integer.parseInt(lector.readLine());
		
		System.out.print("Kilos por uva: ");
		double kilos = Double.parseDouble(lector.readLine());
		
		double precioFinal = 0;
		
		if(TipoUva == 'A') { //tipo.equealsIgnoreCase('A') para string
			if(tamaño == 1) {
				precioFinal = precioInicial + 0.20;
			System.out.print("Tipo A, tamaño 1, +0.20");}
			else if(tamaño == 2) {
				precioFinal = precioInicial + 0.30;
				System.out.print("Tipo A, tamaño 2, +0.30");}}
		
		 if(TipoUva == 'B') { //en este caso se podria usar if en vez de else if porque la variable qu enetra primero es una letra
			if(tamaño == 1) {
				precioFinal = precioInicial - 0.30;
			System.out.print("Tipo A, tamaño 1, -0.30");}
			else if(tamaño == 2) {
				precioFinal = precioInicial - 0.50;
				System.out.print("Tipo B, tamaño 2, -0.50");}}
			double ganancia = precioFinal * kilos;
			System.out.println("Precio final = " + precioFinal);
			System.out.println("Ganancia final: " + ganancia + " euros");
			
			
			//18
			
			System.out.print("Introduce el nombre del alumno/a: ");
			String nombre = lector.readLine();
			
			System.out.println("Introduce el eñao de nacimiento:");
			int añoNacimiento = Integer.parseInt(lector.readLine());
			
			int edad = 2025 - añoNacimiento;
			boolean puedeSalir = false;
			
			if(edad >=15 && edad<18) {
				System.out.println("¿Autorizacion firmada por los padres? S/N");
				char autorizacionFirmada = lector.readLine().charAt(0);
				if(autorizacionFirmada == 'S' || autorizacionFirmada == 's') {
					puedeSalir = true;
				}
			}else if(edad>=18) {
				puedeSalir = true;
			}
			System.out.println(nombre + "," + edad
					+ " años, ¿Puede salir fuera en los recreos?: " + puedeSalir);
				
				
				
				
			//19
				
			System.out.print("Introduce el nombre del juego: ");
			String nombreJuego = lector.readLine();
			
			System.out.println("Introduce Nota 1: ");
			double nota1 = Double.parseDouble(lector.readLine());
			
			System.out.println("Introduce Nota 2: ");
			double nota2 = Double.parseDouble(lector.readLine());
			
			double nota3 = (Math.random() * 10) +1;
			System.out.print("Nota tester 3 aleatoria f" + nota3);
			
			double notaMedia = (nota1 + nota2 + nota3);
					
	}
}
			

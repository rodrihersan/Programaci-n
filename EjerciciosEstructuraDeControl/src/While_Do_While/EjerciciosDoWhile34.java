package While_Do_While;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EjerciciosDoWhile34 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		//ejercicio34
		for(int i = 0; i<=20; i++) { //se pueden hacer a la inversa for(int i = 10; i>0; i--) for(int i = 1; i<=20; i*=2)
			System.out.println(i + ", ");
		}
		
		//ejercicio35
		for(int i =0; i<=10/*tendria que ser mil aqui pero para que no se haga largo*/; i++) {
			System.out.println(i + ", ");
		}
		
		//ejercicio36
		int suma2= 0;
		for(int i=1; i<=100; i++) {
			suma2 = suma2+ i;
		}
		System.out.println("La suma de los 100 primeros números es: " + suma2); //lo sacamos fuera para que ponga solamente que la suma es 5050.
																				//si lo ponemos dentro del for pondra suma a suma hasta 5050 (0,1,3,6,10 etc)
		//ejercicio37
		for(int contador =2; contador <=200; contador+=2) {
			System.out.println(contador);
		}

		//ejercicio38
		int suma3 = 2;
		for(int i =0; i<=200; i+=2) {	
				System.out.println(suma3 + i + ", ");
		}
		
		//ejercicio39
		int impar=0;
		for(int i=1; i<=165; i+=2){
			impar=impar+ i;
		}
		System.out.println("La suma de los 165 primeros impares números es: " + impar);
		int par=0;
		for(int i=2; i<=165; i+=2) {
			par=par+ i;
		}
		System.out.println("La suma de los 165 primeros pares números es: " + par);
	}
}

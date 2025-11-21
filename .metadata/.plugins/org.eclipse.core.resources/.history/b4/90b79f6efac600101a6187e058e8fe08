package While_Do_While;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ejerciciosDoWhile3 {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // --- EJERCICIO 40 ---
        int sumaPares = 0;
        int sumaImpares = 0;
        int numPares = 0;
        int numImpares = 0;
        double media = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Introduce un numero: ");
            int numero = Integer.parseInt(lector.readLine());

            if (numero % 2 == 0) {
                sumaPares += numero;
                numPares++;
                System.out.println(numero + " es par");
            } else {
                sumaImpares += numero;
                numImpares++;
                System.out.println(numero + " es impar");
            }
        }

        if (numImpares > 0) {
            media = (double) sumaImpares / numImpares;
            System.out.println("La media de numeros impares es " + media);
        } else {
            System.out.println("No se introdujeron numeros impares, no se puede calcular la media.");
        }
        System.out.println("La suma de numeros pares es " + sumaPares);
        System.out.println("Hay " + numPares + " numeros pares");

        // --- EJERCICIO 41 ---
        int numPositivos = 0;
        int numNegativos = 0;
        int numNulos = 0;

        for (int i = 1; i <= 20; i++) {
            System.out.print("Introduce un numero: ");
            int numero = Integer.parseInt(lector.readLine());

            if (numero > 0)
                numPositivos++;
            else if (numero < 0)
                numNegativos++;
            else
                numNulos++;
        }
        System.out.println("Los numeros positivos han sido " + numPositivos + "\n" +
                           "Los numeros negativos han sido " + numNegativos + "\n" +
                           "Los numeros nulos han sido " + numNulos);

        // --- EJERCICIO 42 ---
        System.out.print("Dime un numero entero positivo: ");
        int numeroEntero = Integer.parseInt(lector.readLine());

        if (numeroEntero <= 0) {
            System.out.println("El número debe ser positivo.");
        } else {
            int contador = 0;
            int copiaNumero = numeroEntero; // Para no modificar el original

            while (copiaNumero > 0) {
                copiaNumero = copiaNumero / 10;
                contador++;
            }

            System.out.println("El número " + numeroEntero + " tiene " + contador + " cifras.");
        }

        // --- EJERCICIO 48 ---
        System.out.print("Introduce un número entero: ");
        int numeroTriangulo = Integer.parseInt(lector.readLine());

        for (int i = 0; i <= numeroTriangulo; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // --- EJERCICIO 49 ---
        System.out.print("Introduce un número entero entre 0 y 10: ");
        int n = Integer.parseInt(lector.readLine());

        if (n >= 0 && n <= 10) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        } else {
            System.out.println("El número debe estar entre 0 y 10.");
        }

        // --- EJERCICIO 50 ---
        System.out.print("Dime un numero: ");
        int numeroA = Integer.parseInt(lector.readLine());
        System.out.print("Dime un segundo numero: ");
        int numeroB = Integer.parseInt(lector.readLine());

        if (numeroB > numeroA) {
            int contadorPares = 0;

            System.out.println("Números desde " + numeroA + " hasta " + numeroB + ":");
            for (int i = numeroA; i <= numeroB; i++) {
                System.out.println(i);
                if (i % 2 == 0) {
                    contadorPares++;
                }
            }
            System.out.println("Cantidad de números pares: " + contadorPares);
        } else {
            System.out.println("El segundo número debe ser mayor que el primero.");
        }
    } // fin main

} // fin clase

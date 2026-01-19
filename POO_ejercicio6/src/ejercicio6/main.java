package ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        estudiante[] estudiantes = new estudiante[20];
        int contadorId = 1;
        
        boolean salir = false;

        do {
            System.out.println("\nGESTIÓN DE ALUMNOS DAW");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Mostrar aprobados");
            System.out.println("5. Filtrar por clasificación");
            System.out.println("6. Alumnos que pueden pasar de curso");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {

            case 1:
                int posLibre = -1;
                for (int i = 0; i < estudiantes.length; i++) {
                    if (estudiantes[i] == null) {
                        posLibre = i;
                        break;
                    }
                }

                if (posLibre == -1) {
                    System.out.println("No hay más espacio para alumnos");
                    break;
                }

                try {
                    System.out.print("Nombre: ");
                    String nombre = leer.readLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(leer.readLine());
                    System.out.print("Curso (1 o 2): ");
                    int curso = Integer.parseInt(leer.readLine());
                    System.out.print("Nota media: ");
                    double nota = Double.parseDouble(leer.readLine());

                    estudiantes[posLibre] = new estudiante(posLibre, nombre, edad, curso, nota);
                    System.out.println("Alumno registrado correctamente");

                } catch (Exception e) {
                    System.out.println("Error al registrar el alumno: " + e.getMessage());
                }
                break;

            case 7:
                salir = true;
                System.out.println("Saliendo del programa :c");
                break;

            default:
                System.out.println("Opción no válida");
            }

        } while (!salir);
    }
}

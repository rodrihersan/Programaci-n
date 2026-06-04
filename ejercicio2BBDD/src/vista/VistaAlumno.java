package vista;

import java.util.ArrayList;
import controlador.AlumnoController;
import modelo.AlumnoDTO;
import utils.Lecturas;

public class VistaAlumno {
    AlumnoController alumnoController = new AlumnoController();

    public void menuAlumno() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Alumnos ===");
            System.out.println("1. Ver todos los alumnos");
            System.out.println("2. Buscar alumnos por edad maxima");
            System.out.println("3. Ver alumnos de un curso");
            System.out.println("4. Añadir alumno");
            System.out.println("5. Modificar alumno");
            System.out.println("6. Borrar alumno");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 6);
            switch (opcion) {
                case 1: mostrarTodosLosAlumnos(); break;
                case 2: buscarPorEdadMaxima(); break;
                case 3: buscarPorCurso(); break;
                case 4: añadirAlumno(); break;
                case 5: modificarAlumno(); break;
                case 6: borrarAlumno(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodosLosAlumnos() {
        ArrayList<AlumnoDTO> lista = alumnoController.obtenerTodosLosAlumnos();
        System.out.println("Alumnos");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (AlumnoDTO a : lista) {
                System.out.println(a.getId() + " | " + a.getNombre() + " | " + a.getEmail() + " | " + a.getEdad() + " años");
            }
        }
    }

    public void buscarPorEdadMaxima() {
        int edad = Lecturas.leerEntero("Introduce la edad maxima: ");
        ArrayList<AlumnoDTO> lista = alumnoController.obtenerAlumnosPorEdadMaxima(edad);
        System.out.println("Alumnos con edad <= " + edad);
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos con esa edad o inferior.");
        } else {
            for (AlumnoDTO a : lista) {
                System.out.println(a.getId() + " | " + a.getNombre() + " | " + a.getEmail() + " | " + a.getEdad() + " años");
            }
        }
    }

    public void buscarPorCurso() {
        String nombreCurso = Lecturas.leerString("Introduce el nombre del curso: ");
        ArrayList<AlumnoDTO> lista = alumnoController.obtenerAlumnosPorCurso(nombreCurso);
        System.out.println("Alumnos matriculados en '" + nombreCurso + "'");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos en ese curso o el curso no existe.");
        } else {
            for (AlumnoDTO a : lista) {
                System.out.println(a.getId() + " | " + a.getNombre() + " | " + a.getEmail() + " | " + a.getEdad() + " años");
            }
        }
    }

    public void añadirAlumno() {
        String nombre = Lecturas.leerString("Nombre: ");
        String email = Lecturas.leerString("Email: ");
        int edad = Lecturas.leerEntero("Edad: ");
        AlumnoDTO nuevo = new AlumnoDTO(nombre, email, edad);
        if (alumnoController.insertar(nuevo))
            System.out.println("Alumno añadido correctamente.");
        else
            System.out.println("Error al añadir el alumno.");
    }

    public void modificarAlumno() {
        int id = Lecturas.leerEntero("Id del alumno a modificar: ");
        String nombre = Lecturas.leerString("Nuevo nombre: ");
        String email = Lecturas.leerString("Nuevo email: ");
        int edad = Lecturas.leerEntero("Nueva edad: ");
        AlumnoDTO alumno = new AlumnoDTO(id, nombre, email, edad);
        if (alumnoController.actualizar(alumno))
            System.out.println("Alumno actualizado correctamente.");
        else
            System.out.println("Error al actualizar el alumno.");
    }

    public void borrarAlumno() {
        int id = Lecturas.leerEntero("Id del alumno a borrar: ");
        if (alumnoController.borrar(id))
            System.out.println("Alumno borrado correctamente.");
        else
            System.out.println("Error al borrar el alumno.");
    }
}
package vista;

import controlador.MatriculaController;
import utils.Lecturas;

public class VistaMatricula {
    MatriculaController matriculaController = new MatriculaController();

    public void menuMatricula() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Matriculas ===");
            System.out.println("1. Matricular alumno en un curso");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 1);
            switch (opcion) {
                case 1: matricularAlumno(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void matricularAlumno() {
        int idAlumno = Lecturas.leerEntero("Introduce el id del alumno: ");
        int idCurso = Lecturas.leerEntero("Introduce el id del curso: ");
        String fecha = Lecturas.leerString("Introduce la fecha (YYYY-MM-DD): ");
        if (matriculaController.matricularAlumno(idAlumno, idCurso, fecha))
            System.out.println("Matricula realizada correctamente.");
        else
            System.out.println("No se pudo realizar la matricula.");
    }
}
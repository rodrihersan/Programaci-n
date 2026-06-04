package vista;

import java.util.ArrayList;
import controlador.CursoController;
import modelo.CursoDTO;
import utils.Lecturas;

public class VistaCurso {
    CursoController cursoController = new CursoController();

    public void menuCurso() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Cursos ===");
            System.out.println("1. Ver todos los cursos");
            System.out.println("2. Buscar cursos por precio maximo");
            System.out.println("3. Añadir curso");
            System.out.println("4. Modificar curso");
            System.out.println("5. Borrar curso");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 5);
            switch (opcion) {
                case 1: mostrarTodosLosCursos(); break;
                case 2: buscarPorPrecioMaximo(); break;
                case 3: añadirCurso(); break;
                case 4: modificarCurso(); break;
                case 5: borrarCurso(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodosLosCursos() {
        ArrayList<CursoDTO> lista = cursoController.obtenerTodosLosCursos();
        System.out.println("Cursos");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            for (CursoDTO c : lista) {
                System.out.println(c.getId() + " | " + c.getNombre() + " | " + c.getDuracionHoras() + "h | " + c.getPrecio() + " EUR");
            }
        }
    }

    public void buscarPorPrecioMaximo() {
        double precio = Lecturas.leerDouble("Introduce el precio maximo: ");
        ArrayList<CursoDTO> lista = cursoController.obtenerCursosPorPrecioMaximo(precio);
        System.out.println("Cursos con precio <= " + precio);
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay cursos con ese precio o inferior.");
        } else {
            for (CursoDTO c : lista) {
                System.out.println(c.getId() + " | " + c.getNombre() + " | " + c.getDuracionHoras() + "h | " + c.getPrecio() + " EUR");
            }
        }
    }

    public void añadirCurso() {
        String nombre = Lecturas.leerString("Nombre del curso: ");
        int duracion = Lecturas.leerEntero("Duracion en horas: ");
        double precio = Lecturas.leerDouble("Precio: ");
        CursoDTO nuevo = new CursoDTO(nombre, duracion, precio);
        if (cursoController.insertar(nuevo))
            System.out.println("Curso añadido correctamente.");
        else
            System.out.println("Error al añadir el curso.");
    }

    public void modificarCurso() {
        int id = Lecturas.leerEntero("Id del curso a modificar: ");
        String nombre = Lecturas.leerString("Nuevo nombre: ");
        int duracion = Lecturas.leerEntero("Nueva duracion en horas: ");
        double precio = Lecturas.leerDouble("Nuevo precio: ");
        CursoDTO curso = new CursoDTO(id, nombre, duracion, precio);
        if (cursoController.actualizar(curso))
            System.out.println("Curso actualizado correctamente.");
        else
            System.out.println("Error al actualizar el curso.");
    }

    public void borrarCurso() {
        int id = Lecturas.leerEntero("Id del curso a borrar: ");
        if (cursoController.borrar(id))
            System.out.println("Curso borrado correctamente.");
        else
            System.out.println("Error al borrar el curso.");
    }
}

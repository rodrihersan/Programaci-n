package vista;

import java.util.ArrayList;
import controlador.CategoriaController;
import modelo.CategoriaDTO;
import utils.Lecturas;

public class VistaCategoria {
    CategoriaController categoriaController = new CategoriaController();

    public void menuCategoria() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Categorias ===");
            System.out.println("1. Ver todas las categorias");
            System.out.println("2. Añadir categoria");
            System.out.println("3. Modificar categoria");
            System.out.println("4. Borrar categoria");
            System.out.println("0. Salir al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: mostrarTodasLasCategorias(); break;
                case 2: añadirCategoria(); break;
                case 3: modificarCategoria(); break;
                case 4: borrarCategoria(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodasLasCategorias() {
        ArrayList<CategoriaDTO> lista = categoriaController.obtenerTodasLasCategorias();
        System.out.println("Categorias");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay categorias registradas.");
        } else {
            for (CategoriaDTO c : lista) {
                System.out.println(c.getId() + " | " + c.getNombre());
            }
        }
    }

    public void añadirCategoria() {
        String nombre = Lecturas.leerString("Nombre de la nueva categoria: ");
        CategoriaDTO nueva = new CategoriaDTO(nombre);
        if (categoriaController.insertar(nueva))
            System.out.println("Categoria añadida correctamente.");
        else
            System.out.println("Error al añadir la categoria.");
    }

    public void modificarCategoria() {
        int id = Lecturas.leerEntero("Id de la categoria a modificar: ");
        String nuevoNombre = Lecturas.leerString("Nuevo nombre: ");
        CategoriaDTO categoria = new CategoriaDTO(id, nuevoNombre);
        if (categoriaController.actualizar(categoria))
            System.out.println("Categoria actualizada correctamente.");
        else
            System.out.println("Error al actualizar la categoria.");
    }

    public void borrarCategoria() {
        int id = Lecturas.leerEntero("Id de la categoria a borrar: ");
        if (categoriaController.borrar(id))
            System.out.println("Categoria borrada correctamente.");
        else
            System.out.println("Error al borrar la categoria.");
    }
}
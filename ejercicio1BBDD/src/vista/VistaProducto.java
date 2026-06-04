package vista;

import java.util.ArrayList;
import controlador.CategoriaController;
import controlador.ProductoController;
import modelo.ProductoDTO;
import utils.Lecturas;

public class VistaProducto {
    ProductoController productoController = new ProductoController();
    CategoriaController categoriaController = new CategoriaController();

    public void menuProducto() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Productos ===");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Buscar productos por categoria");
            System.out.println("3. Buscar productos con stock bajo");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 3);
            switch (opcion) {
                case 1: mostrarTodosLosProductos(); break;
                case 2: buscarPorCategoria(); break;
                case 3: buscarPorStockBajo(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodosLosProductos() {
        ArrayList<ProductoDTO> lista = productoController.obtenerTodosLosProductos();
        System.out.println("Productos");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (ProductoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getNombre() + " | " + p.getPrecio() + " EUR | Stock: " + p.getStock() + " | Cat: " + p.getIdCategoria());
            }
        }
    }

    public void buscarPorCategoria() {
        String nombreCategoria = Lecturas.leerString("Introduce el nombre de la categoria: ");
        int idCategoria = categoriaController.obtenerIdPorNombre(nombreCategoria);
        if (idCategoria == -1) {
            System.out.println("No se encontró ninguna categoria con ese nombre.");
            return;
        }
        ArrayList<ProductoDTO> lista = productoController.obtenerProductosPorCategoria(idCategoria);
        System.out.println("Productos en la categoria '" + nombreCategoria + "'");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay productos en esa categoria.");
        } else {
            for (ProductoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getNombre() + " | " + p.getPrecio() + " EUR | Stock: " + p.getStock());
            }
        }
    }

    public void buscarPorStockBajo() {
        int maxStock = Lecturas.leerEntero("Introduce el stock maximo: ");
        ArrayList<ProductoDTO> lista = productoController.obtenerProductosConStockBajo(maxStock);
        System.out.println("Productos con stock <= " + maxStock);
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay productos con ese stock o inferior.");
        } else {
            for (ProductoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getNombre() + " | Stock: " + p.getStock());
            }
        }
    }
}
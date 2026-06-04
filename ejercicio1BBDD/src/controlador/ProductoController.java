package controlador;

import java.util.ArrayList;
import modelo.ProductoDAO;
import modelo.ProductoDTO;

public class ProductoController {

    public ArrayList<ProductoDTO> obtenerTodosLosProductos() {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.obtenerTodosLosProductos();
    }

    public ArrayList<ProductoDTO> obtenerProductosPorCategoria(int idCategoria) {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.obtenerProductosPorCategoria(idCategoria);
    }

    public ArrayList<ProductoDTO> obtenerProductosConStockBajo(int maxStock) {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.obtenerProductosConStockBajo(maxStock);
    }
}

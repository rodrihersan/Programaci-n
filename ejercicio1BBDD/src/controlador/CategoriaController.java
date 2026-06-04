package controlador;

import java.util.ArrayList;
import modelo.CategoriaDAO;
import modelo.CategoriaDTO;

public class CategoriaController {

    public ArrayList<CategoriaDTO> obtenerTodasLasCategorias() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.obtenerTodasLasCategorias();
    }

    public int obtenerIdPorNombre(String nombre) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.obtenerIdPorNombre(nombre);
    }

    public boolean insertar(CategoriaDTO categoria) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.insertarCategoria(categoria);
    }

    public boolean actualizar(CategoriaDTO categoria) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.actualizarCategoria(categoria);
    }

    public boolean borrar(int id) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.borrarCategoria(id);
    }
}
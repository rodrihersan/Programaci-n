package controlador;

import java.util.ArrayList;
import modelo.CursoDAO;
import modelo.CursoDTO;

public class CursoController {

    public ArrayList<CursoDTO> obtenerTodosLosCursos() {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.obtenerTodosLosCursos();
    }

    public ArrayList<CursoDTO> obtenerCursosPorPrecioMaximo(double precioMaximo) {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.obtenerCursosPorPrecioMaximo(precioMaximo);
    }

    public boolean insertar(CursoDTO curso) {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.insertarCurso(curso);
    }

    public boolean actualizar(CursoDTO curso) {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.actualizarCurso(curso);
    }

    public boolean borrar(int id) {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.borrarCurso(id);
    }
}

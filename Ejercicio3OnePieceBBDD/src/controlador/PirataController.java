package controlador;

import modelo.PirataDAO;
import modelo.PirataDTO;

public class PirataController {

    public void listarTodosLosPiratas() {
        PirataDAO pirataDAO = new PirataDAO();
        pirataDAO.listarTodosLosPiratas();
    }

    public boolean insertar(PirataDTO pirata) {
        PirataDAO pirataDAO = new PirataDAO();
        return pirataDAO.insertarPirata(pirata);
    }

    public boolean actualizar(PirataDTO pirata) {
        PirataDAO pirataDAO = new PirataDAO();
        return pirataDAO.actualizarPirata(pirata);
    }

    public boolean eliminar(int id) {
        PirataDAO pirataDAO = new PirataDAO();
        return pirataDAO.eliminarPirata(id);
    }
}
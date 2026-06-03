package controlador;

import java.util.ArrayList;
import modelo.PirataDAO;
import modelo.PirataDTO;

public class PirataController {
	
	PirataDAO PirataDAO = new PirataDAO();

	public ArrayList<PirataDTO> verTodosLosPiratas() {
        return PirataDAO.verTodosLosPiratas();
    }

    public boolean insertar(PirataDTO clienteInsertar) {
        return PirataDAO.insertarCliente(clienteInsertar);
    }

    public boolean editar(PirataDTO cliente) {
        return PirataDAO.editarCliente(cliente);
    }

    public boolean borrar(int id) {
        return PirataDAO.borrarCliente(id);
    }
}

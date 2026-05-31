package controlador;

import java.util.ArrayList;
import modelo.ClienteDAO;
import modelo.ClienteDTO;

public class ClienteController {
	
	ClienteDAO clienteDAO = new ClienteDAO();

	public ArrayList<ClienteDTO> obtenerClientes() {
        return clienteDAO.obtenerTodosLosClientes();
    }

    public boolean insertar(ClienteDTO clienteInsertar) {
        return clienteDAO.insertarCliente(clienteInsertar);
    }

    public boolean editar(ClienteDTO cliente) {
        return clienteDAO.editarCliente(cliente);
    }

    public boolean borrar(int id) {
        return clienteDAO.borrarCliente(id);
    }
}
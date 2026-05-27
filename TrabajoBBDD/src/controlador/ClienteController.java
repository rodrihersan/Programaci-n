package controlador;

import java.util.ArrayList;
import modelo.ClienteDAO;
import modelo.ClienteDTO;

public class ClienteController {

    public ArrayList<ClienteDTO> obtenerTodosLosClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.obtenerTodosLosClientes();
    }

    public boolean insertar(ClienteDTO cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.insertarCliente(cliente);
    }

    public boolean editar(ClienteDTO cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.editarCliente(cliente);
    }

    public boolean borrar(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.borrarCliente(id);
    }
}
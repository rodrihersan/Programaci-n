package controlador;

import java.util.ArrayList;
import modelo.PedidoDAO;
import modelo.PedidoDTO;

public class PedidoController {

    public ArrayList<PedidoDTO> obtenerTodosLosPedidos() {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.obtenerTodosLosPedidos();
    }

    public ArrayList<PedidoDTO> obtenerPedidosPorFecha(String fecha) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.obtenerPedidosPorFecha(fecha);
    }

    public ArrayList<PedidoDTO> obtenerPedidosPorTotalMinimo(double totalMinimo) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.obtenerPedidosPorTotalMinimo(totalMinimo);
    }

    public boolean cancelarPedido(int idPedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.cancelarPedido(idPedido);
    }
}
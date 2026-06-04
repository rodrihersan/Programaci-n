package controlador;

import java.util.ArrayList;
import modelo.DetallePedidoDAO;
import modelo.DetallePedidoDTO;

public class DetallePedidoController {

    public ArrayList<DetallePedidoDTO> obtenerTodosLosDetalles() {
        DetallePedidoDAO detalleDAO = new DetallePedidoDAO();
        return detalleDAO.obtenerTodosLosDetalles();
    }

    public void mostrarDetallesConJoin(int idPedido) {
        DetallePedidoDAO detalleDAO = new DetallePedidoDAO();
        detalleDAO.mostrarDetallesConJoin(idPedido);
    }

    public ArrayList<DetallePedidoDTO> obtenerDetallesPorPedido(int idPedido) {
        DetallePedidoDAO detalleDAO = new DetallePedidoDAO();
        return detalleDAO.obtenerDetallesPorPedido(idPedido);
    }
}
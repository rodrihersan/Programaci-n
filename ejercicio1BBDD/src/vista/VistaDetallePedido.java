package vista;

import java.util.ArrayList;
import controlador.DetallePedidoController;
import modelo.DetallePedidoDTO;
import utils.Lecturas;

public class VistaDetallePedido {
    DetallePedidoController detalleController = new DetallePedidoController();

    public void menuDetallePedido() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Detalles de Pedido ===");
            System.out.println("1. Ver todos los detalles");
            System.out.println("2. Ver detalles de un pedido (con nombre producto y fecha)");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 2);
            switch (opcion) {
                case 1: mostrarTodosLosDetalles(); break;
                case 2: mostrarDetallesDeUnPedido(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodosLosDetalles() {
        ArrayList<DetallePedidoDTO> lista = detalleController.obtenerTodosLosDetalles();
        System.out.println("Detalles de pedido");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay detalles registrados.");
        } else {
            for (DetallePedidoDTO d : lista) {
                System.out.println(d.getId() + " | Pedido: " + d.getIdPedido() + " | Producto: " + d.getIdProducto() + " | Cantidad: " + d.getCantidad() + " | Precio unit.: " + d.getPrecioUnitario() + " EUR");
            }
        }
    }

    public void mostrarDetallesDeUnPedido() {
        int idPedido = Lecturas.leerEntero("Introduce el id del pedido: ");
        detalleController.mostrarDetallesConJoin(idPedido);
    }
}
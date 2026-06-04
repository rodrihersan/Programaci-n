package vista;

import java.util.ArrayList;
import controlador.PedidoController;
import modelo.PedidoDTO;
import utils.Lecturas;

public class VistaPedido {
    PedidoController pedidoController = new PedidoController();

    public void menuPedido() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Pedidos ===");
            System.out.println("1. Ver todos los pedidos");
            System.out.println("2. Buscar pedidos por fecha");
            System.out.println("3. Buscar pedidos por total minimo");
            System.out.println("4. Cancelar pedido");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: mostrarTodosLosPedidos(); break;
                case 2: buscarPorFecha(); break;
                case 3: buscarPorTotalMinimo(); break;
                case 4: cancelarPedido(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void mostrarTodosLosPedidos() {
        ArrayList<PedidoDTO> lista = pedidoController.obtenerTodosLosPedidos();
        System.out.println("Pedidos");
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (PedidoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getFecha() + " | " + p.getTotal() + " EUR");
            }
        }
    }

    public void buscarPorFecha() {
        String fecha = Lecturas.leerString("Introduce la fecha (YYYY-MM-DD): ");
        ArrayList<PedidoDTO> lista = pedidoController.obtenerPedidosPorFecha(fecha);
        System.out.println("Pedidos en la fecha " + fecha);
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay pedidos en esa fecha.");
        } else {
            for (PedidoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getFecha() + " | " + p.getTotal() + " EUR");
            }
        }
    }

    public void buscarPorTotalMinimo() {
        double total = Lecturas.leerDouble("Introduce el total minimo: ");
        ArrayList<PedidoDTO> lista = pedidoController.obtenerPedidosPorTotalMinimo(total);
        System.out.println("Pedidos con total >= " + total);
        System.out.println("--------------");
        if (lista.isEmpty()) {
            System.out.println("No hay pedidos con ese total o superior.");
        } else {
            for (PedidoDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getFecha() + " | " + p.getTotal() + " EUR");
            }
        }
    }

    public void cancelarPedido() {
        int idPedido = Lecturas.leerEntero("Introduce el id del pedido a cancelar: ");
        boolean confirmar = Lecturas.leerSiNo("¿Estas seguro de que quieres cancelar el pedido " + idPedido + "?");
        if (!confirmar) {
            System.out.println("Operacion cancelada.");
            return;
        }
        if (pedidoController.cancelarPedido(idPedido))
            System.out.println("Pedido cancelado correctamente. Stock restaurado.");
        else
            System.out.println("Error al cancelar el pedido.");
    }
}
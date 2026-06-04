package trabajoBBDD;

import utils.Lecturas;
import vista.VistaCategoria;
import vista.VistaDetallePedido;
import vista.VistaPedido;
import vista.VistaProducto;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Productos");
            System.out.println("2. Categorias");
            System.out.println("3. Pedidos");
            System.out.println("4. Detalles de pedido");
            System.out.println("0. Salir");

            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: VistaProducto vp = new VistaProducto(); vp.menuProducto(); break;
                case 2: VistaCategoria vc = new VistaCategoria(); vc.menuCategoria(); break;
                case 3: VistaPedido vped = new VistaPedido(); vped.menuPedido(); break;
                case 4: VistaDetallePedido vd = new VistaDetallePedido(); vd.menuDetallePedido(); break;
                case 0: System.out.println("Saliendo... ¡Hasta pronto!"); salir = true; break;
            }
        } while (!salir);
    }
}

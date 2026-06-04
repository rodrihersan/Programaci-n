package vista;

import controlador.RecompensaController;
import utils.Lecturas;

public class VistaRecompensa {
    RecompensaController recompensaController = new RecompensaController();

    public void menuRecompensa() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Recompensas ===");
            System.out.println("1. Listar recompensas");
            System.out.println("2. Emitir recompensa");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 2);
            switch (opcion) {
                case 1: recompensaController.listarRecompensas(); break;
                case 2: emitirRecompensa(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void emitirRecompensa() {
        int pirataId = Lecturas.leerEntero("Introduce el id del pirata: ");
        double cantidad = Lecturas.leerDouble("Introduce la cantidad de berries: ");
        if (recompensaController.emitirRecompensa(pirataId, cantidad))
            System.out.println("Recompensa emitida correctamente.");
        else
            System.out.println("No se pudo emitir la recompensa.");
    }
}
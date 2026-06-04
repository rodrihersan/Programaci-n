package vista;

import controlador.CapturaController;
import utils.Lecturas;

public class VistaCaptura {
    CapturaController capturaController = new CapturaController();

    public void menuCaptura() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Capturas ===");
            System.out.println("1. Listar capturas");
            System.out.println("2. Registrar captura");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 2);
            switch (opcion) {
                case 1: capturaController.listarCapturas(); break;
                case 2: registrarCaptura(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void registrarCaptura() {
        int pirataId = Lecturas.leerEntero("Introduce el id del pirata: ");
        String lugar = Lecturas.leerString("Introduce el lugar de captura: ");
        if (capturaController.registrarCaptura(pirataId, lugar))
            System.out.println("Captura registrada correctamente.");
        else
            System.out.println("No se pudo registrar la captura.");
    }
}

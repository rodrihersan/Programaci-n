package onePiece;

import utils.Lecturas;
import vista.VistaCaptura;
import vista.VistaPirata;
import vista.VistaRecompensa;
import vista.VistaTripulacion;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Piratas");
            System.out.println("2. Tripulaciones");
            System.out.println("3. Recompensas");
            System.out.println("4. Capturas");
            System.out.println("0. Salir");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: VistaPirata vp = new VistaPirata(); vp.menuPirata(); break;
                case 2: VistaTripulacion vt = new VistaTripulacion(); vt.menuTripulacion(); break;
                case 3: VistaRecompensa vr = new VistaRecompensa(); vr.menuRecompensa(); break;
                case 4: VistaCaptura vc = new VistaCaptura(); vc.menuCaptura(); break;
                case 0: System.out.println("Saliendo... ¡Hasta pronto!"); salir = true; break;
            }
        } while (!salir);
    }
}

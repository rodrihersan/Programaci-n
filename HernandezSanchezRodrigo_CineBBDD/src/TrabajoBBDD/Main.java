package TrabajoBBDD;

import java.io.IOException;
import utils.Lecturas;
import vista.VistaPelicula;
import vista.VistaReserva;
import vista.VistaCliente;
import vista.VistaSesion;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean salir = false;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Gestion de peliculas");
            System.out.println("2. Gestion de clientes");
            System.out.println("3. Gestion de sesiones");
            System.out.println("4. Gestion de reservas");
            System.out.println("0. Salir");

            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1:VistaPelicula vp = new VistaPelicula();vp.menuPeliculas();break;
                case 2:VistaCliente vc = new VistaCliente();vc.menuCliente();break;
                case 3:VistaSesion vs = new VistaSesion();vs.menuSesiones();break;
                case 4:VistaReserva vr = new VistaReserva();vr.menuReservas();break;
                case 0:System.out.println("Saliendo del programa");salir = true;break;
            }
        } while (!salir);
    }
}
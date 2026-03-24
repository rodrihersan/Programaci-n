package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViajeInternacional extends Viaje {
    private String pais;

    public void pedirDatos() {
        super.pedirDatos();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce el país: ");
                pais = leer.readLine();
                datosOK = true;
            } catch (IOException e) {
                System.out.println("Has introducido mal algún dato, crack");
                e.printStackTrace();
            }
        }
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("País: " + pais);
    }

    public String getPais() { return pais; }
}

package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Viaje {
    protected String destino;
    protected int dias;
    protected double costePorDia;

    protected void pedirDatos() {
        
    }

    protected void mostrarDatos() {
        System.out.println("----------------");
        System.out.println("Destino: " + destino);
        System.out.println("Días: " + dias);
        System.out.println("Coste/día: " + costePorDia);
        System.out.println("Coste total: " + getCosteTotal());
    }

    public double getCosteTotal() { return dias * costePorDia; }
    public String getDestino() { return destino; }
    public int getDias() { return dias; }
    public double getCostePorDia() { return costePorDia; }
}

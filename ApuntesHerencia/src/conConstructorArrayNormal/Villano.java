package conConstructorArrayNormal;

import conConstructorArrayList.Personaje;

public class Villano extends Personaje {
    private String peligrosidad;
    private String arma;

    public Villano(int id, String nombre, int nivelPoder, String bando, String peligrosidad, String arma) {
        super(id, nombre, nivelPoder, bando);
        this.peligrosidad = peligrosidad;
        this.arma = arma;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Peligrosidad: " + this.peligrosidad);
        System.out.println("Arma principal: " + this.arma);
        System.out.println("----------------------------");
    }
}

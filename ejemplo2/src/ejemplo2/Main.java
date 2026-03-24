package ejemplo2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<Animal>();
        boolean salir = false;

        do {
            System.out.println("=== MENÚ ANIMALES ===");
            System.out.println("4. Nuevo animal");
            System.out.println("6. Animales salvajes por peso");
            System.out.println("7. Salir");

            int opcion = Lecturas.leerEntero("Introduce una opción: ");

            switch (opcion) {
                case 4:
                    System.out.println("=== Nuevo animal ===");
                    nuevoAnimal(animales);
                    break;
                case 6:
                    System.out.println("=== Animales salvajes por peso ===");
                    animalesSalvajesPorPeso(animales);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!salir);
    }

    private static void nuevoAnimal(ArrayList<Animal> animales) {
        String tipo = Lecturas.leerOpcion(
            "Tipo de animal (Domestico/Salvaje): ",
            new String[]{"Domestico", "Salvaje"}
        );

        if (tipo.equalsIgnoreCase("Domestico")) {
            AnimalDomestico ad = new AnimalDomestico();
            ad.pedirDatos();
            animales.add(ad);
        } else {
            AnimalSalvaje as = new AnimalSalvaje();
            as.pedirDatos();
            animales.add(as);
        }
    }

    private static void animalesSalvajesPorPeso(ArrayList<Animal> animales) {
        double pesoMax = Lecturas.leerDouble("Introduce el peso máximo: ");

        boolean hayAlguno = false;
        for (Animal a : animales) {
            if (a instanceof AnimalSalvaje) {
                if (((AnimalSalvaje) a).getPeso() <= pesoMax) {
                    ((AnimalSalvaje) a).mostrarDatos();
                    hayAlguno = true;
                }
            }
        }

        if (!hayAlguno)
            System.out.println("No hay animales salvajes con ese peso.");
    }
}

package academia;

import utils.Lecturas;
import vista.VistaAlumno;
import vista.VistaCurso;
import vista.VistaMatricula;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Alumnos");
            System.out.println("2. Cursos");
            System.out.println("3. Matriculas");
            System.out.println("0. Salir");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 3);
            switch (opcion) {
                case 1: VistaAlumno va = new VistaAlumno(); va.menuAlumno(); break;
                case 2: VistaCurso vc = new VistaCurso(); vc.menuCurso(); break;
                case 3: VistaMatricula vm = new VistaMatricula(); vm.menuMatricula(); break;
                case 0: System.out.println("Saliendo... ¡Hasta pronto!"); salir = true; break;
            }
        } while (!salir);
    }
}

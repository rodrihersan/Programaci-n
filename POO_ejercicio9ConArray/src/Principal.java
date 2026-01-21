public class Principal {
	

	public static void main(String[] args) {
		System.out.println("hola caracola");
		Articulo[] articulos = new Articulo[20];
		
		for(int i=0; i < 20; i++) {
			articulos[i] = new Articulo();
			articulos[i].pedirDatos(articulos, i);
		}

	}

}
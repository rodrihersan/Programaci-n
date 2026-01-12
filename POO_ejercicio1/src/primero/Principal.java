package primero;

public class Principal {

	public static void main(String[] args) {
		Televisor tvHabitacion = new Televisor();
		System.out.println("El canal seleccionado de la hab es el: " + tvHabitacion.getCanal());
		
		/*tvHabitacion.subirCanal();
		System.out.println("El canal seleccionado es el: " + tvHabitacion.getCanal());
		tvHabitacion.bajarCanal();
		System.out.println("El canal seleccionado es el: " + tvHabitacion.getCanal());*/
		
		Televisor tvSalon = new Televisor(5);
		System.out.println("El canal seleccionado del salon es el: " + tvSalon.getCanal());
		tvSalon.setCanal(150);
		System.out.println("El canal seleccionado del salon es el: " + tvSalon.getCanal());
		
		Televisor tvCocina = new Televisor(1,5);
		System.out.println("El canal seleccionado del salon es el: " + tvCocina.getCanal() +
				" y volumen " + tvCocina.getVolumen()  );			
	}
}

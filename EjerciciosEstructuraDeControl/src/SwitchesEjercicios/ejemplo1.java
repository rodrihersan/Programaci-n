package SwitchesEjercicios;

public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mes = 3;
		
		switch(mes) {
		case 1:
			System.out.print("Mes 1");
			break;
		case 2: 
			System.out.print("Mes 1");
			System.out.print("Puedoponer lo que quiera");
			break;
		case 3:
			System.out.print("Mes 3");
		case 4:
			System.out.print("Mes 4. me ejecuto tambien porque no he puesto break");
			break;
		default:
			System.out.print("Opcion por defecto");
			
			String mess = "enero";
			
			switch(mess) {
			case "enero":
				System.out.print("Mes 1");
				break;
			case "febrero": 
				System.out.print("Mes 1");
				System.out.print("Puedoponer lo que quiera");
				break;
			case "marzo":
				System.out.print("Mes 3");
			case "abril":
				System.out.print("Mes 4. me ejecuto tambien porque no he puesto break");
				break;
			default:
				System.out.print("Opcion por defecto");
		}

	}
	}}


package primero;

public class Televisor {
		private int canal;
		private int volumen;

		public Televisor() {
		}

		public Televisor(int valorCanal) {
			canal = valorCanal;
		}
		
		public Televisor(int valorCanal, int valorVolumen) {
			canal = valorCanal;
			volumen = valorVolumen;
		}

		public void subirCanal() {
			setCanal(canal+1);
		}

		public void bajarCanal() {
			setCanal(canal-1);
		}

		public int getCanal() {
			return canal;
		}
		
		public void setCanal(int valorCanal) {
			if (valorCanal < 1 || valorCanal >= 100)
				canal = 1;
			else
				canal = valorCanal;
		}
		
		public int getVolumen() {
			return volumen;
		}
		
		public void setVolumen(int valorVolumen) {
			volumen = valorVolumen;
		}
	}
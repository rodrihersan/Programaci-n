package holaMundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HolaMundoo extends Application {

	public void start(Stage stage) {
		 //1. Creamos un texto en pantalla
		Label label = new Label("Hola, JavaFX!");
		label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: red;");

		 //2. Lo metemos en un layout que centra su contenido
		StackPane root = new StackPane(label);
		// 3. Creamos la escena con 400px de ancho y 300px de alto
		Scene scene = new Scene(root, 400, 300);
		// 4. Configuramos la ventana. El titulo en este caso
		stage.setTitle("Mi primera ventana");
		stage.setScene(scene);
		 //Mostramos la ventena
		stage.show();
		}
		public static void main(String[] args) {
		 //En el main arrancamos la aplicación JavaFX desde el main
		launch(args);
		}


}

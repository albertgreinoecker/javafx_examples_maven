package fx_examples_maven.fx_examples_maven.ex_20_colors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ein kleines Demo wie Farben in Java(FX) erzeugt werden
 */
public class App extends Application {

	Color red = Color.RED; // Vordefinierte Farbe
	Color customColor = Color.rgb(100, 150, 200); // Rot Gruen Blau
	Color transparentBlue = Color.color(0.1, 0.2, 0.8, 0.5); // RGBA

	@Override
	public void start(Stage stage) {

		VBox root = new VBox();

		Button blueB = new Button("Blau");
		blueB.setBackground(new Background(new BackgroundFill(
				transparentBlue, // Farbe
				new CornerRadii(0), // Abgerundete Ecken
				Insets.EMPTY // Kein Abstand
		)));
		
		blueB.setTextFill(Color.WHEAT);
		

		Button redB = new Button("Rot");
		redB.setBackground(new Background(new BackgroundFill(
				red, // Farbe
				new CornerRadii(0), // Abgerundete Ecken
				new Insets(3,4,5,6) // top, right, bottom, left
		)));
		
		
		Button buntB = new Button("Bunt");
		/*	Mittels CSS: ff 57 33 R G B 
		Hexadezimale Werte 
			ff = 16*15 + 1*15 = 255,  
			16*5 + 1*7 = 87
			16*3 + 1*3 = 51
		*/
		buntB.setStyle("-fx-background-color: #ff5733; -fx-text-fill: white;");
		
		root.getChildren().addAll(blueB, redB, buntB);

		Scene scene = new Scene(root, 640, 480);
		stage.setTitle("Farben-Demo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
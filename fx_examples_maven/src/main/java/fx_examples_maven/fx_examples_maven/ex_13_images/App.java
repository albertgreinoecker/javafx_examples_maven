package fx_examples_maven.fx_examples_maven.ex_13_images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Wie kann man Bilder einbauen
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox();

		Image im = new Image(getClass().getResource("/images/htl-logo_rauten.png").toExternalForm());
		ImageView iv = new ImageView(im);
		iv.setFitWidth(200); // gewuenschte Groesse angeben
		iv.setPreserveRatio(true); // soll das Verhaeltnis Hoehe / Breite erhalten bleiben
		// Klick-Event setzen (hier wieder als Lambda-Expression
		iv.setOnMouseClicked(event -> {
			System.out.println("Bild wurde geklickt!");
			System.out.printf("(%f, %f) %n", event.getX(), event.getY());
		});
		iv.setOpacity(0.1); // durchsichtig
		iv.setEffect(new GaussianBlur(10)); // unschaerfe
		root.getChildren().add(iv);
		Scene scene = new Scene(root, 300, 200);

		primaryStage.setTitle("Bildanzeige");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

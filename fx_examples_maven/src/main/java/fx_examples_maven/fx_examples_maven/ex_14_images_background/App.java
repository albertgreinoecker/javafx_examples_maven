package fx_examples_maven.fx_examples_maven.ex_14_images_background;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Setzen eines Hintergrundbildes
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Image im = new Image(getClass().getResource("/images/htl-logo_rauten.png").toExternalForm(), 
				100, //breite
				100, //hoehe
				true, //x-y Verhaeltnis beibehalten
				true); // bessere Qualitaet
	
		/*
		 * Das sind die Parameter: 
		 * image: Das Bild 
		 * repeatX: Wird das Bild in X-Richtung wiederholt 
		 * repeatY: Wird das Bild in Y-Richtung wiederholt 
		 * position: Wo soll das Bild angezeigt werden 
		 * size: Wie groß soll das Hintergrundbild dargestellt werden
		 */
		BackgroundImage bi = new BackgroundImage(im, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(bi));

		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Bildanzeige");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

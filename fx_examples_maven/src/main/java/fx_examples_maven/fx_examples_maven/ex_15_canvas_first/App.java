package fx_examples_maven.fx_examples_maven.ex_15_canvas_first;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Erstes Beispiel fuer Zeichnen mit Canvas
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		   // Erstelle ein Rechteck
        Rectangle rectangle = new Rectangle(50, 50, 200, 100);
        rectangle.setFill(Color.LIGHTBLUE);

        // Erstelle einen Kreis
        Circle circle = new Circle(150, 100, 40);
        circle.setFill(Color.ORANGE);

        // Erstelle einen Text
        Text text = new Text(110, 105, "Hallo JavaFX!");
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font-size: 18px;");

        // Gruppe mit allen Objekten erstellen
        Group group = new Group(rectangle, circle, text);

		root.setCenter(group);
		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Bildanzeige");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

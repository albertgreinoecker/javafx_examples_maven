package fx_examples_maven.fx_examples_maven.ex_07_grid_demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Ein Beispiel wie ein Grid erzeugt wird und wie der gedrueckte Button
 * identifiziert wird
 */
public class App extends Application implements EventHandler<ActionEvent> {

	Label l = new Label();

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		GridPane center = new GridPane();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				String bStr = String.format("(%d %d)", i, j); // wie printf
				Button b = new Button(bStr);
				b.setOnAction(this);
				b.setUserData(new Point(i, j));
				center.add(b, i, j); // stelle den Button an die Stelle i,j
			}
		}
		root.setCenter(center);
		root.setBottom(l);
		Scene scene = new Scene(root, 640, 480);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void handle(ActionEvent event) {
		Button n = (Button) event.getSource(); // Das ist der gedrueckte Button
		Point p = (Point) n.getUserData();
		System.out.printf("x: %d, y: %d %n", p.getX(), p.getY());
		l.setText(p.toString());
	}
}
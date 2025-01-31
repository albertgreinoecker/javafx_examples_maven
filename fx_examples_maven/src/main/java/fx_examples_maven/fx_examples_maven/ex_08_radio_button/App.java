package fx_examples_maven.fx_examples_maven.ex_08_radio_button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
		
		RadioButton bA = new RadioButton("A");
		bA.setOnAction(this);
		RadioButton bB = new RadioButton("B");
		bB.setOnAction(this);
		RadioButton bC = new RadioButton("C");
		bC.setOnAction(this);	
		
		ToggleGroup tgA = new ToggleGroup();
		bA.setToggleGroup(tgA);
		bB.setToggleGroup(tgA);
		bC.setToggleGroup(tgA);
		tgA.selectToggle(bB);
		
		VBox center = new VBox();
		center.getChildren().addAll(bA, bB, bC);
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
		RadioButton b = (RadioButton)event.getSource();
		
		System.out.printf("Auswahl: %s %n", b.getText());
		l.setText("Auswahl:" + b.getText());
	}
}
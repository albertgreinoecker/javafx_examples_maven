package fx_examples_maven.fx_examples_maven.ex_06_class_node;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 4 Arten wie man auf Events reagieren kann
 */
public class App extends Application implements EventHandler<ActionEvent> {

	Label l = new Label(); // Hier kommt die Reaktion auf den Knopfdruck hinein
	Button b1;
	
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(); // Bildet hier das Basislayout

		b1 = new Button("Button 1");
		b1.setOnAction(this);
		//Speichere ein Objekt fuer den Button
		b1.setUserData(new AnyUserData("Daten für den Button 1"));
		//Hier koennen mehrere Objekte zu einem Button gespeichert werden
		b1.getProperties().put("prop1", "Die erste Eigenschaft");
		b1.getProperties().put("prop2", new AnyUserData("Daten für den Button 1"));
		root.getChildren().addAll(b1, l);

		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void handle(ActionEvent event) {
		Button n = (Button) event.getSource(); // Das ist der gedrueckte Button
		if (n == b1)
		{
			AnyUserData ud = (AnyUserData)b1.getUserData();
			ud.inc();
			b1.setUserData(ud);
			
			String s = (String)b1.getProperties().get("prop1");
			l.setText(ud.toString() + " " + s);
		}

	}
}
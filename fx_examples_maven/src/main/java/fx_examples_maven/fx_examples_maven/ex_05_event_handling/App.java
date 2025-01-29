package fx_examples_maven.fx_examples_maven.ex_05_event_handling;

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

	Label l = new Label(); //Hier kommt die Reaktion auf den Knopfdruck hinein
	
    @Override
    public void start(Stage primaryStage) {
		VBox root = new VBox(); //Bildet hier das Basislayout

		Button b1 = new Button("Die gesamte Klasse implementiert das Interface");
		b1.setOnAction(this);
	
		Button b2 = new Button("Anonyme Klasse");
		b2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	l.setText("Anonyme Klasse gedrueckt!");
		    }
		});
		
		Button b3 = new Button("Lambda Expression");
		b3.setOnAction(event -> {l.setText("Lambda Expression gedrueckt");});


		Button b4 = new Button("Methodenreferenz");
		b4.setOnAction(this::handleButton4);
		
		
		root.getChildren().addAll(b1,b2,b3, b4, l);
		
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

	@Override
	public void handle(ActionEvent event) {
		Button n = (Button)event.getSource(); // Das ist der gedrueckte Button
		String txt = String.format("%s gedrueckt", n.getText());
		l.setText(txt);
		
	}
	
	public void handleButton4(ActionEvent event) {
		Button n = (Button)event.getSource(); // Das ist der gedrueckte Button
		String txt = String.format("%s gedrueckt", n.getText());
		l.setText(txt);
		
	}

}
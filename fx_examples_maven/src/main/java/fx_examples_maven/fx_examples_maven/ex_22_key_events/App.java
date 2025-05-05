package fx_examples_maven.fx_examples_maven.ex_22_key_events;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application implements EventHandler<KeyEvent>{

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Drücke eine Taste...");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);

        // Key-Event-Handler
        scene.setOnKeyPressed(this);

        primaryStage.setTitle("JavaFX KeyListener Beispiel");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Fokus setzen, damit Tastaturereignisse empfangen werden
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void handle(KeyEvent event) {
		if (event.getCode() == KeyCode.A)
		{
			System.out.println("Taste A wurde gedrückt");
		}
		//Die Codes stehen alle in der Klasse KeyCode, z.B. KeyCode.M
		System.out.printf("%s : %s %n", event.getText(), event.getCode().getName());
		
	}
}

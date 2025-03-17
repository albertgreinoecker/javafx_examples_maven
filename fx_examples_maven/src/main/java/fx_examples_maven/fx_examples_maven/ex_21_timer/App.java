package fx_examples_maven.fx_examples_maven.ex_21_timer;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Ein kleines Demo wie man einen Timer erstellen kann
 */
public class App extends Application implements EventHandler<ActionEvent> {

	Button b1;
	int s1;
	Timeline timeline;

	@Override
	public void start(Stage stage) {
		s1 = 0;
		VBox root = new VBox();

		b1 = new Button("Starten...");
		b1.setOnAction(this);
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			b1.setText(++s1 + " Sekunden");
		}));
		timeline.setCycleCount(Timeline.INDEFINITE); // Unendlich oft wiederholen
		
		root.getChildren().add(b1);

		Scene scene = new Scene(root, 640, 480);
		stage.setTitle("Farben-Demo");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		if (b == b1) {
			if (timeline.getStatus() == Status.RUNNING)
			{
				timeline.stop(); // Timer stoppen
				b.setText("Pause!");
			} else {
				timeline.play(); // Timer starten
			}
			
		}

	}

	public static void main(String[] args) {
		launch();
	}
}
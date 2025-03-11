package fx_examples_maven.fx_examples_maven.ex_19_TTT;

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
 * Ein einfaches Tic Tac Toe Spiel mit eigener Klasse als Programmlogik
 */
public class App extends Application implements EventHandler<ActionEvent> {

	TTT ttt;
	Label label;

	@Override
	public void start(Stage stage) {
		ttt = new TTT();
		BorderPane root = new BorderPane();

		label = new Label(String.format("Spieler %s ist am Zug...", ttt.getWerAmZug()));
		root.setBottom(label);

		GridPane center = new GridPane();

		for (int i = 0; i < 9; i++) {
			Button b = new Button("_");
			b.setOnAction(this);
			b.setId(i + "");
			center.add(b, i % 3, i / 3);
		}
		root.setCenter(center);
		Scene scene = new Scene(root, 640, 480);
		stage.setTitle("Tic Tac Toe");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)(event.getSource());
		if (ttt.spielZug(Integer.parseInt(b.getId()))) {
			b.setText("" + ttt.getWerAmZug());
			ttt.spielerWechsel();
			label.setText(String.format("Spieler %s ist am Zug...", ttt.getWerAmZug()));

		} else {
			label.setText(String.format("Ungültiger Spielzug. Spieler %s ist am Zug...", ttt.getWerAmZug()));
		}
		if (ttt.gewonnen()) {
			label.setText("Gewonnen!!!");
		} else if (ttt.voll()) {
			label.setText("Unentschieden!!!");
		}
		ttt.ausgabe();
	}

	public static void main(String[] args) {
		launch();
	}
}
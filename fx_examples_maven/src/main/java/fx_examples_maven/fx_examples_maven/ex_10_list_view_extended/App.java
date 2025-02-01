package fx_examples_maven.fx_examples_maven.ex_10_list_view_extended;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Ein erweitertes Beispiel das zeigt wie die Listview funktioniert (mit
 * Hinzufuegen und Loeschen von Elementen)
 */
public class App extends Application implements ChangeListener<String>, EventHandler<ActionEvent> {
	ListView<String> lv;
	ObservableList<String> items;
	Label feedback;
	Button remove;
	Button add;
	Button change;
	TextField text;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			// Die obere Button - Zeile
			HBox top = new HBox();
			remove = new Button("löschen");
			remove.setOnAction(this);
			add = new Button("hinzufügen");
			add.setOnAction(this);
			change = new Button("ändern");
			change.setOnAction(this);
			text = new TextField();
			top.getChildren().addAll(remove, add, change, text);
			root.setTop(top);

			lv = new ListView<String>();
			items = FXCollections.observableArrayList("Eins", "Zwei", "Drei", "Vier");
			lv.setItems(items);
			lv.getSelectionModel().selectedItemProperty().addListener(this);
			root.setCenter(lv);

			feedback = new Label();
			root.setBottom(feedback);

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wird aufgerufen, wenn sich die Listenauswahl verändert hat
	 */
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		int index = lv.getSelectionModel().getSelectedIndex();
		String item = lv.getSelectionModel().getSelectedItem();
		String lvCurrent = String.format("index %d: %s", index, item);
		feedback.setText(lvCurrent);
	}

	@Override
	public void handle(ActionEvent event) {
		String t = text.getText();
		int index = lv.getSelectionModel().getSelectedIndex(); // -1 wenn keine Auswahl
		if (event.getSource() == add) {
			if (t.length() > 0) {
				lv.getItems().add(t);
				feedback.setText(String.format("%s hinzugefügt", t));
			}
		} else if (event.getSource() == remove) {
			if (index != -1) {
				lv.getItems().remove(index);
			}
		} else if (event.getSource() == change) {
			if (index != -1) {
				lv.getItems().set(index, t);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
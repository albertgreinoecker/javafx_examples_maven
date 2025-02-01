package fx_examples_maven.fx_examples_maven.ex_09_list_view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ein Beispiel das zeigt wie die Listview grundsätzlich funktioniert
 */
public class App extends Application implements ChangeListener<String> {

	Label l = new Label();
	ListView<String> lv;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		lv = new ListView<String>(); // Die Darstellung, einfache Strings
		ObservableList<String> items = FXCollections.observableArrayList("Eins", "Zwei", "Drei", "Vier");
		lv.setItems(items); // Hier werden die Daten der Darstellung zugewiesen. Wenn in diesen was geändert
							// wird, wird auch automatisch die Darstellung angepasst.
		lv.getSelectionModel().selectedItemProperty().addListener(this);

		VBox center = new VBox();
		center.getChildren().addAll(lv);
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
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		int index = lv.getSelectionModel().getSelectedIndex();
		String item = lv.getSelectionModel().getSelectedItem();
		String lvCurrent = String.format("index %d: %s oldvalue : %s newvalue : %s", index, item, oldValue, newValue);
		l.setText(lvCurrent);

	}
}
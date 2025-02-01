package fx_examples_maven.fx_examples_maven.ex_12_tables;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Simple Table example
 */
public class App extends Application implements EventHandler<MouseEvent>{

    @Override
    public void start(Stage primaryStage) {
    	TableView<Person> table = new TableView<>();

    	// Person: Von welchem Typ ist der Vorname ein Teil; String: Von welchem Typ ist dieses Attribut
    	TableColumn<Person, String> firstNameCol = new TableColumn<>("Name");
    	// Auf welches Attribut in der Klasse Person wird abgebildet: Hier auf ame
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
    	firstNameCol.setPrefWidth(100); // Breite der Spalte	

    	TableColumn<Person, Integer> secondNameCol = new TableColumn<>("Alter");
    	secondNameCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
    			secondNameCol.setPrefWidth(100); 	
    	
    	table.getColumns().addAll(firstNameCol, secondNameCol); //inklusive dann aller weiteren Spalten
    	ObservableList<Person> persons = FXCollections.observableArrayList();
    	table.setItems(persons);
    	Person p = new Person("Georg", 45);
    	persons.add(p);
    	
    	table.setOnMouseClicked(this);
    	
        VBox root = new VBox(table);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Personentabelle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void handle(MouseEvent event) {
		TableView<Person> table = (TableView<Person>)event.getSource();
		int idx = table.getSelectionModel().getSelectedIndex();
		Person p = table.getSelectionModel().getSelectedItem();
		System.out.println(p);
	}
}

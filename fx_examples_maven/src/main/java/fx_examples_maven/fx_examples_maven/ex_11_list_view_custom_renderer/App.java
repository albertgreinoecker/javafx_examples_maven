package fx_examples_maven.fx_examples_maven.ex_11_list_view_custom_renderer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class App extends Application implements ChangeListener<Person>{

    @Override
    public void start(Stage primaryStage) {
        // ListView zur Darstellung von Personen
        ListView<Person> listView = new ListView<>();

        // Beispiel-Daten für Personen
        ObservableList<Person> persons = FXCollections.observableArrayList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 22)
        );

        listView.setItems(persons);
        listView.getSelectionModel().selectedItemProperty().addListener(this);
        // Definieren eines Cell-Renderers zur Anpassung der Darstellung
        listView.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Person person, boolean empty) {
                super.updateItem(person, empty);
                if (empty || person == null) {
                    setText(null);
                } else {
                    setText(person.getName() + " - " + person.getAge() + " Jahre");
                }
            }
        });

        VBox root = new VBox(listView);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Personenliste");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	@Override
	public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
		System.out.println(newValue);
		
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}

// Klasse Person
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name; // Standardausgabe, falls kein Custom-Renderer genutzt wird
    }
}

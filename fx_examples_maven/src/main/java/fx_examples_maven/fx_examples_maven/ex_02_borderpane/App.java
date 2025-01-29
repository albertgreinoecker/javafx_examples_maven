package fx_examples_maven.fx_examples_maven.ex_02_borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Zeigt wie Borderpane funktioniert
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
    	BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("Oben (Menüleiste)"));
        borderPane.setBottom(new Label("Unten (Fußzeile)"));
        borderPane.setLeft(new Button("Links (Navigation)"));
        borderPane.setRight(new Button("Rechts (Werkzeuge)"));
        borderPane.setCenter(new Label("Hauptinhalt in der Mitte"));

        // Das Layout wird jetzt als Basislayout für die Scene verwendet
        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("BorderPane Beispiel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
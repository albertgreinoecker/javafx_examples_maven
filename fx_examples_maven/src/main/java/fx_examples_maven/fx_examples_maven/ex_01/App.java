package fx_examples_maven.fx_examples_maven.ex_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * The basic structure of a JavaFX Application
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello JavaFX\nxxxx");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
       
    }

    public static void main(String[] args) {
        launch();
    }
}
package fx_examples_maven.fx_examples_maven.ex_24_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) {

		BorderPane borderPane = new BorderPane();

        Scene scene = new Scene(borderPane, 400, 300);
        
        scene.getStylesheets().add(
        	    getClass().getResource("/styles/ex_24.css").toExternalForm()
        	);
        
        Button button1 = new Button("Button1");
        button1.setStyle("-fx-background-color: #00FF00; -fx-text-fill: #00000;");
        
        Button button2 = new Button("Button2");
        button2.setId("button2");

        Button button3 = new Button("Button3");
        button3.getStyleClass().add("click_buttons");        
        
        Button button4 = new Button("Button4");
        button4.getStyleClass().add("click_buttons");
        
        HBox center = new HBox();
        center.getChildren().addAll(button1, button2, button3,button4);
        borderPane.setCenter(center);
        primaryStage.setTitle("CSS Example");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

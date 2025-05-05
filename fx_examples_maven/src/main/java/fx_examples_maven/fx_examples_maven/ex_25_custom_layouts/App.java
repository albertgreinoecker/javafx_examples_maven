package fx_examples_maven.fx_examples_maven.ex_25_custom_layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Zeigt wie man selbst geschriebene Komponenten verwenden kann
 */
public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) {

		//Ein eigenes Layout wird verwendet
		LeftRightBorderPane borderPane = new LeftRightBorderPane();

        Scene scene = new Scene(borderPane, 400, 300);

        borderPane.setTopLeft(new Label("Top left"));
        borderPane.setTopRight(new Label("Top right"));
  
        borderPane.setBottomLeft(new Label("Bottom left"));
        borderPane.setBottomRight(new Label("Bottom right"));
        
        
        //Verwendung der eigenen Button
        SimpleCustomButton button1 = new SimpleCustomButton();
        SimpleCustomButton button2 = new SimpleCustomButton();


        HBox center = new HBox();
        center.getChildren().addAll(button1, button2);
        //Trotz eigenem Layout funktioniert setCenter wie von BorderPane bekannt
        borderPane.setCenter(center);
        
        
        
        
        primaryStage.setTitle("CSS Example");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

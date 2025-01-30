package fx_examples_maven.fx_examples_maven.ex_04_layoutmanager_flow_tile_pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FlowPane und TilePane werden untereinander angezeigt um die Unterschiede zu sehen 
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
		VBox root = new VBox(); //Bildet hier das Basislayout

		FlowPane flowPane = new FlowPane(10, 10); // Abstand: horizontal & vertikal
		flowPane.getChildren().addAll(
				new Button("11111"), new Button("22"), new Button("333333"), new Button("4"), new Button("5"));

		
		TilePane tilePane = new TilePane();
		tilePane.getChildren().addAll(
				new Button("AAAAAA"), new Button("B"), new Button("CCCCCC"), new Button("D"), new Button("E"));

		root.getChildren().addAll(flowPane, tilePane);
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
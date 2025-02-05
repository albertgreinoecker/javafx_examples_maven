package fx_examples_maven.fx_examples_maven.ex_03_layoutmanager_combined;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * So kann man Layoutmanager kombinieren
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		HBox top = new HBox(); //Horizontale Anordnung der Steuerelemente
		Button b1 = new Button("A");
		Button b2 = new Button("B");
		Button b3 = new Button("C");
		//top.getChildren().add  ..fügt ein Steuerelement hinzu
		//hier werden gleich alle hinzugefügt:
		top.getChildren().addAll(b1, b2, b3);
		root.setTop(top);

		VBox left = new VBox(); //Vertikale Anordnung der Steuerelemente
		RadioButton r1 = new RadioButton("rot");
		RadioButton r2 = new RadioButton("grün");
		RadioButton r3 = new RadioButton("blau");
		left.getChildren().addAll(r1,r2,r3);
		root.setLeft(left);
		
		
		GridPane center = new GridPane();
		//Die Elemente können natürlich auch dynamisch erzeugt werden
		for (int i = 0; i < 10;i++)
		{
			for (int j = 0; j < 10;j++)
			{
				String bStr = String.format("(%d %d)", i, j); // wie printf
				Button b = new Button(bStr);
				center.add(b, i,j); //stelle den Button an die Stelle i,j
			}				
		}
		root.setCenter(center);
		
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
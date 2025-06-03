package fx_examples_maven.fx_examples_maven.ex_28_stackpane;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Dieses Beispiel Zeigt den Umang mit einer StackPane.
 * Es wird jede Sekunde ein Knoten in den Vordergrund gebracht.
 */
public class App extends Application {
    
    ArrayList<Node> list = new ArrayList<>();
    StackPane stackPane;
    Timeline timeline;
    int idx = 0;
    
    @Override
    public void start(Stage primaryStage) {
    	stackPane = new StackPane();
        Rectangle rectangle = new Rectangle(200, 100);
        rectangle.setFill(Color.LIGHTBLUE);

        Text text = new Text("Hallo, StackPane!");
        Circle circle = new Circle(50, Color.RED);
        list.addAll(Arrays.asList(rectangle, text, circle));
    	stackPane.getChildren().addAll(rectangle,circle, text);
    	stackPane.setStyle("-fx-background-color: lightgray;");
        
    	Scene scene = new Scene(stackPane, 300, 100);
        primaryStage.setTitle("StackPane Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            idx = (idx + 1) % list.size();
            System.out.println("Bringe: " + idx + "in den Vordergrund");
            
			Node currentNode = list.get(idx);
			currentNode.toFront(); // Den aktuellen Knoten nach vorne bringen
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package fx_examples_maven.fx_examples_maven.ex_27_progress_bar_timeline;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Einfache ProgressBar, die mit einer Timeline gefüllt wird.
 * Der Fortschritt wird alle 1000 Millisekunden um 1 erhöht,
 * bis ein Maximum von 5 erreicht ist.
 */
public class App extends Application {

    private double progress = 0.0;
    Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar(0);

        // Timeline zum Fortschrittsaufbau
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            progress += 1;
            System.out.println("Fortschritt: " + progress);
            progressBar.setProgress(progress / 5.0); // Fortschritt auf 5.0 begrenzen

            if (progress >= 5.0) {
                timeline.stop();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        VBox root = new VBox(20, progressBar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 100);
        primaryStage.setTitle("ProgressBar mit Timeline");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

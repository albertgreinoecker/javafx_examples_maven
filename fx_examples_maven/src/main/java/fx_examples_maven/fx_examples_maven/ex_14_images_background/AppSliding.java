package fx_examples_maven.fx_examples_maven.ex_14_images_background;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppSliding extends Application {

    private static final int VIEW_WIDTH = 800;
    private static final int VIEW_HEIGHT = 600;
    private static final int SCROLL_SPEED = 2;

    @Override
    public void start(Stage stage) {
        // Großes Hintergrundbild laden
        Image background = new Image(getClass().getResource("/images/sliding.png").toExternalForm()); // z. B. 2000px Breite

        ImageView imageView = new ImageView(background);

        // Start-Viewport (linker Bildbereich sichtbar)
        Rectangle2D viewport = new Rectangle2D(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
        imageView.setViewport(viewport);

        // Kein Scaling!
        imageView.setFitWidth(VIEW_WIDTH);
        imageView.setFitHeight(VIEW_HEIGHT);
        imageView.setPreserveRatio(false);

        Pane root = new Pane(imageView);
        Scene scene = new Scene(root, VIEW_WIDTH, VIEW_HEIGHT);

        // Timeline für kontinuierliches Scrollen nach rechts
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            Rectangle2D current = imageView.getViewport();
            double newX = current.getMinX() + SCROLL_SPEED;

            // Nur scrollen, solange Bild nicht zu Ende
            if (newX + VIEW_WIDTH <= background.getWidth()) {
                imageView.setViewport(new Rectangle2D(newX, current.getMinY(), VIEW_WIDTH, VIEW_HEIGHT));
            } else {
				// Wenn Ende erreicht, zurücksetzen
				imageView.setViewport(new Rectangle2D(0, current.getMinY(), VIEW_WIDTH, VIEW_HEIGHT));
			}
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setScene(scene);
        stage.setTitle("Scrolling Background");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

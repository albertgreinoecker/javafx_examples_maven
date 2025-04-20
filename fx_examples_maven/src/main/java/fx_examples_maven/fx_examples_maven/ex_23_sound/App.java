package fx_examples_maven.fx_examples_maven.ex_23_sound;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class App extends Application {

	private MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox();
		
		Button btnAudioClip = new Button("Sound mit AudioClip abspielen");
		btnAudioClip.setOnAction(event -> {
			// Hier AudioClip abspielen
			System.out.println("Sound mit AudioClip abspielen");
			AudioClip sound = new AudioClip(getClass().getResource("/sounds/test.wav").toString());
			sound.play();
		});

		Button btnMedia = new Button("Sound mit Mediaplayer abspielen");		
		String musicFile = getClass().getResource("/sounds/groove.mp3").toExternalForm();
		Media sound = new Media(musicFile);
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Endlosschleife
		
		btnMedia.setOnAction(event -> {
			if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
				mediaPlayer.stop();
				System.out.println("Sound mit Mediaplayer stoppen");
				return;
			}
			// Hier mit Mediaplayer abspielen

			mediaPlayer.play();
		});
		root.getChildren().addAll(btnAudioClip, btnMedia);
		Scene scene = new Scene(root, 400, 300);

		primaryStage.setTitle("JavaFX Sound Beispiel");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Fokus setzen, damit Tastaturereignisse empfangen werden
		root.requestFocus();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package fx_examples_maven.fx_examples_maven.ex_15_canvas_first;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Erstes Beispiel fuer Zeichnen mit Canvas
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		// Erzeugen der Zeichenflaeche
		Canvas canvas = new Canvas(1000, 600);
		
		// Daraus wird das Zeichengeraet (wie der Stift, mit dem gezeichnet wird), erzeugt
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//Will man Zeichnungen ausfuellen, muss man eine Fuellfarbe setzen
		gc.setFill(Color.GREEN); 
		
		// Hier ein paar Moeglichkeiten wie man solche Objekte fuellen kann
		gc.fillRect(100, 100, 100, 100); // x,y,w,h (x,y,Breite, Hoehe)
		gc.fillRect(150, 150, 100, 100);
		gc.fillOval(300, 300, 100, 100); //// x,y,w,h wenn w = h => Kreis
		
	    // Fuer einfaches Zeichnen sind folgende Einstellungen sinnvoll
	    gc.setLineWidth(3); // Einstellen der Stiftdicke
	    gc.setStroke(Color.BLUE); // Einstellen der Zeichenfarbe
	    
	    // Zeichnen funktioniert dann wie das Ausfuellen nur mit stroke:
	    gc.strokeOval(500, 300, 50, 40); 
	    
	    Image im = new Image(getClass().getResource("/images/htl-logo_rauten.png").toExternalForm());
	    gc.drawImage(im, 200, 200);

		root.setCenter(canvas);
		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Bildanzeige");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

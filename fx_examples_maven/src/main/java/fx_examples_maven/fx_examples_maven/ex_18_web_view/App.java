package fx_examples_maven.fx_examples_maven.ex_18_web_view;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Anzeige einer Webseite in JavaFX
 */
public class App extends Application implements EventHandler<ActionEvent> {

	WebEngine webEngine;
	RadioButton rbRemote; 
	RadioButton rbLocal;
	RadioButton rbString;
	RadioButton rbJavascript;
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		HBox top = new HBox();
		rbRemote = new RadioButton("Webseite HTLInn");
		rbRemote.setOnAction(this);
		rbLocal = new RadioButton("Webseite Lokal");
		rbLocal.setOnAction(this);
		rbString = new RadioButton("Webseite aus String");
		rbString.setOnAction(this);
		rbJavascript = new RadioButton("Javascript");
		rbJavascript.setOnAction(this);
		
		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(rbRemote, rbLocal, rbString, rbJavascript);
		top.getChildren().addAll(rbRemote, rbLocal, rbString, rbJavascript);
		
        WebView webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("https://htlinn.ac.at");
		
        root.setCenter(webView);
		root.setTop(top);
		
		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Anzeige der Website");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		Node n = (Node)event.getSource();
		if (n == rbRemote)
			webEngine.load("https://htlinn.ac.at");
		else if (n == rbString)
		{
			String html = "<html><body><h1>Beispiel Webview aus String</h1></body></html>";
			webEngine.loadContent(html);
		} else if (n == rbLocal)
		{
			webEngine.load(getClass().getResource("/html/index.html").toExternalForm());
		} else // Javascript
		{
			webEngine.executeScript("document.write('Hello from JavaFX');");
		}
	}
}

package fx_examples_maven.fx_examples_maven.ex_17_menu;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Erstes Beispiel fuer das Erstellen eines Menu
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		MenuBar bar = new MenuBar();
		
		Menu m1 = new Menu("Menu 1");
		MenuItem m11 = new MenuItem("Eintrag 1 1");
		MenuItem m12 = new CheckMenuItem("Check - Eintrag 1 2");
		
		RadioMenuItem m13 = new RadioMenuItem("Radio -Eintrag 1 3");
		RadioMenuItem m14 = new RadioMenuItem("Radio -Eintrag 1 4");
		ToggleGroup tg = new ToggleGroup();
		m13.setToggleGroup(tg);
		m14.setToggleGroup(tg);
		
		m1.getItems().addAll(m11, m12, m13, m14);
		bar.getMenus().add(m1); //bei mehreren wird addAll verwendet
		
		root.setTop(bar);
		
		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Bildanzeige");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

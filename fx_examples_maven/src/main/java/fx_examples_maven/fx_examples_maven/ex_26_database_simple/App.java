package fx_examples_maven.fx_examples_maven.ex_26_database_simple;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Zeigt wie man von JavaFX auf die Datenbank zugreifen kann
 */
public class App extends Application {
	
	DBManager db;
	Label status;
	
	@Override
	public void start(Stage primaryStage) throws SQLException {
		db = new DBManager();
		BorderPane root = new BorderPane();
        status = new Label("");
        root.setBottom(status);
        VBox cmdsResults = new VBox(); //Hier kommen alle Beispiele rein
        
        //Auswahl eines Professors
        HBox cmds = new HBox();
        TextField idField = new TextField("");
        Label result = new Label("");
        Button oneProf = new Button("oneprof");
        oneProf.setOnAction(event -> {
        	try {
				Professor prof = db.get(idField.getText());
				result.setText(prof.toString());
			} catch (Exception e) {
				status.setText(e.getMessage());
				e.printStackTrace();
			}
        });

        cmds.getChildren().addAll(idField,oneProf, result);
        cmdsResults.getChildren().add(cmds);
        
        root.setCenter(cmdsResults);
        root.setBottom(status);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Acces Database Example");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		db.close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

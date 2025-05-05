package fx_examples_maven.fx_examples_maven.ex_25_custom_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SimpleCustomButton extends Button implements EventHandler<ActionEvent>{
	private int counter;
	
	public SimpleCustomButton(String text) {
		super(text);
		counter = 0;
		setOnAction(this);
		setStyle("-fx-background-color: #00FF00; -fx-text-fill: #00000;");
		
	}

	public SimpleCustomButton() {
		this("0");
	}

	@Override
	public void handle(ActionEvent event) {
		setText(counter++ + "");
		
	}
}

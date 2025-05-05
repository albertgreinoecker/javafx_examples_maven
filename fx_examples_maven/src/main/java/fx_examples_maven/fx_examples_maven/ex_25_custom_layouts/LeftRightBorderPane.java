package fx_examples_maven.fx_examples_maven.ex_25_custom_layouts;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class LeftRightBorderPane extends BorderPane {

	private final HBox topBox = new HBox();
	private final HBox bottomBox = new HBox();

	public LeftRightBorderPane() {
		// Konfiguration für topBox
		topBox.setAlignment(Pos.CENTER_LEFT);
		topBox.setSpacing(10);

		// Konfiguration für bottomBox
		bottomBox.setAlignment(Pos.CENTER_LEFT);
		bottomBox.setSpacing(10);

		// Platzhalter für rechtsbündige Elemente
		Region topSpacer = new Region();
		Region bottomSpacer = new Region();
		HBox.setHgrow(topSpacer, Priority.ALWAYS);
		HBox.setHgrow(bottomSpacer, Priority.ALWAYS);

		// Platzhalter + HBox-Struktur erstellen (zunächst leer)
		topBox.getChildren().addAll(topSpacer);
		bottomBox.getChildren().addAll(bottomSpacer);

		// Im Layout platzieren
		this.setTop(topBox);
		this.setBottom(bottomBox);
	}

	public void setTopLeft(Node node) {
		if (topBox.getChildren().size() > 1)
			topBox.getChildren().remove(0);
		topBox.getChildren().add(0, node);
	}

	public void setTopRight(Node node) {
		if (topBox.getChildren().size() > 2)
			topBox.getChildren().remove(2);
		topBox.getChildren().add(node);
	}

	public void setBottomLeft(Node node) {
		if (bottomBox.getChildren().size() > 1)
			bottomBox.getChildren().remove(0);
		bottomBox.getChildren().add(0, node);
	}

	public void setBottomRight(Node node) {
		if (bottomBox.getChildren().size() > 2)
			bottomBox.getChildren().remove(2);
		bottomBox.getChildren().add(node);
	}
}

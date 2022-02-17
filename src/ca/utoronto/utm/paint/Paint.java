package ca.utoronto.utm.paint;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Class used to execute the application to return the user interface for the paint application.
 * @author sidharth
 *
 */
public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.model = new PaintModel();
		
		// View + Controller
		this.view = new View(model, stage);
		
		stage.widthProperty().addListener((obs, oldVal, newVal) -> {
			double changedWidth = newVal.doubleValue() - oldVal.doubleValue();
		    this.view.getPaintPanel().getCanvas().setWidth(oldVal.doubleValue() + changedWidth);
		    this.view.getPaintPanel().repaint();
		});
		
		stage.heightProperty().addListener((obs, oldVal, newVal) -> {
			double changedHeight = newVal.doubleValue() - oldVal.doubleValue();
		    this.view.getPaintPanel().getCanvas().setHeight(oldVal.doubleValue() + changedHeight-100);
		    this.view.getPaintPanel().repaint();
		});
	}
}

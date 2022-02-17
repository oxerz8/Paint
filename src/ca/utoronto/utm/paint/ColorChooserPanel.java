package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Class that holds the ColorPicker and the Slider for the Thickness.
 * This Uses the GridPane Border
 * @author michaelskotar
 *
 */
public class ColorChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private Color currentcolor= Color.BLACK;
	private View view;
	private Slider slider;
	
	/**
	 * Creates the color chooser and the slider for the Application
	 * @param view		View for the Paint Appication
	 */
	public ColorChooserPanel(View view) {
		
		this.view = view;		
		
		final ColorPicker color = new ColorPicker();
		color.setValue(Color.BLACK);
		final Text text = new Text("Color Panel");
		text.setFill(Color.BLACK);
		this.add(text, 0, 0);
		this.add(color, 0, 1);
		color.setOnAction(this);	
		
		this.slider = new Slider(0,10,0.5); 
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(0.25f);
		slider.setBlockIncrement(0.1f);
		this.add(slider,3,1);
		
		final Text text2 = new Text("Line Thickness");
		text2.setFill(Color.BLACK);
		this.add(text2, 3, 0);
		
	
	}
	
	
	@Override
	/**
	 * This is handle function that gets the color and sets the color to the current chosen one
	 * @param event		ActionEvent
	 */
	public void handle(ActionEvent event) {
		Color current = ((ColorPicker) event.getSource()).getValue();
		this.view.getPaintPanel().setStroke(current);
		currentcolor = current;

	}
	
	/**
	 * Returns value of the slider
	 * @return	double Value of the slider
	 */
	public double getComboValue() {
		double num = this.slider.getValue();
		String value = String.valueOf(num);
		return Double.valueOf(value);
	}
}
	

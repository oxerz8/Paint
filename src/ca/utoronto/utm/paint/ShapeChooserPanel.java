package ca.utoronto.utm.paint;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view


	

	//private ComboBox<String> comboBox;
	private ComboBox comboBox;
	private VBox vbox;
	private ToggleGroup group;
	
	/**
	 * Panel from which the user can select the shape they want to draw
	 * @param view The view of the application. Part of MVC design.
	 */
	
	public ShapeChooserPanel(View view) {

		
		
		this.view = view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
		
		ToggleGroup tg = new ToggleGroup();
		
		int row = 0;
		for (String label : buttonLabels) {
			Image img = new Image(getClass().getResourceAsStream("images/"+ label+ ".png"));
			ToggleButton button = new ToggleButton("", new ImageView(img));					//uses ToggleButton instead of normal button
			button.setToggleGroup(tg);
			button.setMinWidth(57);
			this.add(button, 0, row);
			//button.setSelected(true);
			button.setOnAction(this);
			button.setId(label);
			row++;
		}
		
		
		

	
		VBox vbox = new VBox();
		ToggleGroup group = new ToggleGroup();
		ToggleButton fill = new ToggleButton("    Fill    ");
		ToggleButton noFill = new ToggleButton(" No Fill ");
		fill.setToggleGroup(group);
		noFill.setToggleGroup(group);
		fill.setSelected(true);
		vbox.getChildren().addAll(fill,noFill);
		this.add(vbox, 0, 5);
		this.vbox = vbox;
		this.group = group;
	}
	
	
	@Override
	/**
	 * The event handler for this panel that listens to the mode that is selected
	 */
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getId();
		this.view.getPaintPanel().setMode(command);
		
		System.out.println(command);
	}	
		/**
		 * This method understands if fill is selected or not.
		 * @return true if fill is selected, false otherwise.
		 */
	public boolean getStatus() {
		ToggleButton selectedToggleButton = (ToggleButton) group.getSelectedToggle();
		if (selectedToggleButton.getText()== "    Fill    ") {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	

}

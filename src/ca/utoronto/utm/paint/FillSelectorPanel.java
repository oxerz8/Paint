package ca.utoronto.utm.paint;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * @author sidharth
 * Creates a panel to choose for a solid vs an outline of a shape.
 */
public class FillSelectorPanel extends HBox {

	private View view;
	/**
	 * Creates a selection panel to choose between fill and no fill
	 * @param view 		Used to initiate the panel so that it can be viewed in the application.
	 */
	public FillSelectorPanel(View view) {
		this.view = view;
		
		ToggleGroup group = new ToggleGroup();
		HBox hbox = new HBox();
		ToggleButton fill = new ToggleButton("Fill");
		ToggleButton noFill = new ToggleButton("No Fill");
		fill.setToggleGroup(group);
		noFill.setToggleGroup(group);
		fill.setSelected(true);
		hbox.getChildren().addAll(fill,noFill);
	}
	
}

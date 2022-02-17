package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
/**
 * Ignore this class it isnt used.
 * @author Daniil
 *
 */
public class ThicknessPanel extends StackPane implements EventHandler<ActionEvent>{
	
	private ComboBox comboBox;
	private View view;
	/**
	 * ignore this class it isnt used.
	 * @param view This is the view
	 */
	public ThicknessPanel(View view) {
		this.view = view;
		
		String[] labels = {"1", "2", "3"};
		
		ComboBox comboBox = new ComboBox();
		comboBox.getItems().add("1");
		comboBox.getItems().add("2");
		comboBox.getItems().add("3");
//		for(String i : labels) {
//			comboBox.getItems().add(i);
//		}
		this.getChildren().add(comboBox);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public double getComboValue() {
		String value = (String)this.comboBox.getValue();
		return Double.valueOf(value);
	}

}



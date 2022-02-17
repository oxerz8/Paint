package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SquiggleStrategy implements ShapeManipulatorStrategy {
		
	private PaintModel model;
	private View view;
	
	@Override
	/**
	 * Handles the mouse events for when Squiggle is selected as the drawing mode.
	 */
	public void mouseEvent(MouseEvent e, PaintModel model, View view) {
		this.model = model;
		this.view = view;
		
		if(e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			
			double thickness = this.view.getColorChooserPanel().getComboValue();
			Color color = this.view.getPaintPanel().getStroke();
			view.getPaintPanel().setSquiggle(new Squiggle(thickness, color));
			this.model.addPoint(new Point( (int) e.getX(), (int) e.getY()));
			this.model.addShape(view.getPaintPanel().getSquiggle());
			this.model.addSquiggle(this.model.getPoints());
			this.view.getPaintPanel().repaint();
			//System.out.println("Draggin works");
		}
		else if(e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			
			this.model.addSquiggle(this.model.getPoints());
			System.out.println("Release works");
			//this.model.addSquiggle(view.getPaintPanel().getPoints());
			this.model.addShape(view.getPaintPanel().getSquiggle());
			this.view.getPaintPanel().repaint();
			this.model.clearPoints();
			
		}
	}
	
	
}


//The squiggle array is not involved in repaint so everytime 32 is executed,
//it just deletes the array and so there's nothing to repaint'
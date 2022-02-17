package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Circle Strategy which implements the ShapeManipulatorStrategy, This handles the
 * Mouse Events for a Circle
 * @author michaelskotar
 *
 */
public class CircleStrategy implements ShapeManipulatorStrategy{
	
	private Circle circle;
	private PaintModel model;
	private View view;
	
	
	/**
	 * Handles the MouseEvents of the Circle Strategy with the three mouseevents being:
	 * Mouse Dragged, Mouse Pressed, and Mouse Released
	 * @param e		MouseEvent 
	 * @param model	The PaintModel
	 * @param view	The View for the whole Paint Application
	 */
	public void mouseEvent(MouseEvent e, PaintModel model, View view) {
		this.model = model;
		this.view=view;
		
		if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			if(view.getPaintPanel().getCircle() != null) {
				
				this.model.removeShape(view.getPaintPanel().getCircle());
		
				Point point = new Point((int) e.getX(), (int) e.getY());
				Point center = view.getPaintPanel().getCircle().getCentre();
				
				int radius = (int)(Math.sqrt(Math.pow(center.getX() -  point.getX(),2) + Math.pow(center.getY() - point.getY(), 2)));
				view.getPaintPanel().getCircle().setRadius(radius);
				
				this.model.addShape(view.getPaintPanel().getCircle());
				System.out.println("Number of circles in dragged: " + this.model.getShapes().size());
				this.view.getPaintPanel().repaint();
				
			}
		} else if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			double thickness = this.view.getColorChooserPanel().getComboValue();
			Color color = this.view.getPaintPanel().getStroke();
			Color filler = this.view.getPaintPanel().getStroke();
			Boolean fill = this.view.getShapeChooserPanel().getStatus();
			
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			Circle circle = new Circle(centre, radius, thickness, color, filler, fill);
			view.getPaintPanel().setCircle(new Circle(centre, radius, thickness, color, filler, fill));
			
			this.model.addShape(view.getPaintPanel().getCircle());
			//System.out.println("Number of circles in pressed: " + this.model.getShapes().size());
			this.view.getPaintPanel().repaint();
		
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			int radius = (int)(Math.sqrt(Math.pow(view.getPaintPanel().getCircle().getCentre().getX() -  e.getX(),2) + Math.pow(view.getPaintPanel().getCircle().getCentre().getY() - e.getY(), 2)));
			view.getPaintPanel().getCircle().setRadius(radius);
			model.addShape(view.getPaintPanel().getCircle());
			//System.out.println("Number of circles in released: " + this.model.getShapes().size());
			view.getPaintPanel().setCircle(null);
		}
	}
}

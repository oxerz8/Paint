package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SquareStrategy implements ShapeManipulatorStrategy{
	
	private Square square;
	private PaintModel model;
	private View view;
	
	@Override
	/**
	 * Handles the events for when square is selected and creates squares based on the events.
	 */
	public void mouseEvent(MouseEvent e, PaintModel model, View view) {
		this.model = model;
		this.view = view;
		
		if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			if (view.getPaintPanel().getSquare() != null) {
				this.model.removeShape(view.getPaintPanel().getSquare());
					
				Point point2 = new Point((int) e.getX(), (int) e.getY());
				view.getPaintPanel().getSquare().setPoint2(point2);
					
				this.model.addShape(view.getPaintPanel().getSquare());
				this.view.getPaintPanel().repaint();
			}
			
		} else if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			Point point1 = new Point((int) e.getX(), (int) e.getY());
			Point point2 = new Point((int) e.getX(), (int) e.getY());
			double thickness = this.view.getColorChooserPanel().getComboValue();
			Color color = this.view.getPaintPanel().getStroke();
			Color filler = this.view.getPaintPanel().getStroke();
			Boolean fill = this.view.getShapeChooserPanel().getStatus();
				
			view.getPaintPanel().setSquare(new Square(point1, point2, thickness, color, filler, fill));
				
			this.model.addShape(view.getPaintPanel().getSquare());
			this.view.getPaintPanel().repaint();
			
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			if (view.getPaintPanel().getSquare() != null) {
				Point point2 = new Point((int) e.getX(), (int) e.getY());
				view.getPaintPanel().getSquare().setPoint2(point2);
				this.model.addShape(view.getPaintPanel().getSquare());
				view.getPaintPanel().setSquare(null);
			}
		}
	}
}

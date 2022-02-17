package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Implements strategy for Rectangle. 
 * @author sidharth
 *
 */
public class RectangleStrategy implements ShapeManipulatorStrategy{
	
	private Rectangle rectangle;
	private PaintModel model;
	private View view;
	
	@Override
	/**
	 * Implements the mouse events accordingly
	 */
	public void mouseEvent(MouseEvent e, PaintModel model, View view) {
		this.model = model;
		this.view = view;
		
		//System.out.println("In rect strat");
		
		if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			//System.out.println("in dragged");
			if (view.getPaintPanel().getRectangle() != null) {
				this.model.removeShape(view.getPaintPanel().getRectangle());
					
				Point point2 = new Point((int) e.getX(), (int) e.getY());
				view.getPaintPanel().getRectangle().setPoint2(point2);
					
				this.model.addShape(view.getPaintPanel().getRectangle());
				//System.out.println("here");
				this.view.getPaintPanel().repaint();
			}
				
			}else if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
				
				double thickness = this.view.getColorChooserPanel().getComboValue();
				Color color = this.view.getPaintPanel().getStroke();
				Color filler = this.view.getPaintPanel().getStroke();
				Boolean fill = this.view.getShapeChooserPanel().getStatus();
				Point topLeft = new Point((int) e.getX(), (int) e.getY());
				Point bottomRight = new Point((int) e.getX(), (int) e.getY());
				
				view.getPaintPanel().setRectangle(new Rectangle(topLeft, bottomRight, thickness, color,filler,fill));
				
				//System.out.println("in mouse pressed");
				Point point1 = new Point((int) e.getX(), (int) e.getY());
				Point point2 = new Point((int) e.getX(), (int) e.getY());
				
				//System.out.print("creating rect");
				view.getPaintPanel().setRectangle(new Rectangle(point1, point2, thickness, color,filler,fill));	
				//System.out.println("rect created");
				
				this.model.addShape(view.getPaintPanel().getRectangle());
				this.view.getPaintPanel().repaint();
			
			} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
				if (view.getPaintPanel().getRectangle() != null) {
					Point point2 = new Point((int) e.getX(), (int) e.getY());
					view.getPaintPanel().getRectangle().setPoint2(point2);
					this.model.addShape(view.getPaintPanel().getRectangle());
					view.getPaintPanel().setRectangle(null);

			}
	}
 }
}

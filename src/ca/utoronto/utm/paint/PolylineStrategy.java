package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/*
 * Implements the strategy for polyline
 */
public class PolylineStrategy implements ShapeManipulatorStrategy {
	
	private ArrayList<Integer> xpoints = new ArrayList<Integer>();
	private ArrayList<Integer> ypoints = new ArrayList<Integer>();
	
	
	private Polyline polyline;
	private PaintModel model;
	private View view;
	
	
	@Override
	/**
	 * Initiates the mouseEvents for Polyline
	 */
	public void mouseEvent(MouseEvent e, PaintModel model, View view) {
		
		this.model = model;
		this.view=view;
		
		
		if(e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			double thickness = this.view.getColorChooserPanel().getComboValue();
			Color color = this.view.getPaintPanel().getStroke();
			
			this.model.addPolyPoint(new Point( (int) e.getX(), (int) e.getY()));
			this.model.addPolyline(this.model.getPolyPoints());
			this.model.addShape(new Polyline(thickness,color));
			this.view.getPaintPanel().repaint();
		}else if(e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			//System.out.println("Release works");
			this.model.addPolyline(this.model.getPolyPoints());
			//this.model.addSquiggle(view.getPaintPanel().getPoints());
			this.view.getPaintPanel().repaint();
			this.model.clearPoints();
		}
			
			
		} 
		
		
		/*else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			
			
		
		}*/

	}	
	



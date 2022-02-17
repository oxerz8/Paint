package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Drawable Squiggle which implementes the DrawCommand and actually draws a squiggle to the 
 * screen
 * @author michaelskotar
 *
 */
public class DrawableSquiggle implements DrawCommand{
	private ArrayList<ArrayList<Point>> squiggle;
	
	/**
	 * DrawableSquiggle which is the constructor
	 * @param squiggle Squiggle
	 */
	public DrawableSquiggle(ArrayList<ArrayList<Point>> squiggle) {
		this.squiggle = squiggle;
		
	}
	
	/**
	 * Executes the actual command and draws it to the screen
	 */
	@Override
	public void execute(GraphicsContext g) {
		for(int j=0; j<squiggle.size()-1; j++) {
			ArrayList<Point> points = squiggle.get(j);
			for(int i =0; i<points.size()-1; i++) {
				Point p1 = points.get(i);
				Point p2 = points.get(i+1);
				
				g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		}
		
	}
	
}


package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class DrawablePolyline implements DrawCommand {
	
	private ArrayList<ArrayList<Point>> polyline;
	
	public DrawablePolyline(ArrayList<ArrayList<Point>> polyline) {
		this.polyline = polyline;
	}
	
	private ArrayList<Integer> xpoints = new ArrayList<Integer>();

	private ArrayList<Integer> ypoints = new ArrayList<Integer>();
	
	
	
	@Override
	public void execute(GraphicsContext g) {
	
		/*
		g.setLineWidth(this.polyline.getThickness());
		g.setStroke(this.polyline.getColor());
		ArrayList<Point> points = polyline.getPoints();*/
		
		for(int j=0; j<polyline.size()-1; j++) {
			ArrayList<Point> points = polyline.get(j);
			for(int i =0; i<points.size()-1; i++) {
				Point p1 = points.get(i);
				Point p2 = points.get(i+1);
				
				/*this.xpoints.add(p1.getX(),p2.getX());
				this.ypoints.add(p1.getY(),p2.getY());
				*/
			//g.setLineWidth(this.squiggle.getThickness());
				g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

				//System.out.println("sure");
		}
		
		
		}

}
}
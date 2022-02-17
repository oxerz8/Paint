package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * DrawableCircle which implements the Command design and Draws a circle to
 * the graphics context
 * @author michaelskotar
 *
 */
public class DrawableCircle implements DrawCommand{

	private Circle circle;
	
	/**
	 * Constructor for DrawbleCircle
	 * @param circle Cirlce
	 */
	public DrawableCircle(Circle circle) {
		this.circle = circle;
	}
	
	/**
	 * The implemented the execute function for the command design
	 */
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		int x = this.circle.getCentre().getX();
		int y = this.circle.getCentre().getY();
		int radius = this.circle.getRadius(); 
		g.setLineWidth(this.circle.getThickness());
		g.setStroke(this.circle.getColor());
		if (this.circle.getFillStatus()) {
			g.setFill(this.circle.getFiller());
			g.fillOval(x - radius, y- radius, radius*2, 2*radius);	
		} else {
			g.strokeOval(x - radius, y- radius, radius*2, 2*radius);
		}
	}

}

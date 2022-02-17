package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * Drawable rectangle which implements the drawcommand, this actually draws the rectangle
 * to the screen.
 * @author michaelskotar
 *
 */
public class DrawableRectangle implements DrawCommand {
	
	private Rectangle rectangle;
	
	/**
	 * Constructor for the Drawable Rectangle
	 */
	public DrawableRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	
	/**
	 * Execute the draw command and draws it to the screen
	 */
	@Override
	public void execute(GraphicsContext g) {
		int x1 = this.rectangle.getPoint1().getX();
		int y1 = this.rectangle.getPoint1().getY();
		int x2 = this.rectangle.getPoint2().getX();
		int y2 = this.rectangle.getPoint2().getY();
		
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		
		int x = x1;
		int y = y1;
		
		if (x1 > x2) {
			x = x2;
		}
		
		if (y1 > y2) {
			y = y2;
		}
		g.setLineWidth(this.rectangle.getThickness());
		g.setStroke(this.rectangle.getColor());
		g.strokeRect(x,y,width,height);
		if (this.rectangle.getFillStatus()) {
			g.setFill(this.rectangle.getFiller());
			g.fillRect(x ,y,width,height);	
		} else {
			
			g.strokeRect(x ,y,width,height);
		}
		
	}

}

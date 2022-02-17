package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * DrawableSquare which actually draws a square to the screen. This implements the DrawCommand
 * which has the execute function.
 * @author michaelskotar
 *
 */
public class DrawableSquare implements DrawCommand {
	
	private Square square;
	
	/**
	 * Constructor fot the Drawable Square
	 * @param square	An actual Square
	 */
	public DrawableSquare(Square square) {
		this.square = square;
	}
	
	@Override
	/**
	 * Implements the execute function and draws to the screen
	 */
	public void execute(GraphicsContext g) {
		int x1 = this.square.getPoint1().getX();
		int y1 = this.square.getPoint1().getY();
		int x2 = this.square.getPoint2().getX();
		int y2 = this.square.getPoint2().getY();
		
		int length1 = Math.abs(x1 - x2);
		int length2 = Math.abs(y1 - y2);
		
		int x = x1;
		int y = y1;
		int length;
		int difflen = Math.abs(length1 - length2);
		
		if (length1 < length2) {
			length = length1;
		} else {
			length = length2;
		}
		
		if (x1 > x2) {
			x -= length;
			
		} 
		
		if (y1 > y2) {
			y -= length;
			
		} 
		
		g.setLineWidth(this.square.getThickness());
		g.setStroke(this.square.getColor());
		g.strokeRect(x, y, length, length);
		
		if (this.square.getFillStatus()) {
			g.setFill(this.square.getFiller());
			g.fillRect(x ,y, length, length);	
		} else {
			g.strokeRect(x ,y, length, length);
		}	
	}
}

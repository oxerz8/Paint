package ca.utoronto.utm.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 	Creates the Canvas for the Paint application.
 * @author sidharth
 *
 */
public class ResizableCanvas extends Canvas{
	
	/**
	 * Constructor for Resizable canvas class
	 * @param width		width of canvas
	 * @param height	height of canvas
	 */
	public ResizableCanvas(int width, int height) {
		
		this.setWidth(width);
		this.setHeight(height);
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
	}
	
	/**
	 * Initiates the Canvas for the application.
	 */
	private void draw() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
    }
	
	public boolean isResizable(){
	      return true;
	}
}

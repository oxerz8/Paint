package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
/**
 * The squiggle shape which is a shape.
 * @author Daniil
 *
 */
public class Squiggle extends Shape {

	private Color color;
	private double thickness;
	/**
	 * Creates the Squiggle shape
	 * @param thickness The thickness of the squiggle drawing
	 * @param color The color of the squiggle drawing
	 */
	public Squiggle(double thickness, Color color) {
		this.color = color;
		this.thickness = thickness;
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public double getThickness() {
		return thickness;
	}
}

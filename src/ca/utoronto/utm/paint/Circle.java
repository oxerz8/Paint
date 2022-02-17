package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

/**
 * This is the model for a Circle. This holds the information for what a circle is 
 * in the context of a paint application.
 * @author michaelskotar
 *
 */
public class Circle extends Shape{
	
	private Point centre;
	private int radius;
	private double thickness;
	private Color color;
	private Color filler;
	private Boolean fill;

	/**
	 * The constructor for Circle given a centre, radius, thickness, color, filler and fill.
	 * This is the model for the
	 * @param centre	Center
	 * @param radius	Radius
	 * @param thickness Thickness
	 * @param color	Color
	 * @param filler	Filler
	 * @param fill 	fill
	 */
	public Circle(Point centre, int radius, double thickness, Color color, Color filler,Boolean fill) {
		this.centre = centre;
		this.radius = radius;
		this.thickness = thickness;
		this.color = color;
		this.filler = filler;
		this.fill = fill;
	}

	/**
	 * Gets the center of the circle
	 * @return Point centre
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * Sets the center of a circle given a point
	 * @param centre
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * Sets the Fill color of the circle given a specific color
	 * @param color
	 */
	public void setFill(Color color) {
		this.filler = color;
		this.fill = true;
	}

	/**
	 * Gets the radius of the circle
	 * @return int radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the circle
	 * @param radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Gets the thickness of the circle
	 * @return double thickness
	 */
	public double getThickness() {
		return thickness;
	}
	
	/**
	 * Gets the color of the circle
	 * @return Color color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Gets the color fill of the circle
	 * @return Color filler
	 */
	public Color getFiller() {
		return filler;
	}
	
	/**
	 * Gets the fill status of the circle
	 * @return Boolean fill
	 */
	public Boolean getFillStatus() {
		return fill;
	}
}

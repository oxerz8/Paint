package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * Implements the base code for polyline
 * @author sidharth
 *
 */
public class Polyline extends Shape {
	
	private double thickness;
	private Color color;

	/**
	 * Constructor for polyline
	 * @param thickness thickness of the line
	 * @param color 	color of the line
	 */
	
	
	public Polyline (double thickness, Color color){
	
		this.thickness = thickness;
		this.color = color;
	}
	public double getThickness() {
		return thickness;
	}
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void setThickness(double t) {
		this.thickness = t;
	}



}

package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

/**
 * Implements the base code for shape rectangle
 * @author sidharth
 *
 */
public class Rectangle extends Shape {
	
		private Point point1;
		private Point point2;
		private double thickness;
		private Color color;
		private Color filler;
		private Boolean fill;
		
		/**
		 * Constructor for Rectangle class
		 * @param point1	Object of point class
		 * @param point2	Object of point class
		 * @param thickness	Object of Thickness panel
		 * @param color		Color in consideration
		 * @param filler	Fills the color inside the shape
		 * @param fill		Check for fill
		 */
		public Rectangle(Point point1, Point point2, double thickness, Color color, Color filler, Boolean fill) {
			this.point1 = point1;
			this.point2 = point2;
			this.thickness = thickness;
			this.color = color;
			this.filler=filler;
			this.fill=fill;
		}
		
		
		
		public Point getPoint1() {
			return this.point1;
		}
		
		public void setPoint1(Point point1) {
			this.point1 = point1;
		}
		
		public Point getPoint2() {
			return this.point2;
		}
		
		public void setPoint2(Point point2) {
			this.point2 = point2;
		}
		
		public double getThickness() {
			return thickness;
		}
		
		public Color getColor() {
			return color;
		}
		public Color getFiller() {
			return filler;
		}
		public Boolean getFillStatus() {
			return fill;
		}



		
}

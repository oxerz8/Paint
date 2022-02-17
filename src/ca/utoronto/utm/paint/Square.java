package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
/**
 * The square class which extends abstract class Shape.
 * @author Daniil
 *
 */
public class Square extends Shape {
	
		private Point point1;
		private Point point2;
		private double thickness;
		private Color color;
		private Color filler;
		private Boolean fill;
		/**
		 * The constructor for Square class
		 * @param point1 The starting point (x,y) for the first click of the mouse. The square is created from this point
		 * @param point2 The end point (x2,y2) for the second click of the mouse. The square is built from point1 to point2.
		 * @param thickness The value of the thickness of square when theres no fill.
		 * @param color The color of the outline of the square, when theres no fill.
		 * @param filler The color of the square when painted, when theres fill.
		 * @param fill Value for the shape to see if theres fill or no fill.
		 */
		public Square(Point point1, Point point2, double thickness, Color color, Color filler, Boolean fill) {
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

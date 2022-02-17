package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.canvas.GraphicsContext;
/**
 * Class that creates the model for the Paint application.
 * Controls the execution to draw shapes.
 * @author sidharth
 *
 */
public class PaintModel extends Observable {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<ArrayList<Point>> squiggle = new ArrayList<ArrayList<Point>>();	
	
	private ArrayList<ArrayList<Point>> polyline = new ArrayList<ArrayList<Point>>();	
	private ArrayList<Point> polypoints = new ArrayList<Point>();	//uncommented this
	
	private ArrayList<Point> points = new ArrayList<Point>();	//uncommented this

	private DrawCommand command;
	private ArrayList<DrawCommand> commandsToExe = new ArrayList<>();	
	
	/**
	 * Adds shapes to the shape arraylist
	 * @param shape 	Shape object
	 */
	public void addShape(Shape shape) {
		this.shapes.add(shape);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Adds arraylist of points to the 2d Arraylist
	 * @param points Arraylist of class Point
	 */

	public void addPolyline(ArrayList<Point> points) {
		if(points!=null) {
		this.polyline.add(points);
		this.setChanged();
		this.notifyObservers();
		}
	}
	
	public void addSquiggle(ArrayList<Point> points) {
		if(points!=null) {
		this.squiggle.add(points);
		this.setChanged();
		this.notifyObservers();
		}
	}
	
	/**
	 * Removes the temporary shape that's being created to implement shape feedback
	 * @param shape Shape object under consideration
	 */
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Adds the command to the arraylist of commands
	 * @param command  Command under consideration
	 */
	public void setCommand(DrawCommand command){
	    //this.command = command;
	    this.commandsToExe.add(command);
	}
	
	/**
	 * Executes command to draw circles
	 * @param g GraphicsContext
	 */
	public void drawCircles(GraphicsContext g) {
		command.execute(g);
	}
	
	/**
	 * Executes command to draw rectangles
	 * @param g GraphicsContext
	 */
	public void drawRectangles(GraphicsContext g) {
		command.execute(g);
	}
	
	/**
	 * Executes command to draw squares
	 * @param g GraphicsContext
	 */
	public void drawSquares(GraphicsContext g) {
		command.execute(g);
	}
	
	/**
	 * Executes command to draw squiggle line
	 * @param g
	 */
	public void drawSquiggle(GraphicsContext g) {
		System.out.println("whatever");
		command.execute(g);
	}
	
	/**
	 * 
	 * @return	returns the shape from the arraylist of shapes
	 */
	public ArrayList<Shape> getShapes(){
		return this.shapes;
	}
	/**
	 *  Adds the last command and clears the command array
	 * @param g GraphicsContext
	 */
	public void execute (GraphicsContext g) {
		for(DrawCommand c: commandsToExe) {
			c.execute(g);
		
		}
		DrawCommand last = commandsToExe.get(commandsToExe.size()-1);
		commandsToExe.clear();
		commandsToExe.add(last);
	}

	/**
	 * Adds a point to the Point ArrayList
	 * @param p 	Object of class point
	 */
	public void addPoint(Point p) {
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * 
	 * @return		Returns the Arraylist of points
	 */
	public void addPolyPoint(Point p) {
		this.polypoints.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	/**
	 * 	Clears the Array to create a new one
	 */
	public ArrayList<Point> getPolyPoints(){
		return polypoints;
	}
	
	public void clearPoints() {
		this.points= new ArrayList<Point>();
	}
	
	/**
	 * 
	 * @return  Returns the 2D ArrayList of points
	 */
	public ArrayList<ArrayList<Point>> getSquiggle(){
		return squiggle;
		
	}
	
	public ArrayList<ArrayList<Point>> getPolyline(){
		return polyline;
		
	}
	
	
}


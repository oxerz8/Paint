package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * Creates the class that initiates the actual implementation of the paint application
 * 
 * @author sidharth
 *
 */
class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Rectangle rectangle;
	private Square square;
	private Color stroke;
	private Polyline polyline;
	private ResizableCanvas canvas;
	private Squiggle squiggler;
	

	/**
	 * Constructor for paint panel to create the default setting for the application
	 * @param model Object of PaintModel
	 * @param view	Object of class View
	 */
	public PaintPanel(PaintModel model, View view) {

		
		
		this.canvas = new ResizableCanvas(600, 600);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = "Circle"; // bad code here?
		this.stroke = Color.BLACK;
		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	/**
	 *  Executes commands for the chosen shape.
	 */
	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		

		ArrayList<ArrayList<Point>> polyline= this.model.getPolyline();
		/*if(this.mode == "Polyline") {
			DrawCommand drawPolyline = new DrawableSquiggle(polyline);
			this.model.setCommand(drawPolyline);
			this.model.execute(g)*/;
		
		ArrayList<ArrayList<Point>> squiggle= this.model.getSquiggle();
		ArrayList<Shape> shapes = this.model.getShapes();
		for (Shape s : shapes) {
			
			switch(s.getClass().getSimpleName()) {

				case "Rectangle":
					DrawCommand drawRectangle = new DrawableRectangle((Rectangle)s);
					this.model.setCommand(drawRectangle);
					break;
				case "Circle":
					DrawCommand drawCircle = new DrawableCircle((Circle)s);
					this.model.setCommand(drawCircle);
					break;

				case "Square":
					DrawCommand drawSquare = new DrawableSquare((Square)s);
					this.model.setCommand(drawSquare);
					break;
				case "Squiggle":
					DrawCommand drawSquiggle = new DrawableSquiggle(squiggle);
					this.model.setCommand(drawSquiggle);

		
			
				case "Polyline":
					DrawCommand drawPolyline = new DrawablePolyline(polyline);
					this.model.setCommand(drawPolyline);
					break;
			}
		
		
			
			
			}
			
			this.model.execute(g);
			}
	
			

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	
	/**
	 * Sets the shape mode
	 * @param mode  Shape mode from shapechooserpanel
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Sets color for the shape
	 * @param stroke Color object
	 */
	public void setStroke(Color stroke) {
		this.stroke = stroke;
	}
	
	/**
	 * 
	 * @return the canvas in consideration 
	 */
	public ResizableCanvas getCanvas() {
		return this.canvas;
	}
	
	/**
	 * 
	 * @return the color selected from colorchooserpanel
	 */
	public Color getStroke() {
		return this.stroke;
	}
	
	/**
	 *  Sends the shape mode to shapefactory to initate creation of the shape
	 * @param e		mouseevent
	 */
	public void sendMode(MouseEvent e) {
		ShapeFactory shapefactory = new ShapeFactory();
		shapefactory.getShapeStrategy(e, this.mode, this.model, this.view);
	}
	
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Squiggle getSquiggle() {
		return this.squiggler;
	}
	
	public void setSquiggle(Squiggle squiggler) {
		this.squiggler = squiggler;
	}
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public Square getSquare() {
		return this.square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Polyline getPolyline() {
		return this.polyline;
	}
	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}
	
	@Override
	public void handle(MouseEvent event) {
		//System.out.println("Mouse Event");
		this.sendMode(event);	}

	private void mouseMoved(MouseEvent e) {
	}

	private void mouseDragged(MouseEvent e) {
		
	}

	private void mouseClicked(MouseEvent e) {
	}

	private void mousePressed(MouseEvent e) {
	}

	private void mouseReleased(MouseEvent e) {


	}

	private void mouseEntered(MouseEvent e) {
	}

	private void mouseExited(MouseEvent e) {
	}
}

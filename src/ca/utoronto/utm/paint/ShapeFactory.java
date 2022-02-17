package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
/**
 * The factory which ,depending on the game mode that is selected, creates the appropriate strategy.
 * @author Daniil
 *
 */
public class ShapeFactory {
	public void getShapeStrategy(MouseEvent e, String ButtonID, PaintModel model, View view) {
		//System.out.println(ButtonID);
		
		if (ButtonID.equals("Circle")) {
			//set strategy
			//System.out.println("In the factory");
			CircleStrategy circleStrat = new CircleStrategy();
			circleStrat.mouseEvent(e, model, view);
			
		}
		if (ButtonID.equals("Rectangle")) {
			RectangleStrategy rectStrat = new RectangleStrategy();
			//System.out.println("In the factory");
			rectStrat.mouseEvent(e, model, view);
		}
		if (ButtonID.equals("Square")) {
			SquareStrategy squareStrat = new SquareStrategy();
			squareStrat.mouseEvent(e, model, view);
		}
		if (ButtonID.equals("Squiggle")) {
			//set strategy
			SquiggleStrategy squiggleStrat = new SquiggleStrategy();
			squiggleStrat.mouseEvent(e, model, view);
		}
		if (ButtonID.equals("Polyline")) {
			//set strategy
			PolylineStrategy polylineStrategy = new PolylineStrategy();
			polylineStrategy.mouseEvent(e,model,view);
		}
		//return new CircleStrategy();
	}
	
}

package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
/**
 * The shape manipulator strategy which every other shape strategy implements based on Strategy design pattern.
 * @author Daniil
 *
 */
public interface ShapeManipulatorStrategy {
	public void mouseEvent(MouseEvent e, PaintModel model, View view);
}

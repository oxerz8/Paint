package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
/**
 * The Command interface that all draw shape commands implement based on the Command Design pattern.
 * @author Daniil
 *
 */
public interface DrawCommand {
	public void execute(GraphicsContext g);
}

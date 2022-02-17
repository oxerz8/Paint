package ca.utoronto.utm.paint;

/**
 * Creates a point with x and y coordinates
 * @author sidharth
 *
 */
public class Point extends Shape {
	int x, y;

	/*
	 * Constructor for point class. Creates the point with x and y coordinates
	 */
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



}

package fx_examples_maven.fx_examples_maven.ex_07_grid_demo;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return String.format("(%2d,%2d)", x, y);
	}
}

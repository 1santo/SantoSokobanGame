package e.utils;

/**
 * @author teacher
 * 
 *         Vector2D.
 *
 */

public class Vector2D {
	private int x;
	private int y;
	
	/**
	 * @param x horizontal coordinate
	 * @param y vertical coordinate
	 */
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return horizontal coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return vertical coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param vector 2D.
	 * @return sum of the current vector with the vector given as parameter
	 * soma do vector atual com o vector dado como parametro.
	 */
	public Vector2D plus(Vector2D v) {
		return new Vector2D(getX() + v.getX(), getY() + v.getY());
	}

	/**
	 * @param vector 2D.
	 * @return subtraction of the current vector with the given vector as a parameter
	 * subtracao do vector atual com o vector dado como parametro.
	 */
	public Vector2D minus(Vector2D v) {
		return new Vector2D(getX() - v.getX(), getY() - v.getY());
	}

	/**
	 * @return shows vector coordinates.
	 */
	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}

}

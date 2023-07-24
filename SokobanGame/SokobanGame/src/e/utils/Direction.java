package e.utils;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 * @author teacher, 1santo
 * 
 *         Cardinal directions.
 *
 */
public enum Direction {
	LEFT(new Vector2D(-1, 0)), UP(new Vector2D(0, -1)), RIGHT(new Vector2D(1, 0)), DOWN(new Vector2D(0, 1));

	private Vector2D vector;

	/**
	 * @param cardinal direction vector
	 */
	Direction(Vector2D vector) {
		this.vector = vector;
	}

	/**
	 * @return cardinal direction
	 */
	public Vector2D asVector() {
		return vector;
	}

	/**
	 * @param keystroke code, codigo da tecla primida.
	 * @throws IllegalArgumentException 
	 * @exception If the key pressed is none of those mentioned on the switch.
	 */
	public static Direction directionFor(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_DOWN:
			return DOWN;
		case KeyEvent.VK_UP:
			return UP;
		case KeyEvent.VK_LEFT:
			return LEFT;
		case KeyEvent.VK_RIGHT:
			return RIGHT;
		case KeyEvent.VK_ENTER:
			break;	
		default:
			JOptionPane.showMessageDialog(null, 
			"Jogue apenas com as setas do seu teclado.",
			"ATENCAO", 
			JOptionPane.INFORMATION_MESSAGE);
		}
		throw new IllegalArgumentException();
	}

	/**
	 * @param last key pressed code, codigo da ultima tecla primida.
	 * @return tests whether the given parameter is a direction.
	 *
	 */
	public static boolean isDirection(int lastKeyPressed) {
		return lastKeyPressed >= KeyEvent.VK_LEFT && lastKeyPressed <= KeyEvent.VK_DOWN;
	}

	public Direction inverse() {
		switch (this) {
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		case RIGHT:
			return LEFT;
		case LEFT:
			return RIGHT;
		}
		return null;
	}
}

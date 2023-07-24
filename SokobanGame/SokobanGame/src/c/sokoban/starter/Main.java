package c.sokoban.starter;

import d.poo.gui.ImageMatrixGUI;

/**
 * @author 1santo
 * 
 *         Class that creates the Sokoban Game (Singleton).
 *
 */

public class Main {

	public static void main(String[] args) {
		SokobanGame s = SokobanGame.getinstance();
		ImageMatrixGUI.getInstance().addObserver(s);
		ImageMatrixGUI.getInstance().go();	
	}

}

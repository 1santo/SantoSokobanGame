package a.objects;

import c.sokoban.starter.Map;
import c.sokoban.starter.SokobanGame;
import d.poo.gui.ImageMatrixGUI;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Object of Sokoban Game - grants extra energy and in certain situations can save the player from losing the game.
 *
 */

public class Battery extends AbstractObject{

	public Battery(Position position){
		super(position,"Battery");
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	void interactWith(AbstractObject anotherObj) {
		Map mapa=SokobanGame.getinstance().getMapa();
		
	 	if(anotherObj instanceof Player){
	 		mapa.getPlayer().setEnergia(100);
			mapa.getLevelList().remove(this);
			ImageMatrixGUI.getInstance().removeImage(this);
			 
	 	}		
	}
	
}
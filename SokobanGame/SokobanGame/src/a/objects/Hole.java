package a.objects;

import c.sokoban.starter.Map;
import c.sokoban.starter.SokobanGame;
import d.poo.gui.ImageMatrixGUI;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Object of Sokoban Game - The player loses the game when he is in the same position as an object of this type.
 *
 */

public class Hole extends AbstractObject{
	
	public Hole(Position position){
		super(position,"Hole");
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	void interactWith(AbstractObject anotherObj){
		 Map mapa=SokobanGame.getinstance().getMapa();
			
		 	if(anotherObj instanceof StoneSmall){
				mapa.getLevelList().remove(anotherObj);
				ImageMatrixGUI.getInstance().removeImage(anotherObj);		 
		 	}
			 
			if(anotherObj instanceof StoneBig){
				((StoneBig) anotherObj).setPushable(false);				 
			}
		 
			if(anotherObj instanceof Box){
				mapa.getLevelList().remove(anotherObj);
				ImageMatrixGUI.getInstance().removeImage(anotherObj); 
			}
			
			if(anotherObj instanceof Player){
				mapa.getLevelList().remove(anotherObj);
				ImageMatrixGUI.getInstance().removeImage(anotherObj);
				SokobanGame.getinstance().gameOver();
			}	
	}
	 
}

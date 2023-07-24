package a.objects;

import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Object of Sokoban Game.
 *
 */

public class Floor extends AbstractObject {

	public Floor(Position position){
		super(position,"Floor");
	}
	
	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub		
	}

}

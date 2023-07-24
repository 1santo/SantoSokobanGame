package a.objects;

import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Object of Sokoban Game
 *
 */

public class Target extends AbstractObject{

	public Target(Position position){
		super(position,"Target");
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
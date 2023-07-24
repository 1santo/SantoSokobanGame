package a.objects;

import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Object of Sokoban Game.
 *
 */

public class Wall extends AbstractObject{

	public Wall(Position position){
		super(position,"Wall");
	}

	@Override
	public int getLevel(){
		return 3; 
	}
	
	@Override
	public boolean transposable(){
		return false;
	}

	@Override
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub
		
	}
	
}

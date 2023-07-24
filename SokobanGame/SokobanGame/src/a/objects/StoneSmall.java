package a.objects;

import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Pushable object of Sokoban Game - when it falls into a hole, it disappears from the map.
 *
 */

public class StoneSmall extends AbstractActiveObject{
	
	public StoneSmall(Position initialPosition){
		super(initialPosition,"StoneSmall");
	}

	@Override
	public int getLevel() {
		return 2;
	}
	
	@Override
	 public boolean pushable(){
			return true;
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

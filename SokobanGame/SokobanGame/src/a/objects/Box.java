package a.objects;

import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Pushable object of Sokoban Game - It is intended that all objects in this category are arranged on the target
*													so that the player can pass the level.
 *
 */

public class Box extends AbstractActiveObject{//


	public Box(Position initialPosition){
		super(initialPosition,"Box");
	
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
	 public boolean storableInTarget(){
		return true;
	 }
	
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub
		
	}
	


}
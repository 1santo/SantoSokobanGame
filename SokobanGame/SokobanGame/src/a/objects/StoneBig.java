package a.objects;

import e.utils.Direction;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Pushable Object of Sokoban Game - when it falls into a hole, it stops being pushable.
 *
 */

public class StoneBig extends AbstractActiveObject{
	private boolean pushable=true;
	public StoneBig(Position initialPosition){
		super(initialPosition,"StoneBig");
	}

	@Override
	public int getLevel() {
		return 2;
	}
	
	@Override
	 public boolean pushable(){
		 return pushable;	
	 }

	 void setPushable(boolean pushable){
		this.pushable=pushable;
	}
	
	@Override
	public boolean transposable(){
		return false;
	}
	
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	void move(Direction d){
		if(pushable)super.move(d);	
	}

}

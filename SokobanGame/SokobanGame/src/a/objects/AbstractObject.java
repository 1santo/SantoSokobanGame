package a.objects;

import d.poo.gui.ImageTile;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         All objects of the Sokoban Game with a set of properties that may or may not differ from each other.
 *
 */

public abstract class AbstractObject implements ImageTile,Properties{
	Position position;
	String imageName; 
	
	public AbstractObject(Position position,String imageName){
		this.position=position;
		this.imageName=imageName;
	}

	@Override
	public String getName(){
		return imageName;
	}
	
	@Override
	public Position getPosition() {
		return position;
	}
	
	public abstract int getLevel();
	
	public boolean transposable(){
			return true;
	 }
	
	 public boolean pushable(){
			return false;
	 }
	 
	public boolean storableInTarget(){
			return false;
	}
 
	abstract void interactWith(AbstractObject anotherObj);
}


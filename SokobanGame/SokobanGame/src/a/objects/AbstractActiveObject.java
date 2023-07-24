package a.objects;

import c.sokoban.starter.Map;
import c.sokoban.starter.SokobanGame;
import e.utils.Direction;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Movable Sokoban Game objects.
 *
 */

public abstract class AbstractActiveObject extends AbstractObject{
	
	public AbstractActiveObject(Position position,String imageName){
		super(position,imageName);
	}

	boolean canMove(Position newPosition){
		 Map mapa=SokobanGame.getinstance().getMapa();

		if (newPosition.getX()>=0 && newPosition.getX()<10 && newPosition.getY()>=0 && newPosition.getY()<10
			&&mapa.verificarTransponibilidade(newPosition)&&mapa.getPlayer().getEnergia()>0) 
			return true;
		else return false;
	 }
	 
	 
	void move(Direction d){

		Map mapa=SokobanGame.getinstance().getMapa();
			
		Position newPosition = position.plus(d.asVector());

			if(canMove(newPosition)) position = newPosition;
			else return;
				
				for(AbstractObject obj: mapa.listOfObjectsInThis(newPosition)){
					if(obj instanceof AbstractObject) 
						((AbstractObject)obj).interactWith(this);
				}
	}
	
}

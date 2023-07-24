package a.objects;

import c.sokoban.starter.Map;
import c.sokoban.starter.SokobanGame;
import d.poo.gui.ImageMatrixGUI;
import e.utils.Direction;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Forklift of Sokoban Game - represents the player and can push the movable objects of the level.
 *			Empilhadora
 */

public class Player extends AbstractActiveObject{

	private int plays_number;
	private int energy=100; 
	
	public Player(Position initialPosition){ 
		super(initialPosition,"Forklift_U");
	}

	@Override
	public int getLevel() {
		return 3;
	}

	@Override
	public void move(Direction d) {
		
		Map mapa=SokobanGame.getinstance().getMapa();
		
		Position newPosition = position.plus(d.asVector());
		
		for(AbstractObject obj: mapa.listOfObjectsInThis(newPosition) ){ 
			if(obj instanceof AbstractActiveObject&&!(obj instanceof Player)){//n4o posso fzr inst4nceof this
				((AbstractActiveObject)obj).move(d);
			}
		}
		
			if((energy<=0)) SokobanGame.getinstance().gameOver();
				else{//sem isto se cair no buraco e tiver 1 jogada a faltar faz 2 vezes gameover
					//so o ponho a andar aqui por isso so aqui e q dps podem interagir com ele
					if (this.canMove(newPosition)){
						position = newPosition;				
						mudarImagensDoPlayer(d);
						ImageMatrixGUI.getInstance().update();
						plays_number++;
						energy--;

						for(AbstractObject obj: mapa.listOfObjectsInThis(newPosition)){
							if(obj instanceof AbstractObject) 
								((AbstractObject)obj).interactWith(this);
						}
					
					} else return;	
				}			
	}

	private void mudarImagensDoPlayer(Direction d) {
		if(d==Direction.RIGHT)
			imageName="Forklift_R";
		
		if(d==Direction.LEFT)
			imageName="Forklift_L";
		
		if(d==Direction.UP)
			imageName="Forklift_U";
		
		if(d==Direction.DOWN)
			imageName="Forklift_D";
	}
	
	void interactWith(AbstractObject anotherObj) {
		// TODO Auto-generated method stub		
	}

	public int getPlaysNumber(){
		return plays_number;
	}

	public int getEnergia(){
		return energy;
	}

	public void setEnergia(int energia) {
		this.energy = energia;
	}
}

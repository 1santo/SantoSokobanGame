package c.sokoban.starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import a.objects.AbstractObject;
import a.objects.Target;
import a.objects.Battery;
import a.objects.Hole;
import a.objects.Box;
import a.objects.Floor;
import a.objects.Wall;
import a.objects.StoneBig;
import a.objects.StoneSmall;
import a.objects.Player;
import e.utils.Position;

/**
 * @author 1santo
 * 
 *         Map of each level of the Sokoban Game.
 *
 */

public class Map {

	private String fileName;
	private Player player;
	private ArrayList<AbstractObject>levelList=new ArrayList<AbstractObject>();
	
	public Map(String fileName){
		this.fileName=fileName;
	}

	ArrayList<AbstractObject> buildLevel(){

		try{
			Scanner scanner=new Scanner(new File(fileName));
			int nlinha = 0;
			
			for (int j=0; j!=10; j++)
				for (int i=0; i!=10 ; i++)
					levelList.add(new Floor(new Position(i,j)));
			
			while(scanner.hasNext()){
				String linha=scanner.nextLine();
				
				for(int i=0;i!=linha.length();i++){
					char carater=linha.charAt(i);

					switch(carater){
						
						case '#':
							levelList.add(new Wall(new Position(i,nlinha))); 
						break;
						
						case 'C':
							levelList.add(new Box(new Position(i,nlinha)));
						break;
						
						case 'E':
							this.player = new Player(new Position(i,nlinha));
							levelList.add(this.player);	
						break;
						
						case 'X':
							levelList.add(new Target(new Position(i,nlinha)));
							break;
							
						case 'b':
							levelList.add(new Battery(new Position(i,nlinha)));
							break;
						
						case ' ':
							break;
							
						case 'O':
							levelList.add(new Hole(new Position(i,nlinha)));
							break;

						case 'p':
							levelList.add(new StoneSmall(new Position(i,nlinha)));
							break;
							
						case 'P':
							levelList.add(new StoneBig(new Position(i,nlinha)));
							break;
							
						default: //if an object does not exist, the app still runs
							JOptionPane.showMessageDialog(null, "BETA VERSION - May be faulty.\n"
							+ "Still, we hope you enjoy.","ATTENTION", JOptionPane.ERROR_MESSAGE);
					}
					
				}
					nlinha++;
			}scanner.close();
			
		}catch(FileNotFoundException e){ //only if the player passes all levels!
			Object[] opcoes = { "Play again", "I'm happy" };
			int msgTryAgain = JOptionPane.showOptionDialog(null, "CONGRATS, "+
					SokobanGame.getinstance().getNome()+"!! You completed all levels.","YOU WON",
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, 
					null, opcoes, opcoes[1]);
				if (msgTryAgain == JOptionPane.YES_NO_OPTION) {
					SokobanGame.getinstance().setNivel(SokobanGame.getinstance().getNivelInicial());
					SokobanGame.getinstance().iniciarNovoJogo();
				} 
				else System.exit(0);
		}
		
		return levelList;
	}

	public ArrayList<AbstractObject> listOfObjectsInThis(Position p){
		ArrayList<AbstractObject>objetosNestaPosicao=new ArrayList<AbstractObject>();
		
		for(AbstractObject obj: levelList){ 
			if(p.equals(obj.getPosition()))
				objetosNestaPosicao.add(obj);
		}
		return objetosNestaPosicao;
	}
	
	public boolean verificarTransponibilidade(Position p){
		for(AbstractObject obj: this.listOfObjectsInThis(p)){
			if(!obj.transposable()){
				return false;
			}
		}
	return true;
	}
	
	public Player getPlayer(){
		if(player == null) throw new IllegalStateException();
		return player;
	}
	
	public ArrayList<AbstractObject> getLevelList() {
		return levelList;
	}
}

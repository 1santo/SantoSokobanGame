package c.sokoban.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import a.objects.AbstractObject;
import a.objects.Target;
import b.scores.ScoresTable;
import d.poo.gui.ImageMatrixGUI;
import e.utils.Direction;

/**
 * @author 1santo
 * 
 *         Sokoban Game - Singleton Class.
 *
 */

public class SokobanGame implements Observer {

	private int level;
	private final int initialLevel=level;
	private Map mapa;
	private ScoresTable currentScores;
	private String name;
	private String randomExcuse="FAULTY GAME\nThe developer apologizes for the inconvenience caused.";

	private static final SokobanGame INSTANCE = new SokobanGame();

	private SokobanGame() {
		iniciarNovoJogo();
	}

	public static SokobanGame getinstance() {
		return INSTANCE;
	}

	void iniciarNovoJogo() {
		name = JOptionPane.showInputDialog(null, 
				"Enter your name and press OK to play.", 
				"SOKOBAN GAME V1.1",
				JOptionPane.PLAIN_MESSAGE);
		String teclaOK=name;
		if (teclaOK != null) {
			if (name.length() == 0) name = "Anonymous";
			if(name.contains("-")||name.length() > 15){ 
				JOptionPane.showMessageDialog(null, 
				"Name cannot contain dashes ( - ) nor more than 15 letters.", //" - " influences scores string
				"ATTENTION", 
				JOptionPane.INFORMATION_MESSAGE);
				iniciarNovoJogo();
			}
			else{
				try {
					buildMapAccordingToLevel(initialLevel);
				}catch (NullPointerException e) { //if it does not have the name to terminate the game, 
													//it does not start since the level does not exist
					JOptionPane.showMessageDialog(null, randomExcuse,"ERROR_Nonexistent.Level", 
					JOptionPane.ERROR_MESSAGE);
					
					System.exit(0);
				}
			}
		} 
		else System.exit(0);
	}
	
	private void buildMapAccordingToLevel(int level) {
		mapa = new Map("levels/level" + level + ".txt");//if the map does not exist, its name does not exist to build - (line 62)
		List<AbstractObject> levelList = mapa.buildLevel();
		for (AbstractObject obj : levelList) {
			ImageMatrixGUI.getInstance().addImage(obj);
				try {
					mapa.getPlayer();
				}catch (IllegalStateException e) { //handled here because it depends of the level (line 139 class Map)
					JOptionPane.showMessageDialog(null, randomExcuse,"ERROR_Nonexistent.Level.Player", 
					JOptionPane.ERROR_MESSAGE);
								
					System.exit(0);
				}
			ImageMatrixGUI.getInstance().setStatusMessage(" Player: " + name + " Level: " 
					+ level + " Moves: "+ mapa.getPlayer().getPlaysNumber() + " Energy " + 
					mapa.getPlayer().getEnergia());
		}
	}

	private void levelUpIfAllTargetsAreFilled() {
		List<AbstractObject> listaDeArrumaveisNoAlvo = new ArrayList<AbstractObject>();
		List<AbstractObject> listaDealvosPorPreencher = new ArrayList<AbstractObject>();

			for (AbstractObject obj : mapa.getLevelList()) {
				if (obj.storableInTarget())
					listaDeArrumaveisNoAlvo.add(obj);
				if (obj instanceof Target)
					listaDealvosPorPreencher.add(obj);
			}
			
			int alvosPreenchidos = 0;
			for (AbstractObject arrumavel : listaDeArrumaveisNoAlvo) {
				for (AbstractObject alvo : listaDealvosPorPreencher) {
					if (arrumavel.getPosition().equals(alvo.getPosition())) {
						alvosPreenchidos++;
					}
				}
			}

		if (alvosPreenchidos == listaDealvosPorPreencher.size()) {	
			showScoresAndNextlLevel();
		}
	}

	private void showScoresAndNextlLevel() {
		currentScores = new ScoresTable();
		currentScores.addScore(name, mapa.getPlayer().getPlaysNumber(),"scores/pontuacaoLevel" + level + ".txt");
		JOptionPane.showMessageDialog(null,currentScores.getScores(),
		"TOP 5 of this level"+level,
		JOptionPane.INFORMATION_MESSAGE);

		level++;		
		restart(level);
	}
	
	private void restart(int nivel) {
		ImageMatrixGUI.getInstance().clearImages();
		buildMapAccordingToLevel(nivel);
		ImageMatrixGUI.getInstance().update();
	}

	public void gameOver() {
		Object[] opcoes = { "Try again", "Exit" };
		int msgGameOver = JOptionPane.showOptionDialog(null, "Ohh no... :(\n You lost, " + name + ".", "GAMEOVER",
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[0]);
			
			if (msgGameOver == JOptionPane.YES_NO_OPTION) {
				this.setNivel(initialLevel);
				restart(level);
			} 
			else System.exit(0);
	}

	void setNivel(int nivel) {
		this.level = nivel;
	}
	
	String getNome() {
		return name;
	}

	public Map getMapa() {
		return mapa;
	}

	@Override
	public void update(Observable arg0, Object obj1) {
		int lastKeyPressed = (Integer) obj1;

		try {
			if (lastKeyPressed == 10) restart(level);//Enter recomeca o level.
			mapa.getPlayer().move(Direction.directionFor(lastKeyPressed));

		} catch (IllegalArgumentException e) {	
		}

		levelUpIfAllTargetsAreFilled();
		
		ImageMatrixGUI.getInstance().setStatusMessage(" Jogador: " + name + " Level: " 
				+ level + " Moves: "+ mapa.getPlayer().getPlaysNumber() + " Energy " + 
				mapa.getPlayer().getEnergia());
	}

	final int getNivelInicial() {
		return initialLevel;
	}

}
package b.scores;

/**
 * @author 1santo
 * 
 *         Player Score - includes the player's name and number of points (score).
 *
 */

public class Score{
	private String name;
	private int points;
	
	public Score(String name, int points) {
		this.name=name;
		this.points=points;
		
	}
	
	String getNome() {
		return name;
	}

	int getPontos() {
		return points;
	}
}

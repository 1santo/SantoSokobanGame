package b.scores;

import java.util.Comparator;

/**
 * @author 1santo
 * 
 *         Scores comparator - gives priority to the least number of plays (points).
 *
 */

public class ScoreComparator implements Comparator<Score>{
	
	@Override
	public int compare(Score score1, Score score2) {
		return score1.getPontos()- score2.getPontos();
	}
	
}

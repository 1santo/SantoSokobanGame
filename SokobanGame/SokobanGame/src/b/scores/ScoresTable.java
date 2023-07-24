package b.scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 1santo
 * 
 *          Table with the top 5 finishers from each complete level of the Sokoban Game.
 *
 */

public class ScoresTable{
	private ArrayList<Score> listascores;
	private final int limit=5;
	private int order;
	private String scores="";

	public ScoresTable(){
		listascores = new ArrayList<Score>();
    }

	private void order() { //ordenar
        Collections.sort(listascores, new ScoreComparator());
	}
	
	private void deleteLastPlayerOfTheList() {
		listascores.remove(listascores.size()-1);
	}
	
	public void addScore(String name, int points, String fileName){
		tryReadScoresFile(fileName);
		if(listascores.size()>=limit) deleteLastPlayerOfTheList();
		listascores.add(new Score(name, points));
		if(listascores.size()>1) order();
		
		writeScoreFile(fileName);
	}

	private void tryReadScoresFile(String fileName){
		try{
			Scanner scanner=new Scanner(new File(fileName));
				
				while(scanner.hasNextLine()){
					String line =scanner.nextLine();
					String [] linhaComJogadorPontos=line.split(" - ");
					if(linhaComJogadorPontos.length==3){ //caso a linha esteja em branco(==0)nao da erro
						String nome=linhaComJogadorPontos[1];
						int pontos=Integer.parseInt(linhaComJogadorPontos[2]);
						listascores.add(new Score(nome,pontos));
					}
				}
				scanner.close();
		}catch(FileNotFoundException e){
		}catch(NumberFormatException e){ //caso um ficheiro tenha escrito outras coisas
		}
	}
		
	private void writeScoreFile(String nomeFicheiro) {
		try{
			PrintWriter pwriter=new PrintWriter(new File(nomeFicheiro));
			
				for(Score score: listascores){
					order++;
					scores+=order+" lugar - "+score.getNome()+" - "+score.getPontos()+System.lineSeparator();
				}
			pwriter.write(scores);
			pwriter.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}		
	}
	
	public String getScores() {
		return scores;
	}
	
}

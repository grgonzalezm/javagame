package jsf;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="historial")
@ApplicationScoped
public class Historial implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfGames = 0;
	private int numberOfWinsPlayer1 = 0;
	private int numberOfWinsPlayer2 = 0;
	private int numberOfDraws = 0;
	
	
	public void addGame(String winner) {
		numberOfGames++;
		if(winner.replaceAll("\\s", "").toUpperCase().equals("PLAYER1")) {
			numberOfWinsPlayer1++;
		}else if(winner.replaceAll("\\s", "").toUpperCase().equals("PLAYER2")) {
			numberOfWinsPlayer2++;
		}else {
			numberOfDraws++;
		}
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}

	public int getNumberOfWinsPlayer1() {
		return numberOfWinsPlayer1;
	}

	public void setNumberOfWinsPlayer1(int numberOfWinsPlayer1) {
		this.numberOfWinsPlayer1 = numberOfWinsPlayer1;
	}

	public int getNumberOfWinsPlayer2() {
		return numberOfWinsPlayer2;
	}

	public void setNumberOfWinsPlayer2(int numberOfWinsPlayer2) {
		this.numberOfWinsPlayer2 = numberOfWinsPlayer2;
	}

	public int getNumberOfDraws() {
		return numberOfDraws;
	}

	public void setNumberOfDraws(int numberOfDraws) {
		this.numberOfDraws = numberOfDraws;
	}
	
}

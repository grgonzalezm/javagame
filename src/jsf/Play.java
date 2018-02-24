package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.inject.Inject;

import object.Game;
import object.Player;
import object.Player.Election;

@ManagedBean
@SessionScoped
public class Play implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Game game;
	@Inject
	private Player player1;
	@Inject
	private Player player2;
	
	private boolean gameStarted = false;
	
	private List<Game> games = new ArrayList<Game>(); 

	private Historial historial = (Historial)getBean("historial");
	
	public void newGame() {
		game = new Game();
		player1 = new Player();
		player1.setElection(Election.randomElection());
		player2 = new Player();
		player2.setElection(Election.ROCK);
		game.setPlayer1(player1.getElection());
		game.setPlayer2(player2.getElection());
		game.setWinner(getWinner(player1.getElection(),player2.getElection()));
		gameStarted = true;
		games.add(game);
		historial.addGame(game.getWinner());
	}
	
	public void restart() {
		gameStarted = false;
		if(!games.isEmpty())
			games.clear();
	}
	
	public List<Game> getGames(){
		return this.games;
	}
	
	public String getImageByPlayer(int playerId) {
		if(gameStarted) {
			if(playerId == 0) {
				return "images/" + player1.getElection().toLowerCase() + ".png";
			}else {
				return "images/" + player2.getElection().toLowerCase() + ".png";
			}
		}else {
			return "images/transparent.png";
		}
	}
	
	private String getWinner(String player1, String player2) {
		if(player1.equals(player2))
			return "X";
		if(player1.toUpperCase().equals("SCISSORS"))
			return "Player 2";
		return "Player 1";
	}
	
	public String numberOfGames() {
		return Integer.toString(this.games.size());
	}
	
	private static Object getBean(String beanName){
	    Object bean = null;
	    FacesContext fc = FacesContext.getCurrentInstance();
	    if(fc!=null){
	         ELContext elContext = fc.getELContext();
	         bean = elContext.getELResolver().getValue(elContext, null, beanName);
	    }
	    return bean;
	}
}

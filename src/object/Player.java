package object;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Player{
	
	public Election election;

	public String getElection() {
		return election.getDescription();
	}
	
	public void setElection(Election election) {
		this.election = election;
	}
	
	public Election getRandomElection() {
		return Election.randomElection();
	}
	
	public enum Election{
		ROCK("Rock"),PAPER("Paper"),SCISSORS("Scissors");
		
		private String description;
		private static final List<Election> VALUES =
				 Collections.unmodifiableList(Arrays.asList(values()));
		private static final int SIZE = VALUES.size();
		private static final Random RANDOM = new Random();
		
		Election(String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public static Election randomElection()  {
		    return VALUES.get(RANDOM.nextInt(SIZE));
		}
	}
}

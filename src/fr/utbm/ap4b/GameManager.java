package fr.utbm.ap4b;

import java.util.ArrayList;

import fr.utbm.ap4b.model.Player;

public class GameManager {
	private ArrayList<Player> Players = new ArrayList<Player>();
	private int Round;
	private Player CurrentPlayer;
	private int PlayerCount;
	private int CurrentPlayerID;
	
	public GameManager() {
		Round = 1;
		Player p1 = new Player("Joueur1", "yellowgreen");
		Player p2 = new Player("Joueur2", "#6720C7");
		
		CurrentPlayer = p1;
		CurrentPlayerID = 0;
		Players.add(p1);
		Players.add(p2);
		
		PlayerCount = Players.size();
	}
	
	public Player getCurrentPlayer() {
		return CurrentPlayer;
	}
	
	public Player nextPlayer() {
		CurrentPlayerID ++;
		if (CurrentPlayerID >= PlayerCount) {
			CurrentPlayerID = 0;
			Round++;
		}
		CurrentPlayer = Players.get(CurrentPlayerID);
		return CurrentPlayer;
	}
	
	public int getRound() {
		return Round;
	}
}

package fr.utbm.ap4b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import fr.utbm.ap4b.model.Player;

public class GameManager {
	private ArrayList<Player> Players = new ArrayList<Player>();
	private int Round;
	private Player CurrentPlayer;
	private int PlayerCount;
	private int CurrentPlayerID;
	private ArrayList<CreditCard> deckcredit = new ArrayList<CreditCard>();
	private ArrayList<DestinationGoalCard> deckdestination= new ArrayList<DestinationGoalCard>();
	
	public void Createdeck() {
		int i;
		for(i=0;i<14;i++)
		{
			CreditCard CS = new CreditCard("CS");
			deckcredit.add(CS);
			CreditCard TM = new CreditCard("TM");
			deckcredit.add(TM);
			CreditCard OM = new CreditCard("OM");
			deckcredit.add(OM);
			CreditCard EC = new CreditCard("EC");
			deckcredit.add(EC);
			CreditCard QC = new CreditCard("QC");
			deckcredit.add(QC);
			CreditCard ST = new CreditCard("ST");
			deckcredit.add(ST);
			CreditCard NS = new CreditCard("NS");
			deckcredit.add(NS);
		}
		for(i=0;i<14;i++) {
			CreditCard Bonus = new CreditCard("Bonus");
			deckcredit.add(Bonus);
		}
	}
	
	public GameManager() {
		Round = 1;
		Player p1 = new Player("Joueur1", "yellowgreen");
		Player p2 = new Player("Joueur2", "#6720C7");
		
		CurrentPlayer = p1;
		CurrentPlayerID = 0;
		Players.add(p1);
		Players.add(p2);
		
		Createdeck();
		
		Collections.shuffle(deckcredit);
		//System.out.println(deckcredit.toString());
		
		PlayerCount = Players.size();
	}
	
	
	//public start_game()
	public void printDeck() {
		System.out.println(deckcredit.toString());
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
	
	public ArrayList<CreditCard> getDeckCreditCard() {
		return this.deckcredit;
	}
	
	
	//pick une carte crédit
	public CreditCard pickCreditCard(int index) {
		
		CreditCard temp = new CreditCard(this.deckcredit.get(index));	//on recup la carte dans une variable temporaire
		this.deckcredit.remove(index);	// on supprime la carte du deck
		
		return temp;	
	}
	
	//pick une carte destination
	public DestinationGoalCard pickDestinationGoalCard(int index) {
		
		DestinationGoalCard temp = new DestinationGoalCard(this.deckdestination.get(index));//on recup la carte dans une variable temporaire
		this.deckdestination.remove(index);// on supprime la carte du deck
		
		return temp;
	}
}

package fr.utbm.ap4b.model;

import java.util.ArrayList;

public class Player {
	private String PlayerName;
	private ArrayList<CreditCard> CreditList;
	private ArrayList<DestinationGoalCard> DestinationGoalList;
	private String Color;
	
	public String getPlayerName() {
		return PlayerName;
	}

	public String getColor() {
		return Color;
	}

	public Player(String playerName, String color) {
		PlayerName = playerName;
		Color = color;
		CreditList = new ArrayList<CreditCard>();
		DestinationGoalList = new ArrayList<DestinationGoalCard>();
	}
	
	public void print() {
		System.out.println("\n Player : "+ this.PlayerName + "\n Credit cards : "+ this.CreditList.toString() + "\n Destination Card : "+ this.DestinationGoalList.toString());
		
		
	}
	
	//ajouter une carte credit au deck du joueur
	public void addCreditCard(CreditCard card) {
		CreditList.add(card);
	}
	
	//ajouter une carte destination au deck du joueur
	public void addDestinationCard(DestinationGoalCard card) {
		DestinationGoalList.add(card);
	}
}

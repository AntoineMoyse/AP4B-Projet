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
	}
}

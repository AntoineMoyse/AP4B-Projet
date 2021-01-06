package fr.utbm.ap4b.model;

import java.util.ArrayList;

public class Player {
	private String PlayerName;
	private ArrayList<CreditCard> CreditList;
	private ArrayList<DestinationGoalCard> DestinationGoalList;
	private String Color;
	private int nbCredit;
	
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
		nbCredit = 45;
	}
	
	//methode test juste pour afficher les info d'un player
	public void print() {
		System.out.println("\n Player : "+ this.PlayerName + "\n Credit cards : "+ this.CreditList.toString() + "\n Destination Card : "+ this.DestinationGoalList.toString() + "\nnombre de credit :" + this.nbCredit);
		
		
	}
	
	//ajouter une carte credit au deck du joueur
	public void addCreditCard(CreditCard card) {
		CreditList.add(card);
	}
	
	//ajouter une carte destination au deck du joueur
	public void addDestinationCard(DestinationGoalCard card) {
		DestinationGoalList.add(card);
	}
	
	//retirer une card du deck credit
	public CreditCard pickCreditCardDeck(int index) {
		CreditCard temp = this.CreditList.get(index);
		this.CreditList.remove(index);
		return temp;
	}
	
	public ArrayList<Integer> isPossibleToPutCredit(String typeEdge, int nb) {
		
		int nbCardSameCredit = 0;
		ArrayList<Integer> listCreditCard = new ArrayList<Integer>(); // liste des index � enlever du deck du joueur si il a assez de credit du bon type
		ArrayList<Integer> emptyList = new ArrayList<Integer>(); // liste vide � renvoyer s'il n'en a pas assez
		
	    // on compte le nombre de cartes credit du type voulu (typeEdge)
		for(int i=0; i<this.CreditList.size();i++) {
			if(typeEdge == this.CreditList.get(i).getCreditType()) {
				nbCardSameCredit++;
				listCreditCard.add(i);
			}
					
		}
		if(nbCardSameCredit>=nb && this.nbCredit>=nb)
			return listCreditCard;
		else
			return emptyList;
	}	
}

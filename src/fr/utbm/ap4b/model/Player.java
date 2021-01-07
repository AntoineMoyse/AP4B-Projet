package fr.utbm.ap4b.model;

import java.util.ArrayList;
import java.util.Arrays;

import fr.utbm.ap4b.GameManager;

public class Player {
	private String PlayerName;
	private int[] CreditList;
	private ArrayList<DestinationGoalCard> DestinationGoalList;
	private String Color;
	private int nbCredit;
	private int point;
	private int[] tableaupoint = {1,2,4,7,10,15};
	private GameManager GM;
	
	public String getPlayerName() {
		return PlayerName;
	}

	public String getColor() {
		return Color;
	}

	public Player(String playerName, String color, GameManager gM) {
		PlayerName = playerName;
		Color = color;
		GM=gM;
		CreditList = new int[Credit.values().length];
		DestinationGoalList = new ArrayList<DestinationGoalCard>();
		nbCredit = 45;
		point=0;
	}
	
	//methode test juste pour afficher les info d'un player
	public void print() {
		System.out.println("\n Player : "+ this.PlayerName + "\n Credit cards : "+ this.CreditList.toString() + "\n Destination Card : "+ this.DestinationGoalList.toString() + "\nnombre de credit :" + this.nbCredit + "\nNombre de point :" + this.point);
	}
	
	public void Ajoutpoint(int nb) {
		point = point + tableaupoint[nb-1];
		System.out.println(point);
	}
	
	//ajouter une carte credit au deck du joueur
	public void addCreditCard(CreditCard card) {
		CreditList[card.getCreditType().ordinal()]++;
	}
	
	public int countCredit(Credit c) {
		return CreditList[c.ordinal()];
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
	
	public boolean takeCreditCard(Credit typeEdge, int nb) {
		int nbCardSameCredit = 0;
		
		if (CreditList[typeEdge.ordinal()] >= nb) {
			CreditList[typeEdge.ordinal()] -= nb;
			return true;
		} else {
			return false;
		}
	}
	
	public int isPossibleToPutCredit(Credit typeEdge, int nb) {
		
		int nbCardSameCredit = 0;
		int listCreditCard = new int[]; // liste des index à enlever du deck du joueur si il a assez de credit du bon type
		int emptyList = new int[]; // liste vide à renvoyer s'il n'en a pas assez
		
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
	
	@Override
	public String toString() {
		return "Player [PlayerName=" + PlayerName + ", DestinationGoalList=" + DestinationGoalList + ", Color=" + Color
				+ ", GM=" + GM + ", CreditList=" + Arrays.toString(CreditList) + "]";
	}
}

package fr.utbm.ap4b.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.model.Credit;
import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardDrawController implements Initializable {

	private GameManager GM;
	private int takedCard;
	private static final int maxCard = 2;
	
	@FXML ImageView slot1;
	@FXML ImageView slot2;
	@FXML ImageView slot3;
	@FXML ImageView slot4;
	@FXML ImageView slot5;
	
	ArrayList<ImageView> slots = new ArrayList<ImageView>();
	
	@FXML ImageView UVDeck;
	@FXML Label UVDeckCount;
	@FXML ImageView DestinationGoalDeck;
	@FXML Label DestinationGoalDeckCount;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		slots.add(slot1);
		slots.add(slot2);
		slots.add(slot3);
		slots.add(slot4);
		slots.add(slot5);
		//System.out.println("CardDrawLoaded");
	}

	public void setGameManager(GameManager gM) {
		this.GM = gM;
	}
	
	public void actualize() {
		//on vérifie que la pioche n'est pas vide
		if (GM.getDeckCredit().size() == 0) {
			System.out.println("Pioche carte crédit vide");
			System.out.println("Cre " + GM.getDeckCredit());
			System.out.println("dest " + GM.getDeckCreditDeleted());
			GM.getDeckCredit().addAll(GM.getDeckCreditDeleted());
			GM.getDeckCreditDeleted().removeAll();
			System.out.println("Cre " + GM.getDeckCredit());
			System.out.println("dest " + GM.getDeckCreditDeleted());
		}
		
		if (GM.getDeckCredit().size() > 5) {
			Image UV = new Image(this.getClass().getResourceAsStream("/res/img/UVCard.png"));
			UVDeck.setImage(UV);
		} else {
			Image nocard = new Image(this.getClass().getResourceAsStream("/res/img/nocard.png"));
			UVDeck.setImage(nocard);
		}
		
		
		for (int i = 0; i<slots.size(); i++) {
			CreditCard CC = GM.getDeckCredit().readACard(i);
			if (CC != null) {
				Image img = CC.getImage();
				slots.get(i).setImage(img);
			} else {
				Image nocard = new Image(this.getClass().getResourceAsStream("/res/img/nocard.png"));
				slots.get(i).setImage(nocard);
			}
		}
		
		Image Dest = new Image(this.getClass().getResourceAsStream("/res/img/DestCard.png"));
		DestinationGoalDeck.setImage(Dest);
		
		UVDeckCount.setText(Integer.toString(GM.getDeckCredit().size()));
		DestinationGoalDeckCount.setText(Integer.toString(GM.getDeckDestination().size()));
		
		//System.out.println("CardDrawFilled");
	}

	private void playerTakesACard(int index) {
		CreditCard CC = GM.getDeckCredit().takeACard(index);
		if (CC != null) {
			if (CC.getCreditType() == Credit.joker) {
				System.out.println("Joker pioché");
				if (takedCard == 0) {
					GM.getCurrentPlayer().addCreditCard(CC);
					takedCard = 0;
					GM.nextPlayer();
				} else {
					GM.getDeckCredit().add(CC);
					System.out.println("Vous ne pouvez pas prendre de Joker");
				}
				
			} else {
				takedCard++;
				GM.getCurrentPlayer().addCreditCard(CC);
				if (takedCard >= maxCard) {
					takedCard = 0;
					GM.nextPlayer();
					System.out.println("Limite de carte atteinte");
				}
			}
			
		} else {
			System.out.println("Cette emplacement est vide");
		}
		
		GM.getDisplayManager().updateAll();
	}

	@FXML protected void HandleMouseClickSlot1() {
		playerTakesACard(0);
	}
	
	@FXML protected void HandleMouseClickSlot2() {
		playerTakesACard(1);
	}
	
	@FXML protected void HandleMouseClickSlot3() {
		playerTakesACard(2);
	}
	
	@FXML protected void HandleMouseClickSlot4() {
		playerTakesACard(3);
	}
	
	@FXML protected void HandleMouseClickSlot5() {
		playerTakesACard(4);
	}
	
	@FXML protected void HandleMouseClickUVDraw() {
		playerTakesACard(5);
	}
	
	@FXML protected void HandleMouseClickDestDraw() {
		DestinationGoalCard CC = GM.getDeckDestination().takeACard(0);
		if (CC != null) {
			GM.getCurrentPlayer().addDestinationCard(CC);
			GM.nextPlayer();
			GM.getDisplayManager().updateAll();
		} else {
			System.out.println("Pas de cartes destinations");
		}
	}
}
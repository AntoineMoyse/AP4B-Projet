package fr.utbm.ap4b.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardDrawController implements Initializable {

	private GameManager GM;
	
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

	@FXML protected void HandleMouseClickSlot1() {
		CreditCard CC = GM.getDeckCredit().takeACard(0);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickSlot2() {
		CreditCard CC = GM.getDeckCredit().takeACard(1);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickSlot3() {
		CreditCard CC = GM.getDeckCredit().takeACard(2);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickSlot4() {
		CreditCard CC = GM.getDeckCredit().takeACard(3);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickSlot5() {
		CreditCard CC = GM.getDeckCredit().takeACard(4);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickUVDraw() {
		CreditCard CC = GM.getDeckCredit().takeACard(5);
		if (CC != null) {
			GM.getCurrentPlayer().addCreditCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
	
	@FXML protected void HandleMouseClickDestDraw() {
		DestinationGoalCard CC = GM.getDeckDestination().takeACard(0);
		if (CC != null) {
			GM.getCurrentPlayer().addDestinationCard(CC);
			GM.getDisplayManager().updateAll();
		}
	}
}
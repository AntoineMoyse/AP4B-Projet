package fr.utbm.ap4b.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CardDrawController implements Initializable {

	private GameManager GM;
	
	@FXML ImageView slot1;
	@FXML ImageView slot2;
	@FXML ImageView slot3;
	@FXML ImageView slot4;
	@FXML ImageView slot5;
	@FXML ImageView UVDeck;
	@FXML Label UVDeckCount;
	@FXML ImageView DestinationGoalDeck;
	@FXML Label DestinationGoalDeckCount;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("CardDrawLoaded");
	}

	public void setGameManager(GameManager gM) {
		this.GM = gM;
	}
	
	public void actualize() {
		System.out.println("CardDrawFilled");
	}
}
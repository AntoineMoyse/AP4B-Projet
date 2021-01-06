package fr.utbm.ap4b.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PlayerInfoController implements Initializable {

	private GameManager GM;
	
	@FXML ImageView player_img;
	@FXML Label playername_lbl;
	@FXML HBox cardscontainer_hbox;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("PlayerInfoLoaded");
	}

	public void setGameManager(GameManager gM) {
		this.GM = gM;
	}
	
	public void actualize() {
		Image Avatar = new Image(this.getClass().getResourceAsStream("/res/img/player.png"));
		player_img.setImage(Avatar);
		playername_lbl.setText(GM.getCurrentPlayer().getPlayerName());
		System.out.println("PlayerInfoFilled");
		
	}
}

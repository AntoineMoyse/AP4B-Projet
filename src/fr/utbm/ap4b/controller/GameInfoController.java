package fr.utbm.ap4b.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.utils.Resources;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class GameInfoController implements Initializable {

	private GameManager GM;

	@FXML Label round;
	@FXML Label nextplayer;
	@FXML Label elapsedtime;
	@FXML Label title;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("GameInfoLoaded");
		title.setText(Resources.getStringRessources("title"));
	}

	public void setGameManager(GameManager gM) {
		this.GM = gM;
	}
	
	public void actualize() {
		round.setText(Resources.getStringRessources("round") + GM.getRound());
		elapsedtime.setText(Resources.getStringRessources("notImplemented"));
		nextplayer.setText(Resources.getStringRessources("notImplemented"));
		//System.out.println("GameInfoFilled");
	}
}

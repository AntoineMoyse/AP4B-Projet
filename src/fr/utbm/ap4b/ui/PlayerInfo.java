package fr.utbm.ap4b.ui;

import java.io.IOException;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.controller.PlayerInfoController;
import fr.utbm.ap4b.utils.Resources;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class PlayerInfo implements Displayable {
	private GameManager GM;
	private Parent root;
	private PlayerInfoController controller;
	
	public PlayerInfo(GameManager gM) {
		GM = gM;
		
		ResourceBundle bundle = ResourceBundle.getBundle(Resources.BUNDLEPATH);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/fxml/player_info.fxml"), bundle);
		
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		controller = fxmlLoader.<PlayerInfoController>getController();
		controller.setGameManager(GM);
	}

	@Override
	public void start() {
		update();
	}

	@Override
	public Node getNode() {
		return root;
	}

	@Override
	public void update() {
		controller.actualize();
	}
}

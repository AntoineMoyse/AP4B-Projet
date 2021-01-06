package fr.utbm.ap4b.ui;

import java.io.IOException;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.controller.GameInfoController;
import fr.utbm.ap4b.utils.Resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class GameInfo implements Displayable {
	private Parent root;
	private GameInfoController controller;
	private GameManager GM;
	
	public GameInfo(GameManager gM) {
		GM = gM;
		
		ResourceBundle bundle = ResourceBundle.getBundle(Resources.BUNDLEPATH);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/fxml/game_info.fxml"), bundle);
		
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		controller = fxmlLoader.<GameInfoController>getController();
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

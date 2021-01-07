package fr.utbm.ap4b.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.controller.CardDrawController;
import fr.utbm.ap4b.utils.Resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class CardDraw<Card> implements Displayable {
	protected ArrayList<Card> deck = new ArrayList<Card>();
	private GameManager GM;
	private Parent root;
	private CardDrawController controller;
	
	public CardDraw(GameManager gM) {
		GM = gM;
		
		ResourceBundle bundle = ResourceBundle.getBundle(Resources.BUNDLEPATH);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/fxml/CardDraw.fxml"), bundle);
		
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		controller = fxmlLoader.<CardDrawController>getController();
		controller.setGameManager(GM);
	}
	
	public int size() {
		return deck.size();
	}
	
	public Card takeACard(int index) {
		if (index < size()) {
			Card CC = deck.get(index);  //on recup la carte dans une variable temporaire
			deck.remove(index);  // on supprime la carte du deck
			return CC;
		} else {
			return null;
		}
	}
	
	public Card readACard(int index) {
		if (index < size()) {
			return deck.get(index);
		} else {
			return null;
		}
	}
	
	public void add(Card CC) {
		deck.add(CC);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void addAll(CardDraw<Card> CD) {
		this.deck.addAll(CD.deck);
	}
	
	public void removeAll() {
		this.deck.removeAll(deck);
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
	
	@Override
	public String toString() {
		return "CardDraw [deck=" + deck + "]";
	}
}
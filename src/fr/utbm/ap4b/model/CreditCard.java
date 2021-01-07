package fr.utbm.ap4b.model;

import javafx.scene.image.Image;

public class CreditCard implements Card {
	private Credit type;

	public CreditCard(Credit type) {
		this.type=type;
	}
	
	public CreditCard(CreditCard copy) {
		this.type = copy.getCreditType();
	}
	
	public Credit getCreditType() {
		return type;
	}

	@Override
	public String toString() {
		return this.getCreditType().toString();
	}

	@Override
	public Image getImage() {
		Image img;
		try {
			img = new Image(this.getClass().getResourceAsStream("/res/img/" + type + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
			img = new Image(this.getClass().getResourceAsStream("/res/img/error.png"));
		}
		return img;
	}
}

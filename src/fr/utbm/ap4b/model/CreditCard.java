package fr.utbm.ap4b.model;

public class CreditCard implements Card {
	private String type;

	public CreditCard(String type) {
		this.type=type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return this.getType();
	}

	public void createdeck() {

	}
}

package fr.utbm.ap4b.model;

public class CreditCard implements Card {
	private String type;

	public CreditCard(String type) {
		this.type=type;
	}
	
	public CreditCard(CreditCard copy) {
		this.type = copy.getCreditType();
	}
	public String getCreditType() {
		return type;
	}

	@Override
	public String toString() {
		return this.getCreditType();
	}

}

package fr.utbm.ap4b.model;

public class Edge {
	
	private Vertice Source;
	private Vertice Destination;
	private int Length;
	private Player Owner;
	private Credit type;

	public Vertice getSource() {
		return Source;
	}

	public Vertice getDestination() {
		return Destination;
	}

	public int getLength() {
		return Length;
	}
	
	public Credit getType() {
		return type;
	}

	public Edge(Vertice Source, Vertice Destination, int Cost, Credit type) {
		this.Source = Source;
		this.Destination = Destination;
		this.Length = Cost;
		this.type = type;
	}

	public Player getOwner() {
		return Owner;
	}

	public void setOwner(Player owner) {
		Owner = owner;
	}

	@Override
	public String toString() {
		if (Owner == null) {
			return Integer.toString(Length)+type;
		} else {
			return Owner.getPlayerName();
		}
			
		
	}
}

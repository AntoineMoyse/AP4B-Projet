package fr.utbm.ap4b.model;

public class Edge {
	
	private Vertice Source;
	private Vertice Destination;
	private int Length;
	private Player Owner;
	private String type;

	public Vertice getSource() {
		return Source;
	}

	public Vertice getDestination() {
		return Destination;
	}

	public int getLength() {
		return Length;
	}

	public Edge(Vertice Source, Vertice Destination, int Cost) {
		this.Source = Source;
		this.Destination = Destination;
		this.Length = Cost;
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
			return Integer.toString(Length);
		} else {
			return Owner.getPlayerName();
		}
			
		
	}
}

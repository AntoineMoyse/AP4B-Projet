package fr.utbm.ap4b.model;

public class Edge {
	private Vertice Source;
	private Vertice Destination;
	private int Length;

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

	@Override
	public String toString() {
		return Integer.toString(Length);
	}
}

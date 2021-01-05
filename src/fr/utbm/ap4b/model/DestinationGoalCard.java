package fr.utbm.ap4b.model;

public class DestinationGoalCard implements Card {
	private Vertice Start;
	private Vertice Goal;
	private int point;
	
	public DestinationGoalCard(Vertice Start, Vertice Goal, int point) {
		this.Start=Start;
		this.Goal=Goal;
		this.point=point;
	}
	
	public Vertice getStart() {
		return Start;
	}
	
	public Vertice getGoal() {
		return Goal;
	}
	
	public int getPoint() {
		return point;
	}
	
	@Override
	public String toString() {
		return Start.toString()+Goal.toString()+Integer.toString(point);
	}
}

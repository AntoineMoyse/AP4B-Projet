package fr.utbm.ap4b.model;

import javafx.scene.image.Image;

public class DestinationGoalCard implements Card {
	private Vertice start;
	private Vertice goal;
	private int point;

	public DestinationGoalCard(Vertice start, Vertice goal, int point) {
		this.start=start;
		this.goal=goal;
		this.point=point;
	}
	
	public DestinationGoalCard(DestinationGoalCard card) {
		this.start=card.getStart();
		this.goal=card.getGoal();
		this.point=card.getPoint();
	}

	public Vertice getStart() {
		return start;
	}

	public Vertice getGoal() {
		return goal;
	}

	public int getPoint() {
		return point;
	}

	@Override
	public String toString() {
		return start.toString()+goal.toString()+Integer.toString(point);
	}
	
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}

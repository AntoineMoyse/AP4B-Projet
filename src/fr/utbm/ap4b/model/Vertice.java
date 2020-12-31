package fr.utbm.ap4b.model;

public class Vertice{
	private String UVName;
	
	public Vertice(String Name) {
		this.UVName = Name;
	}

	public String getUVName() {
		return UVName;
	}

	@Override
	public String toString() {
		return this.getUVName();
	}
}

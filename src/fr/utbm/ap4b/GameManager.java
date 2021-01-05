package fr.utbm.ap4b;

public class GameManager {
	private DisplayManager DM;
	
	public GameManager(DisplayManager displayManager) {
		DM = displayManager;
	}

	public DisplayManager getDM() {
		return DM;
	}
}

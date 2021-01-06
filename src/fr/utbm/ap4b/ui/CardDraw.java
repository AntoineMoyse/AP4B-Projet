package fr.utbm.ap4b.ui;
import java.util.ArrayList;
import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import javafx.scene.Node;

public class CardDraw implements Displayable{
	private GameManager GM;
	private ArrayList<CreditCard> deckcredit;
	private ArrayList<DestinationGoalCard> deckdestination;
	
	public CardDraw(GameManager gM) {
		super();
		GM = gM;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}

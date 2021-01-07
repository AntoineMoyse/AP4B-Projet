package fr.utbm.ap4b;

import java.util.ArrayList;

import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.ui.CardDraw;
import fr.utbm.ap4b.ui.Displayable;
import fr.utbm.ap4b.ui.GameInfo;
import fr.utbm.ap4b.ui.GraphUI;
import fr.utbm.ap4b.ui.PlayerInfo;
import fr.utbm.ap4b.utils.Resources;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayManager extends Application {
	public static Stage mainStage; //fenêtre principale
	private GameManager GM;
	private ArrayList<Displayable> ComponentList;
	
	public static void main(String[] args) {
		System.out.println("Main methode - Thread: " + Thread.currentThread().getName());
		launch(args); //lancement de l'application
		
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init methode - Thread: " + Thread.currentThread().getName());
		GM = new GameManager(this);
		//dans cette partie on gère tout ce qui doit être fait avant d'afficher la fenêtre.
		
		/*GM.getCurrentPlayer().print();
		System.out.println(GM.getDeckCreditCard().toString());
		GM.getCurrentPlayer().addCreditCard(GM.pickCreditCard(2));
		System.out.println(GM.getDeckCreditCard().toString());
		GM.getCurrentPlayer().print();
		System.out.println(GM.putCredit("ST", 1));
		System.out.println(GM.putCredit("TM", 1));
		System.out.println(GM.putCredit("CS", 1));
		System.out.println(GM.putCredit("EC", 1));
		GM.getCurrentPlayer().print();*/
		
	}
	
	@Override
	public void start(Stage NewStage) throws Exception {
		System.out.println("Start methode - Thread: " + Thread.currentThread().getName());
		GM = new GameManager(this);
		//dans cette partie on s'occupe de générer la fenêtre
		
		mainStage = NewStage; //l'objet qui contient le fenêtre nous est donné par la superclass
		mainStage.setTitle(Resources.getStringRessources("title"));//on redéfini son titre
		mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/img/ticketToUTBMbiais.png")));//on défini l'icone
		mainStage.setResizable(true);//on défini quelques propriétés
		mainStage.setMinHeight(800);
		mainStage.setMinWidth(1200);
		
		//create the graph
		GraphUI graphUI = new GraphUI(GM);
		CardDraw CD = new CardDraw(GM);
		PlayerInfo PI = new PlayerInfo(GM);
		GameInfo GI = new GameInfo(GM);

		ComponentList = new ArrayList<Displayable>();
		ComponentList.add(graphUI);
		ComponentList.add(CD);
		ComponentList.add(PI);
		ComponentList.add(GI);
		
		BorderPane root = new BorderPane();
		root.setCenter(graphUI.getNode());
		root.setBottom(PI.getNode());
		root.setRight(CD.getNode());
		root.setTop(GI.getNode());
		Scene scene = new Scene(root, 1200, 800);
		
		mainStage.setScene(scene);
		mainStage.show();//on affiche la fenêtre
		mainStage.centerOnScreen();//on initialise quelques propriétés
		mainStage.setAlwaysOnTop(false);
		
		for (Displayable Component : ComponentList) {
			Component.start();
		}
	}
	
	public void updateAll() {
		for (Displayable Component : ComponentList) {
			Component.update();
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop methode - Thread: " + Thread.currentThread().getName());
		//lorsque l'application est quitté
	}
}

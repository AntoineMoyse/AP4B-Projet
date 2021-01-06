package fr.utbm.ap4b;

import fr.utbm.ap4b.ui.CardDraw;
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
	
	public static void main(String[] args) {
		System.out.println("Main methode - Thread: " + Thread.currentThread().getName());
		launch(args); //lancement de l'application
		
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init methode - Thread: " + Thread.currentThread().getName());
		GM = new GameManager();
		//dans cette partie on gère tout ce qui doit être fait avant d'afficher la fenêtre.
		System.out.print("salut");
	}
	
	@Override
	public void start(Stage NewStage) throws Exception {
		System.out.println("Start methode - Thread: " + Thread.currentThread().getName());
		//dans cette partie on s'occupe de générer la fenêtre
		
		mainStage = NewStage; //l'objet qui contient le fenêtre nous est donné par la superclass
		mainStage.setTitle(Resources.getStringRessources("title"));//on redéfini son titre
		mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/img/ticketToUTBMbiais.png")));//on défini l'icone
		mainStage.setResizable(true);//on défini quelques propriétés
		mainStage.setMinHeight(400);
		mainStage.setMinWidth(500);
		
		//create the graph
		GraphUI graphUI = new GraphUI(GM);
		CardDraw CD = new CardDraw(GM);
		PlayerInfo PI = new PlayerInfo(GM);
		GameInfo GI = new GameInfo(GM);
		BorderPane root = new BorderPane();
		root.setCenter(graphUI.getNode());
		root.setBottom(PI.getNode());
		root.setRight(CD.getNode());
		root.setTop(GI.getNode());
		Scene scene = new Scene(root, 1000, 600);
		
		mainStage.setScene(scene);
		mainStage.show();//on affiche la fenêtre
		mainStage.centerOnScreen();//on initialise quelques propriétés
		mainStage.setAlwaysOnTop(false);
		
		graphUI.start();//à faire après le show() absolument
		//graphUI.update();//pour actualiser l'élément
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop methode - Thread: " + Thread.currentThread().getName());
		//lorsque l'application est quitté
	}
}

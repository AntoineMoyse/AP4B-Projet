package fr.utbm.ap4b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.brunomnsilva.smartgraph.graph.Graph;

import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import fr.utbm.ap4b.model.Edge;
import fr.utbm.ap4b.model.Player;
import fr.utbm.ap4b.model.Vertice;

public class GameManager {
	private ArrayList<Player> Players = new ArrayList<Player>();
	private int Round;
	private Player CurrentPlayer;
	private int PlayerCount;
	private int CurrentPlayerID;
	private ArrayList<CreditCard> deckcredit = new ArrayList<CreditCard>();
	private ArrayList<CreditCard> deckDeleted = new ArrayList<CreditCard>();
	private ArrayList<DestinationGoalCard> deckdestination= new ArrayList<DestinationGoalCard>();
	
	
	public void Createdeck() {
		int i;
		for(i=0;i<14;i++)
		{
			CreditCard CS = new CreditCard("CS");
			deckcredit.add(CS);
			CreditCard TM = new CreditCard("TM");
			deckcredit.add(TM);
			CreditCard OM = new CreditCard("OM");
			deckcredit.add(OM);
			CreditCard EC = new CreditCard("EC");
			deckcredit.add(EC);
			CreditCard QC = new CreditCard("QC");
			deckcredit.add(QC);
			CreditCard ST = new CreditCard("ST");
			deckcredit.add(ST);
			CreditCard NS = new CreditCard("NS");
			deckcredit.add(NS);
		}
		for(i=0;i<14;i++) {
			CreditCard Bonus = new CreditCard("Bonus");
			deckcredit.add(Bonus);
		}
	}
	
	public GameManager() {
		Round = 1;
		Player p1 = new Player("Joueur1", "yellowgreen");
		Player p2 = new Player("Joueur2", "#6720C7");
		
		CurrentPlayer = p1;
		CurrentPlayerID = 0;
		Players.add(p1);
		Players.add(p2);
		
		Createdeck();
		
		Collections.shuffle(deckcredit);
		//System.out.println(deckcredit.toString());
		
		PlayerCount = Players.size();
	}
	
	
	//public start_game()
	public void printDeck() {
		System.out.println(deckcredit.toString());
	}
	
	public Player getCurrentPlayer() {
		return CurrentPlayer;
	}
	
	public Player nextPlayer() {
		CurrentPlayerID ++;
		if (CurrentPlayerID >= PlayerCount) {
			CurrentPlayerID = 0;
			Round++;
		}
		CurrentPlayer = Players.get(CurrentPlayerID);
		return CurrentPlayer;
	}
	
	public int getRound() {
		return Round;
	}
	
	public ArrayList<CreditCard> getDeckCreditCard() {
		return this.deckcredit;
	}
	
	
	//pick une carte cr�dit
	public CreditCard pickCreditCard(int index) {
		
		CreditCard temp = new CreditCard(this.deckcredit.get(index));	//on recup la carte dans une variable temporaire
		this.deckcredit.remove(index);	// on supprime la carte du deck
		
		return temp;	
	}
	
	//pick une carte destination
	public DestinationGoalCard pickDestinationGoalCard(int index) {
		
		DestinationGoalCard temp = new DestinationGoalCard(this.deckdestination.get(index));//on recup la carte dans une variable temporaire
		this.deckdestination.remove(index);// on supprime la carte du deck
		
		return temp;
	}
	
	//placer les credits
	public boolean putCredit(String typeEdge, int nb) {
		
		//on verifi si le joueur actuel peut prendre un chemin
		ArrayList<Integer> listCreditCard = this.CurrentPlayer.isPossibleToPutCredit(typeEdge, nb);
		
		if(listCreditCard.isEmpty()==false) {
			for(int i=0;i<nb;i++) {
				deckDeleted.add(this.CurrentPlayer.pickCreditCardDeck(listCreditCard.get(i)));
			}
			return true;
		}
		else
			return false;
	}
	
	public void loadGraph(Graph<Vertice, Edge> g) {
		Vertice MTA = new Vertice("MTA");
		Vertice MTB = new Vertice("MTB");
		Vertice MTC = new Vertice("MTC");
		Vertice PSA = new Vertice("PSA");
		Vertice PSB = new Vertice("PSB");
		Vertice PMA = new Vertice("PMA");
		Vertice CMA = new Vertice("CMA");
		Vertice LO21 = new Vertice("LO21");
		
		Vertice IFA = new Vertice("IFA");
		Vertice IFB = new Vertice("IFB");
		Vertice MDA = new Vertice("MDA");
		Vertice MDB = new Vertice("MDB");
		Vertice TNA = new Vertice("TNA");
		Vertice DT20 = new Vertice("DT20");
		Vertice IFD = new Vertice("IFD");
		
		Vertice EC10 = new Vertice("EC10");
		Vertice GE00 = new Vertice("GE00");
		Vertice GE03 = new Vertice("GE03");
		Vertice SO02 = new Vertice("SO02");
		Vertice SO10 = new Vertice("SO10");
		Vertice ID00 = new Vertice("ID00");
		Vertice EV00 = new Vertice("EV00");
		
		Vertice LE02 = new Vertice("LE02");
		Vertice LE03 = new Vertice("LE03");
		Vertice LG00 = new Vertice("LG00");
		Vertice LK00 = new Vertice("LK00");
		Vertice LJ00 = new Vertice("LJ00");
		Vertice LS00 = new Vertice("LS00");
		Vertice LR00 = new Vertice("LR00");
		
		Vertice SI02 = new Vertice("SI02");
		Vertice PH01 = new Vertice("PH01");
		Vertice PH03 = new Vertice("PH03");
		Vertice PH04 = new Vertice("PH04");
		Vertice HT07 = new Vertice("HT07");
		Vertice EV02 = new Vertice("EV02");
		Vertice CC03 = new Vertice("CC03");
		
		
		g.insertVertex(MTA);
		g.insertVertex(MTB);
		g.insertVertex(MTC);
		g.insertVertex(PSA);
		g.insertVertex(PSB);
		g.insertVertex(CMA);
		g.insertVertex(PMA);
		g.insertVertex(LO21);
		
		g.insertVertex(IFA);
		g.insertVertex(IFB);
		g.insertVertex(MDA);
		g.insertVertex(MDB);
		g.insertVertex(TNA);
		g.insertVertex(DT20);
		g.insertVertex(IFD);
		
		g.insertVertex(EC10);
		g.insertVertex(GE00);
		g.insertVertex(GE03);
		g.insertVertex(SO02);
		g.insertVertex(SO10);
		g.insertVertex(ID00);
		g.insertVertex(EV00);
		
		g.insertVertex(LE02);
		g.insertVertex(LE03);
		g.insertVertex(LG00);
		g.insertVertex(LK00);
		g.insertVertex(LJ00);
		g.insertVertex(LS00);
		g.insertVertex(LR00);
		
		g.insertVertex(SI02);
		g.insertVertex(PH01);
		g.insertVertex(PH03);
		g.insertVertex(PH04);
		g.insertVertex(HT07);
		g.insertVertex(EV02);
		g.insertVertex(CC03);

		Edge MTA_CMA = new Edge(MTA, CMA, 3, "CS");
		Edge CMA_MTB = new Edge(CMA, MTB, 6,"CS");
		Edge MTB_TNA = new Edge(MTB, TNA, 6, "ST");
		Edge TNA_IFB = new Edge(TNA, IFB, 5, "TM");
		Edge IFB_IFA = new Edge(IFB, IFA, 2, "TM");
		Edge IFA_IFB = new Edge(IFA, IFB, 2,"TM");
		Edge IFA_MDA = new Edge(IFA, MDA, 2, "TM");
		Edge MDA_IFA = new Edge(MDA, IFA, 2, "TM");
		Edge MDA_MDB = new Edge(MDA, MDB, 2, "TM");
		Edge MDB_MDA = new Edge(MDB, MDA, 2, "TM");
		Edge MDB_EV02 = new Edge(MDB, EV02, 2, "ST");
		Edge EV02_MDB = new Edge(EV02, MDB, 2, "ST");
		Edge EV02_SI02 = new Edge(EV02, SI02, 2, "QC");
		Edge SI02_PH01 = new Edge(SI02, PH01, 4, "QC");
		Edge PH01_GE00 = new Edge(PH01, GE00, 6, "ST");
		Edge GE00_EC10 = new Edge(GE00, EC10, 2, "OM");
		Edge EC10_LG00 = new Edge(EC10, LG00, 6, "ST");
		Edge LG00_LE02 = new Edge(LG00, LE02, 6, "EC");
		Edge LE02_LS00 = new Edge(LE02, LS00, 3, "EC");
		Edge LS00_LE02 = new Edge(LS00, LE02, 3, "EC");
		Edge LS00_PMA = new Edge(LS00, PMA, 5, "ST");
		Edge PMA_LS00 = new Edge(PMA, LS00, 5, "ST");
		Edge PMA_PSA = new Edge(PMA, PSA, 1, "CS");	
		Edge PSA_PMA = new Edge(PSA, PMA, 1, "CS");
		Edge PSA_MTA = new Edge(PSA, MTA, 1, "CS");
		Edge MTA_PSA = new Edge(MTA, PSA, 1, "CS");
		
		Edge IFD_PH04 = new Edge(IFD, PH04, 2, "ST");
		Edge PH04_SO10 = new Edge(PH04, SO10, 2, "ST");
		Edge SO10_LE03 = new Edge(SO10, LE03, 4, "ST");
		Edge LE03_MTC = new Edge(LE03, MTC, 4, "ST");
		Edge LE03_EV00 = new Edge(LE03, EV00, 2, "ST");
		Edge EV00_LG00 = new Edge(EV00, LG00, 2, "ST");
		Edge MTC_CMA = new Edge(MTC, CMA, 4, "CS");
		Edge MTC_MTB = new Edge(MTC, MTB, 4, "CS");
		Edge MTC_PSB = new Edge(MTC, PSB, 3, "CS");
		Edge PSB_LS00 = new Edge(PSB, LS00, 5, "ST");
		Edge LS00_PSB = new Edge(LS00, PSB, 5, "ST");
		
		Edge ID00_PH04 = new Edge(ID00, PH04, 5, "NB");
		Edge ID00_IFD = new Edge(ID00, IFD, 3, "NB");
		Edge IFD_ID00 = new Edge(IFD, ID00, 3, "NB");
		Edge ID00_CC03 = new Edge(ID00, CC03, 2, "NB");
		Edge ID00_MDA = new Edge(ID00, MDA, 2, "NB");
		Edge MDA_ID00 = new Edge(MDA, ID00, 2, "NB");
		Edge ID00_MDB = new Edge(ID00, MDB, 2, "NB");
		Edge ID00_EV02 = new Edge(ID00, EV02, 2, "NB");
		Edge ID00_PH03 = new Edge(ID00, PH03, 4, "NB");
		
		Edge IFD_DT20 = new Edge(IFD, DT20, 4, "TM");
		Edge DT20_MTC = new Edge(DT20, MTC, 5, "NB");
		Edge DT20_LE03 = new Edge(DT20, LE03, 4, "NB");
		Edge LE03_PSB = new Edge(LE03, PSB, 3, "NB");
		Edge PSB_LE03 = new Edge(PSB, LE03, 3, "NB");
		
		Edge TNA_LO21 = new Edge(TNA, LO21, 3, "NB");
		Edge LO21_DT20 = new Edge(LO21, DT20, 3, "NB");
		Edge DT20_LO21 = new Edge(DT20, LO21, 3, "NB");
		Edge DT20_SO10 = new Edge(DT20, SO10, 1, "NB");
		Edge SO10_DT20 = new Edge(SO10, DT20, 1, "NB");
		Edge SO10_LR00 = new Edge(SO10, LR00, 2, "NB");
		Edge LR00_SO10 = new Edge(LR00, SO10, 2, "NB");
		Edge LR00_SO02 = new Edge(LR00, SO02, 2, "NB");
		Edge SO02_LR00 = new Edge(SO02, LR00, 2, "NB");
		Edge SO02_EC10 = new Edge(SO02, EC10, 2, "OM");
		Edge EC10_SO02 = new Edge(EC10, SO02, 2, "OM");
		
		Edge PSA_CMA = new Edge(PSA, CMA, 4, "CS");
		Edge PSA_MTC = new Edge(PSA, MTC, 6, "CS");
		Edge MTC_LO21 = new Edge(MTC, LO21, 6, "CS");
		Edge PSB_LJ00 = new Edge(PSB, LJ00, 3, "NB");
		Edge LJ00_LE02 = new Edge(LJ00, LE02, 2, "EC");
		Edge LE02_LK00 = new Edge(LE02, LK00, 3, "EC");
		Edge LK00_LG00 = new Edge(LK00, LG00, 3, "EC");
		Edge LK00_EV00 = new Edge(LK00, EV00, 3, "NB");
		Edge LK00_LE03 = new Edge(LK00, LE03, 5, "EC");
		
		Edge GE03_LR00 = new Edge(GE03, LK00, 2, "NB");
		Edge GE03_SO02 = new Edge(GE03, SO02, 2, "OM");
		Edge GE03_GE00 = new Edge(GE03, GE00, 3, "OM");
		Edge GE03_PH03 = new Edge(GE03, PH03, 3, "ST");
		Edge GE03_PH04 = new Edge(GE03, PH04, 2, "ST");
		
		Edge HT07_PH03 = new Edge(HT07, PH03, 1, "QC");
		Edge HT07_EV02 = new Edge(HT07, EV02, 2, "QC");
		Edge EV02_HT07 = new Edge(EV02, HT07, 2, "QC");
		Edge HT07_SI02 = new Edge(HT07, SI02, 2, "QC");
		Edge HT07_PH01 = new Edge(HT07, PH01, 2, "QC");
		Edge HT07_GE00 = new Edge(HT07, GE00, 4, "ST");
		Edge GE00_HT07 = new Edge(GE00, HT07, 4, "ST");
		
		Edge CC03_IFB = new Edge(CC03, IFB, 3, "ST");
		Edge CC03_TNA = new Edge(CC03, TNA, 2, "ST");
		Edge CC03_LO21 = new Edge(CC03, LO21, 6, "ST");
		Edge CC03_IFD = new Edge(CC03, IFD, 4, "ST");
		
		Edge LG00_SO02 = new Edge(LG00, SO02, 4, "ST");
		Edge LG00_LR00 = new Edge(LG00, LR00, 5, "EC");
		Edge LE03_SO10 = new Edge(LE03, SO10, 4, "ST");
		Edge EV00_LR00 = new Edge(EV00, LR00, 3, "ST");
		Edge PMA_PSB = new Edge(PMA, PSB, 6, "CS");
		Edge MTB_LO21 = new Edge(MTB, LO21, 4, "CS");
		Edge LO21_IFD = new Edge(LO21, IFD, 3, "ST");
		Edge IFB_MDA = new Edge(IFB, MDA, 3, "TM");
		Edge SO10_PH04 = new Edge(SO10, PH04, 2, "ST");
		Edge PH04_PH03 = new Edge(PH04, PH03, 2, "QC");
		Edge PH03_EV02 = new Edge(PH03, EV02, 3, "QC");
		
		
		g.insertEdge(LG00, SO02, LG00_SO02);
		g.insertEdge(LG00, LR00, LG00_LR00);
		g.insertEdge(LE03, SO10, LE03_SO10);
		g.insertEdge(EV00, LR00, EV00_LR00);
		g.insertEdge(PMA, PSB, PMA_PSB);
		g.insertEdge(MTB, LO21, MTB_LO21);
		g.insertEdge(LO21, IFD, LO21_IFD);
		g.insertEdge(IFB, MDA, IFB_MDA);
		g.insertEdge(SO10, PH04, SO10_PH04);
		g.insertEdge(PH04, PH03, PH04_PH03);
		g.insertEdge(PH03, EV02, PH03_EV02);
		
		g.insertEdge(CC03, IFB, CC03_IFB);
		g.insertEdge(CC03, TNA, CC03_TNA);
		g.insertEdge(CC03, LO21, CC03_LO21);
		g.insertEdge(CC03, IFD, CC03_IFD);
		
		g.insertEdge(GE03, LR00, GE03_LR00);
		g.insertEdge(GE03, SO02, GE03_SO02);
		g.insertEdge(GE03, GE00, GE03_GE00);
		g.insertEdge(GE03, PH03, GE03_PH03);
		g.insertEdge(GE03, PH04, GE03_PH04);
		
		g.insertEdge(HT07, PH03, HT07_PH03);
		g.insertEdge(HT07, EV02, HT07_EV02);
		g.insertEdge(EV02, HT07, EV02_HT07);
		g.insertEdge(HT07, SI02, HT07_SI02);
		g.insertEdge(HT07, PH01, HT07_PH01);
		g.insertEdge(HT07, GE00, HT07_GE00);
		g.insertEdge(GE00, HT07, GE00_HT07);
		
		g.insertEdge(PSA, CMA, PSA_CMA);
		g.insertEdge(PSA, MTC, PSA_MTC);
		g.insertEdge(MTC, LO21, MTC_LO21);
		g.insertEdge(PSB, LJ00, PSB_LJ00);
		g.insertEdge(LJ00, LE02, LJ00_LE02);
		g.insertEdge(LE02, LK00, LE02_LK00);
		g.insertEdge(LK00, LG00, LK00_LG00);
		g.insertEdge(LK00, EV00, LK00_EV00);
		g.insertEdge(LK00, LE03, LK00_LE03);
				
		g.insertEdge(TNA, LO21, TNA_LO21);
		g.insertEdge(LO21, DT20, LO21_DT20);
		g.insertEdge(DT20, LO21, DT20_LO21);
		g.insertEdge(DT20, SO10, DT20_SO10);
		g.insertEdge(SO10, DT20, SO10_DT20);
		g.insertEdge(SO10, LR00, SO10_LR00);
		g.insertEdge(LR00, SO10, LR00_SO10);
		g.insertEdge(LR00, SO02, LR00_SO02);
		g.insertEdge(SO02, LR00, SO02_LR00);
		g.insertEdge(SO02, EC10, SO02_EC10);
		g.insertEdge(EC10, SO02, EC10_SO02);
		
		g.insertEdge(IFD, DT20, IFD_DT20);
		g.insertEdge(DT20, MTC, DT20_MTC);
		g.insertEdge(DT20, LE03, DT20_LE03);
		g.insertEdge(LE03, PSB, LE03_PSB);
		g.insertEdge(PSB, LE03, PSB_LE03);
		
		g.insertEdge(IFD, PH04, IFD_PH04);
		g.insertEdge(PH04, SO10, PH04_SO10);
		g.insertEdge(SO10, LE03, SO10_LE03);
		g.insertEdge(LE03, MTC, LE03_MTC);
		g.insertEdge(LE03, EV00, LE03_EV00);
		g.insertEdge(EV00, LG00, EV00_LG00);
		g.insertEdge(MTC, CMA, MTC_CMA);
		g.insertEdge(MTC, MTB, MTC_MTB);
		g.insertEdge(MTC, PSB, MTC_PSB);
		g.insertEdge(PSB, LS00, PSB_LS00);
		g.insertEdge(LS00, PSB, LS00_PSB);

		g.insertEdge(MTA, CMA, MTA_CMA);
		g.insertEdge(CMA, MTB, CMA_MTB);
		g.insertEdge(MTB, TNA, MTB_TNA);
		g.insertEdge(TNA, IFB, TNA_IFB);
		g.insertEdge(IFB, IFA, IFB_IFA);
		g.insertEdge(IFA, IFB, IFA_IFB);
		g.insertEdge(IFA, MDA, IFA_MDA);
		g.insertEdge(MDA, IFA, MDA_IFA);
		g.insertEdge(MDA, MDB, MDA_MDB);
		g.insertEdge(MDB, MDA, MDB_MDA);
		g.insertEdge(MDB, EV02, MDB_EV02);
		g.insertEdge(EV02, MDB, EV02_MDB);
		g.insertEdge(EV02, SI02, EV02_SI02);
		g.insertEdge(SI02, PH01, SI02_PH01);
		g.insertEdge(PH01, GE00, PH01_GE00);
		g.insertEdge(GE00, EC10, GE00_EC10);
		g.insertEdge(EC10, LG00, EC10_LG00);
		g.insertEdge(LG00, LE02, LG00_LE02);
		g.insertEdge(LE02, LS00, LE02_LS00);
		g.insertEdge(LS00, LE02, LS00_LE02);
		g.insertEdge(LS00, PMA, LS00_PMA);
		g.insertEdge(PMA, LS00, PMA_LS00);
		g.insertEdge(PMA, PSA, PMA_PSA);
		g.insertEdge(PSA, PMA, PSA_PMA);
		g.insertEdge(PSA, MTA, PSA_MTA);
		g.insertEdge(MTA, PSA, MTA_PSA);
		
		g.insertEdge(ID00, PH04, ID00_PH04);
		g.insertEdge(ID00, IFD, ID00_IFD);
		g.insertEdge(IFD, ID00, IFD_ID00);
		g.insertEdge(ID00, CC03, ID00_CC03);
		g.insertEdge(ID00, MDA, ID00_MDA);
		g.insertEdge(MDA, ID00, MDA_ID00);
		g.insertEdge(ID00, MDB, ID00_MDB);
		g.insertEdge(ID00, EV02, ID00_EV02);
		g.insertEdge(ID00, PH03, ID00_PH03);

		DestinationGoalCard un = new DestinationGoalCard(MTA, MTB, 10);
		deckdestination.add(un);
		System.out.println(deckdestination.toString());
	}
	
}

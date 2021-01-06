package fr.utbm.ap4b.ui;

import com.brunomnsilva.smartgraph.graph.DigraphEdgeList;
import com.brunomnsilva.smartgraph.graph.Graph;
import com.brunomnsilva.smartgraph.graphview.SmartPlacementStrategy;
import com.brunomnsilva.smartgraph.graphview.SmartGraphPanel;
import com.brunomnsilva.smartgraph.graphview.SmartRandomPlacementStrategy;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.model.Edge;
import fr.utbm.ap4b.model.Vertice;
import javafx.scene.Node;

public class GraphUI implements Displayable {
	private Graph<Vertice, Edge> g;
	private SmartGraphPanel<Vertice, Edge> graphView;
	private GameManager GM;

	public GraphUI(GameManager GM) {
		this.GM = GM;
		g = new DigraphEdgeList<Vertice, Edge>();
		loadGraph(g);
		SmartPlacementStrategy strategy = new SmartRandomPlacementStrategy();
		graphView = new SmartGraphPanel<>(g, strategy);
		graphView.setAutomaticLayout(true);
	}
	
	@Override
	public void start() {
		graphView.setVertexDoubleClickAction(graphVertex -> {
		    System.out.println("Vertex contains element: " + graphVertex.getUnderlyingVertex().element());
		    //graphView.getStylableVertex(graphVertex.getUnderlyingVertex().element()).setStyleClass("myVertex");
		    //graphVertex.setStyle("-fx-stroke: black;");
		});
	
		graphView.setEdgeDoubleClickAction(graphEdge -> {
		    System.out.println("Length : " + graphEdge.getUnderlyingEdge().element().getLength());
		    //graphView.getStylableEdge(graphEdge.getUnderlyingEdge().element()).setStyleClass("myEdge");
		    graphEdge.setStyle("-fx-stroke: " + GM.getCurrentPlayer().getColor() + ";");
		    graphEdge.getUnderlyingEdge().element().setOwner(GM.getCurrentPlayer());
		    update();
		});
		graphView.init();
	}

	@Override
	public Node getNode() {
		return this.graphView;
	}

	@Override
	public void update() {
		graphView.update();
	}
	
	private void loadGraph(Graph<Vertice, Edge> g) {
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

		Edge MTA_CMA = new Edge(MTA, CMA, 3);
		Edge CMA_MTB = new Edge(CMA, MTB, 6);
		Edge MTB_TNA = new Edge(MTB, TNA, 6);
		Edge TNA_IFB = new Edge(TNA, IFB, 5);
		Edge IFB_IFA = new Edge(IFB, IFA, 2);
		Edge IFA_MDA = new Edge(IFA, MDA, 2);
		Edge MDA_MDB = new Edge(MDA, MDB, 2);
		Edge MDB_EV02 = new Edge(MDB, EV02, 2);
		Edge EV02_SI02 = new Edge(EV02, SI02, 2);
		Edge SI02_PH01 = new Edge(SI02, PH01, 4);
		Edge PH01_GE00 = new Edge(PH01, GE00, 6);
		Edge GE00_EC10 = new Edge(GE00, EC10, 2);
		Edge EC10_LG00 = new Edge(EC10, LG00, 6);
		Edge LG00_LE02 = new Edge(LG00, LE02, 6);
		Edge LE02_LS00 = new Edge(LE02, LS00, 3);
		Edge LS00_PMA = new Edge(LS00, PMA, 5);
		Edge PMA_PSA = new Edge(PMA, PSA, 1);	
		Edge PSA_MTA = new Edge(PSA, MTA, 1);
		
		Edge IFD_PH04 = new Edge(IFD, PH04, 2);
		Edge PH04_SO10 = new Edge(PH04, SO10, 2);
		Edge SO10_LE03 = new Edge(SO10, LE03, 4);
		Edge LE03_MTC = new Edge(LE03, MTC, 4);
		Edge LE03_EV00 = new Edge(LE03, EV00, 2);
		Edge EV00_LG00 = new Edge(EV00, LG00, 2);
		Edge MTC_CMA = new Edge(MTC, CMA, 4);
		Edge MTC_MTB = new Edge(MTC, MTB, 4);
		Edge MTC_PSB = new Edge(MTC, PSB, 3);
		Edge PSB_LS00 = new Edge(PSB, LS00, 5);
		Edge LS00_PSB = new Edge(LS00, PSB, 5);
		
		Edge ID00_PH04 = new Edge(ID00, PH04, 5);
		Edge ID00_IFD = new Edge(ID00, IFD, 3);
		Edge IFD_ID00 = new Edge(IFD, ID00, 3);
		Edge ID00_CC03 = new Edge(ID00, CC03, 2);
		Edge ID00_MDA = new Edge(ID00, MDA, 2);
		Edge MDA_ID00 = new Edge(MDA, ID00, 2);
		Edge ID00_MDB = new Edge(ID00, MDB, 2);
		Edge ID00_EV02 = new Edge(ID00, EV02, 2);
		Edge ID00_PH03 = new Edge(ID00, PH03, 4);
		
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
		g.insertEdge(IFA, MDA, IFA_MDA);
		g.insertEdge(MDA, MDB, MDA_MDB);
		g.insertEdge(MDB, EV02, MDB_EV02);
		g.insertEdge(EV02, SI02, EV02_SI02);
		g.insertEdge(SI02, PH01, SI02_PH01);
		g.insertEdge(PH01, GE00, PH01_GE00);
		g.insertEdge(GE00, EC10, GE00_EC10);
		g.insertEdge(EC10, LG00, EC10_LG00);
		g.insertEdge(LG00, LE02, LG00_LE02);
		g.insertEdge(LE02, LS00, LE02_LS00);
		g.insertEdge(LS00, PMA, LS00_PMA);
		g.insertEdge(PMA, PSA, PMA_PSA);
		g.insertEdge(PSA, MTA, PSA_MTA);
		
		g.insertEdge(ID00, PH04, ID00_PH04);
		g.insertEdge(ID00, IFD, ID00_IFD);
		g.insertEdge(IFD, ID00, IFD_ID00);
		g.insertEdge(ID00, CC03, ID00_CC03);
		g.insertEdge(ID00, MDA, ID00_MDA);
		g.insertEdge(MDA, ID00, MDA_ID00);
		g.insertEdge(ID00, MDB, ID00_MDB);
		g.insertEdge(ID00, EV02, ID00_EV02);
		g.insertEdge(ID00, PH03, ID00_PH03);

	}
}

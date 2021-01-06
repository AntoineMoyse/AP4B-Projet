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
		Vertice IFA = new Vertice("IFA");
		Vertice PSA = new Vertice("PSA");
		Vertice TNA = new Vertice("TNA");
		Vertice CMA = new Vertice("CMA");
		
		g.insertVertex(MTA);
		g.insertVertex(MTB);
		g.insertVertex(MTC);
		g.insertVertex(IFA);
		g.insertVertex(PSA);
		g.insertVertex(TNA);
		g.insertVertex(CMA);

		Edge MTA_MTB = new Edge(MTA, MTB, 1);
		Edge MTB_MTC = new Edge(MTB, MTC, 3);
		Edge IFA_MTA = new Edge(IFA, MTA, 3);
		Edge PSA_MTA = new Edge(PSA, MTA, 5);
		Edge TNA_MTA = new Edge(TNA, MTA, 7);
		Edge CMA_TNA = new Edge(CMA, TNA, 3);
		Edge MTC_TNA = new Edge(MTC, TNA, 10);

		g.insertEdge(MTA, MTB, MTA_MTB);
		g.insertEdge(MTB, MTC, MTB_MTC);
		g.insertEdge(IFA, MTA, IFA_MTA);
		g.insertEdge(PSA, MTA, PSA_MTA);
		g.insertEdge(TNA, MTA, TNA_MTA);
		g.insertEdge(CMA, TNA, CMA_TNA);
		g.insertEdge(MTC, TNA, MTC_TNA);

	}
}

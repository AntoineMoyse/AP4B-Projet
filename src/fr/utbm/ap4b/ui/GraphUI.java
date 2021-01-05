package fr.utbm.ap4b.ui;

import com.brunomnsilva.smartgraph.graph.DigraphEdgeList;
import com.brunomnsilva.smartgraph.graph.Graph;
import com.brunomnsilva.smartgraph.graphview.SmartPlacementStrategy;
import com.brunomnsilva.smartgraph.graphview.SmartGraphPanel;
import com.brunomnsilva.smartgraph.graphview.SmartRandomPlacementStrategy;

import fr.utbm.ap4b.model.Edge;
import fr.utbm.ap4b.model.Vertice;
import javafx.scene.Node;

public class GraphUI implements Displayable {
	Graph<Vertice, Edge> g;
	SmartGraphPanel<Vertice, Edge> graphView;

	public GraphUI() {
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
		    graphView.getStylableVertex(graphVertex.getUnderlyingVertex().element()).setStyleClass("myVertex");
		});
	
		graphView.setEdgeDoubleClickAction(graphEdge -> {
		    System.out.println("Length : " + graphEdge.getUnderlyingEdge().element().getLength());
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
		

		g.insertEdge(MTA, MTB, MTA_MTB);
		g.insertEdge(MTB, MTC, MTB_MTC);
		g.insertEdge(IFA, MTA, IFA_MTA);
		g.insertEdge(PSA, MTA, PSA_MTA);
		g.insertEdge(TNA, MTA, TNA_MTA);
		g.insertEdge(CMA, TNA, CMA_TNA);

	}
}

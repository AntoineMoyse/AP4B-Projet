package fr.utbm.ap4b.ui;

import com.brunomnsilva.smartgraph.graph.DigraphEdgeList;
import com.brunomnsilva.smartgraph.graph.Graph;
import com.brunomnsilva.smartgraph.graphview.SmartPlacementStrategy;
import com.brunomnsilva.smartgraph.graphview.SmartGraphPanel;
import com.brunomnsilva.smartgraph.graphview.SmartCircularSortedPlacementStrategy;

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
		GM.loadGraph(g);
		SmartPlacementStrategy strategy = new SmartCircularSortedPlacementStrategy();
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
			if(GM.putCredit(graphEdge.getUnderlyingEdge().element().getType(), graphEdge.getUnderlyingEdge().element().getLength())) {
				System.out.println("Length : " + graphEdge.getUnderlyingEdge().element().getLength());
			    //graphView.getStylableEdge(graphEdge.getUnderlyingEdge().element()).setStyleClass("myEdge");
			    graphEdge.setStyle("-fx-stroke: " + GM.getCurrentPlayer().getColor() + ";");
			    graphEdge.getUnderlyingEdge().element().setOwner(GM.getCurrentPlayer());
			    GM.getCurrentPlayer().Ajoutpoint(graphEdge.getUnderlyingEdge().element().getLength());
			    update();
			}
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
}

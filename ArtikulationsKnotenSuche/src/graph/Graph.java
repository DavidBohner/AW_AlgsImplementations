package graph;
import java.util.ArrayList;

public class Graph {
	//private GraphNode front;
	private ArrayList<GraphNode> nodeList;
	
	public Graph() {
		//this.front = null;
		this.nodeList = new ArrayList<GraphNode>();
	}
	
	public void addNode(ArrayList<GraphNode> neighbours) {
		GraphNode node = new GraphNode();
		nodeList.add(node);
		if(neighbours == null) return;
		for(GraphNode n: neighbours) {
			n.addNeighbour(node);
			node.addNeighbour(n);
		}
	}
	
	public void addNode(GraphNode node) {
		nodeList.add(node);
	}
	
	public GraphNode getFirst() {
		return nodeList.get(0);
	}
	
	public int getSize() {
		return nodeList.size();
	}
}

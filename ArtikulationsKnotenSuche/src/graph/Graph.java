package graph;
import java.util.ArrayList;

public class Graph {
	//private GraphNode front;
	private ArrayList<GraphNode> nodeList;
	
	public Graph() {
		//this.front = null;
		this.nodeList = null;
	}
	
	public void addNode(ArrayList<GraphNode> neighbours) {
		GraphNode node = new GraphNode();
		nodeList.add(node);
		for(GraphNode n: neighbours) {
			n.addNeighbour(node);
			node.addNeighbour(n);
		}
	}
	
	public GraphNode getFirst() {
		return nodeList.get(0);
	}
	
	public int getSize() {
		return nodeList.size();
	}
}

package graph;
import java.util.ArrayList;

/**
 * Implements a graph data structure for ArtikulationsKnotenSuche to search on.
 * 
 * @author DavidBohner
 */

public class Graph {
	private ArrayList<GraphNode> nodeList;
	
	public Graph() {
		this.nodeList = new ArrayList<GraphNode>();
	}
	
	public Graph(int size) {
		this.nodeList = new ArrayList<GraphNode>();
		for(int i=0; i<size; i++) nodeList.add(new GraphNode());
	}
	
	public void addNode(GraphNode node) {
		nodeList.add(node);
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
	
	public GraphNode getFirst() {
		return nodeList.get(0);
	}
	
	public GraphNode getNode(int i) {
		return nodeList.get(i-1);
	}
	
	public int getSize() {
		return nodeList.size();
	}
	
	public void connect(GraphNode node1, GraphNode node2) {
		node1.addNeighbour(node2);
		node2.addNeighbour(node1);
	}
	
	public void connect(int node1ID, int node2ID) {
		GraphNode node1 = nodeList.get(node1ID - 1);
		GraphNode node2 = nodeList.get(node2ID - 1);
		connect(node1, node2);
	}
	
	public void connect(int node1ID, int[] neighbours) {
		GraphNode node1 = nodeList.get(node1ID-1);
		for(int i=0; i<neighbours.length; i++) connect(node1, nodeList.get(neighbours[i]-1));
	}
}

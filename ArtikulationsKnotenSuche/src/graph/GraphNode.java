package graph;
import java.util.ArrayList;

public class GraphNode {
	private ArrayList<GraphNode> adjList;
	
	public GraphNode() {
		this.adjList = new ArrayList<GraphNode>();
	}
	
	public void addNeighbour(GraphNode node) {
		adjList.add(node);
	}
	
	public void rmNeighbour(GraphNode node) {
		adjList.remove(node);
	}
	
	public ArrayList<GraphNode> adjIter() {
		return adjList;
	}
}

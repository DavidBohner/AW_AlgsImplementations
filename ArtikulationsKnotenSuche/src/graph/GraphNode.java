package graph;
import java.util.ArrayList;

public class GraphNode {
	private ArrayList<GraphNode> adjList;
	public int dfsNum;
	public int dfsLevel;
	public int lowNum;
	
	public GraphNode() {
		this.adjList = new ArrayList<GraphNode>();
		this.dfsNum = Integer.MIN_VALUE;
		this.dfsLevel = Integer.MIN_VALUE;
		this.lowNum = Integer.MIN_VALUE;
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

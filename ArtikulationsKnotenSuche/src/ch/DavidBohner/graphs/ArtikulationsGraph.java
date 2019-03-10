package ch.DavidBohner.graphs;
import ch.sven_pfiffner.graphs.*;
import java.util.LinkedList;

public class ArtikulationsGraph extends Graph {
	private ArtikulationsNode[] nodeArray; //Stores the nodes of the graph as an array
	private LinkedList<ArtikulationsNode>[] adjList; //Stores the graphs connections and vertices as an adjacency list
	
	
	public ArtikulationsGraph(int size) {
		super(size); //Really only there because the compiler hates it when it isn't.
		
		//Fill node array
		for(int i = 0; i<size; i++) {
			this.nodeArray[i] = new ArtikulationsNode(i);
		}
		
		//Create empty adjacency list with corresponding size
		this.adjList = new LinkedList[size];
	}
	
	public LinkedList<Node> getAdjacency(Node n) {
		return adjList[n.getValue()];
	}
	
}

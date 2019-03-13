package ch.DavidBohner.graphs;
import ch.sven_pfiffner.graphs.*;
import java.util.LinkedList;

/**
 * Implements an undirected graph datastructure which provides some lightweight methods to use in for Tarjan's biconnected-finding algorithm
 * 
 * @author Sven Pfiffner
 * @author David Bohner
 */
public class ArtikulationsGraph extends Graph {
	private NodeType[] nodeArray; //Stores the nodes of the graph as an array
	private LinkedList<NodeType>[] adjList; //Stores the graphs connections and vertices as an adjacency list
	
	
	public ArtikulationsGraph(int size) {
		super(size); //Really only there because the compiler hates it when it isn't.
		
		//Fill node array
		for(int i = 0; i<size; i++) {
			this.nodeArray[i] = new ArtikulationsNode(i);
		}
		
		//Create empty adjacency list with corresponding size
		this.adjList = new LinkedList[size];
	}
	
	public int getSize() {
		return nodeArray.length;
	}
	
	public ArtikulationsNode getFirst() {
		if(getSize() == 0) throw new NullPointerException("The graph does not contain any nodes.");
		return nodeArray[0];
	}
	
}


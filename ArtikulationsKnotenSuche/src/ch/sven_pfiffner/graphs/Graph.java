package ch.sven_pfiffner.graphs;

import java.util.LinkedList;

/**
 * Implements an undirected-graph datastructure which provides some lightweight methods to use in graph traversal algorithms
 * 
 * @author Sven Pfiffner
 */
public class Graph {

	private Node[] nodeArray; //Stores the nodes of the graph as an array
	private LinkedList<Node>[] adjList; //Stores the graphs connections and vertices as an adjacency list
	
	/**
	 * Create a new graph with given size and no edges
	 */
	@SuppressWarnings("unchecked")
	public Graph(int size) {
		
		this.nodeArray = new Node[size];
		
		//Fill node array
		for(int i = 0; i<size; i++) {
			this.nodeArray[i] = new Node(i);
		}
		
		//Create empty adjacency list with corresponding size
		this.adjList = new LinkedList[size];
		
	}
	
	/**
	 * Create a new graph from a given adjacency list
	 */
	public Graph(LinkedList<Node>[] adjList) {
		
		this.nodeArray = new Node[adjList.length];
		
		//Fill node array
		for(int i = 0; i<adjList.length; i++) {
			this.nodeArray[i] = new Node(i);
		}
		
		this.adjList = adjList;
	}
	
	/**
	 * Return a list of adjacent nodes to a given node
	 */
	public LinkedList<Node> getAdjacency(Node n) {
		return adjList[n.getValue()];
	}
	
	/**
	 * Return true if two given nodes are connected, false if not
	 */
	public boolean connected(Node x, Node y) {
		return(adjList[x.getValue()].contains(y) && adjList[y.getValue()].contains(x));
	}
	
	/**
	 * Connect two nodes in the graph with an edge
	 */
	public void connectNodes(Node x, Node y) {
		adjList[x.getValue()].add(y);
		adjList[y.getValue()].add(x);
	}
	
	/**
	 * Remove connection between two nodes if there is one. Return true if connection was removed.
	 * If no such connection exists, return false and keep graph as it is
	 */
	public boolean removeConnection(Node x, Node y) {
		
		boolean connectionExists;
		
		if(connectionExists = connected(x,y)) {
			adjList[x.getValue()].remove(y);
			adjList[x.getValue()].remove(x);
		}
		
		return connectionExists;
	}
	
	/**
	 * Return the node corresponding to a given index
	 */
	public Node getNodeByIndex(int i) {
		return nodeArray[i];
	}
}

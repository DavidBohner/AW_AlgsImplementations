package ch.sven_pfiffner.graphs;

/**
 * Implements a data structure for graph nodes. Mainly used in the undirected-graph implementation
 * 
 * @author Sven Pfiffner
 */
public class Node implements NodeType {

	private int value; //The index value of the node
	private int degree; //The current degree of the node
	
	/**
	 * Create a new node with a given index and degree 0
	 */
	public Node(int value) {
		this.value = value;
	}
	
	/**
	 * Create a new node with a given index value and initial degree
	 */
	public Node(int value, int degree) {
		this.value = value;
		this.degree = degree;
	}
	
	/**
	 * Get the current degree of the node
	 */
	public int getDegree() {
		return degree;
	}
	
	/**
	 * Get the index value of the node
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Increase this nodes degree by 1
	 */
	public void incDeg() {
		degree++;
	}
	
	/**
	 * Decrease this nodes degree by 1 if possible.
	 * 
	 * @throws NegativeNodeDegreeException
	 * If degree decreases beyond 0
	 */
	public void decDeg() throws NegativeNodeDegreeException {
		
		int newDeg;
		
		if((newDeg = degree-1)>=0) {
			degree = newDeg;
		}
		else {
			throw new NegativeNodeDegreeException();
		}
	}
	
}

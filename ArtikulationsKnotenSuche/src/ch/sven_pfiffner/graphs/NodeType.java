package ch.sven_pfiffner.graphs;

public interface NodeType {
	public int getValue();
	public int getDegree();
	public void incDeg();
	public void decDeg() throws NegativeNodeDegreeException;
}

package ch.DavidBohner.graphs;
import ch.sven_pfiffner.graphs.*;

public class ArtikulationsNode implements NodeType {
	private int lowNum;
	private int dfsLevel;
	private int dfsNum;
	private int degree;
	private int value;
	
	public ArtikulationsNode(int value) {
		this.value = value;
		this.degree = 0;
	}
	
	public void setLowNum(int lowNum) {
		this.lowNum = lowNum;
	}
	
	public void setDfsLevel(int dfsLevel) {
		this.dfsLevel = dfsLevel;
	}
	
	public void setDfsNum(int dfsNum) {
		this.dfsNum = dfsNum;
	}
	
	public int getLowNum() {
		return lowNum;
	}
	
	public int getDfsLevel() {
		return dfsLevel;
	}
	
	public int getDfsNum() {
		return dfsNum;
	}

	public int getValue() {
		return value;
	}

	public int getDegree() {
		return degree;
	}

	public void incDeg() {
		degree++;
	}

	public void decDeg() throws NegativeNodeDegreeException {
		if(degree == 0) throw new NegativeNodeDegreeException();
		degree--;
	}
	
}

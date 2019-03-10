package ch.DavidBohner.graphs;
import ch.sven_pfiffner.graphs.*;

public class ArtikulationsNode extends Node {
	private int lowNum;
	private int dfsLevel;
	private int dfsNum;
	
	public ArtikulationsNode(int value) {
		super(value);
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
	
}

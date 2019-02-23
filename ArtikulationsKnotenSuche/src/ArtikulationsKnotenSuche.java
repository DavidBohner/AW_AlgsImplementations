import graph.Graph;
import graph.GraphNode;
import java.util.ArrayList;
import java.util.HashSet;

public class ArtikulationsKnotenSuche {
	static Graph graph;
	static ArrayList<GraphNode> artikulationsKnoten;
	static HashSet<GraphNode> visitedKnots;
	
/*	public static void main(String[] args) {
		graph = new Graph();
		
	}*/
	
	public static ArrayList<GraphNode> search() {
		artikulationsKnoten = null;
		if(graph.getSize() == 0) return null;
		
		GraphNode root = graph.getFirst();
		
		//for() {
			
		//}
		
		return artikulationsKnoten;
	}
	
	public static void derp(GraphNode node) {
		for(GraphNode n: node.adjIter()) {
			
		}
	}
}

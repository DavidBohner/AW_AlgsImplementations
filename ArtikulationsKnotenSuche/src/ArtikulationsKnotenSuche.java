import graph.Graph;
import graph.GraphNode;
import java.util.ArrayList;
import java.util.HashSet;

public class ArtikulationsKnotenSuche {
	static Graph graph;
	static HashSet<GraphNode> artikulationsKnoten;
	static HashSet<GraphNode> visitedKnots;
	
	
/*	public static void main(String[] args) {
		graph = new Graph();
		
	}*/
	
	public static HashSet<GraphNode> search() {
		if(graph.getSize() == 0) return new HashSet<GraphNode>();
		
		GraphNode root = graph.getFirst();
		artikulationsKnoten = new HashSet<GraphNode>();
		visitedKnots = new HashSet<GraphNode>();
		
		dfs(root, 1, 0);
		
		//for() {
			
		//}
		
		return artikulationsKnoten;
	}
	
	public static void dfs(GraphNode node, int dfsLevel, int dfsNum) {
		
		ArrayList<GraphNode> toVisit = new ArrayList<GraphNode>();
		node.dfsNum = dfsNum;
		node.dfsLevel = dfsLevel;
		
		/*for(GraphNode n: node.adjIter()) {
			if(!visitedKnots.contains(n)) {
				visitedKnots.add(n);
				toVisit.add(n);
			}
			//if((n.dfsNum != Integer.MIN_VALUE) && (n.dfsNum - 1 != node.dfsNum)) { //If it's not a direct predecessor ...
				//if(node.lowNum > n.dfsNum) {
					
				//}
			//}
		}*/
		
		visitedKnots.add(node);
		
		for(GraphNode n: node.adjIter()) {
			if(!visitedKnots.contains(n)) {
				dfs(n, dfsLevel +1, dfsNum++);
			}
		}
		
		if((dfsLevel == 0) && (toVisit.size() >= 2)) artikulationsKnoten.add(node); 
		
		/*for(GraphNode n: toVisit) {
			dfs(n, dfsLevel +1, dfsNum++);
		}*/
		
		for(GraphNode n: node.adjIter()) {
			if(n.dfsLevel - 1 != node.dfsLevel) {
				if(n.lowNum < node.lowNum) {
					node.lowNum = n.lowNum;
				} else if(n.dfsNum < node.lowNum) {
					node.lowNum = n.dfsNum;
				}
				
				if(n.lowNum >= node.dfsNum) artikulationsKnoten.add(node);
			}
			
		}
	}
}

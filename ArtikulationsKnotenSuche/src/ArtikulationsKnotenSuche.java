import graph.Graph;
import graph.GraphNode;
import java.util.ArrayList;
import java.util.HashSet;

public class ArtikulationsKnotenSuche {
	static Graph graph;
	static HashSet<GraphNode> artikulationsKnoten;
	static HashSet<GraphNode> visitedKnots;
	static int dfsNum;
	
	
/*	public static void main(String[] args) {
		graph = new Graph();
		
	}*/
	
	public static HashSet<GraphNode> search() {
		if(graph.getSize() == 0) return new HashSet<GraphNode>();
		
		GraphNode root = graph.getFirst();
		artikulationsKnoten = new HashSet<GraphNode>();
		visitedKnots = new HashSet<GraphNode>();
		dfsNum = 1;
		
		dfs(root, 1);
		
		//for() {
			
		//}
		
		return artikulationsKnoten;
	}
	
	public static void dfs(GraphNode node, int dfsLevel) {
		//ArrayList<GraphNode> toVisit = new ArrayList<GraphNode>();
		node.dfsNum = dfsNum;
		node.dfsLevel = dfsLevel;
		node.lowNum = dfsLevel;
		
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
				dfsNum++;
				dfs(n, dfsLevel +1);
			}
		}
		
		//if((dfsLevel == 0) && (toVisit.size() >= 2)) artikulationsKnoten.add(node);
		//if((dfsLevel == 0)) artikulationsKnoten.add(node);
		
		/*for(GraphNode n: toVisit) {
			dfs(n, dfsLevel +1, dfsNum++);
		}*/
		if(dfsLevel == 1) {
			int links = 0;
			for(GraphNode n: node.adjIter()) {
				if(n.dfsLevel == 2) links++;
			}
			if(links >= 2) artikulationsKnoten.add(node);
			//if(links >= 2) System.out.println(node.dfsNum);
		} else {
			for(GraphNode n: node.adjIter()) {
				if(n.dfsLevel + 1 != node.dfsLevel) {
					if(n.lowNum < node.lowNum) {
						node.lowNum = n.lowNum;
					} else if(n.dfsNum < node.lowNum) {
						node.lowNum = n.dfsNum;
					}
					
					if(n.lowNum >= node.dfsNum) artikulationsKnoten.add(node);
					//if(n.lowNum >= node.dfsNum) System.out.println(node.dfsNum); 
				}
				
			}
		}
		System.out.println(node.dfsNum + " " + dfsLevel + " " + node.lowNum);
	}
}

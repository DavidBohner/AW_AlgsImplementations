import graph.Graph;
import graph.GraphNode;
import java.util.HashSet;

public class ArtikulationsKnotenSuche {
	static Graph graph;
	static HashSet<GraphNode> artikulationsKnoten;
	static HashSet<GraphNode> visitedKnots;
	static int dfsNum;
	
	
	public static HashSet<GraphNode> search(Graph inputGraph) {
		graph = inputGraph;
		if(graph.getSize() == 0) return new HashSet<GraphNode>();
		
		GraphNode root = graph.getFirst();
		artikulationsKnoten = new HashSet<GraphNode>();
		visitedKnots = new HashSet<GraphNode>();
		dfsNum = 1;
		
		dfs(root, 1);
		
		
		return artikulationsKnoten;
	}
	
	public static void dfs(GraphNode node, int dfsLevel) {
		node.dfsNum = dfsNum;
		node.dfsLevel = dfsLevel;
		node.lowNum = dfsNum;
		
		
		visitedKnots.add(node);
		
		for(GraphNode n: node.adjIter()) {
			if(!visitedKnots.contains(n)) {
				dfsNum++;
				dfs(n, dfsLevel +1);
			}
		}
		
		if(dfsLevel == 1) {
			int links = 0;
			for(GraphNode n: node.adjIter()) {
				if(n.dfsLevel == 2) links++;
			}
			if(links >= 2) artikulationsKnoten.add(node);
		} else {
			for(GraphNode n: node.adjIter()) {
				if(n.dfsLevel + 1 != node.dfsLevel) {
					if(n.lowNum < node.lowNum) {
						node.lowNum = n.lowNum;
					} else if(n.dfsNum < node.lowNum) {
						node.lowNum = n.dfsNum;
					}
					
				}
				if(n.dfsLevel - 1 == node.dfsLevel) {
					if(n.lowNum >= node.dfsNum) artikulationsKnoten.add(node);
				}
			}
		}
	}
}

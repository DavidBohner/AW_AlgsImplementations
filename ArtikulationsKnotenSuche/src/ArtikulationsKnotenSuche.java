import ch.DavidBohner.graphs.*;
import ch.sven_pfiffner.graphs.NodeType;
import java.util.HashSet;

public class ArtikulationsKnotenSuche {
	static ArtikulationsGraph graph;
	static HashSet<ArtikulationsNode> artikulationsKnoten;
	static HashSet<ArtikulationsNode> visitedKnots;
	static int dfsNum;
	
	
	public static HashSet<ArtikulationsNode> search() {
		if(graph.getSize() == 0) return new HashSet<ArtikulationsNode>();
		
		ArtikulationsNode root = (ArtikulationsNode) graph.getFirst();
		artikulationsKnoten = new HashSet<ArtikulationsNode>();
		visitedKnots = new HashSet<ArtikulationsNode>();
		dfsNum = 1;
		
		dfs(root, 1);
		
		
		return artikulationsKnoten;
	}
	
	public static void dfs(ArtikulationsNode node, int dfsLevel) {
		node.setDfsNum(dfsNum);
		node.setDfsLevel(dfsLevel);
		node.setLowNum(dfsNum);
		
		
		visitedKnots.add(node);
		
		for(ArtikulationsNode n: graph.getAdjacency(node)) {
			if(!visitedKnots.contains(n)) {
				dfsNum++;
				dfs(n, dfsLevel +1);
			}
		}
		
		if(dfsLevel == 1) {
			int links = 0;
			for(ArtikulationsNode n: graph.getAdjacency(node)) {
				if(n.getDfsLevel == 2) links++;
			}
			if(links >= 2) artikulationsKnoten.add(node);
		} else {
			for(ArtikulationsNode n: node.adjIter()) {
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

import static org.junit.jupiter.api.Assertions.*;
import graph.Graph;
import graph.GraphNode;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ArtikulationsKnotenSucheTest {

	@Test
	void testSearch() {
		Graph graph = new Graph(12);
		
		graph.connect(1, new int[] {2, 9, 10});
		graph.connect(2, new int[] {3, 9});
		graph.connect(3, new int[] {4, 8, 9});
		graph.connect(4, new int[] {5});
		graph.connect(5, new int[] {6, 8});
		graph.connect(6, new int[] {7, 8});
		graph.connect(7, new int[] {8});
		graph.connect(10, new int[] {11, 12});
		graph.connect(11, new int[] {12});
		
		
		HashSet<GraphNode> output = ArtikulationsKnotenSuche.search(graph);
		assertTrue(output.contains(graph.getNode(1)));
		assertTrue(output.contains(graph.getNode(3)));
		assertTrue(output.contains(graph.getNode(10)));
		assertFalse(output.contains(graph.getNode(9)));
	}

	@Test
	void testDfs() {
		Graph graph = new Graph(10);
		graph.connect(1, 2);
		graph.connect(2, new int[] {3, 5});
		graph.connect(3, 4);
		graph.connect(4, new int[] {6, 7});
		graph.connect(8, new int[] {6, 7});
		graph.connect(9, 10);
		
		//Setting up environment manually, would normally be handled by ArtikulationsKnotenSuche.search()
		ArtikulationsKnotenSuche.visitedKnots = new HashSet<GraphNode>();
		ArtikulationsKnotenSuche.artikulationsKnoten = new HashSet<GraphNode>();
		ArtikulationsKnotenSuche.dfsNum = 1;
		
		ArtikulationsKnotenSuche.dfs(graph.getNode(2), 1);
		
		assertTrue(graph.getNode(2).dfsNum == 1);
		assertTrue(graph.getNode(8).dfsNum == 6);
		assertTrue(graph.getNode(5).dfsNum == 8);
		assertTrue(ArtikulationsKnotenSuche.visitedKnots.contains(graph.getNode(1)));
		assertFalse(ArtikulationsKnotenSuche.visitedKnots.contains(graph.getNode(10)));
	}
}

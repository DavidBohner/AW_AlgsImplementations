import static org.junit.jupiter.api.Assertions.*;
import graph.Graph;
import graph.GraphNode;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ArtikulationsKnotenSucheTest {

	@Test
	void testSearch() {
		Graph graph = new Graph();
		GraphNode[] nodes = new GraphNode[13];
		ArtikulationsKnotenSuche.graph = new Graph();
		
		for(int i=1; i<nodes.length; i++) {
			nodes[i] = new GraphNode();
			ArtikulationsKnotenSuche.graph.addNode(nodes[i]);
		}
		
		neighbourHandle(nodes[1], new GraphNode[] {nodes[2], nodes[9], nodes[10]});
		neighbourHandle(nodes[2], new GraphNode[] {nodes[1], nodes[3], nodes[9]});
		neighbourHandle(nodes[3], new GraphNode[] {nodes[2], nodes[4], nodes[8], nodes[9]});
		neighbourHandle(nodes[4], new GraphNode[] {nodes[3], nodes[5]});
		neighbourHandle(nodes[5], new GraphNode[] {nodes[4], nodes[6], nodes[8]});
		neighbourHandle(nodes[6], new GraphNode[] {nodes[5], nodes[7], nodes[8]});
		neighbourHandle(nodes[7], new GraphNode[] {nodes[6], nodes[8]});
		neighbourHandle(nodes[8], new GraphNode[] {nodes[3], nodes[5], nodes[6], nodes[7]});
		neighbourHandle(nodes[9], new GraphNode[] {nodes[1], nodes[2], nodes[3]});
		neighbourHandle(nodes[10], new GraphNode[] {nodes[1], nodes[11], nodes[12]});
		neighbourHandle(nodes[11], new GraphNode[] {nodes[10], nodes[12]});
		neighbourHandle(nodes[12], new GraphNode[] {nodes[10], nodes[11]});
		
		HashSet<GraphNode> output = ArtikulationsKnotenSuche.search();
		System.out.println(output.size());
		assertTrue(output.contains(nodes[1])); //TODO visitedKnots not being populated
		assertTrue(output.contains(nodes[3]));
		assertTrue(output.contains(nodes[10]));
		assertFalse(output.contains(nodes[9]));	}

	@Test
	void testDfs() {
		fail("Not yet implemented");
	}

	
	public void neighbourHandle(GraphNode node, GraphNode[] neighbours) {
		for(GraphNode n: neighbours) {
			node.addNeighbour(n);
		}
	}
}

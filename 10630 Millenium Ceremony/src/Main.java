import java.util.Scanner;
import davidbohner.graph.graphs.*;
import davidbohner.graph.nodes.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int t0=0; t0<t; t0++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			
			int[][][] edges = new int[n-1][m][k];
			Graph<int[]> graph = new Graph<int[]>(1);
			graph.addNode(new Node<int[]>(new int[] {0, 1})); //Base Node
			
			for(int i=0; i<n-1; i++) {
				for(int j=0; j<m; j++) {
					for(int l=0; l<k; l++) {
						edges[i][j][l] = scanner.nextInt();
					}
					Node<int[]> node = new Node<int[]>(new int[] {i+1, j+1});
					graph.addNode(node);
				}
			}
			for(int j=0; j<m; j++) {
				graph.addNode(new Node<int[]>(new int[] {n, j+1}));
			}
			
			graph.addNode(new Node<int[]>(new int[] {n+1, 1})); //Torch Node
			buildGraph(n, m, k, edges, graph);
			solver(n, m, k, graph);
		}
		scanner.close();
	}
	
	public static void buildGraph(int n, int m, int k, int[][][] edges, Graph<int[]> graph) {
		for(int j=0; j<m; j++) {
			graph.connectBidirectional(1, 2+j);
		}
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<m; j++) {
				int node1ID = 1 + (i) * m + (j + 1);
				for(int l=0; l<k; l++) {
					int node2ID = 1 + (i+1) * m + edges[i][j][l]; //No +1 since edges[][][] already starts at 1.
					graph.connectBidirectional(node1ID, node2ID);
				}
			}
		}
		for(int j=0; j<m; j++) {
			graph.connectBidirectional(n*m+2, (n-1)*m+j+1);
		}
	}
	
	public static void solver(int n, int m, int k, Graph<int[]> graph) {
		
	}
}

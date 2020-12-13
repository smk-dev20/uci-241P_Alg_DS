/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
//Reference URL : https://www.quora.com/What-is-an-algorithm-to-convert-from-
	//an-adjacency-list-to-an-incidence-matrix?share=1
import java.util.ArrayList;

public class GraphDS {

	static void generateAdjacencyList(int[][] adjacencyMatrix) {
		int n = adjacencyMatrix.length;
		int m = 0; // number of edges
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++)
			adjacencyList.add(new ArrayList<Integer>());

		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[0].length; j++) {
				if (adjacencyMatrix[i][j] == 1) {
					m++;
					adjacencyList.get(i).add(j);
				}

			}
		}
        System.out.println("ADJACENCY LIST");
		for (int vertex = 0; vertex < adjacencyList.size(); vertex++) {
			System.out.print(" " + (vertex+1) + " -> ");
			for (Integer v : adjacencyList.get(vertex)) {
				System.out.print(" " + (v+1) + " ");
			}
			System.out.println();
		}
		generateIncidenceMatrix(adjacencyList, m / 2);
	}

	static void generateIncidenceMatrix(ArrayList<ArrayList<Integer>> adjList, int edges) {
		int vertices = adjList.size();

		ArrayList<ArrayList<Integer>> uniqueEdges = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertices; i++)
			uniqueEdges.add(new ArrayList<Integer>());


		int[][] edgesArray = new int[edges][2];
		int e = 0;
		for (int i = 0; i < vertices; i++) {
			int start_vertex = i;
			for (Integer end_vertex : adjList.get(start_vertex)) {
				if (!(uniqueEdges.get(end_vertex).contains(start_vertex))) {
					uniqueEdges.get(start_vertex).add(end_vertex);
					edgesArray[e][0] = start_vertex;
					edgesArray[e][1] = end_vertex;
					e++;
				}
			}
		}

		int[][] incidenceMatrix = new int[vertices][edges];
		for (int i = 0; i < edges; i++) {
			int start_vertex = edgesArray[i][0];
			int end_vertex = edgesArray[i][1];
			incidenceMatrix[start_vertex][i] = 1;
			incidenceMatrix[end_vertex][i] = 1;
		}

		System.out.println("INCIDENCE MATRIX");
		System.out.print("\t");
		for (int p = 1; p <= edges; p++)
			System.out.print(p + "\t");
		System.out.println();
		for (int i = 0; i < incidenceMatrix.length; i++) {
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < incidenceMatrix[0].length; j++)
				System.out.print((incidenceMatrix[i][j]) + "\t");
			System.out.println();
		}

		convertToAdjacencyList(incidenceMatrix);
	}

	static void convertToAdjacencyList(int[][] IMatrix) {
		int vertices = IMatrix.length;
		int edges = IMatrix[0].length;

		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertices; i++)
			adjList.add(new ArrayList<Integer>());
		int start_index = -1;
		int end_index = -1;
		for (int j = 0; j < edges; j++) {

			for (int i = 0; i < vertices; i++) {
				if (IMatrix[i][j] == 1) {
					start_index = i;
					int col = i + 1;
					while (col != vertices) {
						if (IMatrix[col][j] == 1) {
							end_index = col;
							break;
						}
						col++;
					}
					adjList.get(start_index).add(end_index);
					adjList.get(end_index).add(start_index);
					break;
				}

			}

		}
		
		System.out.println("CONVERTED ADJACENCY LIST");
		for (int vertex = 0; vertex < adjList.size(); vertex++) {
			System.out.print(" " + (vertex+1) + " -> ");
			for (Integer v : adjList.get(vertex)) {
				System.out.print(" " + (v+1) + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		int n = 10; // number of vertices
		int[][] graphEdges = { { 1, 2 }, { 1, 4 }, { 1, 9 }, { 2, 4 }, { 2, 3 }, { 2, 5 }, { 3, 5 }, { 3, 6 }, { 4, 5 },
				{ 4, 7 }, { 5, 6 }, { 5, 7 }, { 5, 8 }, { 6, 8 }, { 7, 8 }, { 7, 9 }, { 7, 10 }, { 8, 10 }, { 9, 10 } };

		int[][] adjacencyMatrix = new int[10][10];
		for (int i = 0; i < graphEdges.length; i++) {
			adjacencyMatrix[graphEdges[i][0] - 1][graphEdges[i][1] - 1] = 1;
			adjacencyMatrix[graphEdges[i][1] - 1][graphEdges[i][0] - 1] = 1;
		}
		 System.out.println("ADJACENCY MATRIX");
		  System.out.print("  "); for(int i=1;i<=n;i++) System.out.print(" "+i+" ");
		  System.out.println(); for(int i=0 ; i<adjacencyMatrix.length;i++) {
		  System.out.print(i+1+" "); for(int j=0;j<adjacencyMatrix[0].length;j++) {
		  System.out.print(" "+adjacencyMatrix[i][j]+" "); } System.out.println(); }
		 
		generateAdjacencyList(adjacencyMatrix);
	}
}
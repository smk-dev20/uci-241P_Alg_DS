import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
//ReferenceURL:https://algocoding.wordpress.com/2014/08/25/depth-first-search-java-and-python-implementation/
//https://www.thejavaprogrammer.com/breadth-first-search-bfs-java-program/
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

public class GraphAlgorithms{
	static final HashMap<Integer,Character>nodeNum = new HashMap<Integer,Character>();

	//sorts adjacent nodes so we traverse in alphabetical order
	public static ArrayList<Integer> sortNodes(ArrayList<Integer> nodes){
		ArrayList<Integer> sorted = new ArrayList<Integer>(nodes.size());
		if(nodes.size()==0)
			return sorted;

		int min_index;
		
		for(int i=0;i<nodes.size();i++) {
			min_index = i;
			for(int j=i+1;j<nodes.size();j++) {
				if(nodes.get(j)<nodes.get(min_index)) {
					min_index = j;
				}
			}
			int temp = nodes.get(i);
			sorted.add(i,nodes.get(min_index));
			sorted.add(min_index,temp);
		}
		return sorted;
	}
	
	public static ArrayList<Integer> breadthFirstSearch(ArrayList<ArrayList<Integer>>graph,int start_node){
		//list to hold bfsOrder of nodes
		ArrayList<Integer> bfsOrder = new ArrayList<Integer>(graph.size());
		
		//queue to keep track of order of nodes visited(FIFO)
		Queue<Integer> queue = new LinkedList();
		
		//boolean array to keep track if node is processed or not
		boolean processed[] = new boolean[graph.size()];
		
		int current_node = start_node;
		queue.add(current_node);
		processed[current_node] = true;
		
		while(!queue.isEmpty()) {
			current_node = queue.poll();
			bfsOrder.add(current_node);
			
			ArrayList<Integer> adjacent_nodes = sortNodes(graph.get(current_node));
			
			for(Integer node : adjacent_nodes) {
				int next_node=node;
				if(processed[next_node]==false) {
					processed[next_node] = true;
					queue.add(next_node);
				}			
			}	
		}
			
		return bfsOrder;
	}

	public static ArrayList<Integer> depthFirstSearch(ArrayList<ArrayList<Integer>>graph,int start_node){
		//list to store dfs traversal order
		ArrayList<Integer> dfsOrder = new ArrayList<Integer>(graph.size());
	    //stack to maintain most recently visited node (LIFO)
		Stack<Integer> stack = new Stack<Integer>();
	    boolean[] processed = new boolean[graph.size()];
	    
	    int current_node = start_node;
	    stack.push(current_node);
	    
	    while(!stack.isEmpty()) {
	    	current_node = stack.pop();
	    	
	    	if(processed[current_node]==false) {
	    		dfsOrder.add(current_node);
	    		processed[current_node]=true;
	    	}
	    	//stack to maintain adjacent nodes 
	    	Stack<Integer> adjStack = new Stack<Integer>();
			ArrayList<Integer> adjacent_nodes = sortNodes(graph.get(current_node));
			for(Integer node : adjacent_nodes) {
				int next_node=node;
				if(processed[next_node]==false)
					adjStack.push(next_node);			
			}
			while(!adjStack.isEmpty()){
				stack.push(adjStack.pop());
			}
	    }			
		return dfsOrder;
	}
	
	public static void main(String[] args) {
		
		//Store in map the numbers corresponding to node names
		nodeNum.put(1,'A');
		nodeNum.put(2,'B');
		nodeNum.put(3,'C');
		nodeNum.put(4,'D');
		nodeNum.put(5,'E');
		nodeNum.put(6,'F');
		nodeNum.put(7,'G');
		nodeNum.put(8,'H');
		nodeNum.put(9,'I');
		nodeNum.put(10,'J');
		
		int num_vertices = nodeNum.size();
		int start_node = 0;

		int[][] graphEdges = { { 1, 2 }, { 1, 4 }, { 1, 9 }, { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 5 }, { 3, 6 }, { 4, 5 },
				{ 4, 7 }, { 5, 6 }, { 5, 7 }, { 5, 8 }, { 6, 8 }, { 7, 8 }, { 7, 9 }, { 7, 10 }, { 8, 10 }, { 9, 10 } };

		
		//initialize adjacency list
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num_vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < graphEdges.length; i++) {
			graph.get((graphEdges[i][0]-1)).add(graphEdges[i][1]-1);
			graph.get((graphEdges[i][1]-1)).add(graphEdges[i][0]-1);
		}
		
        System.out.println("ADJACENCY LIST");
		for (int vertex = 0; vertex < graph.size(); vertex++) {
			System.out.print(" " + nodeNum.get((vertex+1)) + " -> ");
			for (Integer v : graph.get(vertex)) {
				System.out.print(" " + (nodeNum.get(v+1)) + " ");
			}
			System.out.println();
		}
		
		
		ArrayList<Integer> BFSResult = breadthFirstSearch(graph,start_node);
		
		System.out.println("BFS ORDER :");
		for(Integer node : BFSResult) {
			System.out.print(" "+nodeNum.get(node+1));
		}
		ArrayList<Integer> DFSResult = depthFirstSearch(graph,start_node);
		
		System.out.println("\nDFS ORDER :");
		for(Integer node : DFSResult) {
			System.out.print(" "+nodeNum.get(node+1));
		}

	}
}
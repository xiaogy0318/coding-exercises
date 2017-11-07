import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class FindPath {
	private static Point origin, dest;
	public static void main(String[] args) throws IOException {
		
		//Read test case no
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNo = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < testCaseNo; i++) {
			//Read dimensioon of the matrix
			int N = Integer.parseInt(reader.readLine());
			
			//Read the content of the matrix
			//Todo: check validity against N, and illegal situations...
			String[] matrixString = reader.readLine().split(" ");
			int[] matrix = new int[matrixString.length];
			for (int a = 0; a < matrixString.length; a++) {
				matrix[a] = Integer.parseInt(matrixString[a]);
			}
			
			//Now construct the Graph
			HashMap <Point, LinkedList> graph = new HashMap <Point, LinkedList>();
			
			// Model the graph
			// borrow Point from awt to act as the vertex
			// a LinkedList of vertex as adjacent vertexes
			// Parse the input
			for (int j = 0; j < matrix.length; j++) {
				int x = j % N;
				int y = j / N;
				//System.out.println("x = " + x + ", y = " + y);
				
				Point vertex = new Point(x, y);
				graph.put(vertex, null); // Now all vertexes are in the graph, but not the edges yet.
				//Todo: fix the compile warning...
				
				//identify O/D
				if (1 == matrix[j]) {
					origin = new Point(x, y);
				}
				
				if (2 == matrix[j]) {
					dest = new Point(x, y);
				}
			}
			//System.out.println("The origin is: " + origin + ", the dest is: " + dest);
			//System.out.println("The graph is: " + graph);
			
			//Test Point is unique. Test good!
			graph.put(new Point(0,0), null);
			//System.out.println("The graph is: " + graph);
			
			
			// Now build up the edges
			// For any vertex, if its value is 0 or if the test vertex's value is 0, then no connectivity. Otherwise there is connectivity
			// Test connectivity with left, right, up and down respectively
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					/* refactor below into a common function
					// Left
					if (x - 1 < 0) {
						// index out of bound, no connectivity
						continue;
					}
					
					if (matrix[x - 1] * N + y == 0 || matrix[x * N + y] == 0) {
						// no connectivity
					}
					else {
						// yes, there is connectivity, build it
						LinkedList <Point> list = graph.get(new Point(x, y));
						if (list == null) {
							list = new LinkedList();
						}
						list.add(new Point(x - 1, y));
						graph.put(new Point(x, y), list); 
					}
					*/
					
					// Test connectivity and add into graph
					buildConnectivity(x, y, x - 1, y, matrix, N, graph); //left
					buildConnectivity(x, y, x + 1, y, matrix, N, graph); //right
					buildConnectivity(x, y, x, y - 1, matrix, N, graph); //up
					buildConnectivity(x, y, x, y + 1, matrix, N, graph); //down


				}
			}
			//System.out.println("The graph is: " + graph);
			
			int result = BST(origin, dest, graph);
			System.out.println(result);
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static boolean buildConnectivity(int x, int y, int x2, int y2, int[] matrix, int N, HashMap <Point, LinkedList> graph) {

		boolean result = false;
		if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= N) {
			// index out of bound, no connectivity
			return false;
		}
		
		if (matrix[x2 + y2 * N] == 0 || matrix[x + y * N] == 0) {
			// no connectivity
			return false;
		}
		else {
			 
			// yes, there is connectivity, build it
			LinkedList list = graph.get(new Point(x, y));
			if (list == null) {
				list = new LinkedList <Point> ();
			}
			list.add(new Point(x2, y2));
			graph.put(new Point(x, y), list); 

			result = true;
			
		}
		
		return result;

	}

	private static int BST(Point origin, Point dest, HashMap <Point, LinkedList> graph) {
		HashSet <Point> visited = new HashSet <Point>();
		
		LinkedList <Point> queue = new LinkedList <Point>();
		
		// Now start from origin!
		queue.add(origin);
		visited.add(origin);
		
		while(!queue.isEmpty()) {
			Point vertex = queue.poll(); // Now get the item from queue for processing
			LinkedList list = graph.get(vertex); // get the adjacent items
			
			if (list != null) {
				Iterator it = list.iterator();
				while(it.hasNext()) {
					
					// Test if it's the origin
					Point next = (Point)it.next();
					
					if(visited.contains(next)) {// already visited, skip
						continue;
					}
					
					if (next.equals(dest)) {
						// Job done, finish
						return 1;
					}
					//System.out.print("Connection from " + vertex + " to "+ next);
					queue.add(next);
					visited.add(next);
				}
			}
		}
		
		return 0;
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static String[] vertices;     // The sorted list of vertex names
	static AdjListNode[] adjList; // The adjacency list
	
	
	public static String[] topSort() {  
		    String[] topArr = new String[vertices.length];
		    int[] inDegree = new int[vertices.length];
		    Queue<Integer> queue = new ArrayDeque<Integer>();

		    // Preprocess-1: loop through adjList to capture indegrees for each vertices

		    for (int i = 0; i < adjList.length; i++) {
		      AdjListNode temp = adjList[i];
		      while (temp != null) {
		        inDegree[temp.v]++;
		        temp = temp.next;
		      } // end while
		    } // end preprocess-1

		    

		    // Preprocess-2: loop through inDegree array for initial population of queue

		    for (int i = 0; i < adjList.length; i++) {
		      if (inDegree[i] == 0) {
		        queue.add(i);
		        inDegree[i] = -1;
		      }
		    } // end preprocess-2

		    


		    for (int i = 0; i < vertices.length; i++) {
		      if (queue.peek() == null) 
		        return new String[vertices.length];
		      else {  
		        int e = queue.remove();
		        topArr[i] = vertices[e];
		        AdjListNode temp = adjList[e];
		        while (temp != null) {
		          inDegree[temp.v]--;
		          if (inDegree[temp.v] == 0) {
		            queue.add(temp.v);
		          } 
		          temp = temp.next;
		        } }
		    }
		    return topArr; 
		   }
    
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 1) {
			System.err.println("Incorrect number of args passed");
			System.exit(-1);
		}
		Scanner fileIn = new Scanner(new File(args[0]));
		vertices = ReadGraph.readVertices(fileIn);
		adjList = ReadGraph.readEdgesAdjList(fileIn);
		String[] sorted = topSort();
		/*for(int i=0; i<sorted.length; i++) {
			System.out.println(sorted[i]);
		}*/
		
		
	}
}
import java.util.Scanner;
import java.util.Arrays;

public class ReadGraph {
	private static String[] vertices;
	private static AdjListNode[] returnListGlobal;
	
	
	public static String[] readVertices(Scanner fileIn) {
		int numberOfVertices = fileIn.nextInt();
		String[] returnString= new String[numberOfVertices];
		for(int i = 0; i<numberOfVertices; i++) {
			returnString[i] = fileIn.next();
		}
		Arrays.sort(returnString);
		vertices=returnString;
		return returnString;
		
	}
			

	public static AdjListNode[] readEdgesAdjList(Scanner fileIn) {
		/*int numberOfVertices = fileIn.nextInt();
		AdjListNode[] returnList = new AdjListNode[numberOfVertices];
		String[] vertexList= new String[numberOfVertices];
		for(int i = 0; i<numberOfVertices; i++) {
			String nextIn = fileIn.next();
			vertexList[i] = nextIn;
		}
		Arrays.sort(vertexList);*/
		returnListGlobal= new AdjListNode[vertices.length];
		while(fileIn.hasNext()==true) {
			int vertexListIndex= Arrays.binarySearch(vertices,  fileIn.next());
			int secondArg= Arrays.binarySearch(vertices, fileIn.next());
			int weightVal= fileIn.nextInt();
			returnListGlobal[vertexListIndex] = new AdjListNode(secondArg,weightVal, returnListGlobal[vertexListIndex]);
					
		}
		//returnListGlobal=returnList;
		return returnListGlobal;
				
/*				
		String throwOut;
		for(int i = 0; i<numberOfVertices; i++){
			throwOut = fileIn.next();
		}
		for(int j=0; j<numberOfVertices; j++){
			int vertexListIndex = Arrays.binarySearch(vertexList, fileIn.next());
			int secondArgument = Arrays.binarySearch(vertexList, fileIn.next());
			int weightValue = fileIn.nextInt();
			arrayOfLinkedLists[vertexListIndex]= new AdjListNode(secondArgument,weightValue, 
					arrayOfLinkedLists[vertexListIndex]);
		}
		return arrayOfLinkedLists;
	}*/
	}
	
	

}

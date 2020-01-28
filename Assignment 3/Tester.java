import java.util.PriorityQueue;
import java.util.Random;

public class Tester<C> {

	
	public static<C> void main(String[] args) {
		int N = 100;
		PQasSortedArray<Double> pq1 = new PQasSortedArray<Double>(N);
		PriorityQueue<Double> pq2 = new PriorityQueue<Double>(N);
		double[] arr1 = new double[N];
		double[] arr2 = new double[N];
		for(int i = 0; i < arr1.length; i++){
			Random rand = new Random();
			arr1[i] = rand.nextDouble();
			arr2[i] = arr1[i];
		}
		

		long startTime, endTime;
		startTime = System.nanoTime();

		for (int i=0; i < arr1.length; i++){
			pq1.insert(arr1[i]);
		}
		for (int i=arr1.length-1; i >=0 ; i--){
			arr1[i] = (double) pq1.deleteMin();
		}

		endTime = System.nanoTime();
		System.out.println("PQasSortedArray implementation took " + ((endTime - startTime)/1000000) + " time units");

		long startTime2, endTime2;
		startTime2 = System.nanoTime();

		for (int i=0; i < arr2.length; i++){
			pq2.offer(arr2[i]); 
		}
		for (int i=arr2.length-1; i >=0 ; i--){
			arr2[i] = (double) pq2.poll();
		}

		endTime2 = System.nanoTime();
		System.out.println("JavaUtil implementation took " + ((endTime2 - startTime2)/1000000) + " time units");
	}
	
	
	
	
	
	}
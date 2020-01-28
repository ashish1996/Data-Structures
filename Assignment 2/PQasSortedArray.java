
public class PQasSortedArray<C extends Comparable<?super C>> {
	private C[] arr; // store the elements in the priority queue IN SORTED ORDER
	private int currentSize;
	
	
	
	@SuppressWarnings("unchecked")
	public PQasSortedArray(int size){
		arr = (C[]) new Comparable[size];
		currentSize = 0;
	}
	public boolean isFull(){
		return currentSize == arr.length;
		}
	
	public boolean isEmpty(){
		return currentSize == 0;
		}
	
	public void insert(C data){ //fill in the details here
		if(currentSize==arr.length){
		System.out.println("cannot insert anymore because queue is full");
	}else{
	//bubble sort the elements
	arr[currentSize] = data;
	C tmp = arr[currentSize];
	currentSize++;
	for(int i=currentSize-1; i>0 && tmp.compareTo(arr[i-1]) > 0;i--){
	C temp = arr[i];
	arr[i] = arr[i-1];
	arr[i-1] = temp;
	}
	}

	}
	
	public C min(){//fill in the details here
		
		return arr[currentSize-1];
		
	}
	public C deleteMin(){//fill in the details here
		
		C returnValue = arr[currentSize-1];
	
		currentSize--;
		C tmp = arr[0];
		
			for(int i=currentSize-1; i>0 && tmp.compareTo(arr[i-1]) < 0;i--){
		
			C temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
			}
	
	return returnValue;
	}
	  public static void main(String[] args) {
          PQasSortedArray test = new PQasSortedArray(10);
          if(test.isEmpty() == true) {
        	  System.out.println("isEmpty method works!"); 	  
          }
          test.insert(10);
          System.out.println(test.min());
          test.insert(9);
          System.out.println(test.min());

          test.insert(8);
          System.out.println(test.min());

          test.insert(7);
          System.out.println(test.min());

          test.insert(6);
          System.out.println(test.min());

          test.insert(5);
          System.out.println(test.min());

          test.insert(4);
          System.out.println(test.min());

          test.insert(3);
          System.out.println(test.min());

          test.insert(2);
          System.out.println(test.min());

          test.insert(1);
          System.out.println(test.min());

          
       
          
        
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());  
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
          System.out.println(test.deleteMin());
	  }
}
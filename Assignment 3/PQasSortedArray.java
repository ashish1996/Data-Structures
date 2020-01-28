public class PQasSortedArray<C extends Comparable<?super C>> implements PQ<C> {



	private C[] arr; // store the elements in the priority queue IN SORTED ORDER
	private int currentSize;
	private int maxItems;
	private int sizeCounter;



	@SuppressWarnings("unchecked")
	public PQasSortedArray(int size){
		arr = (C[]) new Comparable[size];
		currentSize = 0;
		maxItems = size;
		sizeCounter = 0;
	}
	
	
	public boolean isFull(){
		return sizeCounter==maxItems;
		}
	
	
	public boolean isEmpty(){
		return currentSize == 0;
		}
	
	public void insert (C data) {
		
		if(currentSize == arr.length-1) {
			enlargeArray(arr.length*2+1);
		}
		int hole = ++currentSize;
		for(arr[0]=data; data.compareTo(arr[hole/2])<0;hole/=2) {
			arr[hole] = arr[hole/2];
		}
		arr[hole]=data;
		sizeCounter++;
		
	}
	
	 private void enlargeArray( int newSize )
	    {
	            C [] old = arr;
	            arr = (C []) new Comparable[ newSize ];
	            for( int i = 0; i < old.length; i++ )
	                arr[ i ] = old[ i ];        
	    }
	
	public C min(){
		/*fill in the details here*/
		return arr[1];
		}
	
	
	public C deleteMin( )
    {
       

        C minItem = min();
        arr[ 1 ] = arr[ currentSize-- ];
        percolateDown( 1 );
        sizeCounter--;
        return minItem;
        
    }
	
	private void percolateDown( int hole )
    {
        int child;
        C tmp = arr[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    arr[ child + 1 ].compareTo( arr[ child ] ) < 0 )
                child++;
            if( arr[ child ].compareTo( tmp ) < 0 )
                arr[ hole ] = arr[ child ];
            else
                break;
        }
        arr[ hole ] = tmp;
    }

	
	/*public C deleteMin(){
		
		 C temp = arr[0];
	      --maxItems;
	      if (maxItems > 0)
	      {
	         arr[0] = arr[maxItems];
	         trickleDown(0);
	      }
	      return temp;
		}
	
	 private void trickleDown(int itemPosition)
	   {
	      int child;                        // Index of the larger child.
	      if (2*itemPosition+1 >= maxItems)
	      {
	         child = itemPosition;          // Leaf node (no children).
	      }
	      else if (2*itemPosition+2 == maxItems)
	      {
	         child = 2*itemPosition+1;      // One child (at the left).
	      }
	      else if (arr[2*itemPosition+1].compareTo(arr[2*itemPosition+2])==1)
	      {
	         child = 2*itemPosition+1;      // Two children w/ larger on the left.
	      }
	      else
	      {
	         child = 2*itemPosition+2;      // Two children w/ larger on the right.
	      }
	      if (arr[itemPosition].compareTo( arr[child])==-1)
	      {
	         C temp = arr[itemPosition];
	         arr[itemPosition] = arr[child];
	         arr[child] = temp;
	         trickleDown(child);
	      }
	   } */
	 
	 
	 public static void main(String[] args) {
		 
		 PQasSortedArray testArray= new PQasSortedArray(10);
		 
		 if(testArray.isEmpty() == true) {
			 System.out.println("isEmpty method works!");
		 } else {
			 System.out.println("isEmpty method does not work!");
		 }
		 
		 testArray.insert(5);
		 System.out.println(testArray.min());
		 testArray.insert(2);
		 System.out.println(testArray.min());
		 testArray.insert(4);
		 System.out.println(testArray.min());
		 testArray.insert(8);
		 System.out.println(testArray.min());
		 testArray.insert(3);
		 System.out.println(testArray.min());
		 testArray.insert(10);
		 System.out.println(testArray.min());
		 testArray.insert(5);
		 System.out.println(testArray.min());
		 testArray.insert(7);
		 System.out.println(testArray.min());
		 testArray.insert(1);
		 System.out.println(testArray.min());
		 testArray.insert(2);
		 System.out.println(testArray.min());
		 
		 if(testArray.isFull() == true) {
			 System.out.println("isFull method works!");
		 } else {
			 System.out.println("isFull method does not work!");
		 }
		 
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 System.out.println(testArray.min());
		 testArray.deleteMin();
		 
		 if(testArray.isEmpty() == true) {
			 System.out.println("isEmpty method works!");
		 } else {
			 System.out.println("isEmpty method does not work!");
		 }
	 }
	
}
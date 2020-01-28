package programmingAssignment1;

public class VipQueue<T> {
	private int capacity;
	private T[] q;
	private int frontIndex;
	private int rearIndex;
	private int currentSize;
	
	
	public VipQueue (int capacity) {
		this.capacity = capacity;
		this.q = (T[]) new Object[capacity];
		this.frontIndex = this.rearIndex = 0;
		this.currentSize = 0;
		
	}
	
	public boolean isEmpty(){
		  return (frontIndex == rearIndex);

	}
	public boolean isFull(){
		  return ((frontIndex % capacity) == (rearIndex % capacity) + 1);

	}
	public T peek(){
		if (isEmpty()) {
			   return null;
			  } else {
			   return q[frontIndex % capacity];
			  }
	}
	public T dequeue(){
		if (isEmpty()) {
			   return null;
			  } else {
			   //No need to even clear the indices, they will be written over as the queue wraps around the array
			   T data = q[frontIndex % capacity];
			   frontIndex++;
			   return data;
			   this.currentSize--;
			  }
		
	}
	
	public void enqueue(T element){
		if (rearIndex == capacity) {
			throw new IllegalStateException("Cannot add to full queue");
		
	}
		q[rearIndex] = element;
		rearIndex = (rearIndex + 1) % capacity;
		capacity ++;
	}
	public void vipEnqueue(T element){
		if (rearIndex == capacity) {
			throw new IllegalStateException("Cannot add to full queue");
		
	}
		if ( frontIndex == 0 )
	        frontIndex = capacity - 1;
	    else 
	        frontIndex = ( frontIndex - 1 ) % capacity;

	    q[frontIndex] = element;

	    capacity++;
	}
	
	public int count(){
		//returns the number of elements in you vipQueue
		return rearIndex - frontIndex;
	}

}

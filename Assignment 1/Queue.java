package programmingAssignment1;

public class Queue <T>{
	private int capacity;
	private T[] q;
	private int frontIndex;
	private int rearIndex;
	
	
	public Queue(int capcaity) {
		this.capacity = capacity;
		this.q = (T[]) new Object[capacity];
		this.frontIndex = this.rearIndex = 0;
	}
	
	public boolean isEmpty() {
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
	
	
	
	public static void main(String[] args) throws Exception {
		  //Initializing a new queue holding strings of the fixed size 5
		  Queue < String > q = new Queue < String > (5);
		  //crude but convenient tests
		  if (!q.isEmpty()) {
		   throw new Exception();
		  }

		  for (int i = 1; i < 4; i++) {
		   q.enqueue(i + "hello");
		  }

		
		  

		  if (!q.peek().equals("1hello")) {
		   throw new Exception();
		  }

	

		  if (!q.dequeue().equals("1hello")) {
		   throw new Exception();
		  }

		  System.out.println("Queue works as expected, nice job!");

		 }
		}
	


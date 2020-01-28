package programmingAssignment1;

public class Stack<T> {
	private int capacity;
	private Node top;
	
	public Stack( int capacity) {
		this.capacity = capacity;
		top = null;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	public boolean isFull() {
		return false;
	}
	public T peek() {
		if(isEmpty()) {
		      return null;
		    } else {
		      return (T) top.data;
		    }		
	}
	
	public T pop() {
		 if(isEmpty()) {
		      return null;
		    } else {
		      T data = (T) top.data;
		      top = top.next;
		      return (T) data;
		    }
	}
	public void push(T element) {
		 /*if(isEmpty()) {
		      top = this.new Node <T> (data);
		    } else {
		      Node currentTop = top;
		      top = this.new Node <T> (data);
		      top.next = currentTop;
		    }*/
		   Node newNode = new Node(element); //Creation of New Node.
           newNode.next = top;   //newLink ---> old first
           top = newNode;  //first ---> newNode
		
	}
	
	public static void main(String[] args) throws Exception {
        Stack<Integer> s = new Stack<Integer>(4);

        //crude tests are better than no tests
        if(!s.isEmpty()) {
                throw new Exception();
        }

        for(int i=0; i<100; i++) {
                s.push(i);
        }

        if(s.isEmpty()) {
                throw new Exception();
        }

        if(s.isFull()) {
                throw new Exception();
        }

        if(s.peek()!=99) {
                throw new Exception();
        }

        if(s.pop()!=99) {
                throw new Exception();
        }

        if(s.peek()!=98) {
                throw new Exception();
        }

while(!s.isEmpty()) {
s.pop();
}

        System.out.println("Stack works exactly as expected, but you should write some better testers.");
}

}

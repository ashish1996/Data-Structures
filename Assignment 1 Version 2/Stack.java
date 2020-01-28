

public class Stack<T> {
	private int capacity;
	private Node top;
	private MyLinkedList stack = new MyLinkedList<T>(0);
	private final int MAX_SIZE;
	
	
	// Class that implements a generic Linked List
	private class MyLinkedList<T> {
		private Node<T> front;
		private final int MAX_SIZE;
		
		public MyLinkedList(int capacity) {
			front = null;
			MAX_SIZE = capacity;
		}
		
		public T peek(){
			return front.getData(); 
			}
		
		public void addFirst(Node<T> node) {
			if(front == null)
				front = node;
			else
			{
				node.setNext(front);
				front = node;
			}
		}
		
		public T removeFirst() {
			if(front == null)
				return null;
			else
			{
				Node<T> temp = front;
				front = temp.getNext();
				return temp.getData();
			}
		}
		
		public boolean isEmpty(){
			return front == null;
		}
		
		public String toString() {
			String s = "";
			Node<T> temp = front;
			while(temp != null)
			{
				s += temp.getData() + " ";
				temp = temp.getNext();
			}
			return s;
		}
		
		public int currentLength() {
			int length = 0;
			for(Node myNode = front; myNode != null; myNode = myNode.getNext())
				length ++;
			return length;
		}
	}

	// Class that Implements the Node that is used to implement a Linked List
	private class Node<E> {
		private Node<E> next;
		private E data;
		
		public Node() {
			setNext(null);
			setData(null);
		}
		
		public Node(E o) {
			setData(o);
		}
		
		public Node<E> getNext() { 
			return next; 
			}
		
		public void setNext(Node<E> next) { 
			this.next = next; 
			}
		
		public E getData() {
			return data; 
			}
		
		public void setData(E data) { 
			this.data = data; 
			}
		
	}

	//Constructor for Stack
	public Stack(int capacity){
		MAX_SIZE = capacity;
	}
	
	public T peek() {
		return (T) stack.peek();
	}
	
	public void push(T o) {
		stack.addFirst(new Node<T>(o));
	}
	
	public T pop(){
		return (T) stack.removeFirst();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();	
	}
	
	public boolean isFull() {
		return stack.currentLength() > MAX_SIZE;
	}
	
	public int currentLength(){
		return stack.currentLength();
	}

}

public class VipQueue<T> extends Queue<T>{
	private Stack<T> vipQueue;
	
	public VipQueue(int capacity) {
		super(capacity);
		vipQueue = new Stack<T>(0);
	}
	
	public void vipEnqueue(T element){
		vipQueue.push(element);
	}
	
	public T dequeue() {
		if(vipQueue.isEmpty())
			return super.dequeue();
		else
			return vipQueue.pop();
	}
	
	public boolean isFull(){
		return (currentLength()+1) +vipQueue.currentLength() > baseQueue.length;
	}
	
	public T peek() {
		if(vipQueue.isEmpty())
			return super.peek();
		else
			return vipQueue.peek();
	}
	
	public boolean isEmpty() {
		return baseQueue[0] == null;
	}
	
	public void enqueue(T element)
	{
		if(isEmpty())
			baseQueue[0] = element;
		//else if(isFull())
			//System.out.println("Illegal Operation");
		else
		{
			baseQueue[currentIndex+1] = element;
			currentIndex++;
		}
	}
	
	public int count() {
		return vipQueue.currentLength();
	}
}





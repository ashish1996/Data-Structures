

public class Queue<T> 
{
	protected T[] baseQueue; 
	protected int currentIndex;
	public Queue(int capacity)
	{
		baseQueue = (T[]) new Object[capacity];
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
	public T dequeue()
	{
		T temp = baseQueue[0];
		if(currentIndex != 0)
		{
			for(int i =1; i < currentIndex+1; i++)
			{
				baseQueue[i-1] = baseQueue[i];
			}
			currentIndex--;
		}
		else
		{
			baseQueue[0] = null;
			currentIndex =0;
		}
		return temp;
	}
	
	public T peek() {
		return baseQueue[0];
	}
	
	public boolean isFull() {
		return currentIndex >= baseQueue.length-1;
	}
	
	public boolean isEmpty() {
		return baseQueue[0] == null;
	}
	
	
	public int currentLength() {
		return currentIndex;
	}
	
}


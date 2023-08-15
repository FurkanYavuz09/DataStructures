package queue;

public class Queue<T> {
	private static int frontIndex, rear, capacity;
	private T[] queue;
    private static final int DEFAULT_CAPACITY = 1000;
    private T front;

    
    public Queue() {
    	this(DEFAULT_CAPACITY);
    }
	
	public Queue(int initialCapacity){
		frontIndex = rear = 0;
        capacity = initialCapacity;
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		queue = tempStack;
    }
  
    public boolean enqueue(T newEntry){
    	
        
    	if (capacity == rear) {
        	
        	return false;
        } 	
  
        else {
        	
			queue[rear] = newEntry;
            rear++;
            return true;
        }
    }
  
    
    public T dequeue()
    {
    	front = queue[frontIndex];

        if (frontIndex == rear) {
        
            return null;
        }
  
        else {
        	
            for (int i = 0; i < rear ; i++) {       
            	queue[i] = queue[i + 1];
            }
  
            if (rear < capacity) {
                queue[rear] = null;
                }
            rear--;
        	
        }
        return front;
    }
  
    
    public boolean isEmpty()
    {
    	boolean empty=false;
        if (frontIndex == rear) {
            empty = true;
        }
  
        return empty;
    }

    
    public T getFront()
    {
        if (frontIndex == rear) {
            return null;
        }
        return queue[frontIndex];
    }
    
    
 
	public void clear() {	
		while (rear!=0) {
			
		}
	}

	public T[] getQueue() {
		return queue;
	}
}

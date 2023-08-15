package factory_line;


public class FactoryLine<T> implements IQueue<T>{
    private static int front, rear, capacity;
	private T[] queue;
    private static final int DEFAULT_CAPACITY = 1000;
    private T frontFurniture;
    private String frontFurnitureName;
    
    public FactoryLine() {
    	this(DEFAULT_CAPACITY);
    }
	
	public FactoryLine(int initialCapacity){
		front = rear = 0;
        capacity = initialCapacity;
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		queue = tempStack;
    }
  
    public boolean enqueue(T newEntry){
    	
    	String newFurniture =newEntry.getClass().getSimpleName();
        
    	if (capacity == rear) {
        	System.out.printf("Marketing Analyst requesting "+newFurniture+", FAIL, factory line is full\n");
        	return false;
        }
  
        else {
        	System.out.printf("Marketing Analyst requesting "+newFurniture+", SUCCESS, "+newFurniture+" manufactured\n");
			queue[rear] = newEntry;
            rear++;
            return true;
        }
    }
  
    
    public T dequeue()
    {
    	frontFurniture = queue[front];

        if (front == rear) {
        	System.out.printf("Storage Chief trying to store, FAIL, factory line is empty\n");
            return null;
        }
  
        else {
        	frontFurnitureName =frontFurniture.getClass().getSimpleName();
            for (int i = 0; i < rear ; i++) {       
            	queue[i] = queue[i + 1];
            }
  
            if (rear < capacity) {
                queue[rear] = null;
                }
            rear--;
        	System.out.printf("Storage Chief storing "+frontFurnitureName+", SUCCESS, "+frontFurnitureName+" stored in "+frontFurnitureName+" warehouse\n");
        }
        return frontFurniture;
    }
  
    
    public boolean isEmpty()
    {
    	boolean empty=false;
        if (front == rear) {
            empty = true;
        }
  
        return empty;
    }

    
    public T getFront()
    {
        if (front == rear) {
            return null;
        }
        return queue[front];
    }
    
    
    public String getFrontName() {
    	String name=getFront().getClass().getSimpleName();
    	return name;
    }
    
    
    public void reportLine() {
    	int sofaCounter=0;
    	int bedCounter=0;
    	int chairCounter=0;
    	int dresserCounter=0;
    	int tableCounter=0;
    	int bookcaseCounter=0;
    	
    	for(int i=0;i<rear;i++) {
    		if(queue[i].getClass().getSimpleName().equals("Sofa")) 
    			sofaCounter++;
    		else if(queue[i].getClass().getSimpleName().equals("Bed"))
    			bedCounter++;
    		else if(queue[i].getClass().getSimpleName().equals("Chair"))
    			chairCounter++;
    		else if(queue[i].getClass().getSimpleName().equals("Dresser"))
    			dresserCounter++;
    		else if(queue[i].getClass().getSimpleName().equals("Table"))
    			tableCounter++;
    		else if(queue[i].getClass().getSimpleName().equals("Bookcase"))
    			bookcaseCounter++;		
    	}
    	System.out.println();
    	System.out.println("Amount of Sofa in Sofa Warehouse: "+sofaCounter);
    	System.out.println("Amount of Bed in Bed Warehouse: "+bedCounter);
    	System.out.println("Amount of Chair in Chair Warehouse: "+chairCounter);
    	System.out.println("Amount of Dresser in Dresser Warehouse: "+dresserCounter);
    	System.out.println("Amount of Table in Table Warehouse: "+tableCounter);
    	System.out.println("Amount of Bookcase in Bookcase Warehouse: "+bookcaseCounter);
    	
    	
    }

	public void clear() {	
	}

	public T[] getQueue() {
		return queue;
	}

}

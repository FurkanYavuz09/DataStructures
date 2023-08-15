package warehouse;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Warehouse <T> implements IStack<T>{
    private int size = 0;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private T[] stack;
    private String name;  
 
    
    public Warehouse(String name) {
    	this(DEFAULT_CAPACITY,name);
    }
    
    
    public Warehouse(int initialCapacity,String name) {
    	this.name=name;
		@SuppressWarnings({ "unchecked" })
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		initialized = true;
    }
 
    
    public boolean push(T newEntry) {
    	checkInitialization();
    	ensureCapacity();
    	if(newEntry!=null) {
            stack[size++] = newEntry;
            return true;
    	}
    	else {
    		return false;
    	}
    }
 
    
    public T pop() {
    	checkInitialization();
    	if (isEmpty()) {
    		System.out.printf("Customer buying "+name+", FAIL, "+name+" warehouse empty\n");
    		return null;
    	}
    	else {
        	T top = stack[size-1];
        	stack[--size] = null;
        	System.out.printf("Customer buying "+name+", SUCCESS, Customer bought "+name+"\n");
        	return top;
        	
    	}
    }
 
    
    private void ensureCapacity() {
    	if (size==stack.length-1) {
    		int newLength = 2*stack.length;
    		checkCapacity(newLength);
    		stack= Arrays.copyOf(stack, newLength);
    	}
    }

    
	public T peek() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return stack[size-1];
			
		}

	}
	
	
	public boolean isEmpty() {
		boolean emptiness = false;
		if (size == 0) {
			emptiness = true;
		}
		return emptiness;
	}

	
	private void checkInitialization() {
		if(!initialized) 
			throw new SecurityException("Warehouse object is not initialized properly.");
	}
	
	
	private void checkCapacity(int length) {
		if(length> MAX_CAPACITY) {
			throw new SecurityException("Max capacity of stack is exceeded.");
		}
	}
	
	public void reportWarehouse() {
		System.out.println("Amount of " +name+ " in "+name+ " Warehouse: "+size);
	}
	public void reportSoldFurniture() {
		System.out.println("Amount of " +name+" Sold: "+size);
	}
}

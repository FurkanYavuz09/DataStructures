package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
	private int size = 0;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private T[] stack;
 
 
    
    public Stack() {
    	this(DEFAULT_CAPACITY);
    }
    
    
    public Stack(int initialCapacity) {
    	
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
    		
    		return null;
    	}
    	else {
        	T top = stack[size-1];
        	stack[--size] = null;
        
        	return top;
        	
    	}
    }
 
    
    private void ensureCapacity() {
    	if (size==stack.length-1) {
    		int newLength = 2*stack.length;
    		checkCapacity(newLength);
    		@SuppressWarnings({ "unchecked" })
    		T[] newstack = (T[]) new Object[newLength];
    		for (int i=0;i<stack.length;i++) {
    			newstack[i]=stack[i];
    			stack[i]=null;
    		}
    		stack=newstack; 
    		//copyOf method done by manually
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
		return size==0;
	}

	
	private void checkInitialization() {
		if(!initialized) 
			throw new SecurityException(" object is not initialized properly.");
	}
	
	
	private void checkCapacity(int length) {
		if(length> MAX_CAPACITY) {
			throw new SecurityException("Max capacity of stack is exceeded.");
		}
	}
	
}

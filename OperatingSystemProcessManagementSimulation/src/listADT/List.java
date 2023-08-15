package listADT;


public class List<T> implements IList<Object> {

	private int size;
	private int capacity;
	private final static int DEFAULT_CAPACITY = 20;
	private Object elements[];
	
	public List() {
		this(DEFAULT_CAPACITY);
	}
				
	public List(int capacity) {
		this.capacity = capacity;
		elements = new Object[capacity];
	}

	public boolean add(Object newEntry) {
		return add(size,newEntry);
		
	}

	public boolean add(int index, Object newEntry) {
		ensureCapacity();
		boolean result=true;
		if(index>size) {
			result=false;
		}
		if(index == size) {
			elements[index] = newEntry;
		}
		else {
			Object tempValue1 = elements[index];
			Object tempValue2;
			elements[index] = newEntry;
			
			for(int i =0;i<(size-index);i++) {
				tempValue2 =elements[i+index+1];
				elements[i+index+1]=tempValue1;
				tempValue1 = tempValue2;
				
			}
		}
		size++;
		return result;	
	}

	public Object remove(int index) {
		if(index >= size || index<0) {
			return null;
		}
		else {
			Object removedElement = elements[index];
			for(int i =0;i<(size-index-1);i++) {
				elements[i+index]=elements[i+index+1];	
			}
			elements[size-1]=null;
			size--;
			return removedElement;
		}
	}

	public Object set(int index, Object newEntry) {
		Object result = null;
		if(size>index && index>=0) {
			result = elements[index];
			elements[index]=newEntry;
		}
		return result;
	}

	public Object get(int index) {		
		return elements[index];
	}

	public boolean contains(Object anEntry) {
		
		return false;
	}

	public int size() {		
		return size;
	}

	public boolean isEmpty() {
		return (size==0);
	}

	public boolean isFull() {
		return (capacity==size);
	}

	public void ensureCapacity() {
		if(isFull()) {
			Object[] tempArray = new Object[2*this.capacity];
			this.capacity *= 2;
			for(int i =0;i<size;i++) {
				tempArray[i] = this.elements[i];
			}
			this.elements = tempArray;
			
		}
	}

}

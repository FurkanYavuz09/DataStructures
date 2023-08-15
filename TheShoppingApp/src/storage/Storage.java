package storage;

import item.*;

public final class Storage<T> implements IBag<T> {

	
	
    private final T[] bag;
    private int numberOfEntries = 0;
    private static final int DEFAULT_CAPACITY = 25;
    private int currentWeight = 0;
    private int weightLimit;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 100;
    private String itemNames = "";
    
    /* Creates an empty bag whose initial capacity is 25. */
    public Storage(int weight) {
        this(DEFAULT_CAPACITY,weight);
    }

    
     /* Creates an empty bag having a given initial item capacity. */
    public Storage(int desiredCapacity,int weight) {
        if (desiredCapacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; 
            bag = tempBag;
            initialized = true;
            weightLimit = weight;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
    }

    
	public void setItemNames(String itemNames) {
		this.itemNames = itemNames;
	}
    
	
    /* Adds a new item to this bag. */
    public boolean add(T newItem) {
    	checkInitialization();
        boolean result = false;
        if (!isFull()&&(isAddable(newItem))) {
        	result = true;
        	bag[numberOfEntries] = newItem;
        	numberOfEntries++;
        }
        return result;
    
    }
    
    
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("ShoppingBasket object is not initialized properly.");
   }
    
    
    /* Retrieves all entries that are in this bag. */
    public T[] toArray() {

        @SuppressWarnings("unchecked")


        Item[] result =  new Item[numberOfEntries]; 

 
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = (Item) bag[index];
        }
        return (T[]) result;
    }
    
    
    /* Sees whether this bag is full. */
    public boolean isFull() {
        return numberOfEntries >= bag.length;
    }

    
    /* Sees whether this bag is empty. */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    
    /* Gets the current number of entries in this bag. */
    public int getItemCount() {
        return numberOfEntries;
    }

    
    /* Gets the remaining weight capacity in the bag */
    public int remainingWeightCapacity() {
    	return weightLimit-currentWeight;
    }
    

    /* Tests whether the new item is addable */
    public boolean isAddable(T newItem) {
    	Item item = (Item) (Object) newItem;
    	boolean result = false;
    	if ((remainingWeightCapacity()- item.getItem_weight())>=0) {
    		result=true;
    		currentWeight +=item.getItem_weight();
    		itemNames += (item.getItem_name());
    	}
    	return result;
    }
    
    
    /* Tests whether this bag contains a given item. */
    public boolean contains(T item) {
        checkInitialization();
        return getIndexOf(item) > -1;
    }

    
    /* Removes all entries from this bag. */
    public void dump() {
        while (!isEmpty()) {
            remove();
        }
    }

    /* Removes one unspecified item from this bag, if possible. */
    public T remove() {
        checkInitialization();
        T result = removeByIndex(numberOfEntries - 1);
        return result;
    }

    
    /* Removes one occurrence of a given item from this bag. */
    public T remove(T item) {
        checkInitialization();
        int index = getIndexOf(item);
        T result = removeByIndex(index);
        return result;
    }
    
    
    /* Removes and returns the item at a given array index within the array bag. If no such item exists, returns null. */
    public T removeByIndex(int index) {
    	T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = bag[index];
        	Item item = (Item) (Object) result;
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            currentWeight-=item.getItem_weight();
         }
        return result;
    }

    
    /* Locates a given item within the array bag. Returns the index of the item, if located, or -1 otherwise. */
    public int getIndexOf(T item) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfEntries)) {
            if (item.equals(bag[index])) {
                stillLooking = false;
                where = index;
            }
            index++;
        }
        return where;
    }
    
    
    public void displayItems() {
    	System.out.println("Items: "+ itemNames);
    	System.out.println("Remaining weight limit: "+ remainingWeightCapacity());
    }
    

	public boolean transferTo(IBag<T> targetBag, T item) {
		boolean result =targetBag.add(item);
		remove(item);
		itemNames = "";
		return result;
	}
}
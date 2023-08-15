package listADT;

public interface IList<T> {

	public boolean add(T newEntry);
	public boolean add(int Index, T newEntry);
	public T remove(int Index);
	public T set(int Index, T newEntry);
	public T get(int Index);
	//public boolean contains(Object anEntry);
	public int size();
	public boolean isEmpty();
	public boolean isFull();
	public void ensureCapacity();
	
}

package factory_line;

public interface IQueue<T> {
	public boolean enqueue(T newEntry);
	public T dequeue();
	public T getFront();
	public boolean isEmpty();
	public void clear();
}

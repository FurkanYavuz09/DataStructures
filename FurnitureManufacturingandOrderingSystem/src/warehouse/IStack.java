package warehouse;

public interface IStack<T> {
	public boolean push(T newEntry);
	public T peek();
	public T pop();
}

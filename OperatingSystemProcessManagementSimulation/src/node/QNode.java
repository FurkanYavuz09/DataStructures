package node;

public class QNode <T>{

	private T key;
    private QNode next;
  
    public QNode(T key)
    {
        this.setKey(key);
        this.setNext(null);
    }
    
    public QNode getNext() {
    	return next;
    }

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public void setNext(QNode next) {
		this.next = next;
	}
}

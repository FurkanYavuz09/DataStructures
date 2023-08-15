package computations;

import node.QNode;

public class PriorityComputationQueue<T>{
	
	private QNode front, rear;
	  
    public PriorityComputationQueue() {

        this.front = this.rear = null;
    }

    public void enqueue(T computation){
    	int priority = ((Computation) computation).getProcessPriority();
        // Create a new LL node
        QNode temp = new QNode((Computation) computation);
        
        if (this.front == null) {
            this.front = temp;
        }
        else {
    		QNode tempFront =this.front;	
        	
    		if(priority<((Computation) this.front.getKey()).getProcessPriority()){			
    			this.front = temp;
            	this.front.setNext(tempFront);		
        	}
        	else{
        		while (tempFront.getNext() !=null && ((Computation) tempFront.getNext().getKey()).getProcessPriority() <= priority) {
        			tempFront = tempFront.getNext();
        			
        		}
        	 	QNode tempNode = tempFront.getNext();
        		temp.setNext(tempNode);
        		tempFront.setNext(temp);	
        	}
        }

    }
    
    public QNode dequeue()
    {
        if (this.front == null)
            return null;
  
        QNode temp = this.front;
        this.front = this.front.getNext();
        return temp;
  
    }

    public QNode getFront() {
    	return front;
    }
}

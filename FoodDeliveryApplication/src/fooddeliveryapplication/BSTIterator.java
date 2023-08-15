package fooddeliveryapplication;

import stack.*;
import fooddeliveryapplication.*;
import fooddeliveryapplication.Binarysearchtree.Node;
import queue.*;

public class BSTIterator implements Iterator {
	
		public Stack<Node> ascendingStack;
		private Stack<Node> descendingStack;
		private Queue<Node> queue;
		Node ascRoot;
		Node descRoot;
		Node root;
		public BSTIterator(Node root) {
			this.ascendingStack = new Stack<>();
			this.descendingStack = new Stack<>();
			this.root=root;
			this.ascRoot=this.root;
			this.descRoot=this.root;
			fillAscendingStack();
			fillDescendingStack();
			
		}
	 
		public boolean ascHasNext() {
			return !ascendingStack.isEmpty();
		}
		public boolean descHasNext() {
			return !descendingStack.isEmpty();
		}
		public void fillAscendingStack() {
			while (this.ascRoot != null) {
				this.ascendingStack.push(this.ascRoot);
	
				this.ascRoot = this.ascRoot.getLeft();
			}
		}
		public void fillDescendingStack() {
			while (this.descRoot!= null) {

				this.descendingStack.push(this.descRoot);
				this.descRoot = this.descRoot.getRight();

			}
		}
		
		public void levelOrderTraversal() {
			
			this.queue = new Queue<Node>();
			
	        queue.enqueue(root);
	        
	        while (!queue.isEmpty())
	        {
	 
	           
	            Node tempNode = queue.dequeue();
	            System.out.print(tempNode.getData() );
	 
	            /*Enqueue left child */
	            if (tempNode.getLeft() != null) {
	            	queue.enqueue(tempNode.getLeft());
	            }
	 		
	            /*Enqueue right child */
	            if (tempNode.getRight() != null) {
	                queue.enqueue(tempNode.getRight());
	            }
	        }
		}
		public Node ascendingInOrderTraversal() {
			
			Node stackNode = ascendingStack.pop();
			Node returnNode = stackNode;
			if (stackNode.getRight() != null) {
				stackNode = stackNode.getRight();
				while (stackNode != null) {
					ascendingStack.push(stackNode);
					stackNode = stackNode.getLeft();
				}
			}
			return returnNode;
		}
		public Node descendingInOrderTraversal() {
				Node stackNode = descendingStack.pop();
				Node returnNode = stackNode;
				if (stackNode.getLeft() != null) {
					stackNode = stackNode.getLeft();
					while (stackNode != null) {
						descendingStack.push(stackNode);
						stackNode = stackNode.getRight();
					}
				}
				return returnNode;
		}
		public void preOrderTraversal() {
			if (this.root == null) {
	            return ;
	        }
	
	        Stack<Node> nodeStack = new Stack<Node>();
	        nodeStack.push(root);
	 
	       
	        while (nodeStack.isEmpty() == false) {
	 
	            Node mynode = nodeStack.pop();
	   
	            
	 
	            // Push right and left children of the popped node to stack
	            if (mynode.getRight() != null) {
	                nodeStack.push(mynode.getRight());
	            }
	            if (mynode.getLeft() != null) {
	                nodeStack.push(mynode.getLeft());
	            }
	            
	        }
		}
		public Stack<Object> postOrderTraversal() {
			 Stack<Node> stack = new Stack();
		        stack.push(root);
		    
		        // create another stack to store postorder traversal
		        Stack<Object> out = new Stack<>();
		    
		        // loop till stack is empty
		        while (!stack.isEmpty())
		        {
		            // pop a node from the stack and push the data into the output stack
		            Node curr = stack.pop();
		            out.push(curr.getData());
		    
		            // push the left and right child of the popped node into the stack
		            if (curr.getLeft() != null) {
		                stack.push(curr.getLeft());
		            }
		    
		            if (curr.getRight() != null) {
		                stack.push(curr.getRight());
		            }
		        }
		        return out;
		}
		
		
	
}


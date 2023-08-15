package fooddeliveryapplication;

import fooddeliveryapplication.*;
import stack.Stack;

public class Binarysearchtree<T> {
	public Comparator<T> comparator;
	public BSTIterator iterator;
	public class Node
	    {
	        private T Data;
	        private Node left, right;
	 
	        public Node(T item)
	        {
	        	Data = item;
	            left = right = null;
	        }

			public T getData() {
				return Data;
			}

			public void setData(T data) {
				Data = data;
			}

			public Node getLeft() {
				return left;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public Node getRight() {
				return right;
			}

			public void setRight(Node right) {
				this.right = right;
			}

			
	        
	    }
	public Node root;
	
	public Node getRoot() {
		return root;
	}


	public void setRoot(Node root) {
		this.root = root;
	}


	public Binarysearchtree(Comparator<T> comparator) {
		this.comparator=comparator;
		
		
	}
	public void setIterator(BSTIterator iterator) {
		this.iterator=iterator;
	}
	
	public void add(T newEntry) {
		
		if (isEmpty()) {
			this.root=new Node(newEntry);	
		}
		else {

			addEntry(this.root,newEntry);
			
		}
		              
	}
	private void addEntry(Node root,  T newEntry) {
		
		double comparison =comparator.compare(root.Data, newEntry);
		 if(comparison>=0) {
			 
	            if(root.left == null) {
	                root.left = new Node(newEntry);
	            }
	            else {
	            	  addEntry(root.left, newEntry);
	            }
        }
        else if (comparison<0) {
            if(root.right == null) {
            	 root.right = new Node(newEntry);
            }
               
            else {
            	addEntry(root.right, newEntry);
            }
                
        }
	} 

	
	public boolean isEmpty() {
		return this.root == null;
	}
	 public  Node getMinimumKey(Node curr)
	    {
	        while (curr.left != null) {
	            curr = curr.left;
	        }
	        return curr;
	    }
	
	public T remove(T entry) {
		
		Node currentNode=this.root;
		Node parent=null;
		
		while (currentNode != null && !currentNode.Data.equals(entry))
        {
            parent = currentNode;
            double comparison =comparator.compare(currentNode.Data, entry);
            if (comparison>0) {
            	currentNode = currentNode.left;
            }
            else {
            	currentNode = currentNode.right;
            }
        }
		
		if (currentNode==null) {
			return null;
		}
		
		if (currentNode.left==null && currentNode.right==null) {
			if (currentNode != root)
            {
                if (parent.left == currentNode) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            else {
                root = null;
            }
		}
		
		else if ((currentNode.left != null && currentNode.right != null)) {
            Node successor = getMinimumKey(currentNode.right);
            
            
            remove(successor.Data);
            currentNode.Data=successor.Data;
		}
		
		else {
			Node child = (currentNode.left != null)? currentNode.left: currentNode.right;
			if (currentNode != root) {
                if (currentNode == parent.left) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
            else {
                root = child;
            }
		}
		return entry;
	}
	
	
	@SuppressWarnings("unchecked")
	public T ascInOrder() {
		if (iterator.ascHasNext()) {
			return (T) iterator.ascendingInOrderTraversal().getData();
		}
		else {
			return null;
		}
		
	}
	@SuppressWarnings("unchecked")
	public T descInOrder() {
		if (iterator.descHasNext()) {
			return (T) iterator.descendingInOrderTraversal().getData();
		}
		return null;
	}
	public void levelOrder() {
		iterator.levelOrderTraversal();
	}
	public void preorder() {
		iterator.preOrderTraversal();
	}
	public Stack<Object> postOrder() {
		return iterator.postOrderTraversal();
	}

}
	
	


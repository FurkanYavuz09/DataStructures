package fooddeliveryapplication;

import fooddeliveryapplication.Binarysearchtree.Node;
import stack.Stack;

public interface Iterator {
	public Node ascendingInOrderTraversal();
	public Node descendingInOrderTraversal();
	public void preOrderTraversal();
	public Stack postOrderTraversal();
	public void levelOrderTraversal();
}

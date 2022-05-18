package JavaDS.Trees;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Main super class implement common functionality shared across all different 
 * types of binary trees. 
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data contained within the nodes of the tree.
 */
public abstract class BinaryTree<T extends Comparable<T>> extends SuperTree<T> implements ITree<T> {

	/**
	 * Method to return all of the node data elements populating a given tree 
	 * instance in an <code>AbstractList</code> in an traversal order specified. 
	 * 
	 * @param dir The direction to traverse the tree when generating the list of 
	 * its nodes: <i>Pre-order, in-order, post-order, level-order, reverse pre- in-
	 * and post-order.</i>
	 * @return A list containing all of the nodes in the tree in the specified order.
	 */
	@Override
	public AbstractList<INode<T>> ToList(TraversalDirection dir) {
		ArrayList<INode<T>> list = new ArrayList<INode<T>>();
		INode<T> on = this.GetRoot();
		
		switch(dir) {
			case PREORDER:
				this.TraversalPreorder(list, on);
				break;
			case INORDER:
				this.TraversalInorder(list, on);
				break;
			case POSTORDER:
				this.TraversalPostorder(list, on);
				break;
			case REVERSEPREORDER:
				this.TraversalReversePreorder(list, on);
				break;
			case REVERSEINORDER:
				this.TraversalReverseInorder(list, on);
				break;
			case REVERSEPOSTORDER:
				this.TraversalReversePostorder(list, on);
				break;
			case LEVELORDER:
				this.TraversalLevelorder(list, on);
				break;
			default:
				this.TraversalPreorder(list, on);
				break;
		}
		
		return list;
	}
	
	/**
	 * Method to obtain the size (total number of node elements) contained within
	 * a tree instance. Left unimplemented to allow different rules for different 
	 * underlying tree structures.
	 * 
	 * @return The number of nodes contained within the tree.
	 */
	public int Size() {
		int count = 0;
		this.TraversalCount(count, this.GetRoot());
		
		return count;
	}
	
	/**
	 * Method to traverse the tree in in-order direction while maintaining a 
	 * count on the number of nodes contained in the tree. Final value of number
	 * of nodes will be stored in the <code>count</code> parameter.
	 * 
	 * @param count The running number of nodes within the tree.
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalCount(int count, INode<T> on) {
		if (on == null)
			return;

		count++;
		this.TraversalCount(count, ((BinaryNode<T>) on).GetLeft());
		this.TraversalCount(count, ((BinaryNode<T>) on).GetRight());
	}
	
	/**
	 * Method to traverse the tree in pre-order direction while adding all nodes
	 * to a specified list in pre-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalPreorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		list.add(on);
		this.TraversalPreorder(list, ((BinaryNode<T>) on).GetLeft());
		this.TraversalPreorder(list, ((BinaryNode<T>) on).GetRight());
	}
	
	/**
	 * Method to traverse the tree in in-order direction while adding all nodes
	 * to a specified list in in-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalInorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		this.TraversalInorder(list, ((BinaryNode<T>) on).GetLeft());
		list.add(on);
		this.TraversalInorder(list, ((BinaryNode<T>) on).GetRight());
	}
	
	/**
	 * Method to traverse the tree in post-order direction while adding all nodes
	 * to a specified list in post-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalPostorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		this.TraversalPostorder(list, ((BinaryNode<T>) on).GetLeft());
		this.TraversalPostorder(list, ((BinaryNode<T>) on).GetRight());
		list.add(on);
	}
	
	/**
	 * Method to traverse the tree in reverse pre-order direction while adding all nodes
	 * to a specified list in reverse pre-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalReversePreorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		this.TraversalReversePreorder(list, ((BinaryNode<T>) on).GetRight());
		this.TraversalReversePreorder(list, ((BinaryNode<T>) on).GetLeft());
		list.add(on);
	}
	
	/**
	 * Method to traverse the tree in reverse in-order direction while adding all nodes
	 * to a specified list in reverse in-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalReverseInorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		this.TraversalReverseInorder(list, ((BinaryNode<T>) on).GetRight());
		list.add(on);
		this.TraversalReverseInorder(list, ((BinaryNode<T>) on).GetLeft());
	}
	
	/**
	 * Method to traverse the tree in reverse post-order direction while adding all nodes
	 * to a specified list in reverse post-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param on The node being operated on presently in the traversal. 
	 */
	private void TraversalReversePostorder(AbstractList<INode<T>> list, INode<T> on) {
		if (on == null)
			return;
		
		list.add(on);
		this.TraversalReversePostorder(list, ((BinaryNode<T>) on).GetRight());
		this.TraversalReversePostorder(list, ((BinaryNode<T>) on).GetLeft());
	}
	
	/**
	 * Method to traverse the tree in level-order direction while adding all nodes
	 * to a specified list in level-order. 
	 * 
	 * @param list The list that nodes should be added to when visited. 
	 * @param root The root node to begin the traversal from. 
	 */
	private void TraversalLevelorder(AbstractList<INode<T>> list, INode<T> root) {
		if (root == null)
			return;
		
		Queue<INode<T>> queue = new LinkedList<INode<T>>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			INode<T> node = queue.remove();
			list.add(node);
			
			if (((BinaryNode<T>) node).GetLeft() != null) 
				queue.add(((BinaryNode<T>) node).GetLeft());
			
			if (((BinaryNode<T>) node).GetRight() != null)
				queue.add(((BinaryNode<T>) node).GetRight());
		}
	}

}

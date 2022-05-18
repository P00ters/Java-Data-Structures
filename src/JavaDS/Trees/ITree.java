package JavaDS.Trees;

import java.util.AbstractList;

/**
 * Interface for all one dimensional tree based data structures. Implementing 
 * classes can populate trees with <code>Comparable</code> extending data elements.
 * 
 * @author Tom Esser
 * @param <T> Type of data elements being sorted.
 */
public interface ITree<T extends Comparable<T>> {
	
	/**
	 * Method to access the current root node for a given tree.
	 * 
	 * @return The current root node for the tree instance.
	 */
	public INode<T> GetRoot();
	
	/**
	 * Method to update the current root node for a given tree to a specified
	 * new root node.
	 * 
	 * @param newRoot The new root node for the tree instance.
	 */
	public void SetRoot(INode<T> newRoot);
	
	/**
	 * Method to return all of the node data elements populating a given tree 
	 * instance in an <code>AbstractList</code> in an traversal order specified. 
	 * 
	 * @param dir The direction to traverse the tree when generating the list of 
	 * its nodes: <i>Pre-order, in-order, post-order, level-order, reverse pre- in-
	 * and post-order.</i>
	 * @return A list containing all of the nodes in the tree in the specified order.
	 */
	public AbstractList<INode<T>> ToList(TraversalDirection dir);
	
	/**
	 * Method to add a new, specified node to a tree instance. 
	 * 
	 * @param newNode The new node to add to the tree.
	 */
	public void AddNode(INode<T> newNode);
	
	/**
	 * Method to add a new node to the tree via a specified data element for the 
	 * new node. 
	 * 
	 * @param value The data the new node being added to the tree instance will
	 * contain.
	 */
	public void AddNode(T value);
	
	/**
	 * Method to remove a specified existing node from a tree instance.
	 * 
	 * @param removeNode The node to be removed from the tree.
	 */
	public void RemoveNode(INode<T> removeNode);
	
	/**
	 * Method to remove a node from the tree via a specified data element for the
	 * node being removed from the tree instance. 
	 * 
	 * @param value The data element of the node to be removed from the tree.
	 */
	public void RemoveNode(T value);
	
	/**
	 * Method to obtain the size (total number of node elements) contained within
	 * a tree instance. 
	 * 
	 * @return The number of nodes contained within the tree.
	 */
	public int Size();
	
	/**
	 * Method to check whether the tree contains a node with a data element matching
	 * the specified data element. 
	 * 
	 * @param value The data element to check to see if the tree contains. 
	 * @return True if the tree contains the data element. False if not. 
	 */
	public abstract boolean Contains(T value);
	
}

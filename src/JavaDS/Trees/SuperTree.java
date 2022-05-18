package JavaDS.Trees;

import java.util.AbstractList;

/**
 * Main tree structure class containing shared logic for any underlying, one
 * dimensional tree based data structure to extend from. 
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data element housed within the tree's nodes.
 */
public abstract class SuperTree<T extends Comparable<T>> implements ITree<T> {

	/**
	 * The root node for the tree. 
	 */
	private INode<T> root;
	
	/**
	 * Constructor to create a new tree given a specified root node. 
	 * 
	 * @param root The root node for the newly instantiated tree.
	 */
	public SuperTree(INode<T> root) {
		this.root = root;
	}
	
	/**
	 * Constructor to create a new, empty tree with no specified root node.
	 */
	public SuperTree() {
		this.root = null;
	}
	
	/**
	 * Method to access the current root node for a given tree.
	 * 
	 * @return The current root node for the tree instance.
	 */
	@Override
	public INode<T> GetRoot() {
		return this.root;
	}

	/**
	 * Method to update the current root node for a given tree to a specified
	 * new root node.
	 * 
	 * @param newRoot The new root node for the tree instance.
	 */
	@Override
	public void SetRoot(INode<T> newRoot) {
		this.root = newRoot;		
	}

	/**
	 * Method to return all of the node data elements populating a given tree 
	 * instance in an <code>AbstractList</code> in an traversal order specified. 
	 * 
	 * @param dir The direction to traverse the tree when generating the list of 
	 * its nodes: <i>Pre-order, in-order, post-order, level-order, reverse pre- in-
	 * and post-order.</i>
	 * @return A list containing all of the nodes in the tree in the specified order.
	 */
	public abstract AbstractList<INode<T>> ToList(TraversalDirection dir);

	/**
	 * Method to add a new node to the tree via a specified data element for the 
	 * new node. Left unimplemented to allow different rules for different 
	 * underlying tree structures.
	 * 
	 * @param value The data the new node being added to the tree instance will
	 * contain.
	 */
	public abstract void AddNode(T value);
	
	/**
	 * Method to add a new, specified node to a tree instance. 
	 * 
	 * @param newNode The new node to add to the tree.
	 */
	public void AddNode(INode<T> newNode) {
		this.AddNode(newNode.GetData());
	}
	
	/**
	 * Method to remove a node from the tree via a specified data element for the
	 * node being removed from the tree instance. Left unimplemented to allow 
	 * different rules for different underlying tree structures.
	 * 
	 * @param value The data element of the node to be removed from the tree.
	 */
	public abstract void RemoveNode(T value);
	
	/**
	 * Method to remove a specified existing node from a tree instance. 
	 * 
	 * @param removeNode The node to be removed from the tree.
	 */
	public void RemoveNode(INode<T> removed) {
		this.RemoveNode(removed.GetData());
	}
	
	/**
	 * Method to obtain the size (total number of node elements) contained within
	 * a tree instance. Left unimplemented to allow different rules for different 
	 * underlying tree structures.
	 * 
	 * @return The number of nodes contained within the tree.
	 */
	public abstract int Size();
	
	/**
	 * Method to check whether the tree contains a node with a data element matching
	 * the specified data element. Left unimplemented to allow different rules for different 
	 * underlying tree structures.
	 * 
	 * @param value The data element to check to see if the tree contains. 
	 * @return True if the tree contains the data element. False if not. 
	 */
	public abstract boolean Contains(T value);
}

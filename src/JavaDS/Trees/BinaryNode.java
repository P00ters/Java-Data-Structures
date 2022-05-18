package JavaDS.Trees;

/**
 * Main super class for nodes contained within binary based tree data structures.
 * Contains common functionality for different binary trees.
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data element contained within the node (and binary tree).
 */
public class BinaryNode<T extends Comparable<T>> extends SuperNode<T> implements INode<T> {

	/**
	 * The left sub-child for a binary node.
	 */
	private INode<T> left;
	/**
	 * The right sub-child for a binary node.
	 */
	private INode<T> right;
	
	/**
	 * Constructor accepts a provided data element to contain within the new node.
	 * Sets child nodes to null by default. 
	 * 
	 * @param data The data element to contain within the new node.
	 */
	public BinaryNode(T data) {
		super(data);
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Method to retrieve the child node to the left of a node.
	 * 
	 * @return The left child node. 
	 */
	public INode<T> GetLeft() {
		return this.left;
	}
	
	/**
	 * Method to retrieve the child node to the right of a node.
	 * 
	 * @return The right child node. 
	 */
	public INode<T> GetRight() {
		return this.right;
	}

	/**
	 * Method to update the child node to the left of a node to a specified node.
	 * 
	 * @param newLeft The new left child for the node.
	 */
	public void SetLeft (INode<T> newLeft) {
		this.left = newLeft;
	}
	
	/**
	 * Method to update the child node to the right of a node to a specified node.
	 * 
	 * @param newLeft The new right child for the node.
	 */
	public void SetRight (INode<T> newRight) {
		this.right = newRight;
	}
}

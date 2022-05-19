package JavaDS.Trees;

/**
 * A class implementing Binary Node functionality for specific use within the 
 * context of an AVL Tree. 
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data element contained within the node. 
 */
public class AVLNode<T extends Comparable<T>> extends BinaryNode<T> implements INode<T> {
	
	/**
	 * The height of the node with respect to the tree its contained within.
	 */
	private int height;
	
	/**
	 * Constructor to instantiate a new node from a specified data element.
	 * 
	 * @param data The data element to be contained within the new node.
	 */
	public AVLNode(T data) {
		super(data);
		this.height = 1;
	}
	
	/**
	 * Method to retrieve the height of the node with respect to the tree.
	 * 
	 * @return The height of the node.
	 */
	public int GetHeight() {
		return this.height;
	}
	
	/**
	 * Method to update the height of the node with respect to the tree.
	 * 
	 * @param newHeight The updated height of the node.
	 */
	public void SetHeight(int newHeight) {
		this.height = newHeight;
	}
	
}

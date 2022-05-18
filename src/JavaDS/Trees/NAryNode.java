package JavaDS.Trees;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Main super class for nodes contained with N-ary derived tress. Contains common
 * functionality that can be used for nodes within different types of N-ary trees.
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data element contained within the node. 
 */
public class NAryNode<T extends Comparable<T>> extends SuperNode<T> implements INode<T> {

	/**
	 * A list containing all children for a node.  
	 */
	private AbstractList<INode<T>> children;
	
	/**
	 * Constructor instantiates new node provided a specified data element. 
	 * 
	 * @param data The data element for the newly created node. 
	 */
	public NAryNode(T data) {
		super(data);
		children = new ArrayList<INode<T>>();
	}

	/**
	 * Method to retrieve all of the children from a node. 
	 * 
	 * @return A collection of all of the children of a given node.
	 */
	public AbstractList<INode<T>> GetChildren() {
		return this.children;
	}
	
	/**
	 * Method to update the collection of children for a node to a new collection 
	 * of child nodes. 
	 * 
	 * @param newChildren The new collection of child nodes. 
	 */
	public void SetChildren(AbstractList<INode<T>> newChildren) {
		this.children = newChildren;
	}
	
	/**
	 * Method to retrieve a child node from a node given a specified index for
	 * that child amongst the other child nodes. 
	 * 
	 * @param index The index of the child node to retrieve with respect to the
	 * rest of the child nodes contained within a node. 
	 * @return The child node at the specified index.
	 */
	public INode<T> GetChildAt(int index) {
		return this.children.get(index);
	}
	
	/**
	 * Method to update a child node from a node given a specified index for 
	 * that child amongst the other child nodes. 
	 * 
	 * @param index The index of the child node to update with respect to the
	 * rest of the child nodes contained within a node. 
	 * @param newChild The new child to update to at the specified indx.
	 */
	public void SetChildAt(int index, INode<T> newChild) {
		this.children.set(index, newChild);
	}
}

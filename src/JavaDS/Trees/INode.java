package JavaDS.Trees;

/**
 * Interface for all one dimensional tree node based objects to implement containing
 * shared functionality for any type of tree the underlying node might belong to.
 * 
 * @author Tom Esser
 * @param <T> The type of data element the node (and its parent tree) contains.
 */
public interface INode<T extends Comparable<T>> {
	
	/**
	 * Method to access the data element contained within a node.
	 * 
	 * @return
	 */
	public T GetData();
	
	/**
	 * Method to update the data element contained within a node to a new, 
	 * specified data element. 
	 * 
	 * @param newData The new data element the node should contain.
	 */
	public void SetData(T newData);
	
}

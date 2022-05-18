package JavaDS.Trees;

/**
 * Main node super class containing shared logic for nodes that might be contained
 * in any type of underlying, one dimensional tree structures the node might be 
 * populated within.
 * 
 * @author Tom Esser
 * @param <T> The type of data element contained within the node.
 */
public class SuperNode<T extends Comparable<T>> implements INode<T> {

	/**
	 * The data element housed within the node. This acts as a primary key by default.
	 */
	private T data;
	
	/**
	 * Constructors simply accepts a data element and populates it into the node.
	 * 
	 * @param data The data element to be contained within the new node instance.
	 */
	public SuperNode(T data) {
		this.data = data;
	}
	
	/**
	 * Method to retrieve the data element from a given node instance. 
	 * 
	 * @return The data element contained within the new instance. 
	 */
	@Override
	public T GetData() {
		return this.data;
	}

	/**
	 * Method to update the data element for a given node instance. 
	 * 
	 * @param newData The new data element to be contained within the given node.
	 */
	@Override
	public void SetData(T newData) {
		this.data = newData;
	}

	
}

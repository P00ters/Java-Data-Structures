package JavaDS.Trees;

/**
 * Class implementing the Binary Search Tree data structure and related algorithms.
 * Contains logic for searching, adding, and removing nodes to the tree using 
 * logic dictated by the Binary Search Tree algorithms. 
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data contained within the tree's nodes. 
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements ITree<T> {

	/**
	 * Method to add a new node to the tree from a specified data element.
	 * 
	 * @param value The data element for the new node being added to the tree.
	 */
	@Override
	public void AddNode(T value) {
		this.SetRoot(this.AddRec(this.GetRoot(), value));
	}
	
	/**
	 * Recursive method to perform additions to the tree.
	 * 
	 * @param root The current rooted node being operated upon. 
	 * @param value The data element for the new node being inserted into a tree.
	 * @return The rooted node to plug back into the tree recursively.
	 */
	private INode<T> AddRec(INode<T> root, T value) {
		if (root == null) {
			root = new BinaryNode<T>(value);
			return root;
		}
		
		if (value.compareTo(root.GetData()) < 0) 
			((BinaryNode<T>) root).SetLeft(this.AddRec(((BinaryNode<T>) root).GetLeft(), value));
		else if (value.compareTo(root.GetData()) > 0)
			((BinaryNode<T>) root).SetRight(this.AddRec(((BinaryNode<T>) root).GetRight(), value));
		
		return root;
	}

	/**
	 * Method to remove a node from the tree given a specified data element.
	 * 
	 * @param value The data element of the node that should be removed from the tree.
	 */
	@Override
	public void RemoveNode(T value) {
		this.SetRoot(this.RemoveRec(this.GetRoot(), value));
	}
	
	/**
	 * Recursive method to perform removals to the tree.
	 * 
	 * @param root The current rooted node being operated upon. 
	 * @param value The data element for the node being removed from the tree.
	 * @return The rooted node to plug back into the tree recursively.
	 */
	private INode<T> RemoveRec(INode<T> root, T value) {
		if (root == null)
			return root;
		
		if (value.compareTo(root.GetData()) < 0)
			((BinaryNode<T>) root).SetLeft(this.RemoveRec(((BinaryNode<T>) root).GetLeft(), value));
		
		else if (value.compareTo(root.GetData()) > 0) 
			((BinaryNode<T>) root).SetRight(this.RemoveRec(((BinaryNode<T>) root).GetRight(), value));
		
		else {
			if (((BinaryNode<T>) root).GetLeft() == null)
				return ((BinaryNode<T>) root).GetRight();
			else if (((BinaryNode<T>) root).GetRight() == null)
				return ((BinaryNode<T>) root).GetLeft();
			
			root.SetData(min(((BinaryNode<T>) root).GetRight()));
			
			((BinaryNode<T>) root).SetRight(this.RemoveRec(((BinaryNode<T>) root).GetRight(), root.GetData()));
		}
		
		return root;
	}
	
	/**
	 * Method to calculate the minimum data element given a node and its children.
	 * @param root The root node to calculate the minimum data element for.
	 * @return The minimum data element value. 
	 */
	private T min(INode<T> root) {
		T value = root.GetData();
		while (((BinaryNode<T>) root).GetLeft() != null) {
			value = ((BinaryNode<T>) root).GetLeft().GetData();
			root = ((BinaryNode<T>) root).GetLeft();
		}
		return value;
	}

	/**
	 * Method for performing a search in the tree for a specified data element.
	 * 
	 * @return True if the data element is already contained within a node of
	 * the tree and false if the data element is not contained within a node of 
	 * the tree.
	 */
	@Override
	public boolean Contains(T value) {
		INode<T> on = this.GetRoot();
		
		while(on != null) {
			if (on.GetData() == value)
				return true;
			else if (value.compareTo(value) > 0)
				on = ((BinaryNode<T>) on).GetRight();
			else
				on = ((BinaryNode<T>) on).GetLeft();
		}
		
		return false;
	}

}

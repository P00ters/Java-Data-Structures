package JavaDS.Trees;

/**
 * Class implementing the AVL Tree data structure and related algorithms.
 * Contains logic for searching, adding, and removing nodes to the tree using 
 * logic dictated by the Binary Search Tree algorithms. 
 * 
 * @author Tom Esser
 *
 * @param <T> The type of data contained within the tree's nodes. 
 */
public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> implements ITree<T> {

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
	 * Method to traverse the tree to locate insertion point while handling 
	 * rotations for balancing. 
	 * 
	 * @param node The current rooted node.
	 * @param value The data element being inserted into the tree.
	 * @return The new rooted node. 
	 */
	private INode<T> AddRec(INode<T> node, T value) {
		AVLNode<T> avlnode = (AVLNode<T>) node;
		
		if (avlnode == null)
			return (new AVLNode<T>(value));
		
		if (value.compareTo(avlnode.GetData()) < 0)
			avlnode.SetLeft(this.AddRec(avlnode.GetLeft(), value));
		else if (value.compareTo(node.GetData()) > 0)
			avlnode.SetRight(this.AddRec(avlnode.GetRight(), value));
		else
			return node;
		
		AVLNode<T> left = (AVLNode<T>)avlnode.GetLeft();
		AVLNode<T> right = (AVLNode<T>)avlnode.GetRight();
		avlnode.SetHeight(1 + this.MaxHeight(this.Height(left), this.Height(right)));
		
		int balance = this.GetBalanceFactor(avlnode);
		
		if (balance > 1 && value.compareTo(((AVLNode<T>)avlnode.GetLeft()).GetData()) < 0)
			return this.RightRotate(avlnode);
		
		if (balance < -1 && value.compareTo(((AVLNode<T>)avlnode.GetRight()).GetData()) > 0)
			return this.LeftRotate(avlnode);
		
		if (balance > 1 && value.compareTo(((AVLNode<T>)avlnode.GetLeft()).GetData()) > 0) {
			avlnode.SetLeft(this.LeftRotate(avlnode.GetLeft()));
			return this.RightRotate(avlnode);
		}
		
		if (balance < -1 && value.compareTo(((AVLNode<T>)avlnode.GetRight()).GetData()) < 0) {
			avlnode.SetRight(this.RightRotate(avlnode.GetRight()));
			return this.LeftRotate(avlnode);
		}
		
		return node;
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
	 * Method to recursively traverse tree to find and handle deletion of node with
	 * specified value from tree. 
	 * 
	 * @param root The current rooted node being operated on.
	 * @param value The data element contained in the node to remove. 
	 * @return The new rooted node after traversal or deletion.
	 */
	@SuppressWarnings("unused")
	private INode<T> RemoveRec(INode<T> root, T value) {
		AVLNode<T> avlRoot = ((AVLNode<T>) root);
		if (this.GetRoot() == null)
			return root;
		
		if (value.compareTo(root.GetData()) < 0)
			avlRoot.SetLeft(this.RemoveRec(((AVLNode<T>) root).GetLeft(), value));
		else if (value.compareTo(root.GetData()) > 0)
			avlRoot.SetRight(this.RemoveRec(((AVLNode<T>) root).GetRight(), value));
		else {
			if (avlRoot.GetLeft() == null || avlRoot.GetRight() == null) {
				INode<T> temp = null;
				if (temp == avlRoot.GetLeft())
					temp = avlRoot.GetRight();
				else
					temp = avlRoot.GetLeft();
				
				if (temp == null) {
					temp = root;
					root = null;
				}
				else 
					root = temp;
			}
			else {
				INode<T> temp = this.MinValue(avlRoot.GetRight());
				avlRoot.SetData(temp.GetData());
				avlRoot.SetRight(this.RemoveRec(avlRoot.GetRight(), temp.GetData()));
			}
		}
		
		if (avlRoot == null)
			return avlRoot;
		
		avlRoot.SetHeight(this.MaxHeight(this.Height(avlRoot.GetLeft()), this.Height(avlRoot.GetRight())) + 1);
		
		int balance = this.GetBalanceFactor(avlRoot);
		
		if (balance > 1 && this.GetBalanceFactor(avlRoot.GetLeft()) >= 0)
			return this.RightRotate(avlRoot);
		
		if (balance > 1 && this.GetBalanceFactor(avlRoot.GetLeft()) < 0) {
			avlRoot.SetLeft(this.LeftRotate(avlRoot.GetLeft()));
			return this.RightRotate(avlRoot);
		}
		
		if (balance < -1 && this.GetBalanceFactor(avlRoot.GetRight()) <= 0)
			return this.LeftRotate(avlRoot);
					
		if (balance < -1 && this.GetBalanceFactor(avlRoot.GetRight()) > 0) {
			avlRoot.SetRight(this.RightRotate(avlRoot.GetRight()));
			return this.LeftRotate(avlRoot);
		}
		
		return root;
		
	}
	
	/**
	 * Method to get the minimum data element to the left of a specified node
	 * in the tree. 
	 * 
	 * @param node The current rooted node.
	 * @return The node containing minimum data element.
	 */
	private INode<T> MinValue (INode<T> node) {
		AVLNode<T> current = ((AVLNode<T>) node);
		
		while (current.GetLeft() != null)
			current = (AVLNode<T>)current.GetLeft();
		
		return current;
	}
	
	/**
	 * Method to find the maximum height of two nodes. 
	 * @param a The first height.
	 * @param b The second height. 
	 * @return The maximum height.
	 */
	private int MaxHeight(int a, int b) {
		 if (a >= b)
			 return a;
		 else
			 return b;
	}
	
	/**
	 * Method to perform a right rotation on the rooted node. 
	 * 
	 * @param root The rooted node to perform the rotation on.
	 * @return The new root.
	 */
	private INode<T> RightRotate(INode<T> root) {
		INode<T> a = ((AVLNode<T>) root).GetLeft();
		INode<T> b = ((AVLNode<T>) a).GetRight();
		
		((AVLNode<T>) a).SetRight(root);
		((AVLNode<T>) root).SetLeft(b);
		
		((AVLNode<T>) root).SetHeight(this.MaxHeight(this.Height(((AVLNode<T>) root).GetLeft()), this.Height(((AVLNode<T>) root).GetRight())) + 1);
		((AVLNode<T>) a).SetHeight(this.MaxHeight(this.Height(((AVLNode<T>) a).GetLeft()), this.Height(((AVLNode<T>) a).GetRight())) + 1);
		
		return a;
	}
	
	/**
	 * Method to perform a left rotation on the rooted node. 
	 * 
	 * @param root The rooted node to perform the rotation on.
	 * @return The new root.
	 */
	private INode<T> LeftRotate(INode<T> root) {
		INode<T> a = ((AVLNode<T>) root).GetRight();
		INode<T> b =  ((AVLNode<T>) a).GetLeft();
				
		((AVLNode<T>) a).SetLeft(root);
		((AVLNode<T>) root).SetRight(b);
		
		((AVLNode<T>) root).SetHeight(this.MaxHeight(this.Height(((AVLNode<T>) root).GetLeft()), this.Height(((AVLNode<T>) root).GetRight())) + 1);
		((AVLNode<T>) a).SetHeight(this.MaxHeight(this.Height(((AVLNode<T>) a).GetLeft()), this.Height(((AVLNode<T>) a).GetRight())) + 1);
		
		return a;
	}
	
	private int Height (INode<T> node) {
		AVLNode<T> avlnode = (AVLNode<T>) node;
		
		if (avlnode == null)
			return 0;
		return avlnode.GetHeight();
	}
	
	/**
	 * Gets the balance factor of the specified node. 
	 * @param node The node to get the balance factor for. 
	 * @return The balance factor for the node. 
	 */
	private int GetBalanceFactor(INode<T> node) {
		AVLNode<T> avlnode = (AVLNode<T>) node;
		
		if (avlnode == null)
			return 0;
		
		return this.Height(avlnode.GetLeft()) - this.Height(avlnode.GetRight());
	}

}

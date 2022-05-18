package JavaDS.Sorters;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * A superclass for sorting algorithm classes that contains shared logic and 
 * functionality required by any given sorting algorithm that might extend it, 
 * such as storing and retrieving data and swapping data elements in a collection.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public abstract class SuperSort<T extends Comparable<T>> implements ISorter<T> {
	
	/**
	 * The collection of data elements to do sorting work upon.
	 */
	private AbstractList<T> data;

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public SuperSort (AbstractList<T> unsortedData) {
		this.data = new ArrayList<T>();
		this.data.addAll(unsortedData);
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public SuperSort (T[] unsortedData) {
		this.data = new ArrayList<T>();
		for (int i = 0; i < unsortedData.length; i++) {
			this.data.add(unsortedData[i]);
		}
	}
	
	/**
	 * Unimplemented method for sorting the data stored within the class 
	 * instance in a specified direction. Implementation left to individual 
	 * sorting algorithm sub-classes. 
	 * 
	 * @param dir The direction the data should be sorted in.
	 */
	public abstract void Sort(SortDirection dir);

	/**
	 * Method for accessing the data presently stored within the class instance,
	 * whether presently sorted or unsorted.
	 * 
	 * @return The collection of data presently stored within the instance. 
	 */
	public AbstractList<T> GetData() {
		return this.data;
	}

	/**
	 * Method for updating the data presently stored within the class instance to
	 * allow the sorter instance to be re-used on multiple data sets.
	 * 
	 * @param newData The new data to store for sorting as an <code>AbstractList</code>. 
	 */
	public void SetData(AbstractList<T> newData) {
		this.data.clear();
		this.data.addAll(newData);
	}

	/**
	 * Method for updating the data presently stored within the class instance to
	 * allow the sorter instance to be re-used on multiple data sets.
	 * 
	 * @param newData The new data to store for sorting as an <code>Array</code>.
	 */
	public void SetData(T[] newData) {
		this.data.clear();
		for (int i = 0; i < newData.length; i++) {
			this.data.add(newData[i]);
		}
	}
	
	/**
	 * A method to be used by sorting algorithms to allow for swapping of data
	 * elements stored in the collection easily. Swaps two elements in the collection
	 * provided their two indices within the collection.
	 * 
	 * @param index1 The index of the first data element to swap.
	 * @param index2 The index of the second data element to swap.
	 */
	protected void Swap (int index1, int index2) {
		T temp = this.data.get(index1);
		this.data.set(index1, this.data.get(index2));
		this.data.set(index2, temp);
	}
	
}

package JavaDS.Sorters;

import java.util.AbstractList;

/**
 * Interface for sorting algorithms. Implementing classes can sort 
 * collections of <code>Comparable</code> extending data elements.
 * 
 * @author Tom Esser
 * @param <T> Type of data elements being sorted.
 */
public interface ISorter<T extends Comparable<T>> {
	
	/**
	 * Method to execute a specific sorting algorithm upon a collection
	 * of data stored within implementing classes.
	 * 
	 * @param dir The direction to sort the data in.
	 */
	public void Sort (SortDirection dir);
	
	/**
	 * Method to retrieve data collection stored within an implementing class.
	 * 
	 * @return The data collection, whether sorted or unsorted, presently 
	 * stored within the implementing class.
	 */
	public AbstractList<T> GetData ();
	
	/**
	 * Method to update the data collection stored within an implementing 
	 * class to a specified, new data collection to allow for re-use of 
	 * instances of implementing classes.
	 * 
	 * @param newData The new data collection to store within an implementing
	 * class.
	 */
	public void SetData (AbstractList<T> newData);
	
	/**
	 * Method to update the data collection stored within an implementing 
	 * class to a specified, new data collection to allow for re-use of 
	 * instances of implementing classes.
	 * 
	 * @param newData The new data collection to store within an implementing
	 * class.
	 */
	public void SetData (T[] newData);
	
}

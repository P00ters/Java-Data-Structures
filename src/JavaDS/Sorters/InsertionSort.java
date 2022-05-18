package JavaDS.Sorters;

import java.util.AbstractList;

/**
 * Class implementing the Insertion Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in average O(n^2) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class InsertionSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T> {

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public InsertionSort(AbstractList<T> unsortedData) {
		super(unsortedData);
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public InsertionSort(T[] unsortedData) {
		super(unsortedData);
	}

	/**
	 * Method to sort the data collection stored within the class using the 
	 * Bubble Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		
		
		for (int i = 1; i < this.GetData().size(); ++i) {
			T k = this.GetData().get(i);
			int j = i - 1;
			
			if (dir == SortDirection.ASC) {
				while (j >= 0 && this.GetData().get(j).compareTo(k) > 0) {
					this.GetData().set(j+1, this.GetData().get(j));
					j -= 1;
				}
			}
			else {
				while (j >= 0 && this.GetData().get(j).compareTo(k) < 0) {
					this.GetData().set(j+1, this.GetData().get(j));
					j -= 1;
				}
			}
			
			this.GetData().set(j+1, k);
		}
		
	}

}

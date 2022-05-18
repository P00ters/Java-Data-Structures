package JavaDS.Sorters;

import java.util.AbstractList;

/**
 * Class implementing the Selection Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in O(n^2) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T>  {

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public SelectionSort(AbstractList<T> unsortedData) {
		super(unsortedData);
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public SelectionSort(T[] unsortedData) {
		super(unsortedData);
	}

	/**
	 * Method to sort the data collection stored within the class using the 
	 * Selection Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		for (int i = 0; i < this.GetData().size() - 1; i++) {
			int min = i;
			for (int j = i+1; j < this.GetData().size(); j++) {
				if (dir == SortDirection.ASC) {
					if (this.GetData().get(j).compareTo(this.GetData().get(min)) < 0) {
						min = j;
					}
				} 
				else {
					if (this.GetData().get(j).compareTo(this.GetData().get(min)) > 0) {
						min = j;
					}
				}
			}
			
			this.Swap(i, min);
		}
	}
	
}
